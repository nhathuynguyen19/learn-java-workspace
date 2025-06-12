package BO;

import java.util.ArrayList;

import Bean.SinhVien;
import QuanLyFile.QuanLyFile;

public class SinhVienBo {
	public QuanLyFile qlf = new QuanLyFile();
	public ArrayList<SinhVien> danhSachSinhVienNoiSinh(String noiSinh, ArrayList<SinhVien> ds) throws Exception {
		ArrayList<SinhVien> rs = new ArrayList<SinhVien>();
		for (SinhVien sv : ds) {
			if (sv.getNoiSinh().toLowerCase().contains(noiSinh.toLowerCase())) {
				rs.add(sv);
			}
		}
		return rs;
	}
}
