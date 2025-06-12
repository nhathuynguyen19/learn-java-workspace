package View;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BO.CertificatesBO;
import Bean.CertificatesBean;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	public CertificatesBO certificatesBO = new CertificatesBO();
	public void InsertCertificatesTable(ArrayList<CertificatesBean> listCertificates) {
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("CertificateID");
		model.addColumn("CertificateName");
		model.addColumn("TrainingMonths");
		model.addColumn("TuitionFee");
		
		for (CertificatesBean c : listCertificates) {
			Object[] temp = new Object[4];
			
			temp[0] = c.getCertificateID();
			temp[1] = c.getCertificateName();
			temp[2] = c.getTrainingMonths();
			temp[3] = c.getTuitionFee();
			
			model.addRow(temp);
		}
		
		table.setModel(model);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
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
	public FrmTest() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					InsertCertificatesTable(certificatesBO.getCertificates());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		contentPane = new JPanel();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 412);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane.setBounds(175, 30, 546, 293);
		contentPane.add(tabbedPane);
		
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		scrollPane.setViewportView(table);
		
		Button button = new Button("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmInsertCerificate frminsert = new FrmInsertCerificate();
				frminsert.setVisible(true);
			}
		});
		button.setBounds(175, 329, 70, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Delete");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i : table.getSelectedRows()) {
					String certificateID = (String) table.getValueAt(i, 0);
					try {
						certificatesBO.deleteCertificate(certificateID);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_1.setBounds(251, 329, 70, 22);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Update");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRows().length > 1 || table.getSelectedRows().length < 1) {
					return;
				}
				int row = table.getSelectedRow();
				String id = (String) table.getValueAt(row, 0);
				String name = (String) table.getValueAt(row, 1);
				int tnm = (int) table.getValueAt(row, 2);
				BigDecimal ttf = new BigDecimal(table.getValueAt(row, 3).toString());
				
				CertificatesBean cb = new CertificatesBean(id, name, tnm, ttf);
				FrmUpdateCertificate frmupdate = new FrmUpdateCertificate(cb);
				frmupdate.setVisible(true);
			}
		});
		button_2.setBounds(327, 329, 70, 22);
		contentPane.add(button_2);
		
		Button button_2_1 = new Button("Write file");
		button_2_1.setBounds(403, 329, 70, 22);
		contentPane.add(button_2_1);
		
		Button button_2_1_1 = new Button("Load file");
		button_2_1_1.setBounds(479, 329, 70, 22);
		contentPane.add(button_2_1_1);
		
		Button button_2_1_1_1 = new Button("Find");
		button_2_1_1_1.setBounds(555, 329, 70, 22);
		contentPane.add(button_2_1_1_1);
		
		Button button_2_1_1_1_1 = new Button("Reload");
		button_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InsertCertificatesTable(certificatesBO.getCertificates());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2_1_1_1_1.setBounds(631, 329, 70, 22);
		contentPane.add(button_2_1_1_1_1);
	}
}
