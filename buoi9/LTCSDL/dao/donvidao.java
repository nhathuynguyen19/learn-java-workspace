package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.donvibean;

public class donvidao {
	public ArrayList<donvibean> getdv() throws Exception {
		ArrayList<donvibean> ds = new ArrayList<donvibean>();
		// b1 ket noi csdl
		KetNoi dc = new KetNoi();
		dc.ketnoi();
		
		// b2 thiet lap cau lenh
		String query = "select * from DonVi";
		
		//b3 tao cau lenh
		PreparedStatement cmd = dc.cn.prepareStatement(query);
		
		// b4 truyen tham so neu co
		
		// b5 thuc hiencau lenh sql
		ResultSet rs = cmd.executeQuery();
		
		// b6 duyet qua rs set
		while(rs.next()) {
			String madv = rs.getString("madv");
			String tendv = rs.getString("tendv");
			donvibean dv = new donvibean(madv, tendv);
			ds.add(dv);
		}
		
		// b7 dong ket noi
		rs.close();
		dc.cn.close();
		System.out.println("Da Ngat Ket Noi");
		return ds;
	}
}
