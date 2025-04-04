package BaiTapBuoi7;

import java.sql.Connection;
import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		String password = System.getenv("PASSWORD");
		SqlServer sqlsv = new SqlServer(); // tao doi tuong sql server
		QuanLyFile ql1 = new QuanLyFile();
		QuanLySinhVien qlsv = new QuanLySinhVien();
		QuanLyNhanVien qlnv = new QuanLyNhanVien();
		ArrayList<SinhVien> dssv1 = new ArrayList<SinhVien>();
		ArrayList<NhanVien> dsnv1 = new ArrayList<NhanVien>();
		ArrayList<String> dsk1 = new ArrayList<String>();
		
		// ket noi co so du lieu
		sqlsv.connect("LAB401-30", "1433", "NhanVienSinhVien", "sa", password);
		
		// lay doi tuong ket noi
		Connection connection = sqlsv.getConnection();
		
		// file insert to database
		ql1.fileToDatabase(sqlsv);
		
		// select sinh vien
		dssv1 = sqlsv.selectSinhVien();
		qlsv.xuatSinhVien(dssv1);
		
		// select nhan vien
		dsnv1 = sqlsv.selectNhanVien();
		qlnv.xuatNhanVien(dsnv1);
		
		// Dong ket noi
		sqlsv.disconnect();
	}

}

// java.lang
// java.util
// java.io
// java.sql

// loi tu choi dich vu sql
// thua dau nhay don trong chuoi

// ve lam xoa nhan vien
