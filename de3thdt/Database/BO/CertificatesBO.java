package BO;

import java.util.ArrayList;

import Bean.CertificatesBean;
import DAO.CertificatesDAO;

public class CertificatesBO {
	public CertificatesDAO certificateDAO = new CertificatesDAO();
	
	public ArrayList<CertificatesBean> getCertificates() throws Exception {
		return certificateDAO.getCertificates();
	}
	
	public Boolean isExist(String certificateID) throws Exception {
		return certificateDAO.isExist(certificateID);
	}
	
	public void insertCertificate(CertificatesBean ceri) throws Exception{
		certificateDAO.insertCertificate(ceri);
	}
	
	public void deleteCertificate(String certificateID) throws Exception {
		certificateDAO.deleteCertificate(certificateID);
	}
	
	public void updateCertificate(CertificatesBean cb) throws Exception {
		certificateDAO.updateCertificate(cb);
	}
}
