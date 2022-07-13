
package DSA;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame {
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JPasswordField passwordField;
	static String s1;
     public static void main(String[] args) {
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		   
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				    frame.setVisible(true);
				    frame.setResizable(false);
				    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() throws EncryptedDocumentException, IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./title icon.jpg"));
		setTitle("Login");
		fis = new FileInputStream("./database.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		final int noOfRows=sh.getLastRowNum();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1980, 1070);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(0, 0, 0,88));
		panel.setBounds(701, 322, 486, 298);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(java.awt.Color.WHITE);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 24));
		lblNewLabel.setBounds(80, 71, 125, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(java.awt.Color.WHITE);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 24));
		lblNewLabel_1.setBounds(80, 146, 112, 18);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, 20));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setColumns(10);
		textField.setBounds(227, 71, 142, 24);
		panel.add(textField);
		
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Serif", Font.BOLD, 20));
		passwordField.setColumns(10);
		passwordField.setBounds(227, 146, 142, 24);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Create User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					add_user.main(null);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton.setForeground(java.awt.Color.BLACK);
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 20));
		btnNewButton.setBounds(50, 218, 142, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s1 = textField.getText();
                String s2 = passwordField.getText();
                
        		for(int i=1;i<=noOfRows;i++) {
        			Cell uday = sh.getRow(i).getCell(0);
        			Cell krishna = sh.getRow(i).getCell(1);
        			String ye = uday.toString();
        			String ey = krishna.toString();
        			if(s1.equals("admin")&& s2.equals("admin")) {
	                	
                    	 admin_page.main(null); 
                    	 dispose();
                  
                    }
        		 if(!ye.equals(s1)&& !ey.equals(s2)) {
	                	continue;}
	              else if(ye.equals(s1) && ey.equals(s2)){
                	 try {
						Order.main(null);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
                	 dispose();
                	 break;
                }               
		}
			}
		});
		btnNewButton_1.setForeground(java.awt.Color.BLACK);
		btnNewButton_1.setFont(new Font("Serif", Font.BOLD, 20));
		btnNewButton_1.setBounds(214, 218, 101, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		btnNewButton_2.setForeground(java.awt.Color.BLACK);
		btnNewButton_2.setFont(new Font("Serif", Font.BOLD, 20));
		btnNewButton_2.setBounds(352, 217, 90, 24);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("./login pic.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1924, 1031);
		contentPane.add(lblNewLabel_2);
	}
}
