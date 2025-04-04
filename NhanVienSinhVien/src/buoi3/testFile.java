package buoi3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class testFile {

	public static void main(String[] args) {
//		try {
//			FileReader f = new FileReader("dulieu.txt");
//			BufferedReader bd = new BufferedReader(f);
//			
//			while(true) {
//				String st = bd.readLine();
//				if (st == null || st == "") break;
//				System.out.println(st);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			FileWriter f = new FileWriter("a.txt");
			PrintWriter g = new PrintWriter(f);
			g.println("...");
			f.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
