package BaiTapBuoi7;

import java.sql.Connection;
import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		String password = System.getenv("PASSWORD");
		SqlServer sqlsv = new SqlServer(); // tao doi tuong sql server
		QuanLyFile ql1 = new QuanLyFile();
		
		// ket noi co so du lieu
		sqlsv.connect("localhost", "1433", "NhanVienSinhVien", "SA", password);
		
		// lay doi tuong ket noi
		Connection connection = sqlsv.getConnection();
		
		// file insert to database
		ql1.fileToDatabase(sqlsv);
		
		// select all
		ArrayList<SinhVien> slsv = sqlsv.select("SinhVien");
		
		// Dong ket noi
		sqlsv.disconnect();
	}

}
