package DSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Label;

public class Search extends JFrame {
	
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb,bw;
    private static Sheet sh,hs;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
	private JPanel contentPane1;
	private JTextField textField;
	private JPasswordField passwordField;
	static String c1,c2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public Search() throws EncryptedDocumentException, IOException {
		
		

		fis = new FileInputStream("./database.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet2");
		hs=wb.getSheet("Sheet3");
		
		setBounds(100, 100, 476, 334);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ITEM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(39, 41, 118, 21);
		contentPane1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(188, 41, 166, 27);
		contentPane1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Item");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(39, 98, 118, 21);
		contentPane1.add(lblNewLabel_1);
		
	
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(39, 157, 118, 21);
		contentPane1.add(lblNewLabel_3);
	
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String r1 = textField.getText();
					
				int noOfRows=sh.getLastRowNum();
				for(int i=1;i<=noOfRows;i++) {
        			Cell q1 = sh.getRow(i).getCell(0);
        			
        			String a1 = q1.toString();
        			
        		
	                 if(a1.equals(r1)){
                	 textField.setText(null);
                	 Cell b1,b2;
             		
             		
             		b1 = sh.getRow(i).getCell(0);
             		b2 = sh.getRow(i).getCell(1);

             	
             		c1 = b1.toString();
             		c2 = b2.toString();

                	
             		JLabel lblNewLabel_2 = new JLabel(c1);
            		lblNewLabel_2.setBounds(188, 99, 155, 27);
            		contentPane1.add(lblNewLabel_2);
                
            		JLabel lblNewLabel_4 = new JLabel(c2);
            		lblNewLabel_4.setBounds(188, 153, 166, 27);
            		contentPane1.add(lblNewLabel_4);
            		
            		
            		setState(Search.ICONIFIED);
					setState(Search.NORMAL);
                	break; 
	                 
        			
				}
			}
		}});
	
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(82, 199, 89, 23);
		contentPane1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Add to Cart");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				int noOfRows1=hs.getLastRowNum();
    			row = hs.createRow(noOfRows1+1);
    			cell = row.createCell(0);
    			cell.setCellValue(c1);
    			cell = row.createCell(1);
    			cell.setCellValue(c2);
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
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(258, 199, 118, 23);
		contentPane1.add(btnNewButton_1_1);
	}
}