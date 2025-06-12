import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QuanLySinhVien {
	private QuanLyNguoi qln = new QuanLyNguoi();
	public Boolean isExist(String maSinhVien, DatabaseConnector dbc) throws Exception {
		String query = "select 1 from SinhVien where maSinhVien = ?;";
		PreparedStatement cmd = null;
		ResultSet rs = null;
		try {
			dbc.connect();
			cmd = DatabaseConnector.connection.prepareStatement(query);
			cmd.setString(1, maSinhVien);
			rs = cmd.executeQuery();
			return rs.next();
		} finally {
			if (cmd != null) cmd.close();
			if (rs != null) rs.close();
			dbc.disconnect();
		}
	}
	public void insertSinhVien(SinhVien sv, DatabaseConnector dbc) throws Exception {
		if (isExist(sv.getMaSinhVien(), dbc)) {
			System.out.println("Sinh vien da ton tai");
			return;
		}
		String query = "insert into SinhVien values (?, ?, ?);";
		PreparedStatement cmd = null;
		if (!qln.isExist(sv.getId())) {
			Person ps = new Person(sv.getId(), sv.getName(), sv.getEmail());
			qln.insertPerson(ps);
			try {
				dbc.connect();
				cmd = DatabaseConnector.connection.prepareStatement(query);
				cmd.setString(1, sv.getMaSinhVien());
				cmd.setString(2, sv.getKhoa());
				cmd.setString(3, sv.getId());
				cmd.executeUpdate();
			} finally {
				if (cmd != null) cmd.close();
				dbc.disconnect();
			}
		} else {
			try {
				dbc.connect();
				cmd = DatabaseConnector.connection.prepareStatement(query);
				cmd.setString(1, sv.getMaSinhVien());
				cmd.setString(2, sv.getKhoa());
				cmd.setString(3, sv.getId());
				cmd.executeUpdate();
			} finally {
				if (cmd != null) cmd.close();
				dbc.disconnect();
			}
		}
	}
	
	public ArrayList<SinhVien> selectSinhVien(DatabaseConnector dbc) throws Exception {
		ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
		String query = "select p.id, p.[name], p.email, s.maSinhVien, s.khoa from SinhVien as s left join Person as p on s.id = p.id";
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
				String maSinhVien = rs.getString("maSinhVien");
				String khoa = rs.getString("khoa");
				SinhVien sv = new SinhVien(id, name, email, maSinhVien, khoa);
				dssv.add(sv);
			}
			return dssv;
		} finally {
			if (cmd != null) cmd.close();
			if (rs != null) rs.close();
			dbc.disconnect();
		}
	}
}
