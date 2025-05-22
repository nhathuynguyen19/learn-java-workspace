package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public static Connection cn;
	   public void ketnoi() throws Exception{
	       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	       System.out.println("Da xac dinh HQTCSDL");
	       String url="jdbc:sqlserver://DESKTOP-RUGUKIB:1433;databaseName=qlnhanvien;user=sa; password=123; trustServerCertificate=true";
	       cn= DriverManager.getConnection(url);
	       System.out.println("Co the qua mon nay");
	   }
}
