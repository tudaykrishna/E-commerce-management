package DSA;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class payment extends JFrame {
	static int total =0;
	private static FileInputStream fis,sif;
    private static FileOutputStream fos;
    private static Workbook wb,bw;
    private static Sheet sh,hs;
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
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		 
		
		JButton btnNewButton = new JButton("Pay");
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
				
				   System.out.println(total);
				 
        		String eww = String.valueOf(total);
         		JLabel lblNewLabel_2 = new JLabel(eww);
        		lblNewLabel_2.setBounds(188, 99, 155, 27);
        		contentPane.add(lblNewLabel_2);
        		
        		setState(payment.ICONIFIED);
				setState(payment.NORMAL);

			
		}});
		btnNewButton.setBounds(724, 296, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pay Later");
		btnNewButton_1.setBounds(724, 373, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
