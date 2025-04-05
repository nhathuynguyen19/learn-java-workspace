package Phan1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Phan1 extends JFrame {
	TextField txtrs = new TextField();
	TextField txta = new TextField();
	TextField txtb = new TextField();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phan1 frame = new Phan1();
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
	public Phan1() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txta.setText("0");
				txtb.setText("0");
				txtrs.setText("0");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("a=");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setForeground(new Color(64, 0, 64));
		label.setBounds(25, 25, 50, 22);
		contentPane.add(label);
		
		txta.setBounds(81, 25, 169, 22);
		contentPane.add(txta);
		
		txtb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					int a = Integer.parseInt(txta.getText());
					int b = Integer.parseInt(txtb.getText());
					Integer s = a + b;
					txtrs.setText(s.toString());
				}
				if(e.getKeyCode() == 27) System.exit(1);
			}
		});
		txtb.setBounds(81, 53, 169, 22);
		contentPane.add(txtb);
		
		txtrs.setBounds(81, 81, 169, 22);
		contentPane.add(txtrs);
		
		Button button = new Button("+");
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBackground(new Color(255, 128, 64));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				Integer s = a + b;
				txtrs.setText(s.toString());
			}
		});
		button.setBounds(25, 109, 37, 22);
		contentPane.add(button);
		
		Label label_1 = new Label("b=");
		label_1.setForeground(new Color(64, 0, 64));
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(25, 53, 50, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Result");
		label_2.setForeground(new Color(64, 0, 64));
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(25, 81, 50, 22);
		contentPane.add(label_2);
		
		Button button_1 = new Button("/");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				if (b == 0) {
					JOptionPane.showMessageDialog(null, "Khong the chia cho 0");
				}
				else {
					Integer s = a / b;
					txtrs.setText(s.toString());
				}
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.setBackground(Color.CYAN);
		button_1.setBounds(213, 109, 37, 22);
		contentPane.add(button_1);
		
		Button button_2 = new Button("-");
		button_2.setFont(new Font("Dialog", Font.BOLD, 12));
		button_2.setBackground(Color.GREEN);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				Integer s = a - b;
				txtrs.setText(s.toString());
			}
		});
		button_2.setBounds(91, 109, 37, 22);
		contentPane.add(button_2);
		
		Button button_3 = new Button("*");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				Integer s = a * b;
				txtrs.setText(s.toString());
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 12));
		button_3.setBackground(Color.ORANGE);
		button_3.setBounds(150, 109, 37, 22);
		contentPane.add(button_3);
	}
}
