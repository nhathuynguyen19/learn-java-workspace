import java.util.Scanner;

public class tong2so {

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhap a: ");
		String t = nhap.nextLine();
		int a = Integer.parseInt(t);
		System.out.print("Nhap b: ");
		t = nhap.nextLine();
		int b = Integer.parseInt(t);
		System.out.println(a + " + " + b + " = " + (a+b));
	}

}
