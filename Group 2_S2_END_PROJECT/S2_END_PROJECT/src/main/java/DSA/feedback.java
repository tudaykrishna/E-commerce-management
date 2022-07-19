package DSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class feedback extends JFrame {
	Stack1 a;
	DefaultTableModel mode1;
	int size=0;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	private void refresh() {
		Object []q=a.update();
		for(int i=0;i<=size;i++) {
			table.setValueAt("", i, 0);
		}
		for(int i=0;i<=a.top-1;i++) {
			table.setValueAt(q[i], i, 0);}

		}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback frame = new feedback();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public feedback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(140, 128, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("enter size");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int p=Integer.parseInt(textField.getText());
					if(p!=0 && p<100) {
						size=p;
						a= new Stack1(p);
						mode1 = new DefaultTableModel();
						mode1.addColumn("Stack size:  " +p);
						for(int i=0;i<=p;i++) {
							mode1.addRow(new Object[]{""});
						}
						table.setModel(mode1);
					}
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Kindly enter valid number ");		
				}
			}
		});
		btnNewButton.setBounds(311, 127, 126, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 246, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.push(textField_1.getText());
				textField_1.setText("");
				DefaultTableModel mode1=(DefaultTableModel) table.getModel();
				mode1.addRow(new Object[] {textField_1.getText()});
				refresh();
				textField_1.setText("");
			}
		});
		btnNewButton_1.setBounds(283, 245, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.pop();
				refresh();
			}
		});
		btnNewButton_2.setBounds(399, 245, 89, 23);
		contentPane.add(btnNewButton_2);
		
		table = new JTable();
		table.setToolTipText("");
		table.setBounds(72, 294, 463, 221);
		contentPane.add(table);
		
		lblNewLabel = new JLabel("Customer Feedback");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(321, 23, 148, 23);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("./feedback.png"));
		lblNewLabel_1.setBounds(0, 0, 878, 545);
		contentPane.add(lblNewLabel_1);
	}
}
