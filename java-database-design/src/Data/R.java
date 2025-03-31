package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class R {
	public String showU(String U) throws Exception {
		String[] splitU = U.split("");
		String content = "U = {";
		int i = 0;
		
		for (String x : splitU) {
			if (i != 0) {
				content += ", " + x;
			}
			else {
				content += x;
			}
			i++;
		}
		content += "}\n";
		return content;
	}
	
	public String showF(ArrayList<String[]> F) throws Exception {
		String content = "F = {";
		int i = 0;
		
		for (String[] x : F) {
			if (x[0] != null && x[1] != null) {
				if (i != 0) {
					content += ", " + x[0] + "$\\to$" + x[1];
				}
				else {
					content += x[0] + "$\\to$" + x[1];
				}
			}
			i++;
		}
		content += "}\n";
		return content;
	}
	
	public void setU(String st) throws Exception {
		st = st.strip().toUpperCase();
		FileWriter f = new FileWriter("U.txt", false);
		PrintWriter pf = new PrintWriter(f);
		pf.println(st);
		pf.close();
	}
	
	public void setF(String st) throws Exception {
		st = st.strip().toUpperCase();
		FileWriter f = new FileWriter("F.txt", false);
		PrintWriter pf = new PrintWriter(f);
		pf.println(st);
		pf.close();
	}
	public String getU() throws Exception {
		String result = new String();
		FileReader f = new FileReader("U.txt");
		BufferedReader bf = new BufferedReader(f);
		String line = new String();
		
		while (true) {
			line = bf.readLine();
			if (line == "" || line == null) continue;
			if (line != "" || line != null) break;
		}
		result = line.strip().toUpperCase();
		
		bf.close();
		return result;
	}
	
	public ArrayList<String[]> getF() throws Exception {
		ArrayList<String[]> result = new ArrayList<String[]>();
		FileReader f = new FileReader("F.txt");
		try (BufferedReader bf = new BufferedReader(f)) {
			String line = new String();
			String t1;
			String t2;

			while(true) {
				line = bf.readLine();
				if (line == "" || line == null) break;
				line.strip();
				String[] splitLine = line.split("[-]");
				if (splitLine.length != 2) {
					String[] t = new String[2];
					t1 = "Error";
					t2 = "Input error";
					t[0] = t1;
					t[1] = t2;
					result.add(t);
					break;
				}
				splitLine[0] = splitLine[0].toUpperCase();
				splitLine[1] = splitLine[1].toUpperCase();
				result.add(splitLine);
			}
			
			bf.close();
		}
		return result;
	}
}
