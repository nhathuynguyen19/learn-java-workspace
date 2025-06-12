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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmUpdateCertificate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static CertificatesBean cbean;		
	CertificatesBO cerbo = new CertificatesBO();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUpdateCertificate frame = new FrmUpdateCertificate(cbean);
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
	public FrmUpdateCertificate(CertificatesBean cbean) {
		TextField textField = new TextField();
		TextField textField_1 = new TextField();
		TextField textField_2 = new TextField();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				textField.setText(cbean.getCertificateName());
				textField_1.setText(String.valueOf(cbean.getTrainingMonths()));
				textField_2.setText(String.valueOf(cbean.getTuitionFee()));
			}
		});
		FrmUpdateCertificate.cbean = cbean;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField.setBounds(176, 10, 209, 22);
		contentPane.add(textField);
		
		textField_1.setBounds(176, 38, 209, 22);
		contentPane.add(textField_1);
		
		textField_2.setBounds(176, 66, 209, 22);
		contentPane.add(textField_2);
		
		Label label = new Label("CertificateName");
		label.setBounds(10, 10, 109, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("TrainingMonths");
		label_1.setBounds(10, 38, 109, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("TuitionFee");
		label_2.setBounds(10, 66, 109, 22);
		contentPane.add(label_2);
		
		Button button = new Button("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String certificateName = textField.getText();
				int trainingMonths = Integer.parseInt(textField_1.getText());
				BigDecimal tuitionFee = new BigDecimal(textField_2.getText());
				CertificatesBean cb = new CertificatesBean(cbean.getCertificateID(), certificateName, trainingMonths, tuitionFee);
				try {
					cerbo.updateCertificate(cb);
					setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(10, 94, 70, 22);
		contentPane.add(button);
	}
}
