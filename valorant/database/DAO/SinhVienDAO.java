package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.SinhVien;

public class SinhVienDAO {
	public Connector dbc = new Connector();
	
	public boolean isExist(String msv) throws Exception {
		// ket noi
		dbc.connect();
		
		// tao chuoi lenh
		String query = "select * from NhanVien where MaNhanVien = ?";
		
		// chuan bi cau lenh
		PreparedStatement cmd = Connector.cn.prepareStatement(query);
		
		// them tham so neu co
		cmd.setString(1, msv);
		
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
	
	public void insert(SinhVien sv) throws Exception {
		// ket noi
		dbc.connect();
		
		// tao query
		String query = "insert into SinhVien(MaSv, HoTen, QueQuan, NamSinh, GioiTinh, DiemTB) values (?, ?, ?, ?, ?, ?)";
		
		// chuan bi cau lenh
		PreparedStatement cmd = Connector.cn.prepareStatement(query);
		
		// them tham so
		cmd.setString(1, sv.getMsv());
		cmd.setString(2, sv.getHt());
		cmd.setString(3, sv.getNoiSinh());
		cmd.setInt(4, sv.getNamSinh());
		cmd.setBoolean(5, sv.isGt());
		cmd.setFloat(5, sv.getDtb());
		
		// thuc thi cau lenh
		cmd.executeUpdate();
		
		// ngat ket noi
		if (cmd != null) cmd.close();
		dbc.disconnect();
	}
}
