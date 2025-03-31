package BaiTapBuoi7;

import java.sql.Date;

public abstract class Nguoi {
    private String hoTen;
    private Date ngaySinh;
    private String queQuan;
    private String khoa;
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public Nguoi(String hoTen, Date ngaySinh, String queQuan, String khoa) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.khoa = khoa;
    }
    public String getQueQuan() {
        return queQuan;
    }
	public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public String getKhoa() {
        return khoa;
    }
    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
