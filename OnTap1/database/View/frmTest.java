package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BO.GiangVienBO;
import BO.NhanVienBO;
import Bean.GiangVien;
import Bean.NhanVien;
import Modules.QuanLyFile;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class frmTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table1;
	
	private NhanVienBO nvbo = new NhanVienBO();
	private GiangVienBO gvbo = new GiangVienBO();
	private QuanLyFile qlf = new QuanLyFile();
	
	public void insertTable1NhanVien(ArrayList<NhanVien> ds) throws Exception {
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Mã Nhân Viên");
		model.addColumn("Họ Tên");
		model.addColumn("Loại Hợp Đồng");
		model.addColumn("Hệ Số Lương");
		
		for (NhanVien nv : ds) {
			Object[] t = new Object[4];
			
			t[0] = nv.getMaNhanVien();
			t[1] = nv.getHoTen();
			t[2] = nv.getLoaiHopDong();
			t[3] = nv.getHeSoLuong();
			
			model.addRow(t);
		}
		
		table1.setModel(model);
	}
	
	public void insertTable1GiangVien(ArrayList<GiangVien> ds) throws Exception {
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Mã Giảng Viên");
		model.addColumn("Họ Tên");
		model.addColumn("Loại Hợp Đồng");
		model.addColumn("Hệ Số Lương");
		model.addColumn("Phụ Cấp");
		
		for (GiangVien gv : ds) {
			Object[] t = new Object[5];
			
			t[0] = gv.getMaGiangVien();
			t[1] = gv.getHoTen();
			t[2] = gv.getLoaiHopDong();
			t[3] = gv.getHeSoLuong();
			t[4] = gv.getPhuCap();
			
			model.addRow(t);
		}
		
		table1.setModel(model);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTest frame = new frmTest();
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
	public frmTest() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
		JScrollPane scrollPane1 = new JScrollPane();
		table1 = new JTable();
		JButton btnSelectAllNhanVien = new JButton("select * NV");
		JTextArea textAreaConsole = new JTextArea();
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 371);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane1.setBounds(137, 11, 509, 204);
		contentPane.add(tabbedPane1);
		
		tabbedPane1.addTab("New tab", null, scrollPane1, null);
		
		scrollPane1.setViewportView(table1);
		
		btnSelectAllNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insertTable1NhanVien(nvbo.selectAllNhanVien());
					textAreaConsole.setText("Select * from NhanVien");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSelectAllNhanVien.setBounds(10, 226, 109, 23);
		contentPane.add(btnSelectAllNhanVien);
		
		JButton btnSelectAllGiangVien = new JButton("select * GV");
		btnSelectAllGiangVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insertTable1GiangVien(gvbo.selectAllGiangVien());
					textAreaConsole.setText("Select * from GiangVien");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSelectAllGiangVien.setBounds(10, 260, 109, 23);
		contentPane.add(btnSelectAllGiangVien);
		
		JButton btnInsertFileToDatabase = new JButton("Load file to database");
		btnInsertFileToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textAreaConsole.setText(qlf.loadFileToDatabase("ds.txt"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInsertFileToDatabase.setBounds(137, 226, 149, 23);
		contentPane.add(btnInsertFileToDatabase);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 109, 204);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(textAreaConsole);
	}
}
