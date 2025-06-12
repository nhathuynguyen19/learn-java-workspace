package View;

import DAO.DBConnector;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnector dbc = new DBConnector();
		try {
			dbc.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
