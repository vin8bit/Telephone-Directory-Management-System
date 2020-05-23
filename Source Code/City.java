import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class City implements ActionListener 
{
	
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2 ;
	JLabel l1,l2,l3,l4;
	JTextField ltf1,ltf2,ltf3,ltf4;
	Choice choice1,choice2;
	int pass9,ph,ph2,ch1;
	String user="system";
	String pass="system";
	JButton ad,clear;
	String 	s1,s2,s3,s4,s5,s6,s7,s8;
	private static JDialog jd;
	Main m1;
	public City(Main m)
	{	m1=m;
		jd=new JDialog(m);
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		jd.setSize(500,320);
		jd.setTitle("Add City STD code");
		JPanel p1=new JPanel();
		p1.setBounds(0,0,500,300);	
		p1.setLayout(null);
		jd.add(p1);
		JLabel tl=new JLabel("Add City STD code");
		Font font= new Font("Algerian",Font.BOLD,15);
		tl.setBounds(150,20,250,30);
		tl.setForeground(Color.orange);
		tl.setFont(font);
		p1.add(tl);

		Font font1= new Font("Century",Font.BOLD,15);
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
	
		l1.setFont(font1);
		l2.setFont(font1);
		l3.setFont(font1);
		l4.setFont(font1);	
		l4.setForeground(Color.orange);	
		l1.setForeground(Color.orange);
		l2.setForeground(Color.orange);
		l3.setForeground(Color.orange);	
	
		ltf1= new JTextField();
		ltf1.setBounds(200,60,150,20);
		try{
		Count1   co= new Count1();
			int au=1+co.call2();
			ltf1.setText(String.valueOf(au));
			
			}
			catch(Exception c){}
		p1.add(ltf1);
		ltf2= new JTextField();
		ltf2.setBounds(200,100,150,20);
		p1.add(ltf2);

		choice2= new  Choice();
		choice2.addItem("");
		choice2.addItem("Delhi");
		choice2.addItem("Mumbai");
		choice2.addItem("Kolkata");
		choice2.addItem("Chennai");
		choice2.addItem("Rajasthan");
		choice2.addItem("Uttar Pradesh");
		choice2.addItem("Haryana");
		choice2.addItem("Uttaranchal");
		choice2.addItem("Punjab");
		
		choice2.setBounds(200,180,150,20);
		choice2.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						ltf4.setText((String)choice2.getSelectedItem());
					}
				});
		p1.add(choice2);


		ltf3= new JTextField();
		ltf3.setBounds(200,140,150,20);
		p1.add(ltf3);
		ltf4= new JTextField();
		ltf4.setBounds(200,180,150,20);
		//p1.add(ltf4);
		ad= new JButton("Add Code",new ImageIcon("image/add.png"));
		ad.setBounds(50,220,140,30);
		ad.addActionListener(this);
		p1.add(ad);
		clear= new JButton("Clear",new ImageIcon("image/clear.png"));
		clear.setBounds(250,220,100,30);
		clear.addActionListener(new ActionListener() {      
				public void actionPerformed(ActionEvent e)
					{
						try{
					Count1   co= new Count1();
					int au=1+co.call2();
					ltf1.setText(String.valueOf(au));
			
					}
					catch(Exception c){}
						
						ltf3.setText("");
						jd.dispose();  new City(m1);
					}		

			
		});
		p1.add(clear);
		p1.setBackground(Color.orange);
		jd.setLayout(null);
		JLabel img=new JLabel(new ImageIcon("image/main2.jpg"));
		img.setBounds(0,0,500,300);
		p1.add(img);
		jd.setResizable(false);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
	}


	

	public void actionPerformed(ActionEvent er)
		{

					ph=0; ph2=0;ch1=0;
					s1=ltf1.getText();
					s2=ltf2.getText();
					s3=ltf3.getText();  
				if(er.getSource()==ad)
				{
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty())
					{    JOptionPane.showMessageDialog(jd," Text Fields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					else{
										
						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from city");
							while (rs2.next())
							{
								if(s1.equals(rs2.getString(1)))
								{
									ch1=1; 
									break;
								}
							} 
						   }catch(Exception e){}
									


						pass9=0;
					   String i = ltf1.getText();
					   String i1=ltf3.getText();
					for(int y=0;y<i.length(); ++y)
					{
						if(!Character.isDigit(i.charAt(y)))
							{  pass9=7; ph=1; }
					}
					for(int y1=0;y1<i1.length(); ++y1)
					{
						if(!Character.isDigit(i1.charAt(y1)))
						{  pass9=7; ph2=1; }
					}
					    
					if(ch1==0){	
						if(pass9==0)
						{

						   try        { Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
							stm =  con.prepareStatement("insert into city values(?,?,?,?)");
			                		stm.setString(1,ltf1.getText());
							stm.setString(2,ltf2.getText());
							stm.setString(3,ltf3.getText());
							stm.setString(4,ltf4.getText());	
							stm.executeUpdate();
							JOptionPane.showMessageDialog(jd,"Add Code Success","Success",JOptionPane.INFORMATION_MESSAGE);
							jd.dispose();  new City(m1);		
							try{
						Count1   co= new Count1();
						int au=1+co.call2();
						ltf1.setText(String.valueOf(au));
			
						}
						catch(Exception c){}	
				 			
							ltf3.setText("");
							con.close();

							}
						catch(Exception e){ }
							}
							else { if(ph==1){JOptionPane.showMessageDialog(jd,"STD ID only Number accepted","Error",JOptionPane.ERROR_MESSAGE); } 
								if(ph2==1){JOptionPane.showMessageDialog(jd,"STD Code only Number accepted","Error",JOptionPane.ERROR_MESSAGE); }
								} 
							}
							else{if(ch1==1){JOptionPane.showMessageDialog(jd,"STD ID already added","Error",JOptionPane.ERROR_MESSAGE); }}						
						
						}


				}
		
		}

	
}