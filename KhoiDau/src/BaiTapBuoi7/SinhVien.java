package BaiTapBuoi7;

import java.sql.Date;

public class SinhVien extends Nguoi{
    private String maSV;
    private Double diemTB;
    
    // Khoi tao
    public SinhVien(String hoTen, Date ngaySinh, String queQuan, String khoa, String maSV, Double diemTB) {
        super(hoTen, ngaySinh, queQuan, khoa);
        this.maSV = maSV;
        this.diemTB = diemTB;
    }
    
    public String getMaSV() {
        return maSV;
    }
    public Double getDiemTB() {
        return diemTB;
    }
    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    public void setDiemTB(Double diemTB) {
        this.diemTB = diemTB;
    } 
    
}
