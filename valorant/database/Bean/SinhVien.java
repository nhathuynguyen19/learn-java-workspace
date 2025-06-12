package Bean;

public class SinhVien {
	private String msv;
	private String ht;
	private String noiSinh;
	private Integer namSinh;
	private boolean gt;
	private Float dtb;
	
	public SinhVien(String msv, String ht, String noiSinh, Integer namSinh, boolean gt, Float dtb) {
		super();
		this.msv = msv;
		this.ht = ht;
		this.noiSinh = noiSinh;
		this.namSinh = namSinh;
		this.gt = gt;
		this.dtb = dtb;
	}
	
	public String getMsv() {
		return msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	public String getHt() {
		return ht;
	}
	public void setHt(String ht) {
		this.ht = ht;
	}
	public String getNoiSinh() {
		return noiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}
	public Integer getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(Integer namSinh) {
		this.namSinh = namSinh;
	}
	public boolean isGt() {
		return gt;
	}
	public void setGt(boolean gt) {
		this.gt = gt;
	}
	public Float getDtb() {
		return dtb;
	}
	public void setDtb(Float dtb) {
		this.dtb = dtb;
	}
	@Override
	public String toString() {
		return "SinhVien [msv=" + msv + ", ht=" + ht + ", noiSinh=" + noiSinh + ", namSinh=" + namSinh + ", gt=" + gt
				+ ", dtb=" + dtb + ", getMsv()=" + getMsv() + ", getHt()=" + getHt() + ", getNoiSinh()=" + getNoiSinh()
				+ ", getNamSinh()=" + getNamSinh() + ", isGt()=" + isGt() + ", getDtb()=" + getDtb() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
