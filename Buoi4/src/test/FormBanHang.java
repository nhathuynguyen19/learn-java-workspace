<<<<<<< HEAD
package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormBanHang extends JFrame {
	Label label = new Label("Chọn loại hàng");
	Label label_1 = new Label("Giá");
	Label label_2 = new Label("Nhập số lượng");
	Label label_3 = new Label("Thành tiền");
	Choice choice = new Choice();
	TextField txtgia = new TextField();
	TextField txtsl = new TextField();
	TextField txttt = new TextField();
	
	QuanLyHang ql = new QuanLyHang();
	ArrayList<Hang> ds;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Button button = new Button("Thanh toan");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBanHang frame = new FormBanHang();
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
	public FormBanHang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ds = ql.getHang();
					for (Hang hang : ds) {
						choice.add(hang.getTenhang().toString());
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label.setBounds(10, 10, 91, 22);
		contentPane.add(label);
		
		label_1.setBounds(10, 44, 62, 22);
		contentPane.add(label_1);
		
		label_2.setBounds(10, 106, 91, 22);
		contentPane.add(label_2);
		
		label_3.setBounds(10, 153, 62, 22);
		contentPane.add(label_3);
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					ds = ql.getHang();
					String tenhang = choice.getSelectedItem();
					Long gia = ql.getGia(ds, tenhang);
					txtgia.setText(gia.toString());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		choice.setBounds(128, 10, 255, 20);
		contentPane.add(choice);
		
		txtgia.setBounds(128, 44, 255, 22);
		contentPane.add(txtgia);
		txtsl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					try {
						Long gia = Long.parseLong(txtgia.getText());
						Long sl = Long.parseLong(txtsl.getText());
						Long thanhtien = gia * sl;
						txttt.setText(thanhtien.toString());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		txtsl.setBounds(128, 106, 255, 22);
		contentPane.add(txtsl);
		
		txttt.setBounds(128, 153, 255, 22);
		contentPane.add(txttt);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int t = JOptionPane.showConfirmDialog(null, "Xac nhan thanh toan");
					if (t == 0) {
						String tenhang = choice.getSelectedItem();
						Long gia = Long.parseLong(txtgia.getText());
						Long sl = Long.parseLong(txtsl.getText());
						ql.luuHang(tenhang, gia, sl);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button.setBounds(128, 198, 70, 22);
		
		contentPane.add(button);
	}

}
=======
package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormBanHang extends JFrame {
	Label label = new Label("Chọn loại hàng");
	Label label_1 = new Label("Giá");
	Label label_2 = new Label("Nhập số lượng");
	Label label_3 = new Label("Thành tiền");
	Choice choice = new Choice();
	TextField txtgia = new TextField();
	TextField txtsl = new TextField();
	TextField txttt = new TextField();
	
	QuanLyHang ql = new QuanLyHang();
	ArrayList<Hang> ds;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Button button = new Button("Thanh toan");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBanHang frame = new FormBanHang();
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
	public FormBanHang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ds = ql.getHang();
					for (Hang hang : ds) {
						choice.add(hang.getTenhang().toString());
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label.setBounds(10, 10, 91, 22);
		contentPane.add(label);
		
		label_1.setBounds(10, 44, 62, 22);
		contentPane.add(label_1);
		
		label_2.setBounds(10, 106, 91, 22);
		contentPane.add(label_2);
		
		label_3.setBounds(10, 153, 62, 22);
		contentPane.add(label_3);
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					ds = ql.getHang();
					String tenhang = choice.getSelectedItem();
					Long gia = ql.getGia(ds, tenhang);
					txtgia.setText(gia.toString());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		choice.setBounds(128, 10, 255, 20);
		contentPane.add(choice);
		
		txtgia.setBounds(128, 44, 255, 22);
		contentPane.add(txtgia);
		txtsl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					try {
						Long gia = Long.parseLong(txtgia.getText());
						Long sl = Long.parseLong(txtsl.getText());
						Long thanhtien = gia * sl;
						txttt.setText(thanhtien.toString());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		txtsl.setBounds(128, 106, 255, 22);
		contentPane.add(txtsl);
		
		txttt.setBounds(128, 153, 255, 22);
		contentPane.add(txttt);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int t = JOptionPane.showConfirmDialog(null, "Xac nhan thanh toan");
					if (t == 0) {
						String tenhang = choice.getSelectedItem();
						Long gia = Long.parseLong(txtgia.getText());
						Long sl = Long.parseLong(txtsl.getText());
						ql.luuHang(tenhang, gia, sl);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button.setBounds(128, 198, 70, 22);
		
		contentPane.add(button);
	}

}
>>>>>>> 19dce88 (g)
