<<<<<<< HEAD
package Buoi7;

public class SinhVien extends Nguoi{
	private String masv;
	private String tenLop;
	private Double dtb;
	
	public String getMasv() {
		return masv;
	}

	public SinhVien(String hoTen, int tuoi, String masv, String tenLop) {
		super(hoTen, tuoi);
		this.masv = masv;
		this.tenLop = tenLop;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public Double getDtb() {
		return dtb;
	}

	public void setDtb(Double dtb) {
		this.dtb = dtb;
	}

	public void hienThi() {
		super.hienThi();
		System.out.println("SV: " + masv + ";" + tenLop + ";" + dtb);
	}
}
=======
package Buoi7;

public class SinhVien extends Nguoi{
	private String masv;
	private String tenLop;
	private Double dtb;
	
	public String getMasv() {
		return masv;
	}

	public SinhVien(String hoTen, int tuoi, String masv, String tenLop) {
		super(hoTen, tuoi);
		this.masv = masv;
		this.tenLop = tenLop;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public Double getDtb() {
		return dtb;
	}

	public void setDtb(Double dtb) {
		this.dtb = dtb;
	}

	public void hienThi() {
		super.hienThi();
		System.out.println("SV: " + masv + ";" + tenLop + ";" + dtb);
	}
}
>>>>>>> 19dce88 (g)
