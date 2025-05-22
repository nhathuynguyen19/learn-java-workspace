<<<<<<< HEAD
package Buoi7;

public class Nguoi {
	protected String hoTen;
	protected int tuoi;
	
	public Nguoi() {}
	public Nguoi(String hoTen) {
		this.hoTen = hoTen;
		this.tuoi = 0;
	}
	public Nguoi(String hoTen, int tuoi) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
	}
	
	public String getHoTen() {return hoTen;}
	public void setHoTen(String hoTen) {this.hoTen = hoTen;}
	public int getTuoi() {return tuoi;}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	@Override
	public String toString() {
		return getHoTen() + "; " + getTuoi();
	}
	
	public void hienThi() {
		System.out.print("Nguoi: " + hoTen + ";" + tuoi + ";");
	}
}
=======
package Buoi7;

public class Nguoi {
	protected String hoTen;
	protected int tuoi;
	
	public Nguoi() {}
	public Nguoi(String hoTen) {
		this.hoTen = hoTen;
		this.tuoi = 0;
	}
	public Nguoi(String hoTen, int tuoi) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
	}
	
	public String getHoTen() {return hoTen;}
	public void setHoTen(String hoTen) {this.hoTen = hoTen;}
	public int getTuoi() {return tuoi;}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	@Override
	public String toString() {
		return getHoTen() + "; " + getTuoi();
	}
	
	public void hienThi() {
		System.out.print("Nguoi: " + hoTen + ";" + tuoi + ";");
	}
}
>>>>>>> 19dce88 (g)
