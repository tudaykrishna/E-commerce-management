package DSA;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

import com.graphbuilder.struc.Stack;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class payment extends JFrame {
	static int total =0;
	private static FileInputStream fis,sif,sif1;
    private static FileOutputStream fos;
    private static Workbook wb,bw,bw1;
    private static Sheet sh,hs,hs1;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
	private JPanel contentPane;
	static int bye;
	static String su;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment();
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
	 */
	

	public payment() throws IOException {
		fis = new FileInputStream("./database.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet2");
		final int noOfRows=sh.getLastRowNum();
		
		sif = new FileInputStream("./database.xlsx");
		bw=WorkbookFactory.create(sif);
		hs=bw.getSheet("Sheet3");
		final int noOfRows1=hs.getLastRowNum();
		
		sif1 = new FileInputStream("./database.xlsx");
		bw1=WorkbookFactory.create(sif1);
		hs1=bw1.getSheet("Sheet5");
		final int noOfRows2=hs1.getLastRowNum();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		 
		
		JButton btnNewButton = new JButton("Display Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Stack s = new Stack();
				for(int j=1;j<=noOfRows1;j++) {
					Cell uday = hs.getRow(j).getCell(0);
        			Cell krishna = hs.getRow(j).getCell(1);
        			String su = uday.toString();
        			String se = krishna.toString();
        			
				
				
        		for(int i=1;i<=noOfRows;i++) {
        			Cell ud = sh.getRow(i).getCell(0);
        			Cell kri = sh.getRow(i).getCell(1);
        			String ye = ud.toString();
        			String ey = kri.toString();
        			
        			int hi = Integer.valueOf(ey);
        			int bye = Integer.valueOf(se);
        			
        		    
        			
        		
        			
        			if(su.equals(ye)) {
        				int jack = hi*bye;   
        				s.push(jack);   
        				
        				
        				
                   }        			
        			}        		        		
        		}
				while(!s.isEmpty()) {
					String w = (String) s.pop().toString();
					total = total+ Integer.valueOf(w);
				}
				
				 
        		String eww = String.valueOf(total);
         		JLabel lblNewLabel_2 = new JLabel(eww);
        		lblNewLabel_2.setBounds(190, 159, 155, 27);
        		contentPane.add(lblNewLabel_2);
        		
        		setState(payment.ICONIFIED);
				setState(payment.NORMAL);

			
		}});
		btnNewButton.setBounds(44, 61, 136, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Caash On Delivery");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login a = null;
				try {
					a = new Login();
				} catch (EncryptedDocumentException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

    			row = hs1.createRow(noOfRows2+1);
    			cell = row.createCell(0);
    			cell.setCellValue(a.s1);
    			cell = row.createCell(1);
    			cell.setCellValue(total);

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
		btnNewButton_1.setBounds(202, 61, 163, 23);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblNewLabel = new JLabel("Total Amount:");
		lblNewLabel.setBounds(96, 165, 84, 14);
		contentPane.add(lblNewLabel);
	}
}
