package BaiTapBuoi7;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlServer {
	public static Connection connection;
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public void connect(String serverName, String port, String databaseName, String userName, String password) {
		try {
			String url = "jdbc:sqlserver://LAB401-30:1433;databaseName=NhanVienSinhVien;user=sa;password=16082005159487!Hh;trustServerCertificate=true;encrypt=true";
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Da xac dinh HQTCSDL");
			connection = DriverManager.getConnection(url);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			System.out.println("Ket noi that bai");
		}
	}
	public void disconnect() {
		try {
			connection.close();
			System.out.println("Da dong ket noi");
		} catch (Exception e) {
			System.out.println("Loi khi dong ket noi");
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
		}
	}
	public void insertKhoa(String st, String tenKhoa) {
		String  insertSQL = "insert into DonVi (MaKhoa, TenKhoa) values (?, ?)";
		
		try (PreparedStatement preparedstatement = connection.prepareStatement(insertSQL)) {
			preparedstatement.setString(1, st);
			preparedstatement.setString(2, tenKhoa);
			
			int rowsAffected = preparedstatement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
			
		} catch (Exception e) {
			System.out.println("Loi khi chen du lieu Khoa");		}
	}
	public boolean isSinhVien(Object ob) {
		if (ob.getClass().getName().contains("SinhVien")) return true;
		return false;
	}
	public boolean isNhanVien(Object ob) {
		if (ob.getClass().getName().contains("NhanVien")) return true;
		return false;
	}
	public boolean isKhoa(Object ob) {
		if (ob.getClass().getName().contains("String")) return true;
		return false;
	}
	public void insert(Object ob) {
		if (isSinhVien(ob)) insertSinhVien((SinhVien) ob);
		if (isNhanVien(ob)) insertNhanVien((NhanVien) ob);
		if (isKhoa(ob)) insertKhoa((String) ob, "");
	}
	public ArrayList<SinhVien> selectSinhVien() {
		ArrayList<SinhVien> result = new ArrayList<SinhVien>();
		try {
			String query = "select * from SinhVien";
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String maSinhVien = rs.getString("MaSinhVien");
				String hoTen = rs.getString("HoTen");
				Date ngaySinh = rs.getDate("NgaySinh");
				String queQuan = rs.getString("QueQuan");
				Double diemTrungBinh = rs.getDouble("DiemTrungBinh");
				String khoa = rs.getString("MaKhoa");
				SinhVien sv = new SinhVien(hoTen, ngaySinh, queQuan, khoa, maSinhVien, diemTrungBinh);
				result.add(sv);
			}
			System.out.println("select sinh vien thanh cong");
			return result;
		} catch (Exception e) {
			System.out.println("loi khi select sinh vien");
		}
		return null;
	}
	public ArrayList<NhanVien> selectNhanVien() {
		ArrayList<NhanVien> result = new ArrayList<NhanVien>();
		try {
			String query = "select * from NhanVien";
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String maNhanVien = rs.getString("MaNhanVien");
				String hoTen = rs.getString("HoTen");
				Date ngaySinh = rs.getDate("NgaySinh");
				String queQuan = rs.getString("QueQuan");
				String khoa = rs.getString("MaKhoa");
				Double heSoLuong = rs.getDouble("HeSoLuong");
				Double luong = rs.getDouble("Luong");
				NhanVien nv = new NhanVien(hoTen, ngaySinh, queQuan, khoa, maNhanVien, heSoLuong, luong);
				result.add(nv);
			}
			System.out.println("select nhan vien thanh cong");
			return result;
		} catch (Exception e) {
			System.out.println("loi khi select nhan vien");
		}
		return null;
	}
	public ArrayList<String> selectKhoa() {
		ArrayList<String> result = new ArrayList<String>();
		try {
			String query = "select * from Khoa";
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String maKhoa = rs.getString("MaKhoa");
				result.add(maKhoa);
			}
			System.out.println("select khoa thanh cong");
			return result;
		} catch (Exception e) {
			System.out.println("loi khi select khoa");
		}
		return null;
	}
}
