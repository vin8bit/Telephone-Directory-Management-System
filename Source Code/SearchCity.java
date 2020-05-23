import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SearchCity implements ActionListener 
{
	
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	JLabel l1,l2,l3,l4;
	JTextField ltf1,ltf2,ltf3,ltf4;
	JButton clear,search;
	String user="system";
	String pass="system";
	int pass9,de;
	String dl;
	JDialog jd;
	
	public SearchCity(Main m)
	{
		jd = new JDialog(m);
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		JPanel p1=new JPanel();
		p1.setBounds(0,0,500,320);	
		p1.setLayout(null);
		jd.add(p1);
		JLabel tl=new JLabel("Search City STD code");
		Font font= new Font("Algerian",Font.BOLD,15);
		tl.setBounds(150,20,250,30);
		tl.setFont(font);
		p1.add(tl);


		l1 =new JLabel("STD ID :");
		l1.setBounds(50,60,150,20);
		p1.add(l1);
		l2 =new JLabel("City Name :");
		l2.setBounds(50,100,150,20);
		p1.add(l2);
		l3 =new JLabel("STD Code :");
		l3.setBounds(50,140,150,20);
		p1.add(l3);
		l4 =new JLabel("State :");
		l4.setBounds(50,180,150,20);
		p1.add(l4);
		

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
			

		clear= new JButton("Clear",new ImageIcon("image/clear.png"));
		clear.setBounds(220,220,100,30);
		clear.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent e)
					{
						ltf1.setText("");
						ltf2.setText("");
						ltf3.setText("");
						ltf4.setText("");
						
		
					}		

			
		});
		p1.add(clear);

		search = new JButton("Search",new ImageIcon("image/se.png"));
		search.setBounds(100,220,100,30);
		search.addActionListener(this);
		p1.add(search);
		
					ltf1.setEditable(false);
					ltf2.setEditable(false);
					ltf3.setEditable(false);
					ltf4.setEditable(false);
		jd.setSize(500,300);
		jd.setLayout(null);
		jd.setLocationRelativeTo(null);
		p1.setBackground(Color.orange);
		jd.setTitle("Search City STD code");
		jd.setVisible(true);
	}


	

	public void actionPerformed(ActionEvent er)
		{

			
			if(er.getSource()==search)
				{   	de=0;
			 		dl=JOptionPane.showInputDialog(jd,"Enter STD ID"); 
				        
					if(!dl.isEmpty())
					{
						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from city");
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
					rs2= stm2.executeQuery("SELECT  *  FROM city WHERE std_id="+dl+" ");
						
				while(rs2.next())
					{
						
					
					ltf2.setEditable(true);
					ltf3.setEditable(true);
					ltf1.setEditable(true);
					ltf4.setEditable(true);
					
					ltf1.setText(rs2.getString(1));
					ltf2.setText(rs2.getString(2));
					ltf3.setText(rs2.getString(3));
					ltf4.setText(rs2.getString(4));
					}
					
				          }
				catch(Exception p){JOptionPane.showMessageDialog(jd,p,"Error",JOptionPane.ERROR_MESSAGE);}
			        		}else{ JOptionPane.showMessageDialog(jd,"Data not found","Error",JOptionPane.ERROR_MESSAGE);} 
					}else{ JOptionPane.showMessageDialog(jd,"Textfield is empty","Error",JOptionPane.ERROR_MESSAGE);}
		

				}
		
				
		
		}

	
}