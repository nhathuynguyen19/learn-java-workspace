package BO;

import java.util.ArrayList;

import Bean.NhanVien;
import DAO.NhanVienDAO;

public class NhanVienBO {
	public NhanVienDAO nvdao = new NhanVienDAO();
	
	public boolean isExist(String maNhanVien) throws Exception {
		return nvdao.isExist(maNhanVien);
	}
	
	public ArrayList<NhanVien> selectAllNhanVien() throws Exception {
		return nvdao.selectAllNhanVien();
	}
	
	public String insert(NhanVien nv) throws Exception {
		return nvdao.insert(nv);
	}
}
