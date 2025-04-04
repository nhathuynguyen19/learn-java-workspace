package BaiTapBuoi7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;

public class QuanLyFile {
	public void fileToDatabase(SqlServer sqlsv) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			FileReader f = new FileReader("src/BaiTapBuoi7/data.txt");
			BufferedReader bf = new BufferedReader(f);
			
			while(true) {
				String line = bf.readLine();
				if (line == "" || line == null) break;
				String[] splitLine = line.split("[,]");
				String hoTen = splitLine[1];
				String ma = splitLine[0];
				Date ngaySinh = new Date(sdf.parse(splitLine[2]).getTime());
				String queQuan = splitLine[3];
				String khoa = null;
				
				if (line.charAt(0) == 's') {
					Double diemTB = Double.parseDouble(splitLine[4]);
					khoa = splitLine[5];
					
					SinhVien sv = new SinhVien(hoTen, ngaySinh, queQuan, khoa, ma, diemTB);
					sqlsv.insert(sv);
				}
				else if (line.charAt(0) == 'n') {
					Double heSoLuong = Double.parseDouble(splitLine[4]);
					Double luong = Double.parseDouble(splitLine[5]);
					khoa = splitLine[6];
					
					NhanVien nv = new NhanVien(hoTen, ngaySinh, queQuan, khoa, ma, heSoLuong, luong);
					sqlsv.insert(nv);
				}
				sqlsv.insert(khoa);
			}
			
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
