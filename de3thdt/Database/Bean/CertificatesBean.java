package Bean;

import java.math.BigDecimal;

public class CertificatesBean {
	private String certificateID;
	private String certificateName;
	private int trainingMonths;
	private BigDecimal tuitionFee;
	public CertificatesBean(String certificateID, String certificateName, int trainingMonths, BigDecimal tuitionFee) {
		super();
		this.certificateID = certificateID;
		this.certificateName = certificateName;
		this.trainingMonths = trainingMonths;
		this.tuitionFee = tuitionFee;
	}
	public String getCertificateID() {
		return certificateID;
	}
	public void setCertificateID(String certificateID) {
		this.certificateID = certificateID;
	}
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	public int getTrainingMonths() {
		return trainingMonths;
	}
	public void setTrainingMonths(int trainingMonths) {
		this.trainingMonths = trainingMonths;
	}
	public BigDecimal getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(BigDecimal tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	@Override
	public String toString() {
		return "Certificates [certificateID=" + certificateID + ", certificateName=" + certificateName
				+ ", trainingMonths=" + trainingMonths + ", tuitionFee=" + tuitionFee + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
