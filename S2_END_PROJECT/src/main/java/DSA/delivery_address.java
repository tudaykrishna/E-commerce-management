package DSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(135, 118, 463, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Set Size");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		                 
		                 table.setModel(model);
		             }
		            }  catch (Exception e1) {
		             JOptionPane.showMessageDialog(null, "Kindly enter valid number");
		         }
				 textField.setText("");

		     }
			
		});
		btnNewButton.setBounds(873, 132, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enter your Address");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   a.equeue(textField.getText());
				   textField.setText("");
				   DefaultTableModel model=(DefaultTableModel) table.getModel();
				   refresh();
				   textField.setText("");
			}


		});
		btnNewButton_1.setBounds(816, 242, 146, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove your Address");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         a.dequeue();
		         refresh();
			}
			
		});
		
		btnNewButton_2.setBounds(816, 291, 146, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Payment");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment.main(null);
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
		table.setBounds(135, 216, 463, 266);
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("./delivery address.png"));
		lblNewLabel_1.setBounds(0, 0, 1056, 654);
		contentPane.add(lblNewLabel_1);
	}
}
