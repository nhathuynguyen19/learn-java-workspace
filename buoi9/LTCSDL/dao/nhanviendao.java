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
}
