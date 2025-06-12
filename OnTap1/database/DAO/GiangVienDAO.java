package DAO;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.GiangVien;

public class GiangVienDAO {
	public DBConnector dbc = new DBConnector();
	
	public boolean isExist(String maGiangVien) throws Exception {
		// ket noi
		dbc.connect();
		
		// tao chuoi lenh
		String query = "select * from GiangVien where MaGiangVien = ?";
		
		// chuan bi cau lenh
		PreparedStatement cmd = DBConnector.cn.prepareStatement(query);
		
		// them tham so neu co
		cmd.setString(1, maGiangVien);
		
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
	
	public ArrayList<GiangVien> selectAllGiangVien() throws Exception {
		ArrayList<GiangVien> rs = new ArrayList<GiangVien>();
		
		// ket noi co so du lieu
		dbc.connect();
		
		// tao chuoi lenh
		String query = "select * from GiangVien";
		
		// chuan bi cau lenh
		PreparedStatement cmd = DBConnector.cn.prepareStatement(query);
		
		// them tham so neu co
		
		// thuc hien cau lenh
		ResultSet rsset = cmd.executeQuery();
		
		while (rsset.next()) {
			String hoTen = rsset.getString("HoTen");
			String loaiHopDong = rsset.getString("LoaiHopDong");
			Float heSoLuong = rsset.getFloat("HeSoLuong");
			String maGiangVien = rsset.getString("MaGiangVien");
			BigDecimal phuCap = rsset.getBigDecimal("PhuCap");
			
			GiangVien gv = new GiangVien(hoTen, loaiHopDong, heSoLuong, maGiangVien, phuCap);
			rs.add(gv);
		}
		
		// dong ket noi
		if (cmd != null) cmd.close();
		if (rsset != null) rsset.close();
		dbc.disconnect();
		
		// tra ve danh sach ket qua
		return rs;
	}
	
	public String insert(GiangVien gv) throws Exception {
		// ket noi
		dbc.connect();
		
		// tao query
		String query = "insert into GiangVien(MaGiangVien, HoTen, LoaiHopDong, HeSoLuong, PhuCap) values (?, ?, ?, ?, ?)";
		
		// chuan bi cau lenh
		PreparedStatement cmd = DBConnector.cn.prepareStatement(query);
		
		// them tham so
		cmd.setString(1, gv.getMaGiangVien());
		cmd.setString(2, gv.getHoTen());
		cmd.setString(3, gv.getLoaiHopDong());
		cmd.setFloat(4, gv.getHeSoLuong());
		cmd.setBigDecimal(5, gv.getPhuCap());
		
		// thuc thi cau lenh
		cmd.executeUpdate();
		
		// ngat ket noi
		if (cmd != null) cmd.close();
		dbc.disconnect();
		
		return "Da chen thanh cong GiangVien voi MaGiangVien = " + gv.getMaGiangVien() + "\n";
	}
}
