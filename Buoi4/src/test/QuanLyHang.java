<<<<<<< HEAD
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QuanLyHang {
	public ArrayList<Hang> getHang() throws Exception {
		// khai bao 1 mang chua cac hang
		ArrayList<Hang> ds = new ArrayList<Hang>();
		
		// mo file.txt, doc file va luu vao arraylist
		FileReader f = new FileReader("hang.txt");
		BufferedReader bf = new BufferedReader(f);
		
		while(true) {
			String line = bf.readLine();
			if (line == null || line == "") break;
			String[] che = line.split("[;]");
			
			Hang hang = new Hang();
			hang.setTenhang(che[0]);
			hang.setGia(Long.parseLong(che[1]));
			ds.add(hang);
		}
		
		bf.close();
		return ds;
	}
	
	public Long getGia(ArrayList<Hang> ds, String tenhang) throws Exception {
		for (Hang hang : ds) {
			if (hang.getTenhang().equalsIgnoreCase(tenhang)) {
				return hang.getGia();
			}
		}
		return (long)-1;
	}
	
	public void luuHang(String tenhang, Long gia, Long sl) throws Exception {
		// Tao ra file luuHang.txt
		// Luu ten hang;gia;sl;thanh tien
		
		FileWriter f = new FileWriter("luuHang.txt", true);
		PrintWriter p = new PrintWriter(f);
		String t = tenhang + ";" + gia + ";" + sl + ";" + gia * sl;
		p.println(t);
		
		// giam hang trong kho
		// kho khong du thi khong thanh toan
		
		p.close();
	}
}
=======
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QuanLyHang {
	public ArrayList<Hang> getHang() throws Exception {
		// khai bao 1 mang chua cac hang
		ArrayList<Hang> ds = new ArrayList<Hang>();
		
		// mo file.txt, doc file va luu vao arraylist
		FileReader f = new FileReader("hang.txt");
		BufferedReader bf = new BufferedReader(f);
		
		while(true) {
			String line = bf.readLine();
			if (line == null || line == "") break;
			String[] che = line.split("[;]");
			
			Hang hang = new Hang();
			hang.setTenhang(che[0]);
			hang.setGia(Long.parseLong(che[1]));
			ds.add(hang);
		}
		
		bf.close();
		return ds;
	}
	
	public Long getGia(ArrayList<Hang> ds, String tenhang) throws Exception {
		for (Hang hang : ds) {
			if (hang.getTenhang().equalsIgnoreCase(tenhang)) {
				return hang.getGia();
			}
		}
		return (long)-1;
	}
	
	public void luuHang(String tenhang, Long gia, Long sl) throws Exception {
		// Tao ra file luuHang.txt
		// Luu ten hang;gia;sl;thanh tien
		
		FileWriter f = new FileWriter("luuHang.txt", true);
		PrintWriter p = new PrintWriter(f);
		String t = tenhang + ";" + gia + ";" + sl + ";" + gia * sl;
		p.println(t);
		
		// giam hang trong kho
		// kho khong du thi khong thanh toan
		
		p.close();
	}
}
>>>>>>> 19dce88 (g)
