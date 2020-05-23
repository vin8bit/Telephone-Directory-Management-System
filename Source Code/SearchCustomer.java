import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SearchCustomer implements ActionListener ,ItemListener
{
	
	JButton clear,search;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9;
	String user="system";
	String pass="system";
	int pass9;
	String dl;
	JDialog jd;
	int de;
	public SearchCustomer(Main m)
	{
		jd = new JDialog(m);
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		JPanel p1=new JPanel();
		p1.setBounds(0,0,500,500);	
		p1.setLayout(null);
		jd.add(p1);
		JLabel tl=new JLabel("Search Customer");
		Font font= new Font("Algerian",Font.BOLD,15);
		tl.setBounds(150,20,250,30);
		tl.setFont(font);
		p1.add(tl);


		l1 =new JLabel("Customer ID :");
		l1.setBounds(50,60,150,20);
		p1.add(l1);
		l2 =new JLabel("Customer Name :");
		l2.setBounds(50,100,150,20);
		p1.add(l2);
		l3 =new JLabel("Residential Address :");
		l3.setBounds(50,140,150,20);
		p1.add(l3);
		l4 =new JLabel("Gender :");
		l4.setBounds(50,180,150,20);
		p1.add(l4);
		l5 =new JLabel("City :");
		l5.setBounds(50,220,150,20);
		p1.add(l5);
		l6 =new JLabel("Email ID :");
		l6.setBounds(50,260,150,20);
		p1.add(l6);
		l7 =new JLabel("Contact No :");
		l7.setBounds(50,300,150,20);
		p1.add(l7);
		l8 =new JLabel("ID Proof :");
		l8.setBounds(50,340,150,20);
		p1.add(l8);


		ltf1= new JTextField();
		ltf1.setBounds(200,60,150,20);
		p1.add(ltf1);
		ltf2= new JTextField();
		ltf2.setBounds(200,100,150,20);
		p1.add(ltf2);
		ltf3= new JTextField();
		ltf3.setBounds(200,140,150,20);
		p1.add(ltf3);
		ltf4= new JTextField();
		ltf4.setBounds(200,180,150,20);
		p1.add(ltf4);
		
		
		ltf5= new JTextField();
		ltf5.setBounds(200,220,150,20);
		p1.add(ltf5);


		ltf6= new JTextField();
		ltf6.setBounds(200,260,150,20);
		p1.add(ltf6);
		ltf7= new JTextField();
		ltf7.setBounds(200,300,150,20);
		p1.add(ltf7);
		ltf8= new JTextField();
		ltf8.setBounds(200,340,150,20);
		p1.add(ltf8);
	

		
		clear= new JButton("Clear",new ImageIcon("image/clear.png"));
		clear.setBounds(220,380,100,30);
		clear.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent e)
					{
						ltf1.setText("");
						ltf2.setText("");
						ltf3.setText("");
						ltf4.setText("");
						ltf5.setText("");
						ltf6.setText("");
						ltf7.setText("");
						ltf8.setText("");
						
		
					}		

			
		});
		p1.add(clear);
		
		search = new JButton("Search",new ImageIcon("image/se.png"));
		search.setBounds(100,380,100,30);
		search.addActionListener(this);
		p1.add(search);
		
					ltf1.setEditable(false);
					ltf2.setEditable(false);
					ltf3.setEditable(false);
					ltf4.setEditable(false);
					ltf5.setEditable(false);
					ltf6.setEditable(false);
					ltf7.setEditable(false);
					ltf8.setEditable(false);
		jd.setSize(500,500);
		jd.setLayout(null);
		jd.setLocationRelativeTo(null);
		jd.setTitle("Search Customer");
		p1.setBackground(Color.orange);
		jd.setVisible(true);
	}


	public void itemStateChanged(ItemEvent e)
	{	ltf4.setText(((Checkbox)e.getItemSelectable()).getLabel());
		
			
				
	}

	public void actionPerformed(ActionEvent er)
		{

			
			if(er.getSource()==search)
				{   	de=0;
			 		dl=JOptionPane.showInputDialog(jd,"Enter Customer ID"); 
				        
					
					if(!dl.isEmpty())
					{
						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from customer");
							while (rs2.next())
							{
								if(dl.equals(rs2.getString(1)))
								{
									de=1; 
									break;
								}
							} 
							con.close();
					}
							catch(Exception e){}	
					if(de==1){
				         try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM customer WHERE c_id="+dl+" ");
						
				while(rs2.next())
					{
						
					ltf1.setEditable(true);
					ltf2.setEditable(true);
					ltf3.setEditable(true);
					ltf4.setEditable(true);
					ltf5.setEditable(true);
					ltf6.setEditable(true);
					ltf7.setEditable(true);
					ltf8.setEditable(true);
					ltf1.setText(rs2.getString(1));
					ltf2.setText(rs2.getString(2));
					ltf3.setText(rs2.getString(3));
					ltf4.setText(rs2.getString(4));
					ltf5.setText(rs2.getString(5));
					ltf6.setText(rs2.getString(6));
					ltf7.setText(rs2.getString(7));
					ltf8.setText(rs2.getString(8));
					}
				          }
				catch(Exception p){JOptionPane.showMessageDialog(jd,p,"Error",JOptionPane.ERROR_MESSAGE);}
					} else{ JOptionPane.showMessageDialog(jd,"Data not found","Error",JOptionPane.ERROR_MESSAGE); }
			        		 } else{ JOptionPane.showMessageDialog(jd,"Textfield is empty","Error",JOptionPane.ERROR_MESSAGE); }
		


		
				}


		
		}

	
}