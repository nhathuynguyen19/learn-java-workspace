<<<<<<< HEAD
package buoi3;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		TruongHoc th = new TruongHoc();
		ArrayList ds = th.getThongTin();

		th.luuFile(ds);
		th.in_danhSachSinhVien(ds);
		th.in_danhSachNhanVien(ds);
		
		System.out.print("Nhap ma sinh vien de xem diem trung binh: ");
		String masinhvien = nhap.nextLine();
		System.out.println(th.get_diemTrungBinh(masinhvien, ds));
		
		System.out.print("Nhap key de in ra thong tin: ");
		String keyperson = nhap.nextLine();
		th.get_thongTin(keyperson, ds);
		
		
		nhap.close();
	}

}
=======
package buoi3;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		TruongHoc th = new TruongHoc();
		ArrayList ds = th.getThongTin();

		th.luuFile(ds);
		th.in_danhSachSinhVien(ds);
		th.in_danhSachNhanVien(ds);
		
		System.out.print("Nhap ma sinh vien de xem diem trung binh: ");
		String masinhvien = nhap.nextLine();
		System.out.println(th.get_diemTrungBinh(masinhvien, ds));
		
		System.out.print("Nhap key de in ra thong tin: ");
		String keyperson = nhap.nextLine();
		th.get_thongTin(keyperson, ds);
		
		
		nhap.close();
	}

}
>>>>>>> 19dce88 (g)
