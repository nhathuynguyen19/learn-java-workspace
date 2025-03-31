package buoi3;

public class testHam {
	public void xuat(Object...ts) {
		for(Object t : ts) {
			System.out.print(t.toString() + " ");
		}
		System.out.println("");
	}
	
	public Double diemTrungBinh(Double...dsDiem) {
		Double sum = 0.0;
		for(Double t : dsDiem) {
			sum = sum + t;
		}
		return sum / dsDiem.length;
	}

	public static void main(String[] args) {
		testHam t = new testHam();
		t.xuat("Huy", 2*3, true);
		System.out.println(t.diemTrungBinh(3.0, 4.0, 5.0));
	}

}
