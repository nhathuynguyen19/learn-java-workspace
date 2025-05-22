<<<<<<< HEAD

import java.util.Scanner;

public class Mang {

	public static void main(String[] args) {
		BtMang m = new BtMang();
		Scanner nhap = new Scanner(System.in);
		BtFile filee = new BtFile();
		
		// cau a
		System.out.println("- Cau a:");
		System.out.println(m.TaoNgay("01/02/1900", "12/12/2907") + "\n__________");
		
		// cau b
		System.out.println("- Cau b:");
		for (int i = 0; i < 100; ++i) {
			System.out.println(m.TaoHoTen() + "; " + m.TaoNgay("01/02/1900", "12/12/2900"));
		}
		System.out.println("\n__________");	
		
		// cau c
		System.out.println("- Cau c:");
		System.out.print("nhap n: ");
		int n = nhap.nextInt();
		m.HienThi(n);
		
		// cau 2
		filee.TaoDanhSach(n);
		
		nhap.close();
	}
}
=======

import java.util.Scanner;

public class Mang {

	public static void main(String[] args) {
		BtMang m = new BtMang();
		Scanner nhap = new Scanner(System.in);
		BtFile filee = new BtFile();
		
		// cau a
		System.out.println("- Cau a:");
		System.out.println(m.TaoNgay("01/02/1900", "12/12/2907") + "\n__________");
		
		// cau b
		System.out.println("- Cau b:");
		for (int i = 0; i < 100; ++i) {
			System.out.println(m.TaoHoTen() + "; " + m.TaoNgay("01/02/1900", "12/12/2900"));
		}
		System.out.println("\n__________");	
		
		// cau c
		System.out.println("- Cau c:");
		System.out.print("nhap n: ");
		int n = nhap.nextInt();
		m.HienThi(n);
		
		// cau 2
		filee.TaoDanhSach(n);
		
		nhap.close();
	}
}
>>>>>>> 19dce88 (g)
