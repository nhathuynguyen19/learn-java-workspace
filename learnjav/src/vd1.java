import java.util.Scanner;

public class vd1 {

	public static void main(String[] args) {
		int max = 0;
		int n;
		System.out.print("Nhap so luong xe: ");
		Scanner nhap = new Scanner(System.in);
		String str = nhap.nextLine();
		n = Integer.parseInt(str);
		int[] array = new int[n];
		Xe temp = new Xe();
		for(int i = 0; i < n; i++) {
			Xe x = new Xe();
			array[i] = x.getSx();
			if(max < x.Diem(array[i])) {
				max = x.Diem(array[i]);
			}
			int t = i + 1;
			System.out.println("So xe " + t + ": " + x.HienThi(array[i]) + ", Diem: " + x.Diem(array[i]));
		}
		System.out.println("Diem cao nhat: "+max);
		for(int i = 0; i < n; i++) {
			if(max == temp.Diem(array[i])) {
				int t = i + 1;
				System.out.println("so xe " + t + ": " + temp.HienThi(array[i]) + ", Diem: " + temp.Diem(array[i]));
			}
		}

	}

}
