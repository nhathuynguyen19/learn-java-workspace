import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;

public class BtFile {
	public void TaoDanhSach(int n) {
		try {
			FileOutputStream f = new FileOutputStream("sv.txt");
			OutputStreamWriter o = new OutputStreamWriter(f);
			PrintWriter w = new PrintWriter(o);
			
			Random r = new Random();
			BtMang m = new BtMang();
			for (int i = 1; i <= n; i++) {
				double dtb = r.nextDouble()*10;
				w.println("Sv" + i + ";" +m.TaoHoTen() + ";" + m.TaoNgay("01/01/1960", "01/01/2000") + ";" + dtb);
			}
			w.close();
			System.out.println("Da tao xong");
		} catch (Exception e) {
			System.out.println("Loi o ham TaoDanhSach: " + e.getMessage());
		}
	}
}
