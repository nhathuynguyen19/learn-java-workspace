package Phan1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Phan12 extends JFrame {
	TextField txt1 = new TextField();
	Choice c1 = new Choice();
	List list1 = new List();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phan12 frame = new Phan12();
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
	public Phan12() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		txt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					c1.add(txt1.getText());
					list1.add(txt1.getText());
					txt1.setText("");
				}
			}
		});
		
		txt1.setBounds(100, 10, 200, 22);
		contentPane.add(txt1);
		
		c1.setBounds(100, 48, 200, 20);
		contentPane.add(c1);
		list1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String muc = list1.getSelectedItem();
				txt1.setText(muc);
			}
		});
		
		list1.setBounds(100, 103, 200, 131);
		contentPane.add(list1);
	}
}
