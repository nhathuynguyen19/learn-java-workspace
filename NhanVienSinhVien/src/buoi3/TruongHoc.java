package buoi3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TruongHoc {
	public ArrayList getThongTin() {
		ArrayList ds = new ArrayList();
		
		try {
			FileReader f = new FileReader("data.txt");
			BufferedReader bd = new BufferedReader(f);
	
			while(true) {
				String st = bd.readLine();
				if (st == null || st == "") break;
				String[] che = st.split("[;]");
				
				if (che.length==3) {
					SinhVien sv = new SinhVien();
					sv.setMasv(che[0]);
					sv.setHoten(che[1]);
					sv.setDtb(Double.parseDouble(che[2]));
					ds.add(sv);
				}
				else  {
					NhanVien nv = new NhanVien();
					nv.setManv(che[0]);
					nv.setHoten(che[1]);
					nv.setTendv(che[2]);
					nv.setHsl(Double.parseDouble(che[3]));
					ds.add(nv);
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return ds;
	}
	
	public void luuFile(ArrayList ds) {
		try {
			FileWriter fsv = new FileWriter("fsv.txt");
			FileWriter fnv = new FileWriter("fnv.txt");
			PrintWriter gsv = new PrintWriter(fsv);
			PrintWriter gnv = new PrintWriter(fnv);
			
			for(Object o : ds) {
				if (o instanceof SinhVien) {
					SinhVien sv = (SinhVien)o;
					gsv.println(sv.toString());
				}
				else if (o instanceof NhanVien) {
					NhanVien nv = (NhanVien)o;
					gnv.println(nv.toString());
				}
			}
			
			fsv.close();
			fnv.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Double get_diemTrungBinh(String masv, ArrayList ds) {
		for(Object o : ds) {
			if (o instanceof SinhVien) {
				SinhVien sv = (SinhVien)o;
				if (sv.getMasv().equalsIgnoreCase(masv)) {
					return sv.getDtb();
				}
			}
		}
		return -1.0;
	}
	
	public void in_danhSachSinhVien(ArrayList ds) {
		System.out.println("Danh sach sinh vien:");
		for(Object o : ds) {
			if (o instanceof SinhVien) {
				SinhVien sv = (SinhVien)o;
				System.out.println("- " + sv.toString());
			}
		}
	}
	
	public void in_danhSachNhanVien(ArrayList ds) {
		System.out.println("Danh sach nhan vien:");
		for(Object o : ds) {
			if (o instanceof NhanVien) {
				NhanVien nv = (NhanVien)o;
				System.out.println("- " + nv.toString());
			}
		}
	}
	
	public void get_thongTin(String keyperson, ArrayList ds) {
		for(Object o : ds) {
			if (o instanceof SinhVien) {
				SinhVien sv = (SinhVien)o;
				if (sv.getHoten().toLowerCase().contains(keyperson.toLowerCase().strip())) {
					System.out.println(sv.toString());
				}
			}
			else if (o instanceof NhanVien) {
				NhanVien nv = (NhanVien)o;
				if (nv.getHoten().toLowerCase().contains(keyperson.toLowerCase().strip())) {
					System.out.println(nv.toString());
				}
			}
		}
	}
}
