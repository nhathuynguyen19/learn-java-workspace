package bean;

import java.util.Date;

public class nhanvienbean {
	private String manv;
	private String hoten;
	private Date ngaysinh;
	private Boolean gioitinh;
	private Double hsl;
	private String ghichu;
	private String madv;
	public nhanvienbean(String manv, String hoten, Date ngaysinh, Boolean gioitinh, Double hsl, String ghichu,
			String madv) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.hsl = hsl;
		this.ghichu = ghichu;
		this.madv = madv;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public Boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Double getHsl() {
		return hsl;
	}
	public void setHsl(Double hsl) {
		this.hsl = hsl;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public String getMadv() {
		return madv;
	}
	public void setMadv(String madv) {
		this.madv = madv;
	}
	@Override
	public String toString() {
		return "nhanvienbean [manv=" + manv + ", hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", gioitinh=" + gioitinh
				+ ", hsl=" + hsl + ", ghichu=" + ghichu + ", madv=" + madv + ", getManv()=" + getManv()
				+ ", getHoten()=" + getHoten() + ", getNgaysinh()=" + getNgaysinh() + ", getGioitinh()=" + getGioitinh()
				+ ", getHsl()=" + getHsl() + ", getGhichu()=" + getGhichu() + ", getMadv()=" + getMadv()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}