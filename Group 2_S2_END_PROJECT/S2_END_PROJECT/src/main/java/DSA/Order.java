package DSA;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Order extends JFrame {
	static String a,y,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,b,x,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10;
	
	
	class Node
	{
		String data;
		Node next;
		Node prev;
		public Node(String data)
		{
			this.data=data;
			next=next;
			prev=prev;
			
		}
	}
       public int size=0;
       public Node head=null;
       public Node tail=null;
       
       public void AddNode(String data)
       {
    	   Node addnode=new Node(data);
    	   if (head==null)
    	   {
    		   head=addnode;
    		   tail=addnode;
    		   
    	   }
    	   else
    	   {
    		   tail.next=addnode;
    		   tail=addnode;
    	   }
    	   size++;
    	   
       }
public void deleteNode(int position)
{
	if(head==null)
		return;
	Node temp = head;
	if (position == 0)
	{
		head=temp.next;
		return;
		
	}
	for(int i=0; temp!=null && i<position-1; i++)
		temp=temp.next;
	if(temp==null || temp.next==null)
		return;
	//System.out.println("-----------Removing a node from given POSITION:"+position);
	Node next=temp.next.next;
	temp.next=next;
	
	
}
 public String Display() {
	 
	 Node current=head;
	  String disp = "your items are ";
	  int serialno=0;
	  while(current!=null)
	  {
		  String hi =current.data;
		  disp += /*"NO:"+Integer.valueOf(serialno)+*/":"+'\n'+current.data;
//		  
		  
		 

		  if(current.next !=null)
			  disp+= /*Integer.valueOf(serialno)+*/"";
		  
		 current=current.next;
		 serialno++;
		 
	  }
	  return disp;
	  
	  
	  
	  
 }
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
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	public Order() throws IOException {

		fis = new FileInputStream("./database.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet3");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2160, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1.setBounds(137, 272, 97, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		final JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_2.setBounds(467, 272, 97, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		final JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_1.setBounds(730, 272, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_1);
		
		final JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_2.setBounds(1038, 272, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_2);
		
		final JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_3.setBounds(137, 594, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_3);
		
		final JCheckBox chckbxNewCheckBox_1_4 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_4.setBounds(467, 594, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_4);
		
		final JCheckBox chckbxNewCheckBox_1_5 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_5.setBounds(730, 594, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_5);
		
		final JCheckBox chckbxNewCheckBox_1_6 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_6.setBounds(1038, 594, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_6);
		
		final JCheckBox chckbxNewCheckBox_1_7 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_7.setBounds(137, 946, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_7);
		
		final JCheckBox chckbxNewCheckBox_1_8 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_8.setBounds(467, 946, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_8);
		
		final JCheckBox chckbxNewCheckBox_1_9 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_9.setBounds(730, 946, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_9);
		
		final JCheckBox chckbxNewCheckBox_1_10 = new JCheckBox("Add To Cart");
		chckbxNewCheckBox_1_10.setBounds(1038, 946, 97, 23);
		contentPane.add(chckbxNewCheckBox_1_10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("IMAGES-DSA\\FERRERO ROCHER.jpeg"));
		lblNewLabel.setBounds(86, 84, 143, 148);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 273, 32, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JLabel lblNewLabel_16_0 = new JLabel("ROCHER");
		lblNewLabel_16_0.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_0.setBounds(127, 243, 61, 14);
		contentPane.add(lblNewLabel_16_0);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("IMAGES-DSA\\BRU - COFFEE.jpeg"));
		lblNewLabel_1.setBounds(394, 84, 143, 148);
		contentPane.add(lblNewLabel_1);
		
		final JLabel lblNewLabel_16_1 = new JLabel("BRU");
		lblNewLabel_16_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_1.setBounds(450, 243, 61, 14);
		contentPane.add(lblNewLabel_16_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(394, 273, 32, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("IMAGES-DSA\\AACHI SAMBAR POWDER.jpeg"));
		lblNewLabel_2.setBounds(659, 84, 143, 148);
		contentPane.add(lblNewLabel_2);
		
		final JLabel lblNewLabel_16_2 = new JLabel("AACHI SAMBAR POWDER");
		lblNewLabel_16_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_2.setBounds(648, 243, 201, 14);
		contentPane.add(lblNewLabel_16_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(659, 273, 32, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("IMAGES-DSA\\ARGAN OIL.jpeg"));
		lblNewLabel_3.setBounds(959, 84, 143, 148);
		contentPane.add(lblNewLabel_3);
		
		final JLabel lblNewLabel_16_3 = new JLabel("ARGAN OIL");
		lblNewLabel_16_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_3.setBounds(969, 243, 92, 14);
		contentPane.add(lblNewLabel_16_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(959, 273, 32, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("IMAGES-DSA\\LAYS.jpeg"));
		lblNewLabel_4.setBounds(86, 406, 143, 148);
		contentPane.add(lblNewLabel_4);
		
		final JLabel lblNewLabel_16_4 = new JLabel("LAYS");
		lblNewLabel_16_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_4.setBounds(127, 565, 61, 14);
		contentPane.add(lblNewLabel_16_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(86, 595, 32, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("IMAGES-DSA\\MOONG DAL.jpeg"));
		lblNewLabel_5.setBounds(383, 404, 143, 148);
		contentPane.add(lblNewLabel_5);
		
		final JLabel lblNewLabel_16_5 = new JLabel("MOONG DAL");
		lblNewLabel_16_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_5.setBounds(424, 563, 87, 14);
		contentPane.add(lblNewLabel_16_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(383, 593, 32, 20);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("IMAGES-DSA\\PAPER TOWEL.jpeg"));
		lblNewLabel_6.setBounds(659, 404, 143, 148);
		contentPane.add(lblNewLabel_6);
		
		final JLabel lblNewLabel_16_6 = new JLabel("PAPER TOWEL");
		lblNewLabel_16_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_6.setBounds(700, 563, 102, 14);
		contentPane.add(lblNewLabel_16_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(659, 593, 32, 20);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("IMAGES-DSA\\OIL.jpeg"));
		lblNewLabel_7.setBounds(959, 406, 143, 148);
		contentPane.add(lblNewLabel_7);
		
		final JLabel lblNewLabel_16_7 = new JLabel("OIL");
		lblNewLabel_16_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_7.setBounds(1000, 565, 61, 14);
		contentPane.add(lblNewLabel_16_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(959, 595, 32, 20);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("IMAGES-DSA\\MILK.jpeg"));
		lblNewLabel_8.setBounds(86, 758, 143, 148);
		contentPane.add(lblNewLabel_8);
		
		final JLabel lblNewLabel_16_8 = new JLabel("MILK");
		lblNewLabel_16_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_8.setBounds(127, 917, 61, 14);
		contentPane.add(lblNewLabel_16_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(86, 947, 32, 20);
		contentPane.add(textField_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("IMAGES-DSA\\MONSTER.jpeg"));
		lblNewLabel_9.setBounds(383, 756, 143, 148);
		contentPane.add(lblNewLabel_9);
		
		final JLabel lblNewLabel_16_9 = new JLabel("MONSTER");
		lblNewLabel_16_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_9.setBounds(394, 915, 91, 14);
		contentPane.add(lblNewLabel_16_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(383, 945, 32, 20);
		contentPane.add(textField_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("IMAGES-DSA\\TRESEMME.jpeg"));
		lblNewLabel_10.setBounds(659, 756, 143, 148);
		contentPane.add(lblNewLabel_10);
		
		final JLabel lblNewLabel_16_10 = new JLabel("TRESEMME");
		lblNewLabel_16_10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_10.setBounds(700, 915, 102, 14);
		contentPane.add(lblNewLabel_16_10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(659, 945, 32, 20);
		contentPane.add(textField_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("IMAGES-DSA\\PRIYA PACHADLU.jpeg"));
		lblNewLabel_11.setBounds(959, 756, 143, 148);
		contentPane.add(lblNewLabel_11);
		
		final JLabel lblNewLabel_16_11 = new JLabel("PRIYA PACHADLU");
		lblNewLabel_16_11.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_16_11.setBounds(959, 915, 143, 14);
		contentPane.add(lblNewLabel_16_11);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(959, 945, 32, 20);
		contentPane.add(textField_11);
		
		JButton btnNewButton = new JButton("Show Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				textField_12.setText(Display());	
			
		}});
		btnNewButton.setBounds(1455, 298, 101, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Conform Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delivery_address a = new delivery_address();
				dispose();
				a.show();
//				a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		}});
		btnNewButton_1.setBounds(1566, 298, 130, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3_1 = new JButton("Remove From Cart");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String n=textField_13.getText();
				  int nn= Integer.parseInt(n);
				  deleteNode(nn);
				  textField_12.setText(Display());
			}
		});
		btnNewButton_3_1.setBounds(1566, 344, 143, 23);
		contentPane.add(btnNewButton_3_1);
		
		textField_12 = new JTextField();
		textField_12.setBounds(1342, 388, 479, 325);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(1342, 345, 101, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("feedback");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback su = new feedback();
				su.show();
				su.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_2.setBounds(1732, 946, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add To Cart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				 a = lblNewLabel_16_0.getText();
				 b = lblNewLabel_16_1.getText();
				 a1 = lblNewLabel_16_2.getText();
				 a2= lblNewLabel_16_3.getText();
				 a3 = lblNewLabel_16_4.getText();
				 a4 = lblNewLabel_16_5.getText();
				 a5 = lblNewLabel_16_6.getText();
				 a6 = lblNewLabel_16_7.getText();
				 a7 = lblNewLabel_16_8.getText();
				 a8 = lblNewLabel_16_9.getText();
				 a9 = lblNewLabel_16_10.getText();
				 a10= lblNewLabel_16_11.getText();
				 
				 x= textField.getText();				 
				 y=textField_1.getText();
				 x1= textField_2.getText();
				 x2= textField_3.getText();
				 x3= textField_4.getText();
				 x4= textField_5.getText();
				 x5= textField_6.getText();
				 x6= textField_7.getText();
				 x7= textField_8.getText();
				 x8= textField_9.getText();
				 x9= textField_10.getText();
				 x10= textField_11.getText();
				int noOfRows=sh.getLastRowNum();
				if(chckbxNewCheckBox_1.isSelected()){  
					  AddNode(a+","+x);
						
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x);  
		        }  
		     
				if(chckbxNewCheckBox_2.isSelected()){  
					  AddNode(b+","+y);
						
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(b);
		    			cell = row.createCell(1);
		    			cell.setCellValue(y);
		        }
				if(chckbxNewCheckBox_1_1.isSelected()){  
					  AddNode(a1+","+x1);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a1);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x1);

		        }  
				if(chckbxNewCheckBox_1_2.isSelected()){  
					  AddNode(a2+","+x2);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a2);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x2);

		        }  
				if(chckbxNewCheckBox_1_3.isSelected()){  
					  AddNode(a3+","+x3);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a3);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x3);

		        }  
				if(chckbxNewCheckBox_1_4.isSelected()){  
					  AddNode(a4+","+x4);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a4);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x4);

		        }  
				if(chckbxNewCheckBox_1_5.isSelected()){  
					  AddNode(a5+","+x5);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a5);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x5);

		        }  
				if(chckbxNewCheckBox_1_6.isSelected()){  
					  AddNode(a6+","+x6);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a6);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x6);

		        }  
				if(chckbxNewCheckBox_1_7.isSelected()){  
					  AddNode(a7+","+x7);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a7);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x7);

		        }  
				if(chckbxNewCheckBox_1_8.isSelected()){  
					  AddNode(a8+","+x8);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a8);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x8);

		        }  
				if(chckbxNewCheckBox_1_9.isSelected()){  
					  AddNode(a9+","+x9);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a9);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x9);				  

		        }  
				if(chckbxNewCheckBox_1_10.isSelected()){  
					  AddNode(a10+","+x10);
		    			row = sh.createRow(noOfRows+1);
		    			cell = row.createCell(0);
		    			cell.setCellValue(a10);
		    			cell = row.createCell(1);
		    			cell.setCellValue(x10); 

		        }
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
		
		btnNewButton_3.setBounds(1342, 298, 101, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search ac = null;
				try {
					ac = new Search();
				} catch (EncryptedDocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ac.show();
				ac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnSearch.setBounds(1455, 344, 101, 23);
		contentPane.add(btnSearch);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./Order.jpg"));
		label.setBounds(0, 0, 1924, 1041);
		contentPane.add(label);
		
		
	}
}
