package Bean;

public class NhanVien extends Nguoi {
	private String maNhanVien;
	
	public NhanVien(String hoTen, String loaiHopDong, Float heSoLuong, String maNhanVien) {
		super(hoTen, loaiHopDong, heSoLuong);
		this.maNhanVien = maNhanVien;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", getMaNhanVien()=" + getMaNhanVien() + ", getHoTen()="
				+ getHoTen() + ", getLoaiHopDong()=" + getLoaiHopDong() + ", getHeSoLuong()=" + getHeSoLuong()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
}
