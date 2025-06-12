package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class KetNoi {
	public static Connection cn;
	
	public static final Logger logger = Logger.getLogger(KetNoi.class.getName());
	
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		logger.info("JDBC driver loaded successfully");
		String url="jdbc:sqlserver://DESKTOP-RUGUKIB:1433;databaseName=qlnhanvien;user=sa;password=123;trustServerCertificate=true;encrypt=false";
		cn= DriverManager.getConnection(url);
		logger.info("Connect dababase successfully");
	}
}
