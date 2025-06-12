package View;

import java.util.ArrayList;
import java.util.Scanner;

import BO.SinhVienBo;
import Bean.SinhVien;
import DAO.SinhVienDAO;
import QuanLyFile.QuanLyFile;

public class test {

	public static void main(String[] args) {
		QuanLyFile qlf = new QuanLyFile();
		Scanner input = new Scanner(System.in);
		SinhVienBo svbo = new SinhVienBo();
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		ArrayList<SinhVien> t = new ArrayList<SinhVien>();
		
		try {
			// cau 1
			ds = qlf.loadSinhVienFromFile("sinhvien.txt");
			qlf.outputDanhSachSinhVienTuDanhSach(ds);
			
			// cau 2
			System.out.print("Nhap noi sinh: ");
			String noiSinh = input.nextLine();
			t = svbo.danhSachSinhVienNoiSinh(noiSinh, ds);
			if (t.size() > 0) {
				qlf.outputDanhSachSinhVienTuDanhSach(t);
			} else {
				System.out.println("Khong co sinh vien sinh tai " + noiSinh);
			}
			
			// cau 3
			System.out.print("Nhap ma sinh vien can tim: ");
			String msv = input.nextLine().strip();
			t = svbo.findSinhVien(ds, msv);
			if (t.size() > 0) {
				qlf.outputDanhSachSinhVienTuDanhSach(t);
			} else {
				System.out.println("Khong ton tai sinh vien co ma " + msv);
			}
			
			// cau 4
			System.out.print("Nhap nam sinh: ");
			Integer namSinh = Integer.parseInt(input.nextLine());
			t = svbo.danhSachSinhVien2002and7(ds, namSinh);
			if (t.size() > 0) {
				qlf.outputDanhSachSinhVienTuDanhSach(t);
			} else {
				System.out.println("Khong ton tai sinh vien co nam sinh = " + namSinh + "va diem trung binh > 7.0");
			}
			
			// cau 5
			for (SinhVien sv : ds) {
				if (!svbo.isExist(sv.getMsv())) {
					svbo.insert(sv);
				}
			}
			
			//cau 6
			System.out.println("Danh sach 3 sinh vien co diem tb cao nhat");
			t = svbo.selectTop3Dtb();
			if (t.size() > 0) {
				qlf.outputDanhSachSinhVienTuDanhSach(t);
			}
			
			input.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
