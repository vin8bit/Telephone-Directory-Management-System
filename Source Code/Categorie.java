import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Categorie implements ActionListener 
{
	
	
	String 	s1,s2,s3,s4,s5,s6,s7,s8;
	Choice choice1,choice2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf7,ltf8,ltf9;
	JTextArea ltf6;
	JButton ad,clear;
	Connection con;
	Statement stm2;
	ResultSet rs2 ;
	PreparedStatement stm;
	String user="system";
	String pass="system";
	int pass9,ph,ph2,ph3,ch1;
	private static JDialog jd;
	Main m1;
	
	public Categorie(Main m)
	{              m1=m;
		jd=new JDialog(m);
		jd.setSize(500,480);
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		jd.setTitle("Add new Categorie");
		
		JPanel p1=new JPanel();
		p1.setBounds(0,0,500,500);	
		p1.setLayout(null);
		jd.add(p1);
		JLabel tl=new JLabel("Add New Categorie");
		Font font= new Font("Algerian",Font.BOLD,15);
		tl.setBounds(150,20,250,30);
		
		tl.setForeground(Color.orange);
		tl.setFont(font);
		p1.add(tl);

		Font font1= new Font("Century",Font.BOLD,15);
		l1 =new JLabel("Categorie ID :");
		l1.setBounds(50,60,150,20);
		
		l1.setForeground(Color.orange);
		p1.add(l1);
		l2 =new JLabel("Categorie Type :");
		l2.setBounds(50,100,150,20);
		
		l2.setForeground(Color.orange);
		p1.add(l2);
		l3 =new JLabel("Categorie city :");
		l3.setBounds(50,140,150,20);
		
		l3.setForeground(Color.orange);
		p1.add(l3);
		l4 =new JLabel("Categorie Name :");
		l4.setBounds(50,180,200,20);
		
		l4.setForeground(Color.orange);
		p1.add(l4);
		l5 =new JLabel("Contact No :");
		l5.setBounds(50,220,200,20);
		
		l5.setForeground(Color.orange);
		p1.add(l5);
		l6 =new JLabel("Categorie Full Address :");
		l6.setBounds(50,260,200,20);
		
		l6.setForeground(Color.orange);
		p1.add(l6);
		l1.setFont(font1);
		l2.setFont(font1);
		l3.setFont(font1);
		l4.setFont(font1);
		l5.setFont(font1);
		l6.setFont(font1);
		ltf1= new JTextField();
		ltf1.setBounds(250,60,150,20);
		try{
		Count1   co= new Count1();
			int au=1+co.call3();
			ltf1.setText(String.valueOf(au));
			
			}
			catch(Exception c){}



		p1.add(ltf1);
		ltf2= new JTextField();
		choice2=new  Choice();
		choice2.addItem("");
		choice2.addItem("Blood bank");
		choice2.addItem("Hospital");
		choice2.addItem("Policestation");
		choice2.addItem("Hotel");
		choice2.addItem("Bank");
		choice2.addItem("Post Office");
		choice2.addItem("Restaurant");
		choice2.addItem("Dance Club");
		choice2.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						ltf2.setText((String)choice2.getSelectedItem());
					}
				});
		choice2.setBounds(250,100,150,20);
		p1.add(choice2);
		p1.add(ltf2);
	
		ltf3= new JTextField();
		choice1= new  Choice();
		choice1.addItem("");
		choice1.addItem("Delhi");
		choice1.addItem("Mumbai");
		choice1.addItem("Kolkata");
		choice1.addItem("Chennai");
		choice1.addItem("Uttrakhand");
		choice1.addItem("Kerla");
		choice1.addItem("Utt. Pradesh");
		choice1.addItem("Rajastan");
		choice1.addItem("Gujrat");
		choice1.addItem("M.Pradesh");
		choice1.addItem("Him.Prades");
		
		choice1.setBounds(250,140,150,20);
		choice1.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						ltf3.setText((String)choice1.getSelectedItem());
					}
				});
		p1.add(choice1);
		p1.add(ltf3);
		
		ltf4= new JTextField();
		ltf4.setBounds(250,180,150,20);
		p1.add(ltf4);
	
		ltf5= new JTextField();
		ltf5.setBounds(250,220,150,20);
		p1.add(ltf5);

		ltf6 = new JTextArea();
		JScrollPane jscroll = new JScrollPane(ltf6,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		jscroll.setBounds(250,260,200,80);
		p1.add(jscroll);
		
	

		ad= new JButton("Add Categorie",new ImageIcon("image/add.png"));
		ad.setBounds(50,380,140,30);
		ad.addActionListener(this);
		p1.add(ad);

		clear= new JButton("Clear",new ImageIcon("image/clear.png"));
		clear.setBounds(250,380,100,30);
		clear.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent e)
					{
					
						jd.dispose();  new Categorie(m1);
		
					}		

			
		});
		p1.add(clear);
		p1.setBackground(Color.orange);
		jd.setLayout(null);
		
		JLabel img=new JLabel(new ImageIcon("image/main2.jpg"));
		img.setBounds(0,0,500,450);
		p1.add(img);
		jd.setResizable(false);
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
						


						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from categorie");
							while (rs2.next())
							{
								if(s1.equals(rs2.getString(1)))
								{
									ch1=1; 
									break;
								}
							} 
			
						      } catch(Exception e){}				
						
						pass9=0;
					   //String i = ltf4.getText();
					   String i1=ltf5.getText();
					   String i2=ltf1.getText();
					
					for(int y1=0;y1<i1.length(); ++y1)
					{
						 if(i1.length()<=9){ pass9=7; ph2=1; }
						if(!Character.isDigit(i1.charAt(y1)))
						{  pass9=7;  ph2=1; }
						if(i1.length()>20)
							{ pass9=7; ph2=1;  }
					}
					for(int y2=0;y2<i2.length(); ++y2)
					{
						
						if(!Character.isDigit(i2.charAt(y2)))
						{  pass9=7;  ph3=1; }
					}
					

					if(ch1==0){	
						if(pass9==0)
						{

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
							JOptionPane.showMessageDialog(jd,"Add Success","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf5.setText("");
							ltf6.setText("");;
							jd.dispose();  new Categorie(m1);
							con.close();

							}
						catch(Exception e){ }
							}
							else { 
								
								if(ph2==1){JOptionPane.showMessageDialog(jd,"Incorrect contact no","Error",JOptionPane.ERROR_MESSAGE);}
								if(ph3==1){JOptionPane.showMessageDialog(jd,"Categorie ID only number accepted","Error",JOptionPane.ERROR_MESSAGE);}
								} 						
							}
							else{ if(ch1==1){JOptionPane.showMessageDialog(jd,"Categorie ID already added","Error",JOptionPane.ERROR_MESSAGE);}}					
						}


				}
		
		}

	
}