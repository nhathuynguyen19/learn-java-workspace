package Display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMenu frame = new FormMenu();
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
	public FormMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label labelFullName = new Label("Họ tên");
		labelFullName.setFont(new Font("Dialog", Font.BOLD, 12));
		labelFullName.setBounds(10, 10, 63, 23);
		contentPane.add(labelFullName);
		
		Label labelAge = new Label("Tuổi");
		labelAge.setFont(new Font("Dialog", Font.BOLD, 12));
		labelAge.setBounds(10, 39, 63, 23);
		contentPane.add(labelAge);
		
		TextField textFieldFullName = new TextField();
		textFieldFullName.setBounds(79, 10, 259, 21);
		contentPane.add(textFieldFullName);
		
		TextField textFieldAge = new TextField();
		textFieldAge.setBounds(79, 39, 259, 21);
		contentPane.add(textFieldAge);
		
		Button buttonAdd = new Button("Add");
		buttonAdd.setBackground(new Color(222, 221, 218));
		buttonAdd.setForeground(new Color(0, 0, 0));
		buttonAdd.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonAdd.setBounds(10, 78, 78, 25);
		contentPane.add(buttonAdd);
		
		Button buttonDel = new Button("Dellete");
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonDel.setForeground(Color.BLACK);
		buttonDel.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonDel.setBackground(new Color(222, 221, 218));
		buttonDel.setBounds(94, 78, 78, 25);
		contentPane.add(buttonDel);
		
		Button buttonSave = new Button("Save");
		buttonSave.setForeground(Color.BLACK);
		buttonSave.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonSave.setBackground(new Color(222, 221, 218));
		buttonSave.setBounds(262, 78, 78, 25);
		contentPane.add(buttonSave);
		
		Button buttonUpdate = new Button("Update");
		buttonUpdate.setForeground(Color.BLACK);
		buttonUpdate.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonUpdate.setBackground(new Color(222, 221, 218));
		buttonUpdate.setBounds(178, 78, 78, 25);
		contentPane.add(buttonUpdate);
		
		Button buttonFind = new Button("Add");
		buttonFind.setForeground(Color.BLACK);
		buttonFind.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonFind.setBackground(new Color(222, 221, 218));
		buttonFind.setBounds(346, 78, 78, 25);
		contentPane.add(buttonFind);
	}
}
