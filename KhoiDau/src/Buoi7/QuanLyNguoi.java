package Buoi7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuanLyNguoi {
	ArrayList<Nguoi> getNguoi() throws Exception {
		ArrayList<Nguoi> ds = new ArrayList<Nguoi>();
		
		FileReader f = new FileReader("nguoi.txt");
		BufferedReader bf = new BufferedReader(f);
		
		while(true) {
			String line = bf.readLine();
			if (line == "" || line == null) break;
			String[] che = line.split("[;]");
			String ht = che[0];
			String t = che[1];
			Nguoi p = new Nguoi(ht, Integer.parseInt(t));
			ds.add(p);
		}
		
		bf.close();
		return ds;
	}
	
	public ArrayList<Nguoi> Tim(String key, ArrayList<Nguoi> ds) throws Exception {
		ArrayList<Nguoi> temp = new ArrayList<Nguoi>();
		
		for (Nguoi n : ds) {
			if (n.getHoTen().toLowerCase().contains(key.toLowerCase())) {
				Nguoi ng = new Nguoi(n.getHoTen(), n.getTuoi());
				temp.add(ng);
			}
		}
		return temp;
	}
	
	public void xuat(ArrayList<Nguoi> ds) {
		for (Nguoi x : ds) {
			System.out.println(x.toString());
		}
	}
}
