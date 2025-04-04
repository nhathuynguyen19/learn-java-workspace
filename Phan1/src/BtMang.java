import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BtMang {
	public String TaoNgay(String ngay1, String ngay2) {
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			Date day1 = formatDate.parse(ngay1);
			Date day2 = formatDate.parse(ngay2);
			Random random = new Random();
			
			while(true) {
				Long temp = random.nextLong();
				
				if(temp >= day1.getTime() && temp <= day2.getTime()) {
					Date ngayMoi = new Date(temp);
					return formatDate.format(ngayMoi);
				}
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	public String TaoHoTen() {
		String[] ho = {"Tran", "Le", "Nguyen"};
		String[] chuLot = {"Thanh", "Hoang", "Trung", "Van", "My"};
		String[] ten = {"Hung", "Nga", "Tien", "Tam", "Ton", "Giang", "Sy"};
		
		Random r = new Random();
		String h = ho[r.nextInt(ho.length)];
		String cl = chuLot[r.nextInt(chuLot.length)];
		String t = ten[r.nextInt(ten.length)];
		
		return h + " " + cl + " " + t;
	}
	public Double DiemTrungBinh() {
		Random r = new Random();
		return Math.round(r.nextDouble() * 10.0 * 10.0) / 10.0;
	}
	public int GioiTinhHo(String h) {
		String[] ho = {"Tran", "Le", "Nguyen"};
		int[] gioiTinh = {-1, -1, -1};
		
		int i;
		for(i = 0; i < ho.length; i++) {
			if(ho[i].equals(h)) {
				break;
			}
		}
		return gioiTinh[i];
	}
	public int GioiTinhTenDem(String cl) {
		String[] chuLot = {"Thanh", "Hoang", "Trung", "Van", "My"};
		int[] gioiTinh = {1, 1, 1, 1, 0};
		
		int i;
		for(i = 0; i < chuLot.length; i++) {
			if(chuLot[i].equals(cl)) {
				break;
			}
		}
		return gioiTinh[i];
	}
	public int GioiTinhTen(String t) {
		String[] ten = {"Hung", "Nga", "Tien", "Tam", "Ton", "Giang", "Sy"};
		int[] gioiTinh = {1, 0, 0, 1, 1, 0, 1};
		
		int i;
		for(i = 0; i < ten.length; i++) {
			if(ten[i].equals(t)) {
				break;
			}
		}
		return gioiTinh[i];
	}
	public Boolean GioiTinh(String hoTen) {
		String[] parts = hoTen.split(" ");
		int doGioiTinhHo = GioiTinhHo(parts[0]);
		int doGioiTinh = GioiTinhTenDem(parts[1]) + GioiTinhTen(parts[2]);
		if(doGioiTinh > 1) {
			return true;
		} else if(doGioiTinh == 0) {
			return false;
		} else if(doGioiTinh == 1) {
			if(doGioiTinhHo == 1) {
				return true;
			} else if(doGioiTinhHo == 0) {
				return false;
			}
		}
		Random r = new Random();
		return r.nextBoolean();
	}
	public String HienGioiTinh(Boolean condition) {
		if(condition) {
			return "Nam";
		}
		return "Nữ";
	}
	public String KetQua(Double diemTrungBinh) {
		if(diemTrungBinh >= 5) {
			return "Đậu";
		}
		return "Rớt";
	}
	public String XepLoai(Double diemTrungBinh) {
		if(diemTrungBinh >= 8.0) {
			return "Giỏi";
		} else if(diemTrungBinh >= 6.5) {
			return "Khá";
		} else if(diemTrungBinh >= 5.0) {
			return "Trung bình";
		} else if(diemTrungBinh >= 3.0) {
			return "Yếu";
		}
		return "Kém";
	}
	public void HienThi(int n) {
		for(int i = 0; i < n; i++) {
			String hoTen = TaoHoTen();
			Double diemTrungBinh = DiemTrungBinh();
			
			System.out.println(hoTen + "; " 
					+ TaoNgay("01/01/1900", "01/01/2900") + "; " 
					+ HienGioiTinh(GioiTinh(hoTen)) + "; "
					+ diemTrungBinh + "; "
					+ KetQua(diemTrungBinh)
					);
		}
	}
}
