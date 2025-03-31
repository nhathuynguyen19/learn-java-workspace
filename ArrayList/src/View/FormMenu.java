package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.TextField;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;

public class FormMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Ho ten");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(10, 10, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Tuoi");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(10, 38, 62, 22);
		contentPane.add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(78, 10, 249, 22);
		contentPane.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(78, 38, 249, 22);
		contentPane.add(textField_1);
		
		Button button = new Button("Add");
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(10, 66, 70, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Dellete");
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.setBounds(88, 66, 70, 22);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Find");
		button_2.setFont(new Font("Dialog", Font.BOLD, 12));
		button_2.setBounds(164, 66, 70, 22);
		contentPane.add(button_2);
		
		Button button_1_1 = new Button("Save");
		button_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1_1.setBounds(242, 66, 70, 22);
		contentPane.add(button_1_1);
		
		Button button_2_1 = new Button("Add");
		button_2_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_2_1.setBounds(318, 66, 70, 22);
		contentPane.add(button_2_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 94, 414, 156);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ho", "Ho dem", "Ten", "Tuoi"
			}
		));
		scrollPane.setViewportView(table);
	}
}
