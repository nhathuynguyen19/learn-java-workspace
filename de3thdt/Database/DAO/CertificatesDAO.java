package DAO;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bean.CertificatesBean;

public class CertificatesDAO {
	public DatabaseConnector DBConnector = new DatabaseConnector();
	
	public ArrayList<CertificatesBean> getCertificates() throws Exception {
		ArrayList<CertificatesBean> result = new ArrayList<CertificatesBean>();
		
		DBConnector.connect();
		
		String query = "select * from Certificates";
		PreparedStatement cmd = DBConnector.connection.prepareStatement(query);
		
		ResultSet resultSet = cmd.executeQuery();
		
		while (resultSet.next()) {
			String certificateID = resultSet.getString("CertificateID");
			String certificateName = resultSet.getString("CertificateName");
			int trainingMonths = resultSet.getInt("TrainingMonths");
			BigDecimal tuitionFee = resultSet.getBigDecimal("TuitionFee");
			
			CertificatesBean certificatesBean = new CertificatesBean(certificateID, certificateName, trainingMonths, tuitionFee);
			result.add(certificatesBean);
		}
		
		resultSet.close();
		DBConnector.disconnect();
		return result;
	}
	
	public Boolean isExist(String certificateID) throws Exception {
		String query = "select 1 from Certificates where CertificateID = ?";
		PreparedStatement cmd = null;
		ResultSet rs = null;
		
		try {
			DBConnector.connect();
			cmd = DBConnector.connection.prepareStatement(query);
			cmd.setString(1, certificateID);
			rs = cmd.executeQuery();
			return rs.next();
		} finally {
			if (cmd != null) cmd.close();
			if (rs != null) rs.close();
			DBConnector.connection.close();
		}
	}
	
	public void insertCertificate(CertificatesBean ceri) throws Exception{
		
		if (isExist(ceri.getCertificateID())) {
			DatabaseConnector.logger.info("CertificateID is exist in database");
			return;
		}
		
		DBConnector.connect();
		
		String query = "insert into Certificates values(?, ?, ?, ?)";
		
		PreparedStatement cmd = DBConnector.connection.prepareStatement(query);
		
		cmd.setString(1, ceri.getCertificateID());
		cmd.setString(2, ceri.getCertificateName());
		cmd.setInt(3, ceri.getTrainingMonths());
		cmd.setBigDecimal(4, ceri.getTuitionFee());
		
		cmd.executeUpdate();
		
		cmd.close();
		DBConnector.disconnect();
		DatabaseConnector.logger.info("Inserted complete");
	}
	
	public void deleteCertificate(String certificateID) throws Exception {
		if (!isExist(certificateID)) {
			DatabaseConnector.logger.info("CertificateID is not exist in database");
			return;
		}
		
		DBConnector.connect();
		
		String query = "delete from Certificates where CertificateID = ?";
		
		PreparedStatement cmd = DBConnector.connection.prepareStatement(query);
		
		cmd.setString(1, certificateID);
		
		cmd.executeUpdate();
		
		cmd.close();
		DBConnector.disconnect();
		DatabaseConnector.logger.info("Deleted complete");
	}
	
	public void updateCertificate(CertificatesBean cb) throws Exception {
		
		if (!isExist(cb.getCertificateID())) {
			DatabaseConnector.logger.info("Not exist certificate ID");
			return;
		}
		
		String query = "update Certificates set CertificateName = ?, TrainingMonths = ?, TuitionFee = ? where CertificateID = ?";
		PreparedStatement cmd = null;
		
		try {
			DBConnector.connect();
			cmd = DBConnector.connection.prepareStatement(query);
			cmd.setString(1, cb.getCertificateName());
			cmd.setInt(2, cb.getTrainingMonths());
			cmd.setBigDecimal(3, cb.getTuitionFee());
			cmd.setString(4, cb.getCertificateID());
			cmd.executeUpdate();
			DatabaseConnector.logger.info("Updated complete");
		} finally {
			if (cmd != null) cmd.close();
			DBConnector.disconnect();
		}
	}
}
