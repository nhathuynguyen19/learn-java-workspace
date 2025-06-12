package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BO.CertificatesBO;
import Bean.CertificatesBean;

import java.awt.TextField;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class FrmInsertCerificate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	CertificatesBO cerbo = new CertificatesBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInsertCerificate frame = new FrmInsertCerificate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmInsertCerificate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextField textFieldCertificateID = new TextField();
		textFieldCertificateID.setBounds(102, 10, 200, 22);
		contentPane.add(textFieldCertificateID);
		
		TextField textFieldCertificateName = new TextField();
		textFieldCertificateName.setBounds(102, 40, 200, 22);
		contentPane.add(textFieldCertificateName);
		
		TextField textFieldTrainingMonth = new TextField();
		textFieldTrainingMonth.setBounds(102, 68, 200, 22);
		contentPane.add(textFieldTrainingMonth);
		
		TextField textFieldTuitionFee = new TextField();
		textFieldTuitionFee.setBounds(102, 96, 200, 22);
		contentPane.add(textFieldTuitionFee);
		
		Label label = new Label("CertificateID");
		label.setBounds(10, 10, 86, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("CertificateName");
		label_1.setBounds(10, 40, 86, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("TrainingMonth");
		label_2.setBounds(10, 68, 86, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("TuitionFee");
		label_3.setBounds(10, 96, 86, 22);
		contentPane.add(label_3);
		
		Button button = new Button("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal tuitionFee = new BigDecimal(textFieldTuitionFee.getText());
				CertificatesBean cbean = new CertificatesBean(textFieldCertificateID.getText(), textFieldCertificateName.getText(), Integer.parseInt(textFieldTrainingMonth.getText()), tuitionFee);
				try {
					cerbo.insertCertificate(cbean);
					setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(10, 135, 70, 22);
		contentPane.add(button);
	}
}
