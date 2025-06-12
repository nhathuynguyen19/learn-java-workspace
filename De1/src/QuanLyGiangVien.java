import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QuanLyGiangVien {
	private QuanLyNguoi qln = new QuanLyNguoi();
	public Boolean isExist(String maGiangVien, DatabaseConnector dbc) throws Exception {
		String query = "select 1 from GiangVien where maGiangVien = ?;";
		PreparedStatement cmd = null;
		ResultSet rs = null;
		try {
			dbc.connect();
			cmd = DatabaseConnector.connection.prepareStatement(query);
			cmd.setString(1, maGiangVien);
			rs = cmd.executeQuery();
			return rs.next();
		} finally {
			if (cmd != null) cmd.close();
			if (rs != null) rs.close();
			dbc.disconnect();
		}
	}
	public void insertGiangVien(GiangVien gv, DatabaseConnector dbc) throws Exception {
		if (isExist(gv.getMaGiangVien(), dbc)) {
			System.out.println("Giang vien da ton tai");
			return;
		}
		String query = "insert into GiangVien values (?, ?, ?);";
		PreparedStatement cmd = null;
		if (!qln.isExist(gv.getId())) {
			Person ps = new Person(gv.getId(), gv.getName(), gv.getEmail());
			qln.insertPerson(ps);
			try {
				dbc.connect();
				cmd = DatabaseConnector.connection.prepareStatement(query);
				cmd.setString(1, gv.getMaGiangVien());
				cmd.setString(2, gv.getBoMon());
				cmd.setString(3, gv.getId());
				cmd.executeUpdate();
			} finally {
				if (cmd != null) cmd.close();
				dbc.disconnect();
			}
		} else {
			try {
				dbc.connect();
				cmd = DatabaseConnector.connection.prepareStatement(query);
				cmd.setString(1, gv.getMaGiangVien());
				cmd.setString(2, gv.getBoMon());
				cmd.setString(3, gv.getId());
				cmd.executeUpdate();
			} finally {
				if (cmd != null) cmd.close();
				dbc.disconnect();
			}
		}
	}
	public ArrayList<GiangVien> selectGiangVien(DatabaseConnector dbc) throws Exception {
		ArrayList<GiangVien> dsgv = new ArrayList<GiangVien>();
		String query = "select p.id, p.[name], p.email, g.maGiangVien, g.boMon from GiangVien as g left join Person as p on g.id = p.id";
		PreparedStatement cmd = null;
		ResultSet rs = null;
		try {
			dbc.connect();
			cmd = DatabaseConnector.connection.prepareStatement(query);
			rs = cmd.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String maGiangVien = rs.getString("maGiangVien");
				String boMon = rs.getString("boMon");
				GiangVien sv = new GiangVien(id, name, email, maGiangVien, boMon);
				dsgv.add(sv);
			}
			return dsgv;
		} finally {
			if (cmd != null) cmd.close();
			if (rs != null) rs.close();
			dbc.disconnect();
		}
	}
}
