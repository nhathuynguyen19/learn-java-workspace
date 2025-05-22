package view;

import bean.donvibean;
import bo.donvibo;

public class donviview {
	public static void main(String[] args) {
		try {
			donvibo dvbo = new donvibo();
			for (donvibean dv : dvbo.getdv())
				System.out.println(dv.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
