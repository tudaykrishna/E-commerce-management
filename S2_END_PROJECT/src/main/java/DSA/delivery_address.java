package DSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.EncryptedDocumentException;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class delivery_address extends JFrame {
	
    queue a=new queue();
    DefaultTableModel model;
 int size=0;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delivery_address frame = new delivery_address();
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
	private void refresh() {
		Object []q =a.update();

         for(int i =0;i<=size;i++){
             table.setValueAt(" ", i, 0);
         }
         for(int i =0;i<=a.rear-1;i++){
             table.setValueAt(q[i], i, 0);
             }
		
	}
	public delivery_address() {
		 try{
             int p=20;
             if(p!=0 && p<100){
                 size=p;
                 a = new queue(p);
                 model = new DefaultTableModel();
                 model.addColumn("Queue size:" +p);
                 for(int i=0;i<=p;i++) {
                     model.addRow(new Object[]{""});
                 }
                 
                 
             }
            }  catch (Exception e1) {
         }


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("1.Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(104, 134, 58, 23);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(172, 136, 121, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Enter your Address");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {				 
//				   if(textField == null) {
//					   JOptionPane.showMessageDialog(null,"          PLEASE FILL ALL THE FIELDS        ","ERROR", JOptionPane.ERROR_MESSAGE);
//					   System.out.println("hi");
//				   }
		    if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty()) {
					   JOptionPane.showMessageDialog(null,"          PLEASE FILL ALL THE FIELDS        ","ERROR", JOptionPane.ERROR_MESSAGE);
					   
				   }
		    else {  
					   
					   table.setModel(model);
					   a.equeue("Name"+":"+textField.getText());
					   a.equeue("Address"+":"+textField_1.getText());
					   a.equeue("Phone No."+":"+textField_2.getText());
					   textField.setText("");
					   DefaultTableModel model=(DefaultTableModel) table.getModel();
					   refresh();
					   textField.setText("");
				   
				   
			}}


		});
		btnNewButton_1.setBounds(798, 242, 164, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove your Address");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         a.dequeue();
		         refresh();
			}
			
		});
		
		btnNewButton_2.setBounds(798, 291, 164, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Payment");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty()) {

					   JOptionPane.showMessageDialog(null,"          PLEASE FILL ALL THE FIELDS        ","ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						payment.main(null);
					} catch (EncryptedDocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_3.setBounds(873, 531, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Delivery Address");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(389, 39, 128, 28);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setToolTipText("");
		table.setBounds(135, 313, 463, 266);
		contentPane.add(table);
		
		JLabel lblNewLabel_2_1 = new JLabel("2.Address");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(389, 136, 78, 23);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(477, 138, 121, 23);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("3.Phone No.");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(104, 194, 94, 23);
		contentPane.add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(216, 195, 121, 23);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("./delivery address.png"));
		lblNewLabel_1.setBounds(0, 0, 1056, 654);
		contentPane.add(lblNewLabel_1);
	}
}
