package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.nhanvienbean;

public class nhanviendao {
	public ArrayList<nhanvienbean> getnv() throws Exception {
		ArrayList<nhanvienbean> ds = new ArrayList<nhanvienbean>();
		// b1 ket noi csdl
		KetNoi dc = new KetNoi();
		dc.ketnoi();
		
		// b2 thiet lap cau lenh
		String query = "select * from nhanvien";
		
		//b3 tao cau lenh
		PreparedStatement cmd = dc.cn.prepareStatement(query);
		
		// b4 truyen tham so neu co
		
		// b5 thuc hiencau lenh sql
		ResultSet rs = cmd.executeQuery();
		
		// b6 duyet qua rs set
		while(rs.next()) {
			String manv = rs.getString("manv");
			String hoten = rs.getString("hoten");
			Date ngaysinh = rs.getDate("ngaysinh");
			Boolean gioitinh = rs.getBoolean("gioitinh");
			Double hsl = rs.getDouble("hsl");
			String ghichu = rs.getString("ghichu");
			String madv = rs.getString("madv");
			nhanvienbean nv = new nhanvienbean(manv, hoten, ngaysinh, gioitinh, hsl, ghichu, madv);
			ds.add(nv);
		}
		
		// b7 dong ket noi
		rs.close();
		dc.cn.close();
		System.out.println("Da Ngat Ket Noi");
		return ds;
	}
	
	public String add(String manv, String hoten, String ngaysinh, String gioitinh, String hsl, String ghichu, String madv) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		String query = "insert into NhanVien values(?, ?, ?, ?, ?, ?, ?);";
				
		PreparedStatement cmd = kn.cn.prepareStatement(query);
		
		cmd.setString(1, manv);
		cmd.setString(2, hoten);
		cmd.setString(3, ngaysinh);
		cmd.setString(4, gioitinh);
		cmd.setString(5, hsl);
		cmd.setString(6, ghichu);
		cmd.setString(7, madv);
		
		cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return "Da chen 1 nhan vien";
	}
	
	public String delete(String manv) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		String query = "delete from NhanVien where manv = ?;";
				
		PreparedStatement cmd = kn.cn.prepareStatement(query);
		
		cmd.setString(1, manv);
		
		cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return "Da xoa 1 nhan vien";
	}
}
