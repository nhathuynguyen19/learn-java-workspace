package Algorithms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class AlgorithmsManagement {
	public String SapXepU(String U) throws Exception{
		char[] charArray = U.strip().toUpperCase().toCharArray();
		Arrays.sort(charArray);
		
		String sortedU = new String(charArray);
		
		return sortedU;
	}
	
	public String LoaiBoThuocTinhGiongNhau(String U) throws Exception {
		LinkedHashSet<Character> set = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();
        
        for (char c : U.toCharArray()) {
            set.add(c);
        }
        for (char c : set) {
            result.append(c);
        }
        return result.toString();
	}
	
	
	// bao dong
	public ArrayList<String> timToHopU(String str, int index, String current) {
        ArrayList<String> result = new ArrayList<>();

        if (index == str.length()) {
            if (!current.isEmpty()) result.add(current);
            return result;
        }
        result.addAll(timToHopU(str, index + 1, current + str.charAt(index)));
        result.addAll(timToHopU(str, index + 1, current)); 

        return result;
    }
	
	public String[] BaoDong(String X, ArrayList<String[]> F) throws Exception {
		String NEW = X;
		String OLD = "";
		String content = "### ***Tính $(" + NEW + ")^+$:***" + "\n\n";
		String[] result = new String[2];
		int i = 0;
		
		content += "$X^{(" + i + ")}$(init) = " + NEW + "\n";
		
		while(!NEW.equalsIgnoreCase(OLD)) {
			OLD = NEW;
			for (String[] phuThuocHam : F) {
				i++;
				if (OLD.contains(phuThuocHam[0])) {
					content += "$X^{(" + i + ")}$(" + phuThuocHam[0] + "$\\to$" + phuThuocHam[1] + ") = " + NEW + " $\\cup$ {" + phuThuocHam[1] + "} = ";
					NEW += phuThuocHam[1];
					NEW = SapXepU(LoaiBoThuocTinhGiongNhau(NEW));
					content += NEW + "\n";
				}
				else {
					content += "$X^{(" + i + ")}$(" + phuThuocHam[0] + "$\\to$" + phuThuocHam[1] + ") = " + NEW + "\n";
				}
			}
		}
		content += "\n***$\\implies (" + X + ")^{+}$ = " + NEW + "***\n\n";
		result[0] = NEW;
		result[1] = content;
		return result;
	}
	
	public ArrayList<String> xoaBotToHopU(ArrayList<String> arr, int len) {
		ArrayList<String> rs = new ArrayList<String>();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).strip().length() == len) {
				String st = new String();
				st = arr.get(i);
				rs.add(st);
			}
		}
		return rs;
	}
}
