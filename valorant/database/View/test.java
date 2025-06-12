package View;

import QuanLyFile.QuanLyFile;

public class test {

	public static void main(String[] args) {
		QuanLyFile qlf = new QuanLyFile();
		
		try {
			// cau 1
			qlf.outputDanhSachSinhVienTuDanhSach(qlf.loadSinhVienFromFile("sinhvien.txt"));
			
			// cau 2
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
