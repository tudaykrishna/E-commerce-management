package DSA;

import java.awt.*;import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class add_user extends JFrame implements ActionListener{
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    GridBagConstraints gbc; 
    Font f1,f2;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    
    public add_user() throws EncryptedDocumentException, IOException{
        super("Login");
        setTitle("Add User");
        setBackground(Color.WHITE);
		fis = new FileInputStream("./database.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
        f1 = new Font("TimesRoman",Font.BOLD,20);
        f2 = new Font("TimesRoman",Font.BOLD,15);
	gbc=new GridBagConstraints();
		
        gbc.gridx=0;
	gbc.gridy=0; 
        
	gbc.gridx=2;
        gbc.gridy=0;
        getContentPane().setLayout(null);
		
	gbc.gridx=0;
        gbc.gridy=2;

	gbc.gridx=2;
        gbc.gridy=2;
				
	
	gbc.gridx=0;
        gbc.gridy=8;

        gbc.gridx=2;
	gbc.gridy=8;
	
        gbc.gridx=4;
	gbc.gridy=8;
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0,88));
        panel.setBounds(727, 336, 491, 358);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        Button b2 = new Button("Submit");
        b2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String s1 = textField.getText();
    			String s2 = textField_1.getText();
    			String s4 = textField_2.getText();
    			String s5 = textField_3.getText();
    			int noOfRows=sh.getLastRowNum();
    			row = sh.createRow(noOfRows+1);
    			cell = row.createCell(0);
    			cell.setCellValue(s1);
    			cell = row.createCell(1);
    			cell.setCellValue(s2);
    			cell = row.createCell(2);
    			cell.setCellValue(s4);
    			cell = row.createCell(3);
    			cell.setCellValue(s5);
    			try {
    				fos = new FileOutputStream("./database.xlsx");
    			} catch (FileNotFoundException e1) {
    				e1.printStackTrace();
    			}
    			try {
    				wb.write(fos);
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
    			try {
    				fos.flush();
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
    			try {
    				fos.close();
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
    			JOptionPane.showMessageDialog(null,"          USER ADDED SUCCESSFULLY        ","ADDED USER", JOptionPane.INFORMATION_MESSAGE);
    			textField.setText(null);
    			textField_1.setText(null);
    			textField_2.setText(null);
    			textField_3.setText(null);
        	}
        	});
        b2.setFont(new Font("Serif", Font.BOLD, 20));
        b2.setBounds(53, 290, 77, 26);
        panel.add(b2);
        
        Button b3 = new Button("Log In");
        b3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
           	 try {
  				Login.main(null);
  			} catch (EncryptedDocumentException e1) {
  				e1.printStackTrace();
  			}
             	 dispose();        		
        	}
        });
        b3.setFont(new Font("Serif", Font.BOLD, 20));
        b3.setBounds(211, 290, 69, 26);
        panel.add(b3);
        
        Button b4 = new Button("Close");
        b4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        b4.setFont(new Font("Serif", Font.BOLD, 20));
        b4.setBounds(377, 290, 61, 26);
        panel.add(b4);
        
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 20));
        lblNewLabel_1.setBounds(130, 63, 100, 32);
        panel.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Serif", Font.PLAIN, 20));
        textField.setBounds(254, 72, 131, 25);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 20));
        lblNewLabel_2.setBounds(131, 122, 101, 22);
        panel.add(lblNewLabel_2);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Serif", Font.PLAIN, 20));
        textField_1.setBounds(254, 122, 131, 25);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("email");
        lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 20));
        lblNewLabel_3.setBounds(130, 167, 77, 26);
        panel.add(lblNewLabel_3);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Serif", Font.PLAIN, 20));
        textField_2.setBounds(254, 168, 131, 25);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Phone No.");
        lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 20));
        lblNewLabel_4.setBounds(130, 226, 100, 26);
        panel.add(lblNewLabel_4);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Serif", Font.PLAIN, 20));
        textField_3.setBounds(254, 227, 131, 25);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("./add user.png"));
        lblNewLabel.setBounds(0, 0, 1924, 1031);
        getContentPane().add(lblNewLabel);
                
        setVisible(true);   
        setSize(1980,1070); 
        setLocation(400,200);   
    }

    public void actionPerformed(ActionEvent ae){
           
            
	}
            
   
    public static void main(String[] args) throws EncryptedDocumentException, IOException{
            new add_user();
    }
}
