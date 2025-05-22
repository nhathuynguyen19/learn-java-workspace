<<<<<<< HEAD
package Buoi7;

public class NhanVien extends Nguoi {
	private String manv;
	private String tendv;
	private Double hsl;
	private Double phuCap;
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	@Override
	public String toString() {
		return "Nhan vien: " + manv + ";" + tendv + ";" + hsl + ";" + phuCap + ";";
	}
	public Double getHsl() {
		return hsl;
	}
	public NhanVien(String hoTen, int tuoi, String manv, String tendv, Double hsl, Double phuCap) {
		super(hoTen, tuoi);
		this.manv = manv;
		this.tendv = tendv;
		this.hsl = hsl;
		this.phuCap = phuCap;
	}
	public void setHsl(Double hsl) {
		this.hsl = hsl;
	}
	public Double getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(Double phuCap) {
		this.phuCap = phuCap;
	}
	
	public void hienThi() {
		System.out.println(this.toString());
	}
}
=======
package Buoi7;

public class NhanVien extends Nguoi {
	private String manv;
	private String tendv;
	private Double hsl;
	private Double phuCap;
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	@Override
	public String toString() {
		return "Nhan vien: " + manv + ";" + tendv + ";" + hsl + ";" + phuCap + ";";
	}
	public Double getHsl() {
		return hsl;
	}
	public NhanVien(String hoTen, int tuoi, String manv, String tendv, Double hsl, Double phuCap) {
		super(hoTen, tuoi);
		this.manv = manv;
		this.tendv = tendv;
		this.hsl = hsl;
		this.phuCap = phuCap;
	}
	public void setHsl(Double hsl) {
		this.hsl = hsl;
	}
	public Double getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(Double phuCap) {
		this.phuCap = phuCap;
	}
	
	public void hienThi() {
		System.out.println(this.toString());
	}
}
>>>>>>> 19dce88 (g)
