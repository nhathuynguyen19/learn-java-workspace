package BaiTapBuoi7;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlServer {
	private Connection connection = null;
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public void connect(String serverName, String port, String databaseName, String userName, String password) {
		String url = "";
		if (userName == null || userName == "" || password == null || password == "") {
			url = "jdbc:sqlserver://" + serverName + ":" + port + ";" 
			           + "databaseName=" + databaseName + ";" 
			           + "integratedSecurity=true;" 
			           + "encrypt=false;";
			
			try {
				connection = DriverManager.getConnection(url);
				System.out.println("Ket noi thanh cong");
			} catch (SQLException e) {
				System.out.println("Ket noi that bai");
				e.printStackTrace();
			}
		}
		else {
			url = 	"jdbc:sqlserver://" + serverName + ":" 
					+ port + ";" + "databaseName=" + databaseName + ";encrypt=false";
			
			try {
				connection = DriverManager.getConnection(url, userName, password);
				System.out.println("Ket noi thanh cong");
			} catch (SQLException e) {
				System.out.println("Ket noi that bai");
				e.printStackTrace();
			}
		}
	}
	public void disconnect() {
		try {
			connection.close();
			System.out.println("Da dong ket noi");
		} catch (Exception e) {
			System.out.println("Loi khi dong ket noi");
			e.printStackTrace();
		}
	}
	public void insertSinhVien(SinhVien sinhVien) {
		String  insertSQL = "insert into SinhVien (MaSinhVien, HoTen, NgaySinh, QueQuan, DiemTrungBinh, MaKhoa) values (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement preparedstatement = connection.prepareStatement(insertSQL)) {
			preparedstatement.setString(1, sinhVien.getMaSV());
			preparedstatement.setString(2, sinhVien.getHoTen());
			preparedstatement.setDate(3, sinhVien.getNgaySinh());
			preparedstatement.setString(4, sinhVien.getQueQuan());
			preparedstatement.setDouble(5, sinhVien.getDiemTB());
			preparedstatement.setString(6, sinhVien.getKhoa());
			
			int rowsAffected = preparedstatement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
			
		} catch (Exception e) {
			System.out.println("Loi khi chen du lieu Sinh vien");
			e.printStackTrace();
		}
	}
	public void insertNhanVien(NhanVien nhanVien) {
		String  insertSQL = "insert into NhanVien (MaNhanVien, HoTen, NgaySinh, QueQuan, HeSoLuong, Luong, MaKhoa) values (?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement preparedstatement = connection.prepareStatement(insertSQL)) {
			preparedstatement.setString(1, nhanVien.getMaNV());
			preparedstatement.setString(2, nhanVien.getHoTen());
			preparedstatement.setDate(3, nhanVien.getNgaySinh());
			preparedstatement.setString(4, nhanVien.getQueQuan());
			preparedstatement.setDouble(5, nhanVien.getHeSoLuong());
			preparedstatement.setDouble(6, nhanVien.getLuong());
			preparedstatement.setString(7, nhanVien.getKhoa());
			
			int rowsAffected = preparedstatement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
			
		} catch (Exception e) {
			System.out.println("Loi khi chen du lieu Nhan vien");
			e.printStackTrace();
		}
	}
	public void insertKhoa(String st) {
		String  insertSQL = "insert into Khoa (MaKhoa) values (?)";
		
		try (PreparedStatement preparedstatement = connection.prepareStatement(insertSQL)) {
			preparedstatement.setString(1, st);
			
			int rowsAffected = preparedstatement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
			
		} catch (Exception e) {
			System.out.println("Loi khi chen du lieu Khoa");
			e.printStackTrace();
		}
	}
	public void insert(Object ob) {
		if (ob.getClass().getName().contains("SinhVien")) insertSinhVien((SinhVien) ob);
		if (ob.getClass().getName().contains("NhanVien")) insertNhanVien((NhanVien) ob);
		if (ob.getClass().getName().contains("String")) insertKhoa((String) ob);
	}
	public SinhVien selectSinhVien(ResultSet rs) throws Exception {
		String maSinhVien = rs.getString("MaSinhVien");
		String hoTen = rs.getString("HoTen");
		Date ngaySinh = rs.getDate("NgaySinh");
		String queQuan = rs.getString("QueQuan");
		Double diemTrungBinh = rs.getDouble("DiemTrungBinh");
		String khoa = rs.getString("MaKhoa");
		return new SinhVien(hoTen, ngaySinh, queQuan, khoa, maSinhVien, diemTrungBinh);
	}
	public NhanVien selectNhanVien(ResultSet rs) throws Exception {
		String maNhanVien = rs.getString("MaNhanVien");
		String hoTen = rs.getString("HoTen");
		Date ngaySinh = rs.getDate("NgaySinh");
		String queQuan = rs.getString("QueQuan");
		String khoa = rs.getString("MaKhoa");
		Double heSoLuong = rs.getDouble("HeSoLuong");
		Double luong = rs.getDouble("Luong");
		return new NhanVien(hoTen, ngaySinh, queQuan, khoa, maNhanVien, heSoLuong, luong);
	}
	public String selectKhoa(ResultSet rs) throws Exception {
		return rs.getString("MaKhoa");
	}
	public void select(ArrayList<Object> ob) {
		
		try {
			String query = "select * from " + tableName;
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (tableName == "SinhVien") result.add(selectSinhVien(rs));
				if (tableName == "NhanVien") result.add(selectNhanVien(rs));
				if (tableName == "Khoa") result.add(selectKhoa(rs));
			}
			return result;
		} catch (Exception e) {
			System.out.println("loi khi select");
			e.printStackTrace();
		}
		return null;
	}
}
