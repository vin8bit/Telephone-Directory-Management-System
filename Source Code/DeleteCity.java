import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteCity implements ActionListener 
{
	
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	int pass9,de;
	String dl;
	JLabel l1,l2,l3,l4;
	JTextField ltf1,ltf2,ltf3,ltf4;
	String 	s1,s2,s3;
	String user="system";
	String pass="system";
	JButton ad,clear,search;
	JDialog jd;
	public DeleteCity(Main m)
	{
		jd = new JDialog(m);
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		jd.setSize(500,320);
		jd.setTitle("Delete City STD code");
		JPanel p1=new JPanel();
		p1.setBounds(0,0,500,300);	
		p1.setLayout(null);
		jd.add(p1);
		JLabel tl=new JLabel("Delete City STD code");
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
		ad= new JButton("Delete",new ImageIcon("image/cancel.png"));
		ad.setBounds(50,220,140,30);
		ad.addActionListener(this);
		p1.add(ad);
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
		search.setBounds(350,220,100,30);
		search.addActionListener(this);
		p1.add(search);
		ltf1.setEditable(false);
		ltf2.setEditable(false);
		ltf3.setEditable(false);
		ltf4.setEditable(false);
		jd.setLayout(null);
		p1.setBackground(Color.orange);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
	}


	

	public void actionPerformed(ActionEvent er)
		{

			
					s1=ltf1.getText();
					s2=ltf2.getText();
					s3=ltf3.getText();  
				if(er.getSource()==ad)
				{
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty())
					{    JOptionPane.showMessageDialog(jd,"Text Fields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					else{
										
						
						pass9=0;
					   String i = ltf1.getText();
					   String i1=ltf3.getText();
					for(int y=0;y<i.length(); ++y)
					{
						if(!Character.isDigit(i.charAt(y)))
							{  pass9=7;  }
					}
					for(int y1=0;y1<i1.length(); ++y1)
					{
						if(!Character.isDigit(i1.charAt(y1)))
						{  pass9=7;  }
					}
						
						if(pass9==0)
						{
							try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
      						String query = "delete from city where std_id = ?";
      						PreparedStatement preparedStmt = conn.prepareStatement(query);
      						preparedStmt.setString(1, s1);
      						preparedStmt.execute();
      						conn.close();
				   		}
						catch(Exception r){}

							JOptionPane.showMessageDialog(jd,"Delete Success","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setText("");
							ltf2.setText("");
							ltf3.setText("");
							ltf4.setText("");
			
							}
							else { JOptionPane.showMessageDialog(jd,"STD ID or STD code  only Number accepted","Error",JOptionPane.ERROR_MESSAGE); } 						
						
						}


				}
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