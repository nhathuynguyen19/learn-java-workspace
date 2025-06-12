

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class DatabaseConnector {
	public static Logger logger = Logger.getLogger(DatabaseConnector.class.getName());
	QuanLySinhVien qlsv = new QuanLySinhVien();
	QuanLyGiangVien qlgv = new QuanLyGiangVien();
	public static Connection connection;
	private String driverUrl = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://DESKTOP-RUGUKIB:1433;databaseName=De1SinhVienGiangVien;user=sa;password=123;encrypt=false;trustCertificate=true";
	
	public void connect() throws Exception {
		Class.forName(driverUrl);
		logger.info("Da phat hien driver");
		connection = DriverManager.getConnection(url);
		logger.info("Da ket noi database");
	}
	
	public void disconnect() throws Exception {
		connection.close();
	}
	
	public void importFromFile(String fpath) throws Exception {
		FileReader f = new FileReader(fpath);
		BufferedReader bf = new BufferedReader(f);
		String line = null;
		while ((line = bf.readLine()) != null) {
			String[] st = line.split(",");
			if (st[0].equals("GV")) {
				QuanLyGiangVien qlgv = new QuanLyGiangVien();
				GiangVien gv = new GiangVien(st[1], st[2], st[3], st[4], st[5]);
				qlgv.insertGiangVien(gv, this);
			} else if (st[0].equals("SV")) {
				QuanLySinhVien qlsv = new QuanLySinhVien();
				SinhVien sv = new SinhVien(st[1], st[2], st[3], st[4], st[5]);
				qlsv.insertSinhVien(sv, this);
			}
		}
		f.close();
		bf.close();
	}
	
	public void getStatitics() throws Exception {
		StatisticsResult.dssv = qlsv.selectSinhVien(this);
		StatisticsResult.dsgv = qlgv.selectGiangVien(this);
	}
}
