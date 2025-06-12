package BO;

import java.util.ArrayList;

import Bean.GiangVien;
import DAO.GiangVienDAO;

public class GiangVienBO {
	public GiangVienDAO gvdao = new GiangVienDAO();
	
	public boolean isExist(String maGiangVien) throws Exception {
		return gvdao.isExist(maGiangVien);
	}
	
	public ArrayList<GiangVien> selectAllGiangVien() throws Exception {
		return gvdao.selectAllGiangVien();
	}
	
	public String insert(GiangVien nv) throws Exception {
		return gvdao.insert(nv);
	}
}
