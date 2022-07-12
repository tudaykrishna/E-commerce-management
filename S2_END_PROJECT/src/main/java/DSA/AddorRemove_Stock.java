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

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AddorRemove_Stock extends JFrame {
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
	private JTextField textField_1;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./database.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet2");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddorRemove_Stock frame = new AddorRemove_Stock();
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
	public AddorRemove_Stock() {
		final Cell r1;
		final Cell r2;
		r1 = sh.getRow(1).getCell(0);
		r2 = sh.getRow(1).getCell(1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Add Item");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = textField.getText();
    			String s2 = textField_1.getText();
    			int noOfRows=sh.getLastRowNum();
    			row = sh.createRow(noOfRows+1);
    			cell = row.createCell(0);
    			cell.setCellValue(s1);
    			cell = row.createCell(1);
    			cell.setCellValue(s2);
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
    			JOptionPane.showMessageDialog(null,"          Item ADDED SUCCESSFULLY        ","ADDED ITEM", JOptionPane.INFORMATION_MESSAGE);
    			textField.setText(null);
    			textField_1.setText(null);
        	}
				
			
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_3.setBounds(517, 172, 207, 52);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Remove Item");
		btnNewButton_3_1.addActionListener(new ActionListener() {
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
        		
    			JOptionPane.showMessageDialog(null,"          ITEM HAS BEEN REMOVED       ","ITEM REMOVED", JOptionPane.INFORMATION_MESSAGE);
    			textField.setText(null);
    			admin_page.main(null);
    			dispose();
    			break;
        		}}
				
			
		});
		btnNewButton_3_1.setForeground(Color.BLACK);
		btnNewButton_3_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_3_1.setBounds(148, 172, 207, 52);
		contentPane.add(btnNewButton_3_1);
		
		textField = new JTextField();
		textField.setBounds(269, 62, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Item");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(148, 58, 86, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPrice.setBounds(474, 58, 86, 24);
		contentPane.add(lblPrice);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(598, 62, 86, 20);
		contentPane.add(textField_1);
	}
}
