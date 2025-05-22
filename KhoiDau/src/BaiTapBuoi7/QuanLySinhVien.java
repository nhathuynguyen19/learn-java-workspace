<<<<<<< HEAD
package BaiTapBuoi7;

import java.util.ArrayList;

public class QuanLySinhVien {
	public void xuatSinhVien(ArrayList<SinhVien> dssv) {
		System.out.printf(
				"%-5s | %-20s | %-10s | %-15s |%-3s | %-4s%n",
				"MSV", "HTSV", "NS", "QQ", "DTB", "K"
			);
		for (SinhVien sv : dssv) {
			System.out.printf(
				"%-5s | %-20s | %-10s | %-15s |%-2.1f | %-4s%n",
				sv.getMaSV(), sv.getHoTen(), sv.getNgaySinh().toString(), sv.getQueQuan(), sv.getDiemTB(), sv.getKhoa()
			);
		}
	}
}
=======
package BaiTapBuoi7;

import java.util.ArrayList;

public class QuanLySinhVien {
	public void xuatSinhVien(ArrayList<SinhVien> dssv) {
		System.out.printf(
				"%-5s | %-20s | %-10s | %-15s |%-3s | %-4s%n",
				"MSV", "HTSV", "NS", "QQ", "DTB", "K"
			);
		for (SinhVien sv : dssv) {
			System.out.printf(
				"%-5s | %-20s | %-10s | %-15s |%-2.1f | %-4s%n",
				sv.getMaSV(), sv.getHoTen(), sv.getNgaySinh().toString(), sv.getQueQuan(), sv.getDiemTB(), sv.getKhoa()
			);
		}
	}
}
>>>>>>> 19dce88 (g)
