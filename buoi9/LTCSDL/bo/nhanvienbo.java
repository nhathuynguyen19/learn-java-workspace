package bo;

import java.util.ArrayList;

import bean.nhanvienbean;
import dao.nhanviendao;

public class nhanvienbo {
	nhanviendao nvdao = new nhanviendao();
	ArrayList<nhanvienbean> ds;
	public ArrayList<nhanvienbean> getnv() throws Exception {
		ds = nvdao.getnv();
		return ds;
	}
	
	public ArrayList<nhanvienbean> TimMdv(String madv) throws Exception {
		ArrayList<nhanvienbean> tam = new ArrayList<nhanvienbean>();
		for (nhanvienbean nv : ds) {
			if (madv.toLowerCase().equals(nv.getMadv().toLowerCase())) {
				tam.add(nv);
			}
		}
		return tam;
	}
	
	public ArrayList<nhanvienbean> Tim(String Key) throws Exception {
		ArrayList<nhanvienbean> tam = new ArrayList<nhanvienbean>();
		for (nhanvienbean nv : ds) {
			if (nv.getHoten().toLowerCase().contains(Key.toLowerCase())) {
				tam.add(nv);
			}
		}
		return tam;
	}
}