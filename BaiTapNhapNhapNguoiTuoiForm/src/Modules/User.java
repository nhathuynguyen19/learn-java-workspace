package Modules;

public class User {
	protected String ho;
	protected String hoDem;
	protected String ten;
	protected Integer tuoi;
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getHoDem() {
		return hoDem;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String ho, String hoDem, String ten, Integer tuoi) {
		this.ho = ho;
		this.hoDem = hoDem;
		this.ten = ten;
		this.tuoi = tuoi;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Integer getTuoi() {
		return tuoi;
	}
	public void setTuoi(Integer tuoi) {
		this.tuoi = tuoi;
	}
	@Override
	public String toString() {
		return ho + ";" + hoDem + ";" + ten + ";" + tuoi;
	}
}
