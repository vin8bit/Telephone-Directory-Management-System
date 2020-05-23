import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer implements ActionListener ,ItemListener
{
	
	
	String 	s1,s2,s3,s4,s5,s6,s7,s8;
	Checkbox box1,box2,box3;
	CheckboxGroup group;
	Choice choice1,choice2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9;
	JButton ad,clear;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2 ;
	String user="system";
	String pass="system";
	int pass9,ph,ph2,ph3,ph4,ch1;
	JDialog jd;
	Main m1;
	private Pattern pattern;
	private Matcher matcher;
	String email;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public Customer(Main m)
	{
		m1=m;
		pattern = Pattern.compile(EMAIL_PATTERN);
		jd = new JDialog(m);
		jd.setSize(500,500);
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		jd.setTitle("Add new Customer");
		JPanel p1=new JPanel();
		p1.setBounds(0,0,500,500);	
		p1.setLayout(null);
		jd.add(p1);
		JLabel tl=new JLabel("Add New Customer");
		Font font= new Font("Algerian",Font.BOLD,20);
		tl.setForeground(Color.yellow);
		tl.setBounds(150,20,250,30);
		tl.setFont(font);
		p1.add(tl);

		Font font1= new Font("Century",Font.BOLD,15);
		l1 =new JLabel("Customer ID :");
		l1.setBounds(50,60,150,20);
		l1.setForeground(Color.orange);
		p1.add(l1);
		l2 =new JLabel("Customer Name :");
		l2.setBounds(50,100,150,20);
		l2.setForeground(Color.orange);
		p1.add(l2);
		l3 =new JLabel("Address :");
		l3.setBounds(50,140,150,20);
		l3.setForeground(Color.orange);
		p1.add(l3);
		l4 =new JLabel("Gender :");
		l4.setBounds(50,180,150,20);
		l4.setForeground(Color.orange);	
		p1.add(l4);
		l5 =new JLabel("City :");
		l5.setBounds(50,220,150,20);
		
		l5.setForeground(Color.orange);
		p1.add(l5);
		l6 =new JLabel("Email ID :");
		l6.setBounds(50,260,150,20);
		
		l6.setForeground(Color.orange);
		p1.add(l6);
		l7 =new JLabel("Contact No :");
		l7.setBounds(50,300,150,20);
		
		l7.setForeground(Color.orange);
		p1.add(l7);
		l8 =new JLabel("ID Proof :");
		l8.setBounds(50,340,150,20);
		
		l8.setForeground(Color.orange);
		p1.add(l8);
		l1.setFont(font1);
		l2.setFont(font1);
		l3.setFont(font1);
		l4.setFont(font1);
		l5.setFont(font1);
		l6.setFont(font1);
		l7.setFont(font1);
		l8.setFont(font1);
		ltf1= new JTextField();
		ltf1.setBounds(200,60,150,20);
		try{
		Count1   co= new Count1();
			int au=201+co.call();
			ltf1.setText(String.valueOf(au));
			
			}
			catch(Exception c){}



		p1.add(ltf1);
		ltf2= new JTextField();
		ltf2.setBounds(200,100,150,20);
		p1.add(ltf2);
		ltf3= new JTextField();
		ltf3.setBounds(200,140,150,20);
		p1.add(ltf3);
		ltf4= new JTextField();
		group= new CheckboxGroup();
		box1 = new Checkbox("Male",false,group);
		box1.addItemListener(this);
		box1.setBounds(200,180,60,10);
		p1.add(box1);
		box2 = new Checkbox("Female",false,group);
		box2.addItemListener(this);
		box2.setBounds(260,180,60,10);
		p1.add(box2);
		box3 = new Checkbox("Other",false,group);
		box3.addItemListener(this);
		box3.setBounds(330,180,60,10);
		p1.add(box3);
		
		ltf5= new JTextField();
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
		choice1.addItem("Bangalore");
		choice1.addItem("Hyderabad");
		choice1.addItem("Surat");
		choice1.addItem("Jaipur");
		choice1.addItem("Lucknow");
		choice1.addItem("Agra");
		choice1.addItem("Nashik");
		choice1.addItem("Varanasi");
		choice1.addItem("Aurangabad");
		choice1.addItem("Guwahati");
		choice1.addItem("Punjab");
		
		choice1.setBounds(200,220,150,20);
		choice1.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						ltf5.setText((String)choice1.getSelectedItem());
					}
				});
		p1.add(choice1);
		ltf6= new JTextField();
		ltf6.setBounds(200,260,150,20);
		p1.add(ltf6);
		ltf7= new JTextField();
		ltf7.setBounds(200,300,150,20);
		p1.add(ltf7);
		ltf8= new JTextField();
		choice2=new  Choice();
		choice2.addItem("");
		choice2.addItem("Addhaar card");
		choice2.addItem("Pan card");
		choice2.addItem("Voter ID");
		choice2.addItem("Driving License");
		choice2.addItem("Passport");
		choice2.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						ltf8.setText((String)choice2.getSelectedItem());
					}
				});
		choice2.setBounds(200,340,150,20);
		p1.add(choice2);
	

		ad= new JButton("Add Customer",new ImageIcon("image/add.png"));
		ad.setBounds(50,380,140,30);
		ad.addActionListener(this);
		p1.add(ad);
		clear= new JButton("Clear",new ImageIcon("image/clear.png"));
		clear.setBounds(250,380,100,30);
		clear.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent e)
					{
						ltf1.setText("");
						ltf2.setText("");
						ltf3.setText("");
						ltf6.setText("");
						ltf7.setText("");
						jd.dispose();  new Customer(m1);
		
					}		

			
		});
		p1.add(clear);
		box1.setBackground(Color.black);
		box1.setForeground(Color.white);
		box2.setBackground(Color.black);
		box2.setForeground(Color.white);
		box3.setBackground(Color.black);
		box3.setForeground(Color.white);
		p1.setBackground(Color.orange);
		JLabel img=new JLabel(new ImageIcon("image/main2.jpg"));
		img.setBounds(0,0,500,500);
		p1.add(img);
		jd.setLayout(null);
		jd.setResizable(false);
		jd.setLocationRelativeTo(null);		
		jd.setVisible(true);
	}


	public void itemStateChanged(ItemEvent e)
	{	ltf4.setText(((Checkbox)e.getItemSelectable()).getLabel());
		
			
				
	}

	 
	       
	 
	    

	public void actionPerformed(ActionEvent er)
		{
				ph=0; ph2=0; ph3=0; ph4= 0; ch1=0;
				 s1=ltf1.getText(); 
				 s2=ltf2.getText();
				 s3=ltf3.getText();
				 s4=ltf4.getText();
				 s5=ltf5.getText();
				 s6=ltf6.getText();
				 s7=ltf7.getText();
				 s8=ltf8.getText();
				if(er.getSource()==ad)
				{
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty()||s8.isEmpty())
					{    JOptionPane.showMessageDialog(jd,"Text Fields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					else{
						
						   pass9=0;
						   String i = ltf1.getText();
						   String i1=ltf7.getText();
						  String i2=ltf2.getText();

						 matcher = pattern.matcher(s6);
	       					 if(matcher.matches()){ System.out.println("true"); } 
						else{ pass9=4; ph4=1; System.out.println("false");}

						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from customer");
							while (rs2.next())
							{
								if(s1.equals(rs2.getString(1)))
								{
									ch1=1; 
									break;
								}
							} 
						   }catch(Exception e){}
										
						
						

					for(int y=0;y<i.length(); ++y)
					{
						if(!Character.isDigit(i.charAt(y)))
							{  pass9=4;   ph=1; }
					
					}

					for(int y2=0;y2<i2.length(); ++y2)
					{
						if(!Character.isDigit(i2.charAt(y2)))
							{   }
						else{ pass9=3; ph3=1; }
					}
					for(int y1=0;y1<i1.length(); ++y1)
					{
						 if(i1.length()<=9){ pass9=7; ph2=1; }
						if(!Character.isDigit(i1.charAt(y1)))
						{  pass9=7;  ph2=1;}
						if(i1.length()>10)
							{ pass9=7; ph2=1;  }
					}
					
					if(ch1==0){
						if(pass9==0)
						{

						   try        { Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
							stm =  con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
			                			stm.setString(1,ltf1.getText());
							stm.setString(2,ltf2.getText());
							stm.setString(3,ltf3.getText());	
							stm.setString(4,ltf4.getText());
							stm.setString(5,ltf5.getText());
							stm.setString(6,ltf6.getText());
							stm.setString(7,ltf7.getText());
							stm.setString(8,ltf8.getText());
							stm.executeUpdate();
							JOptionPane.showMessageDialog(jd,"Add Success","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf5.setText("");
							ltf6.setText("");
							ltf7.setText("");
							jd.dispose();  new Customer(m1);
							con.close();

							}
						catch(Exception e){ }
							}
							else { if(ph==1){JOptionPane.showMessageDialog(jd,"Customer ID or only Number accepted","Error",JOptionPane.ERROR_MESSAGE);}
								if(ph2==1){JOptionPane.showMessageDialog(jd,"Incorrect Contact No","Error",JOptionPane.ERROR_MESSAGE);}
								if(ph3==1){JOptionPane.showMessageDialog(jd,"Incorrect Name","Error",JOptionPane.ERROR_MESSAGE);}
								if(ph4==1){JOptionPane.showMessageDialog(jd,"Invalid Email","Error",JOptionPane.ERROR_MESSAGE);}
							         } 						
						    }
						    else{ JOptionPane.showMessageDialog(jd,"Customer ID already added","Error",JOptionPane.ERROR_MESSAGE);}
						}


				}
		
		}

	
}