package DSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Manage_user extends JFrame {
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
	private JTextField textField;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./database.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_user frame = new Manage_user();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Manage_user() {
		final Cell r1;
		final Cell r2;
		r1 = sh.getRow(1).getCell(0);
		r2 = sh.getRow(1).getCell(1);
		
		setTitle("Edit User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username\r\n");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel.setBounds(101, 78, 157, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(314, 78, 157, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Chanage Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		
    			try {
					Change_password.main(null);
				} catch (EncryptedDocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			dispose();
        		
			}});
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 17));
		btnNewButton.setBounds(291, 230, 180, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = textField.getText();

    			int noOfRows=sh.getLastRowNum();
        		for(int i=1;i<=noOfRows;i++) {
        			Cell uday = sh.getRow(i).getCell(0);
        			String ye = uday.toString();

        			
        			
        		 if(!ye.equals(s1)) {
	                	continue;}
	              else if(ye.equals(s1)){
	            	
                	 }

        			row = sh.createRow(i);
        			cell = row.createCell(0);
        			cell.setCellValue("");	
        			cell = row.createCell(1);
        			cell.setCellValue("");
        			cell = row.createCell(2);
        			cell.setCellValue("");
        			cell = row.createCell(3);
        			cell.setCellValue("");
        			try {
						fos = new FileOutputStream("./database.xlsx");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			try {
						wb.write(fos);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			try {
						fos.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			try {
						fos.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		
    			JOptionPane.showMessageDialog(null,"          USER HAS BEEN REMOVED       ","USER REMOVED", JOptionPane.INFORMATION_MESSAGE);
    			textField.setText(null);
    			admin_page.main(null);
    			dispose();
    			break;
        		}}
			
		});
		btnRemoveUser.setFont(new Font("Serif", Font.BOLD, 17));
		btnRemoveUser.setBounds(63, 230, 180, 29);
		contentPane.add(btnRemoveUser);
	}
}
