package View;

import DAO.DatabaseConnector;

public class test {

	public static void main(String[] args) {
		DatabaseConnector DB = new DatabaseConnector();
		try {
			DB.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
