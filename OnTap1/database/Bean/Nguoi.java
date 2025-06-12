package Bean;

public class Nguoi {
	private String hoTen;
	private String loaiHopDong;
	private Float heSoLuong;
	public Nguoi(String hoTen, String loaiHopDong, Float heSoLuong) {
		super();
		this.hoTen = hoTen;
		this.loaiHopDong = loaiHopDong;
		this.heSoLuong = heSoLuong;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getLoaiHopDong() {
		return loaiHopDong;
	}
	public void setLoaiHopDong(String loaiHopDong) {
		this.loaiHopDong = loaiHopDong;
	}
	public Float getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(Float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	@Override
	public String toString() {
		return "Nguoi [hoTen=" + hoTen + ", LoaiHopDong=" + loaiHopDong + ", HeSoLuong=" + heSoLuong + ", getHoTen()="
				+ getHoTen() + ", getLoaiHopDong()=" + getLoaiHopDong() + ", getHeSoLuong()=" + getHeSoLuong()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
