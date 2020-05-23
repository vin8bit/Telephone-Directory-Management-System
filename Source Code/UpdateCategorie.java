import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCategorie implements ActionListener 
{
	
	
	String 	s1,s2,s3,s4,s5,s6,s7,s8;
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf7,ltf8,ltf9;
	JTextArea ltf6;
	JButton ad,clear,search;
	Connection con;
	Statement stm2;
	ResultSet rs2;
	PreparedStatement stm;
	String user="system";
	String pass="system";
	private static JDialog jd;
	int pass9,ph,ph2,ph3,ch1,de;
	String dl;
	Main m1;
	public UpdateCategorie(Main m)
	{
		  m1=m;
		jd=new JDialog(m);
		jd.setSize(500,480);
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		jd.setTitle("Update Categorie");
		JPanel p1=new JPanel();
		p1.setBounds(0,0,500,500);	
		p1.setLayout(null);
		jd.add(p1);
		JLabel tl=new JLabel("Update Categorie");
		Font font= new Font("Algerian",Font.BOLD,15);
		tl.setBounds(150,20,250,30);
		tl.setFont(font);
		p1.add(tl);


		l1 =new JLabel("Categorie ID :");
		l1.setBounds(50,60,150,20);
		p1.add(l1);
		l2 =new JLabel("Categorie Type :");
		l2.setBounds(50,100,150,20);
		p1.add(l2);
		l3 =new JLabel("Categorie city :");
		l3.setBounds(50,140,150,20);
		p1.add(l3);
		l4 =new JLabel("Categorie Name :");
		l4.setBounds(50,180,200,20);
		p1.add(l4);
		l5 =new JLabel("Contact No :");
		l5.setBounds(50,220,200,20);
		p1.add(l5);
		l6 =new JLabel("Categorie Full Address :");
		l6.setBounds(50,260,200,20);
		p1.add(l6);
		
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

		ltf6 = new JTextArea();
		JScrollPane jscroll = new JScrollPane(ltf6,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		jscroll.setBounds(200,260,200,80);
		p1.add(jscroll);
		
	

		ad= new JButton("Update",new ImageIcon("image/add.png"));
		ad.setBounds(50,380,140,30);
		ad.addActionListener(this);
		p1.add(ad);
		
		search= new JButton("Search",new ImageIcon("image/se.png"));
		search.setBounds(350,380,130,30);
		search.addActionListener(this);
		p1.add(search);

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
						ltf1.setEditable(false);
						ltf2.setEditable(false);
						ltf3.setEditable(false);
						ltf4.setEditable(false);
						ltf5.setEditable(false);
						ltf6.setEditable(false);
		
					}		

			
		});
		p1.add(clear);
		ltf1.setEditable(false);
		ltf2.setEditable(false);
		ltf3.setEditable(false);
		ltf4.setEditable(false);
		ltf5.setEditable(false);
		ltf6.setEditable(false);
		jd.setLayout(null);
		p1.setBackground(Color.orange);
		jd.setLocationRelativeTo(null);		
		jd.setVisible(true);
	}


	
	public void actionPerformed(ActionEvent er)
		{
				
			ph=0; ph2=0; ph3=0; ch1=0; 
				 s1=ltf1.getText(); 
				 s2=ltf2.getText();
				 s3=ltf3.getText();
				 s4=ltf4.getText();
				 s5=ltf5.getText();
				 s6=ltf6.getText();
				 		
				if(er.getSource()==ad)
				{ if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty())
					{    JOptionPane.showMessageDialog(jd,"Text Fields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					else{
										
						
						pass9=0;
					   //String i = ltf4.getText();
					   String i1=ltf5.getText();
					   String i2=ltf1.getText();
					
					for(int y1=0;y1<i1.length(); ++y1)
					{	 if(i1.length()<=9){ pass9=7; ph2=1; }
						if(!Character.isDigit(i1.charAt(y1)))
						{  pass9=7; ph2=1; }
						if(i1.length()>20)
							{ pass9=7; ph2=1;  }
					}
					for(int y2=0;y2<i2.length(); ++y2)
					{
						if(!Character.isDigit(i2.charAt(y2)))
						{  pass9=7; ph3=1; }
					}
					

	
						if(pass9==0)
						{

						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
      						String query = "delete from categorie where c_id = ?";
      						PreparedStatement preparedStmt = conn.prepareStatement(query);
      						preparedStmt.setString(1, s1);
      						preparedStmt.execute();
      						conn.close();
				   		}
						catch(Exception r){}

						   try        { Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
							stm =  con.prepareStatement("insert into categorie values(?,?,?,?,?,?)");
			                			stm.setString(1,ltf1.getText());
							stm.setString(2,ltf2.getText());
							stm.setString(3,ltf3.getText());	
							stm.setString(4,ltf4.getText());
							stm.setString(5,ltf5.getText());
							stm.setString(6,ltf6.getText());
							stm.executeUpdate();
							JOptionPane.showMessageDialog(jd,"Update Success","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setEditable(false);
							ltf2.setEditable(false);
							ltf3.setEditable(false);
							ltf4.setEditable(false);
							ltf5.setEditable(false);
							ltf6.setEditable(false);
							ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf4.setText("");
							ltf5.setText("");
							ltf6.setText("");;
							con.close();

							}
						catch(Exception e){ }
							}
							else {  
								if(ph2==1){JOptionPane.showMessageDialog(jd,"Incorrect Contact no","Error",JOptionPane.ERROR_MESSAGE);}
								if(ph3==1){JOptionPane.showMessageDialog(jd,"Categorie ID only number accepted","Error",JOptionPane.ERROR_MESSAGE);} } 						
						
						}


				}
	
			if(er.getSource()==search)
				{   	de=0;
			 		dl=JOptionPane.showInputDialog(jd,"Enter Categorie ID"); 
				        
					if(!dl.isEmpty())
					{
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from Categorie");
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
					rs2= stm2.executeQuery("SELECT  *  FROM categorie WHERE c_id="+dl+" ");
						
				while(rs2.next())
					{
						
					ltf1.setEditable(false);
					ltf2.setEditable(true);
					ltf3.setEditable(true);
					ltf4.setEditable(true);
					ltf5.setEditable(true);
					ltf6.setEditable(true);
					
					ltf1.setText(rs2.getString(1));
					ltf2.setText(rs2.getString(2));
					ltf3.setText(rs2.getString(3));
					ltf4.setText(rs2.getString(4));
					ltf5.setText(rs2.getString(5));
					ltf6.setText(rs2.getString(6));
					
					}
				          }
				catch(Exception p){JOptionPane.showMessageDialog(jd,p,"Error",JOptionPane.ERROR_MESSAGE);}
			        		} else{ JOptionPane.showMessageDialog(jd,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}
					}else{ JOptionPane.showMessageDialog(jd,"Textfield is empty","Error",JOptionPane.ERROR_MESSAGE);}
		


		
				}
		
		}

}