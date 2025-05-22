package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bean.nhanvienbean;
import bo.nhanvienbo;

public class nhanvienview {
	public static void main(String[] args) {
		try {
			nhanvienbo nvbo = new nhanvienbo();
			for (nhanvienbean nv : nvbo.getnv()) {
				System.out.println(nv.toString());
			}
			
			Scanner nhap = new Scanner(System.in);
			System.out.println("Nhap ma dv");
			String mdv = nhap.nextLine();
			for (nhanvienbean nv : nvbo.TimMdv(mdv))
				System.out.println(nv.toString());
			
			System.out.println("Nhap ho ten");
			String ht = nhap.nextLine();
			for(nhanvienbean nv : nvbo.Tim(ht))
				System.out.println(nv.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}