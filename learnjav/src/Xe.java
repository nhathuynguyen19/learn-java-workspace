<<<<<<< HEAD
import java.util.Random;

public class Xe {
	public int getSx() {
		Random r = new Random();
		int soxe = r.nextInt(99999);
		return soxe;
	}
	public int Diem(int soxe) {
		int diem = 0;
		for(int i = 0; i <= 4; i++) {
			diem = diem + soxe%10;
			soxe = soxe/10;
		}
		if (diem < 10) {
			return diem;
		} else {
			return diem%10;
		}
	}
	public String HienThi(int soxe) {
		int donvi = soxe%10;
		soxe = soxe/10;
		int chuc = soxe%10;
		soxe = soxe/10;
		int tram = soxe%10;
		soxe = soxe/10;
		int nghin = soxe%10;
		soxe = soxe/10;
		int chucnghin = soxe%10;
		String chuoisx = String.valueOf(chucnghin) + String.valueOf(nghin) + String.valueOf(tram) + String.valueOf(chuc) + String.valueOf(donvi);
		return chuoisx;
	}
}
=======
import java.util.Random;

public class Xe {
	public int getSx() {
		Random r = new Random();
		int soxe = r.nextInt(99999);
		return soxe;
	}
	public int Diem(int soxe) {
		int diem = 0;
		for(int i = 0; i <= 4; i++) {
			diem = diem + soxe%10;
			soxe = soxe/10;
		}
		if (diem < 10) {
			return diem;
		} else {
			return diem%10;
		}
	}
	public String HienThi(int soxe) {
		int donvi = soxe%10;
		soxe = soxe/10;
		int chuc = soxe%10;
		soxe = soxe/10;
		int tram = soxe%10;
		soxe = soxe/10;
		int nghin = soxe%10;
		soxe = soxe/10;
		int chucnghin = soxe%10;
		String chuoisx = String.valueOf(chucnghin) + String.valueOf(nghin) + String.valueOf(tram) + String.valueOf(chuc) + String.valueOf(donvi);
		return chuoisx;
	}
}
>>>>>>> 19dce88 (g)
