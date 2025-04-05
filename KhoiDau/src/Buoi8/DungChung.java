package Buoi8;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import io.github.cdimascio.dotenv.Dotenv;

public class DungChung {
	public static Connection cn;
	public static String serverName = "localhost";
	public static String databaseName = "NhanVienSinhVien";
	public static String userName = "SA";
	public static Dotenv dotenv = Dotenv.load();
	public static String password = dotenv.get("PASSWORD");
	public void ketNoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		String url = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;trustServerCertificate=true", serverName, databaseName, userName, password);
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	public void HienThiNV() throws Exception {
		// b1 ket noi csdl
		DungChung dc = new DungChung();
		dc.ketNoi();
		
		// b2 thiet lap cau lenh
		String query = "select * from NhanVien";
		
		//b3 tao cau lenh
		PreparedStatement cmd = dc.cn.prepareStatement(query);
		
		// b4 truyen tham so neu co
		
		// b5 thuc hiencau lenh sql
		ResultSet rs = cmd.executeQuery();
		
		// b6 duyet qua rs set
		while(rs.next()) {
			String maNhanVien = rs.getString("MaNhanVien");
			String hoTen = rs.getString("HoTen");
			Date ngaySinh = rs.getDate("NgaySinh");
			String queQuan = rs.getString("QueQuan");
			String khoa = rs.getString("MaKhoa");
			Double heSoLuong = rs.getDouble("HeSoLuong");
			Double luong = rs.getDouble("Luong");
			System.out.println(maNhanVien + ","
					+ hoTen + ","
					+ ngaySinh + ","
					+ queQuan + ","
					+ khoa + ","
					+ heSoLuong + ","
					+ luong);
		}
		
		// b7 dong ket noi
		rs.close();
		dc.cn.close();
	}
	public void HienThiDonVi() throws Exception {
		// b1 ket noi csdl
		DungChung dc = new DungChung();
		dc.ketNoi();
		
		// b2 thiet lap cau lenh
		String query = "select * from DonVi";
		
		//b3 tao cau lenh
		PreparedStatement cmd = dc.cn.prepareStatement(query);
		
		// b4 truyen tham so neu co
		
		// b5 thuc hiencau lenh sql
		ResultSet rs = cmd.executeQuery();
		
		// b6 duyet qua rs set
		while(rs.next()) {
			String maKhoa = rs.getString("MaKhoa");
			String tenKhoa = rs.getString("TenKhoa");
			System.out.println(maKhoa + ","
					+ tenKhoa
					);
		}
		
		// b7 dong ket noi
		rs.close();
		dc.cn.close();
	}
	public void HienThiNhanVienHSL45() throws Exception {
		// b1 ket noi csdl
		DungChung dc = new DungChung();
		dc.ketNoi();
		
		// b2 thiet lap cau lenh
		String query = "select HoTen, HeSoLuong from NhanVien where HeSoLuong > 4.5";
		
		//b3 tao cau lenh
		PreparedStatement cmd = dc.cn.prepareStatement(query);
		
		// b4 truyen tham so neu co
		
		// b5 thuc hiencau lenh sql
		ResultSet rs = cmd.executeQuery();
		
		// b6 duyet qua rs set
		while(rs.next()) {
			String hoTen = rs.getString("HoTen");
			Double heSoLuong = rs.getDouble("HeSoLuong");
			System.out.println(hoTen + "," + heSoLuong);
		}
		
		// b7 dong ket noi
		rs.close();
		dc.cn.close();
	}
	public void HienThiNVDonVi() throws Exception {
		// b1 ket noi csdl
		DungChung dc = new DungChung();
		dc.ketNoi();
		
		// b2 thiet lap cau lenh
		String query = 	"select HoTen, NgaySinh, HeSoLuong, TenKhoa "
						+ "from DonVi "
						+ "inner join NhanVien "
						+ "on DonVi.MaKhoa = NhanVien.MaKhoa";
		
		//b3 tao cau lenh
		PreparedStatement cmd = dc.cn.prepareStatement(query);
		
		// b4 truyen tham so neu co
		
		// b5 thuc hiencau lenh sql
		ResultSet rs = cmd.executeQuery();
		
		// b6 duyet qua rs set
		while(rs.next()) {
			String hoTen = rs.getString("HoTen");
			Date ngaySinh = rs.getDate("NgaySinh");
			Double heSoLuong = rs.getDouble("HeSoLuong");
			String tenKhoa = rs.getString("TenKhoa");
			System.out.println(hoTen + ","
					+ ngaySinh + ","
					+ heSoLuong + ","
					+ tenKhoa);
		}
		
		// b7 dong ket noi
		rs.close();
		dc.cn.close();
	}
	public int xoaDonVi(String madv) throws Exception {
		// b1 ket noi csdl
		DungChung dc = new DungChung();
		dc.ketNoi();
		
		// b2 thiet lap cau lenh
		String query = 	"delete DonVi where MaKhoa = ?";
		
		//b3 tao cau lenh
		PreparedStatement cmd = dc.cn.prepareStatement(query);
		
		// b4 truyen tham so neu co
		cmd.setString(1, madv);
		
		// b5 thuc hien cau lenh sql
		int rs = cmd.executeUpdate();
		
		// b6 dong ket noi
		dc.cn.close();
		return rs;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DungChung dc = new DungChung();
			dc.HienThiNV();
			System.out.println("-----");
			dc.HienThiDonVi();
			System.out.println("-----");
			dc.HienThiNhanVienHSL45();
			System.out.println("-----");
			dc.HienThiNVDonVi();
			System.out.println("-----");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
