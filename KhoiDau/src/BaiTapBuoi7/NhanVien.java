package BaiTapBuoi7;

import java.sql.Date;

public class NhanVien extends Nguoi{
	private String maNV;
	private Double heSoLuong;
	private Double luong;
	
	// Khoi tao
	public NhanVien(String hoTen, Date ngaySinh, String queQuan, String khoa, String maNV, Double heSoLuong, Double luong) {
		super(hoTen, ngaySinh, queQuan, khoa);
		this.maNV = maNV;
		this.heSoLuong = heSoLuong;
		this.luong = luong;
	}
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(Double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public Double getLuong() {
		return luong;
	}
	public void setLuong(Double luong) {
		this.luong = luong;
	}
}
