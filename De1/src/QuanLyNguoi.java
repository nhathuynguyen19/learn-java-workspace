
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuanLyNguoi {
	public Boolean isExist(String id) throws Exception {
		DatabaseConnector dbc = new DatabaseConnector();
		String query = "select 1 from Person where id = ?;";
		PreparedStatement cmd = null;
		ResultSet rs = null;
		try {
			dbc.connect();
			cmd = DatabaseConnector.connection.prepareStatement(query);
			cmd.setString(1, id);
			rs = cmd.executeQuery();
			return rs.next();
		} finally {
			if (cmd != null) cmd.close();
			if (rs != null) rs.close();
			dbc.disconnect();
		}
	}
	public void insertPerson(Person ps) throws Exception {
		DatabaseConnector dbc = new DatabaseConnector();
		if (isExist(ps.getId())) {
			System.out.println("ID Person da ton tai");
			return;
		}
		String query = "insert into Person values (?, ?, ?);";
		PreparedStatement cmd = null;
		try {
			dbc.connect();
			cmd = DatabaseConnector.connection.prepareStatement(query);
			cmd.setString(1, ps.getId());
			cmd.setString(2, ps.getName());
			cmd.setString(3, ps.getEmail());
			cmd.executeUpdate();
		} finally {
			if (cmd != null) cmd.close();
			dbc.disconnect();
		}
		
	}
}
