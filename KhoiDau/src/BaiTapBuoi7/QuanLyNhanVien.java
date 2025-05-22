<<<<<<< HEAD
package BaiTapBuoi7;

import java.util.ArrayList;

public class QuanLyNhanVien {
	public void xuatNhanVien(ArrayList<NhanVien> dsnv) {
		System.out.printf(
				"%-5s | %-20s | %-10s | %-15s |%-3s | %-15s | %-4s%n",
				"MNV", "HTNV", "NS", "QQ", "HSL", "L", "K"
			);
		for (NhanVien nv : dsnv) {
			System.out.printf(
				"%-5s | %-20s | %-10s | %-15s |%-2.1f | %-15.1f | %-4s%n",
				nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh().toString(), nv.getQueQuan(), nv.getHeSoLuong(), nv.getLuong(), nv.getKhoa()
			);
		}
	}
}
=======
package BaiTapBuoi7;

import java.util.ArrayList;

public class QuanLyNhanVien {
	public void xuatNhanVien(ArrayList<NhanVien> dsnv) {
		System.out.printf(
				"%-5s | %-20s | %-10s | %-15s |%-3s | %-15s | %-4s%n",
				"MNV", "HTNV", "NS", "QQ", "HSL", "L", "K"
			);
		for (NhanVien nv : dsnv) {
			System.out.printf(
				"%-5s | %-20s | %-10s | %-15s |%-2.1f | %-15.1f | %-4s%n",
				nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh().toString(), nv.getQueQuan(), nv.getHeSoLuong(), nv.getLuong(), nv.getKhoa()
			);
		}
	}
}
>>>>>>> 19dce88 (g)
