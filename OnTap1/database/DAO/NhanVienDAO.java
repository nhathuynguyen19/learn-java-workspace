package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.NhanVien;

public class NhanVienDAO {
	public DBConnector dbc = new DBConnector();
	
	public boolean isExist(String maNhanVien) throws Exception {
		// ket noi
		dbc.connect();
		
		// tao chuoi lenh
		String query = "select * from NhanVien where MaNhanVien = ?";
		
		// chuan bi cau lenh
		PreparedStatement cmd = DBConnector.cn.prepareStatement(query);
		
		// them tham so neu co
		cmd.setString(1, maNhanVien);
		
		// thuc hien cau lenh
		ResultSet rsset = cmd.executeQuery();
		
		try {
			if (rsset.next()) return true;
			else return false;
		} finally {
			if (cmd != null) cmd.close();
			if (rsset != null) rsset.close();
			dbc.disconnect();
		}
		
	}
	
	public ArrayList<NhanVien> selectAllNhanVien() throws Exception {
		ArrayList<NhanVien> rs = new ArrayList<NhanVien>();
		
		// ket noi co so du lieu
		dbc.connect();
		
		// tao chuoi lenh
		String query = "select * from NhanVien";
		
		// chuan bi cau lenh
		PreparedStatement cmd = DBConnector.cn.prepareStatement(query);
		
		// them tham so neu co
		
		// thuc hien cau lenh
		ResultSet rsset = cmd.executeQuery();
		
		while (rsset.next()) {
			String hoTen = rsset.getString("HoTen");
			String loaiHopDong = rsset.getString("LoaiHopDong");
			Float heSoLuong = rsset.getFloat("HeSoLuong");
			String maNhanVien = rsset.getString("MaNhanVien");
			
			NhanVien nv = new NhanVien(hoTen, loaiHopDong, heSoLuong, maNhanVien);
			rs.add(nv);
		}
		
		// dong ket noi
		if (cmd != null) cmd.close();
		if (rsset != null) rsset.close();
		dbc.disconnect();
		
		// tra ve danh sach ket qua
		return rs;
	}
	
	public String insert(NhanVien nv) throws Exception {
		// ket noi
		dbc.connect();
		
		// tao query
		String query = "insert into NhanVien(MaNhanVien, HoTen, LoaiHopDong, HeSoLuong) values (?, ?, ?, ?)";
		
		// chuan bi cau lenh
		PreparedStatement cmd = DBConnector.cn.prepareStatement(query);
		
		// them tham so
		cmd.setString(1, nv.getMaNhanVien());
		cmd.setString(2, nv.getHoTen());
		cmd.setString(3, nv.getLoaiHopDong());
		cmd.setFloat(4, nv.getHeSoLuong());
		
		// thuc thi cau lenh
		cmd.executeUpdate();
		
		// ngat ket noi
		if (cmd != null) cmd.close();
		dbc.disconnect();
		
		return "Da chen thanh cong NhanVien voi MaNhanVien = " + nv.getMaNhanVien() + "\n";
	}
}
