package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class DatabaseConnector {
	public static final Logger logger = Logger.getLogger(DatabaseConnector.class.getName());
	public static String deviceName = "DESKTOP-RUGUKIB";
	public static String databaseName = "de3thdt";
	public static String user = "sa";
	public static Integer password = 123;
	public static String url = "jdbc:sqlserver://" + deviceName + ":1433;databaseName=" + databaseName + ";user=" + user + ";password=" + password + ";encrypt=false;trustCertificate=true";
	public Connection connection;
	
	public void loadSQLServerDriver() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		logger.info("JDBC driver loaded successfully");
	}
	
	public void connect() throws Exception {
		loadSQLServerDriver();
		connection = DriverManager.getConnection(url);
		logger.info("Database connect successfully");
	}
	
	public void disconnect() throws Exception {
		connection.close();
		logger.info("Disconnected");
	}
}
