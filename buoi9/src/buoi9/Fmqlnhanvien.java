package buoi9;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.donvibean;
import bean.nhanvienbean;
import bo.donvibo;
import bo.nhanvienbo;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class Fmqlnhanvien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	JList list = new JList();
	
	donvibo dvbo = new donvibo();
	nhanvienbo nvbo = new nhanvienbo();
	ArrayList<nhanvienbean> ds;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	void NapBang(ArrayList<nhanvienbean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("manv");
		mh.addColumn("hoten");
		mh.addColumn("ngaysinh");
		mh.addColumn("gioitinh");
		mh.addColumn("hsl");
		mh.addColumn("ghichu");
		mh.addColumn("madv");
		
		for (nhanvienbean nv : ds) {
			Object[] t = new Object[7];
			t[0] = nv.getManv();
			t[1] = nv.getHoten();
			t[2] = nv.getNgaysinh();
			t[3] = nv.getGioitinh();
			t[4] = nv.getHsl();
			t[5] = nv.getGhichu();
			t[6] = nv.getMadv();
			mh.addRow(t);
		}
		table.setModel(mh);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fmqlnhanvien frame = new Fmqlnhanvien();
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
	public Fmqlnhanvien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					DefaultListModel<donvibean> mh = new DefaultListModel<donvibean>();
					for (donvibean dv : dvbo.getdv()) {
						mh.addElement(dv);
					}
					list.setModel(mh);
					
					ds = nvbo.getnv();
					NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					donvibean dv = (donvibean)list.getSelectedValue();
//					System.out.println(dv.getMadv());
					NapBang(nvbo.TimMdv(dv.getMadv()));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		list.setBounds(10, 11, 157, 407);
		contentPane.add(list);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(177, 263, 485, 175);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(259, 9, 276, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(259, 40, 276, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(259, 71, 276, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(259, 102, 276, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(259, 133, 276, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(259, 164, 276, 20);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nvbo.add(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(177, 229, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedColumnCount() != -1 && table.getSelectedRow() != -1) {
					Object manv = table.getValueAt(table.getSelectedRow(), 0);
					try {
						nvbo.delete(manv.toString());
						ds = nvbo.getnv();
						NapBang(ds);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnDelete.setBounds(276, 229, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NapBang(nvbo.getnv());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(375, 229, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnLoadFile = new JButton("Load file");
		btnLoadFile.setBounds(474, 229, 89, 23);
		contentPane.add(btnLoadFile);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String key = JOptionPane.showInputDialog("Nhap ho ten");
					NapBang(nvbo.Tim(key));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnFind.setBounds(573, 229, 89, 23);
		contentPane.add(btnFind);
		
		Label label = new Label("Mã nhân viên");
		label.setBounds(173, 11, 80, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Họ tên");
		label_1.setBounds(173, 40, 80, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Ngày sinh");
		label_2.setBounds(173, 69, 80, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Giới tính");
		label_3.setBounds(173, 100, 80, 22);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Hệ số lương");
		label_4.setBounds(173, 131, 80, 22);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Ghi chú");
		label_5.setBounds(173, 162, 80, 22);
		contentPane.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(259, 192, 276, 20);
		contentPane.add(textField_6);
		
		Label label_6 = new Label("Mã đơn vị");
		label_6.setBounds(173, 190, 80, 22);
		contentPane.add(label_6);
	}
}
