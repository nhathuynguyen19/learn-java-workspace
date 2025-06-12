package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	public static Connection cn;
	
	public void connect() throws Exception {
		String driverURL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		Class.forName(driverURL);
		System.out.println("Da xac dinh he quan tri co so du lieu");
		String databaseURL = "jdbc:sqlserver://DESKTOP-RUGUKIB:1433;databaseName=ontap1javacoban;user=sa;password=123;encrypt=false;trustCertificate=true";
		cn = DriverManager.getConnection(databaseURL);
		System.out.println("Da ket noi co so du lieu");
	}
	
	public void disconnect() throws Exception {
		cn.close();
		System.out.println("Da ngat ket noi co so du lieu");
	}
}
