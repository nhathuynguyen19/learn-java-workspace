package Buoi7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FormDangNhap extends JFrame {
	TextField user_name = new TextField();
	TextField password = new TextField();
	Button button = new Button("Đăng nhập");
	ArrayList<Users> ds = new ArrayList<Users>();
	QuanLyUsers ql = new QuanLyUsers();
	public static String temmp = "";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDangNhap frame = new FormDangNhap();
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
	public FormDangNhap() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ds = ql.getUsers();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user_name.setBounds(115, 38, 160, 22);
		contentPane.add(user_name);
		
		password.setBounds(115, 77, 160, 22);
		contentPane.add(password);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (!user_name.getText().equalsIgnoreCase("")) {
						if (!password.getText().equalsIgnoreCase("")) {
							temmp = "Hello Huy";
							new FormTrangDangNhap().setVisible(true);
						}
					}
				}
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(115, 118, 70, 22);
		contentPane.add(button);
	}
}
