package Bean;

import java.math.BigDecimal;

public class GiangVien extends Nguoi {
	private String maGiangVien;
	private BigDecimal phuCap;
	public GiangVien(String hoTen, String loaiHopDong, Float heSoLuong, String maGiangVien, BigDecimal phuCap) {
		super(hoTen, loaiHopDong, heSoLuong);
		this.maGiangVien = maGiangVien;
		this.phuCap = phuCap;
	}
	public String getMaGiangVien() {
		return maGiangVien;
	}
	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}
	public BigDecimal getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(BigDecimal phuCap) {
		this.phuCap = phuCap;
	}
	@Override
	public String toString() {
		return "GiangVien [maGiangVien=" + maGiangVien + ", phuCap=" + phuCap + ", getMaGiangVien()=" + getMaGiangVien()
				+ ", getPhuCap()=" + getPhuCap() + ", getHoTen()=" + getHoTen() + ", getLoaiHopDong()="
				+ getLoaiHopDong() + ", getHeSoLuong()=" + getHeSoLuong() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
