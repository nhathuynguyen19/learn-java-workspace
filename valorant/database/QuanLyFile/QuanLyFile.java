package QuanLyFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Bean.SinhVien;


public class QuanLyFile {
	public ArrayList<SinhVien> loadSinhVienFromFile(String path) throws Exception {
		ArrayList<SinhVien> rs = new ArrayList<SinhVien>();
		FileReader f = new FileReader(path);
		BufferedReader bf = new BufferedReader(f);
		String line;
		
		while ((line = bf.readLine()) != null) {
			String[] lineSplit = line.split(";");
			String msv = lineSplit[0];
			String ht = lineSplit[1];
			String noiSinh = lineSplit[2];
			Integer namSinh = Integer.parseInt(lineSplit[3]);
			boolean gt = false;
			if (lineSplit[4].equalsIgnoreCase("nam")) {
				gt = true;
			} else if (lineSplit[4].equalsIgnoreCase("nu")) {
				gt = false;
			}
			Float dtb = Float.parseFloat(lineSplit[5]);
			
			SinhVien sv = new SinhVien(msv, ht, noiSinh, namSinh, gt, dtb);
			rs.add(sv);
		}
		f.close();
		bf.close();
		
		return rs;
	}
	
	public void outputDanhSachSinhVienTuDanhSach(ArrayList<SinhVien> ds) throws Exception {
	    System.out.printf("%-6s | %-15s | %-10s | %-8s | %-9s | %-6s\n", "MaSV", "HoTen", "NoiSinh", "NamSinh", "GioiTinh", "DiemTB");

	    for (SinhVien sv : ds) {
	    	String gioiTinh = "";
	    	if (sv.isGt()) {
				gioiTinh = "nam";
			} else if (!sv.isGt()) {
				gioiTinh = "nu";
			}
	        System.out.printf("%-6s | %-15s | %-10s | %-8d | %-9s | %-6.1f\n",
	                sv.getMsv(), sv.getHt(), sv.getNoiSinh(), sv.getNamSinh(), gioiTinh, sv.getDtb());
	    }
	}
	
	
}
