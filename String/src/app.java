import java.text.SimpleDateFormat;

public class app {
	public static boolean KtNgay(String ngay) {
		try {
			SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
			dd.setLenient(false);
			System.out.println(dd.parseObject(ngay));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(KtNgay("19/09/2005"));
	}

}
