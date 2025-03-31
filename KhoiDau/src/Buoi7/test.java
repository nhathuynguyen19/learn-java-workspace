package Buoi7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		try {
			SinhVien sv1 = new SinhVien("Hung", 20, "sv1", "CNTT");
			Nguoi sv2 = new SinhVien("Nga", 20, "sv2", "CNTT");
			NhanVien nv1 = new NhanVien("Hai", 25, "nv1", "DHKH", 2.5, 300000.0);
			NhanVien nv2 = new NhanVien("Bao", 22, "nv2", "DHKH", 3.5, 350000.0);
//			sv1.hienThi();
//			sv2.hienThi();
//			nv1.hienThi();
//			nv2.hienThi();
			
			ArrayList<Nguoi> ds = new ArrayList<Nguoi>();
			ds.add(sv1);
			ds.add(sv2);
			ds.add(nv1);
			ds.add(nv2);
			
			for (Nguoi n : ds) {
				n.hienThi();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
