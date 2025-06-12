package View;

import java.util.ArrayList;
import java.util.Scanner;

import BO.SinhVienBo;
import Bean.SinhVien;
import QuanLyFile.QuanLyFile;

public class test {

	public static void main(String[] args) {
		QuanLyFile qlf = new QuanLyFile();
		Scanner input = new Scanner(System.in);
		SinhVienBo svbo = new SinhVienBo();
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		
		try {
			// cau 1
			ds = qlf.loadSinhVienFromFile("sinhvien.txt");
			qlf.outputDanhSachSinhVienTuDanhSach(ds);
			
			// cau 2
			System.out.print("Nhap noi sinh: ");
			String noiSinh = input.nextLine();
			qlf.outputDanhSachSinhVienTuDanhSach(svbo.danhSachSinhVienNoiSinh(noiSinh, ds));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
