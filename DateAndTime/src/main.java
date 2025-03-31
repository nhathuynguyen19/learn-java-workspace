import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		
		//1: Nhap vao 1 key (ho, ten, chu lot) in ra ho  ten tim duoc
//		String[] dsht = {" le van nam", "Le loi", "Nguyen van nam", "ngo quang hieu", "ngo van lai"};
//		
//		System.out.print("Nhap key: ");
//		String key = nhap.nextLine();
//		
//		System.out.println("Danh sach tim duoc theo key: ");
//		for (String ht:dsht) {
//			if (ht.toLowerCase().trim().contains(key.toLowerCase().trim())) {
//				System.out.println("Ho ten: " + ht.toUpperCase().trim());
//			}
//		}
		
		//2: in ra cac nguoi co ho Le
//		System.out.println("Danh sach nguoi ho Le tim duoc: ");
//		for (String ht:dsht) {
//			if (ht.toLowerCase().strip().startsWith("le")) {
//				System.out.println("Ho ten: " + ht.toUpperCase().trim());
//			}
//		}
//		
//		
//		// in ra ho ten va ma sinh vien
//		String tt = "sv1;  LE Van nam; CNNT; 23";
//		String[] ds = tt.split("[;]");
//		System.out.println("\nBai 3:");
//		
//		//
//		System.out.println("Ho ten: " + ds[1]);
//		
//		//
//		System.out.println("Ma sinh vien" + ds[0]);
		
		// cau 3 nhung cho 2 sinh vien cong nghe thong tin
		String[] dslop = {	"sv1;  LE Van nam;K48; CNNT; 23", 
						"sv2;  Le lai ;K47; CNTT; 17",
						"sv3; Tran tien; K47; Ton; 16",
						"sv4; Nguyem Trung; K47; Ly; 25",
						};

		//1: nhap vao 1 masv -> in ra diem dau vao
		System.out.print("Nhap ma sinh vien: ");
		String masv = nhap.nextLine();
		
		for (String thongtin : dslop) {
			
			String[] phantu = thongtin.split("[;]");
			if(masv.equalsIgnoreCase(phantu[0].trim())) {
				System.out.println("Diem dau vao: " + phantu[4].trim());
			}
		}

		// 2: nhap vao khoa, in ra ds sv va tbc cua diem dau vao cua khoa do
		System.out.print("\nNhap vao khoa: ");
		String tenkhoa = nhap.nextLine();
		
		Double Tong = 0.0;
		Double count = 0.0;
		for (String thongtin : dslop) {
			String[] phantu = thongtin.split("[;]");
			if (phantu[3].trim().toLowerCase().contains(tenkhoa.trim().toLowerCase())) {
				String diemstr = phantu[4].trim();
				Double diem = Double.parseDouble(diemstr);
				Tong += diem;
				count += 1;
				System.out.println("Thong tin: " 	+ phantu[0].trim() + ", " 
													+ phantu[1].trim().toLowerCase() + ", "
													+ phantu[2].trim() + ", "
													+ phantu[3].trim() + ", "
													+ phantu[4].trim()
													);
			}
		}
		Double tbc = Tong / count;
		System.out.println("Trung binh khoa: " + tbc);

		// 3: nhap vao 1 key (ho, ten, chulot) -> in ra thong tin
		System.out.print("\nNhap key: ");
		String khoa = nhap.nextLine();
		for (String thongtin : dslop) {
			String[] phantu = thongtin.split("[;]");
			if (phantu[1].trim().toLowerCase().contains(khoa.trim().toLowerCase())) {
				System.out.println("Thong tin: " 	+ phantu[0].trim() + ", " 
													+ phantu[1].trim().toLowerCase() + ", "
													+ phantu[2].trim() + ", "
													+ phantu[3].trim() + ", "
													+ phantu[4].trim()
													);
			}
		}
		
		// 4: thong ke xem moi khoa co bao nhieu sinh vien
		
		
		
		
//		String ho, hoLot, ten, hoTen;
//		Scanner nhap = new Scanner(System.in);
//		System.out.print("Nhap ho ten: ");
//		try {
//			hoTen = nhap.nextLine();
//			int pos1 = hoTen.indexOf(" ");
//			int pos2 = hoTen.lastIndexOf(" ");
//			
//			if (pos1 != -1) { // xu ly ho ten ten dem va ten
//				ho = hoTen.substring(0, pos1);
//				hoLot = hoTen.substring(pos1 + 1, pos2);
//				ten = hoTen.substring(pos2 + 1);
//				
//				System.out.println("Ho: " + "'" + ho + "'");
//				System.out.println("Ho lot: " + "'" + hoLot + "'");
//				System.out.println("Ten: " + "'" + ten + "'");
//			}
//			else if (pos1 == pos2) { // xu ly ho va ten
//				ho = hoTen.substring(0, pos1);
//				ten = hoTen.substring(pos1 + 1);
//				
//				System.out.println("Ho: " + "'" + ho + "'");
//				System.out.println("Ten: " + "'" + ten + "'");
//			}
//			else if (pos1 == -1) { // co 1 ten
//				System.out.println("Ten: " + "'" + hoTen + "'");
//			}
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
		
		
		
		
		
//		String ngay1 = "10:03 10/02/2025";
//		String ngay2 = "14:05 10/02/2025";
//		try {
//			SimpleDateFormat f = new SimpleDateFormat("hh:mm dd/MM/yyyy");
//			Date day1 = f.parse(ngay1);
//			Date day2 = f.parse(ngay2);
//			int tienMoiGio = 2000;
//			long miliseconds = day2.getTime() - day1.getTime();
//			double seconds = miliseconds / 1000;
//			double minutes = seconds / 60.0;
//			double hours = minutes / 60.0;
//			double days = hours / 24.0;
//			
//			System.out.println("So giay: " + Math.ceil(seconds));
//			System.out.println("So phut: " + Math.ceil(minutes));
//			System.out.println("So gio: " + Math.ceil(hours));
//			System.out.println("So ngay: " + Math.ceil(days));
//			
//			double gioTinhTien = Math.ceil(hours);
//			System.out.println("Ngay 1: " + f.format(day1) + " - Ngay 2: " + f.format(day2) + "\n- Cach nhau: " + seconds + " Giay");
//			System.out.println("So tien: " + gioTinhTien * tienMoiGio);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
