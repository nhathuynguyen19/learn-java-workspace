package View;

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
import javax.swing.JTabbedPane;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modules.User;
import Modules.UserManagement;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class FormMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableContent;

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
		setBounds(100, 100, 474, 289);
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
		
		Button buttonFind = new Button("Find");
		buttonFind.setForeground(Color.BLACK);
		buttonFind.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonFind.setBackground(new Color(222, 221, 218));
		buttonFind.setBounds(346, 78, 78, 25);
		contentPane.add(buttonFind);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 109, 446, 135);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPaneContent = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPaneContent, null);
		
		tableContent = new JTable();
		scrollPaneContent.setViewportView(tableContent);
		tableContent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ho", "Ho dem","Ten", "Tuoi"
			}
		));
		tableContent.setToolTipText("");
		
		// Function
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					UserManagement usermn = new UserManagement();
					ArrayList<User> usersList = usermn.getUsers();
					DefaultTableModel model = (DefaultTableModel) tableContent.getModel();
					
					for (User u : usersList) {
						Object[] rowData = {u.getHo(), u.getHoDem(), u.getTen(), u.getTuoi()};
						model.addRow(rowData);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
