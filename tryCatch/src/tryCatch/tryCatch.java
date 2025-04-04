package tryCatch;

public class tryCatch {

	public static void main(String[] args) {
		try {
			int a = 5;
			int b = 0;
			int s = a / b;
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("Loi: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Dong lenh 2");
	}

}
