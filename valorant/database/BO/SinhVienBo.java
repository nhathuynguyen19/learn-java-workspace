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
	
	public ArrayList<SinhVien> findSinhVien(ArrayList<SinhVien> ds, String msv) {
		ArrayList<SinhVien> rs = new ArrayList<SinhVien>();
		
		for (SinhVien sv : ds) {
			if (sv.getMsv().equalsIgnoreCase(msv)) {
				rs.add(sv);
				return rs;
			}
		}
		
		return rs;
	}
	
	public ArrayList<SinhVien> danhSachSinhVien2002and7(ArrayList<SinhVien> ds, Integer namSinh) throws Exception {
		ArrayList<SinhVien> rs = new ArrayList<SinhVien>();
		
		for (SinhVien sv : ds) {
			if (sv.getNamSinh().equals(namSinh) && sv.getDtb() > 7.0) {
				rs.add(sv);
			}
		}
		
		return rs;
	}
}
