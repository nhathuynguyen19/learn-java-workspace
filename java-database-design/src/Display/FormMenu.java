package Display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Algorithms.AlgorithmsManagement;
import Data.R;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.awt.TextArea;
import java.awt.CardLayout;
import java.awt.List;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FormMenu extends JFrame{
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JMenu menu1 = new JMenu("Dữ liệu");
	JMenuItem menu2Item1 = new JMenuItem("Nhập U");
	JMenuItem menu2Item3 = new JMenuItem("Tính toán");
	JMenuBar menuBar = new JMenuBar();
	Label label1 = new Label("Input example:");
	Label label2 = new Label("ABCD");
	Label label3 = new Label("or abcd");
	Label label4 = new Label("or aBcD");
	Button button1 = new Button("Xác nhận");
	JMenuItem menu2Item2 = new JMenuItem("Nhập F");
	TextField textField1 = new TextField();
	
	R R1 = new R();
	String U1;
	ArrayList<String[]> F1;
	static AlgorithmsManagement almn = new AlgorithmsManagement();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel3 = new JPanel();
	private final TextField textField2 = new TextField();
	private final Choice choice3 = new Choice();
	public static String[] bdt = new String[2];
	public static ArrayList<String> toHopU = new ArrayList<String>();
	public static ArrayList<String> toHopURutGon = new ArrayList<String>();

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
	
	public void setVisibleOffAll(JPanel contentPane) {
		for (Component comp : contentPane.getComponents()) {
		    comp.setVisible(false);
		}
	}
	
	public void setChoiceThuatToan(Choice choice) {
		choice.removeAll();
		choice.addItem("Chọn thuật toán");
		choice.addItem("Tính bao đóng");
	}

	/**
	 * Create the frame.
	 */
	public FormMenu() {
		try {
			U1 = R1.getU();
			F1 = R1.getF();
			toHopU = almn.timToHopU(U1, 0, "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 441);
		setJMenuBar(menuBar);
		menuBar.add(menu1);
		menu1.add(menu2Item1);
		menu1.add(menu2Item2);
		menu1.add(menu2Item3);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(panel1, "name_128329790401796");
		panel1.setLayout(null);
		label2.setBounds(10, 41, 112, 25);
		panel1.add(label2);
		label3.setBounds(10, 67, 112, 25);
		panel1.add(label3);
		label4.setBounds(10, 98, 112, 25);
		panel1.add(label4);
		button1.setBounds(128, 41, 78, 25);
		panel1.add(button1);
		label1.setFont(new Font("Dialog", Font.BOLD, 12));
		label1.setBounds(10, 10, 112, 25);
		panel1.add(label1);
		textField1.setBounds(128, 10, 429, 21);
		panel1.add(textField1);
		contentPane.add(panel2, "name_128329801716572");
		panel2.setLayout(null);
		
		Label label8 = new Label("Input example:");
		label8.setFont(new Font("Dialog", Font.BOLD, 12));
		label8.setBounds(10, 10, 161, 25);
		panel2.add(label8);
		
		Label label9 = new Label("a-Bc");
		label9.setBounds(10, 41, 161, 25);
		panel2.add(label9);
		
		Label label10 = new Label("b-cD");
		label10.setBounds(10, 70, 161, 25);
		panel2.add(label10);
		
		Label label11 = new Label("D-HC");
		label11.setBounds(10, 101, 161, 25);
		panel2.add(label11);
		
		Label label5 = new Label("c-ab");
		label5.setBounds(10, 132, 161, 25);
		panel2.add(label5);
		
		TextArea textArea1 = new TextArea();
		textArea1.setBounds(177, 10, 380, 187);
		panel2.add(textArea1);
		
		Button button2 = new Button("Xác nhận");
		button2.setBounds(177, 203, 78, 25);
		panel2.add(button2);
		
		contentPane.add(panel3, "name_129087352696937");
		panel3.setLayout(null);
		
		Label labelData1 = new Label("U =");
		labelData1.setFont(new Font("Dialog", Font.BOLD, 12));
		labelData1.setBounds(427, 10, 32, 23);
		panel3.add(labelData1);
		
		List list2 = new List();
		list2.setBounds(465, 39, 92, 121);
		panel3.add(list2);
		
		Label labelData2 = new Label("F =");
		labelData2.setFont(new Font("Dialog", Font.BOLD, 12));
		labelData2.setBounds(427, 39, 32, 23);
		panel3.add(labelData2);
		textField2.setBounds(465, 10, 92, 21);
		panel3.add(textField2);
		Choice choice1 = new Choice();
		choice1.setFont(new Font("Dialog", Font.PLAIN, 12));
		choice1.setBounds(10, 10, 130, 31);
		panel3.add(choice1);
		TextArea textAreaRS = new TextArea();
		textAreaRS.setBounds(146, 10, 275, 321);
		panel3.add(textAreaRS);
		Button buttonRun = new Button("Run");buttonRun.setBounds(343, 337, 78, 25);
		panel3.add(buttonRun);
		Button buttonCopy = new Button("Copy");
		buttonCopy.setBounds(259, 337, 78, 25);
		panel3.add(buttonCopy);
		Choice choice2 = new Choice();
		choice2.setBounds(10, 47, 130, 31);
		panel3.add(choice2);
		choice3.setBounds(10, 84, 130, 31);
		panel3.add(choice3);
		setChoiceThuatToan(choice1);
		
		

		choice2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int lenVeTrai = Integer.parseInt(choice2.getSelectedItem());
				try {
					U1 = R1.getU();
					F1 = R1.getF();
					toHopU = almn.timToHopU(U1, 0, "");
					toHopURutGon = almn.xoaBotToHopU(toHopU, lenVeTrai);
				} catch (Exception e2) {
					// TODO: handle exceptions
					e2.printStackTrace();
				}
				choice3.removeAll();
				choice3.addItem("Chọn tập thuộc tính");
				for (String x : toHopURutGon) {
					choice3.addItem(x);
				}
				
			}
		});
		choice1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (choice1.getSelectedItem().toString().equalsIgnoreCase("Tính bao đóng")) {
					try {
						U1 = R1.getU();
						F1 = R1.getF();
						toHopU = almn.timToHopU(U1, 0, "");
						choice2.removeAll();
						choice2.addItem("Số lượng thuộc tính");
						for (int i = 1; i <= R1.getU().length(); i++) {
							choice2.addItem(String.valueOf(i));
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		buttonRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (choice1.getSelectedItem().strip().toString() == "Tính bao đóng") {
					try {
						String content = "";
						content += R1.showU(U1);
						content += R1.showF(F1) + "\n";
						bdt = almn.BaoDong(choice3.getSelectedItem().toString(), F1);
						content += bdt[1];
						textAreaRS.setText(content);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		buttonCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textAreaRS.getText();
				StringSelection selection = new StringSelection(text);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			}
		});
		
		for (Component comp : contentPane.getComponents()) {
		    comp.setVisible(false);
		}
		
		button2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				choice2.removeAll();
				choice3.removeAll();
				setChoiceThuatToan(choice1);
				try {
					if (textArea1.getText().toString().strip() != "") {
						  R1.setF(textArea1.getText());
						  F1 = R1.getF();
					}
					textArea1.setText("");
					setVisibleOffAll(contentPane);
					
					list2.removeAll();
					textField2.setText(U1);
					for (String[] x : F1) {
						list2.addItem(x[0] + "->" +x[1]);
					}
					  
					panel3.setVisible(true);
					  
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if (textField1.getText().toString().strip() != "" ) {
							R1.setU(textField1.getText());
						}
						U1 = R1.getU();
						panel1.setVisible(false);
						panel2.setVisible(true);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		});
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField1.getText().toString().strip() != "") {
						R1.setU(textField1.getText());
					}
					U1 = R1.getU();
					panel1.setVisible(false);
					panel2.setVisible(true);
					textArea1.requestFocusInWindow();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		menu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menu1.doClick();
			}
		});
		
		menu2Item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component comp : contentPane.getComponents()) {
				    comp.setVisible(false);
				}
				panel1.setVisible(true);
				textField1.setVisible(true);
				textField1.setText("");
			}
		});
		menu2Item3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				for (Component comp : contentPane.getComponents()) {
				    comp.setVisible(false);
				}

				list2.removeAll();
				
				textField2.setText(U1);
				for (String[] x : F1) {
					list2.addItem(x[0] + "->" +x[1]);
				}
				
				panel3.setVisible(true);
			}
		});
		
		menu2Item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component comp : contentPane.getComponents()) {
				    comp.setVisible(false);
				}
				textArea1.setText("");
				panel2.setVisible(true);
			}
		});
	}
}
