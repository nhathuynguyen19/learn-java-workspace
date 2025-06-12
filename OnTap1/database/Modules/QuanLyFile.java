package Modules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;

import BO.GiangVienBO;
import BO.NhanVienBO;
import Bean.GiangVien;
import Bean.NhanVien;

public class QuanLyFile {
	public NhanVienBO nvbo = new NhanVienBO();
	public GiangVienBO gvbo = new GiangVienBO();
	
	public String loadFileToDatabase(String path) throws Exception {
		String rs = "";
		FileReader f = new FileReader(path);
		BufferedReader bf = new BufferedReader(f);
		String line;
		
		while ((line = bf.readLine()) != null) {
			String[] lineSplit = line.split(",");
			
			if (lineSplit[0].substring(0, 2).equalsIgnoreCase("NV")) {
				String maNhanVien = lineSplit[0];
				
				if (nvbo.isExist(maNhanVien)) {
					rs += "Da ton tai NhanVien co MaNhanVien = " + maNhanVien + "\n";
				} else {
					String hoTen = lineSplit[1];
					String loaiHopDong = lineSplit[2];
					Float heSoLuong = Float.parseFloat(lineSplit[3]);
					
					NhanVien nv = new NhanVien(hoTen, loaiHopDong, heSoLuong, maNhanVien);
					rs += nvbo.insert(nv);
				}
				
			} else if (lineSplit[0].substring(0, 2).equalsIgnoreCase("GV")) {
				String maGiangVien = lineSplit[0];
				
				if (gvbo.isExist(maGiangVien)) {
					rs += "Da ton tai GiangVien co MaGiangVien = " + maGiangVien + "\n";
				} else {
					String hoTen = lineSplit[1];
					String loaiHopDong = lineSplit[2];
					Float heSoLuong = Float.parseFloat(lineSplit[3]);
					BigDecimal phuCap = new BigDecimal(lineSplit[4]);
					
					GiangVien gv = new GiangVien(hoTen, loaiHopDong, heSoLuong, maGiangVien, phuCap);	
					rs += gvbo.insert(gv);
				}
			}
		}
		f.close();
		bf.close();
		
		return rs;
	}
}
