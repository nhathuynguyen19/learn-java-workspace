package bo;

import java.util.ArrayList;

import bean.donvibean;
import dao.donvidao;

public class donvibo {
	donvidao dvdao = new donvidao();
	ArrayList<donvibean> ds;
	public ArrayList<donvibean> getdv() throws Exception {
		ds = dvdao.getdv();
		return ds;
	}
}
