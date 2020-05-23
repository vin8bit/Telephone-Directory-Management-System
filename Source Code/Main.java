import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener
{
	JMenuBar m;
	JMenu file,customer,city,categorie,report,help;
	JMenuItem f1,f2;
	JMenuItem g1,g2,g3,g4,g5,g6,g7;
	JMenuItem r1,r2,r3,r4,r5,r6,r7;
	JMenuItem ro1;
	JMenuItem s1,s2,s3,s4,s5,s6,s7;
	JMenuItem m1,m2,m3,m4,m5,m6,m7;
	JMenuItem l1;
	JToolBar tbar;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
	public Main()
	{
		
		setSize(820,660);
		setTitle("Telephone Directory");
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel p= new JPanel();
		add(p);
		
		//Menu
		m=new JMenuBar();
		file=new JMenu("File");
		m.add(file);
		customer=new JMenu("Customer");
		m.add(customer);
		city=new JMenu("City");
		m.add(city);
		categorie=new JMenu("Category");
		m.add(categorie);
		report=new JMenu("Record");
		m.add(report);
		help=new JMenu("Help");
		m.add(help);
		
		//ToolBar
		tbar= new JToolBar();
		b1= new JButton(new ImageIcon("image/1.png"));
		tbar.add(b1);
		b1.setRolloverIcon(new ImageIcon("image/1c.png"));
		b1.addActionListener(this);
		b1.setToolTipText("New Customer");
		
		b2= new JButton(new ImageIcon("image/2.png"));
		tbar.add(b2);
		b2.setRolloverIcon(new ImageIcon("image/2c.png"));
		b2.addActionListener(this);
		b2.setToolTipText("Update customer");
	
		b3= new JButton(new ImageIcon("image/3.png"));
		tbar.add(b3);
		b3.setRolloverIcon(new ImageIcon("image/3c.png"));
		b3.addActionListener(this);
		b3.setToolTipText("Search customer");
		
		b4= new JButton(new ImageIcon("image/4.png"));
		tbar.add(b4);
		b4.setRolloverIcon(new ImageIcon("image/4c.png"));
		b4.addActionListener(this);
		b4.setToolTipText("Delete customer");
		
		b5= new JButton(new ImageIcon("image/5.png"));
		tbar.add(b5);
		b5.setRolloverIcon(new ImageIcon("image/5c.png"));
		b5.addActionListener(this);
		b5.setToolTipText("Add city code");

		b6= new JButton(new ImageIcon("image/6.png"));
		tbar.add(b6);
		b6.setRolloverIcon(new ImageIcon("image/6c.png"));
		b6.addActionListener(this);
		b6.setToolTipText("Update city code");
		
		b7= new JButton(new ImageIcon("image/3.png"));
		tbar.add(b7);
		b7.setRolloverIcon(new ImageIcon("image/3c.png"));
		b7.addActionListener(this);
		b7.setToolTipText("Search city code");
			
		b8= new JButton(new ImageIcon("image/7.png"));
		tbar.add(b8);
		b8.setRolloverIcon(new ImageIcon("image/7c.png"));
		b8.addActionListener(this);
		b8.setToolTipText("Delete city code");
		
		b9= new JButton(new ImageIcon("image/8.png"));
		tbar.add(b9);
		b9.setRolloverIcon(new ImageIcon("image/8c.png"));
		b9.addActionListener(this);
		b9.setToolTipText("Add new categorie");

		b10= new JButton(new ImageIcon("image/9.png"));
		tbar.add(b10);
		b10.setRolloverIcon(new ImageIcon("image/9c.png"));
		b10.addActionListener(this);
		b10.setToolTipText("Update categorie");
		
		b11= new JButton(new ImageIcon("image/3.png"));
		tbar.add(b11);
		b11.setRolloverIcon(new ImageIcon("image/3c.png"));
		b11.addActionListener(this);
		b11.setToolTipText("Search categorie");
		
		b12= new JButton(new ImageIcon("image/7.png"));
		tbar.add(b12);
		b12.setRolloverIcon(new ImageIcon("image/7c.png"));
		b12.addActionListener(this);
		b12.setToolTipText("Delete categorie");
		
		b13= new JButton(new ImageIcon("image/11.png"));
		tbar.add(b13);
		b13.setRolloverIcon(new ImageIcon("image/11c.png"));
		b13.addActionListener(this);
		b13.setToolTipText("Customer Record");
		
		b14= new JButton(new ImageIcon("image/12.png"));
		tbar.add(b14);
		b14.setRolloverIcon(new ImageIcon("image/12c.png"));
		b14.addActionListener(this);
		b14.setToolTipText("City Record");
		
		b15= new JButton(new ImageIcon("image/6.png"));
		tbar.add(b15);
		b15.setRolloverIcon(new ImageIcon("image/6c.png"));
		b15.addActionListener(this);
		b15.setToolTipText("Categorie Record");
		
		add(tbar,BorderLayout.NORTH);


		//file
		f1=new JMenuItem("Log out",new ImageIcon("image/key.png"));
		file.add(f1);
		f1.addActionListener(this);
		f2=new JMenuItem("Exit",new ImageIcon("image/cancel.png"));
		f2.addActionListener(this);
		file.add(f2);

		//Cusotmer
		g1=new JMenuItem("New Customer",new ImageIcon("image/customer.png"));
		customer.add(g1);
		g1.addActionListener(this);
		g2=new JMenuItem("Update Customer",new ImageIcon("image/upc.png"));
		g2.addActionListener(this);
		customer.add(g2);
		g3=new JMenuItem("Search Customer",new ImageIcon("image/search.png"));
		customer.add(g3);
		g3.addActionListener(this);
		g4=new JMenuItem("Delete Customer",new ImageIcon("image/dl.png"));
		g4.addActionListener(this);
		customer.add(g4);
		
		//City
		r1=new JMenuItem("New STD code",new ImageIcon("image/phone.png"));
		city.add(r1);
		r1.addActionListener(this);
		r2=new JMenuItem("Update STD code",new ImageIcon("image/up2.png"));
		r2.addActionListener(this);
		city.add(r2);
		r3=new JMenuItem("Search STD code",new ImageIcon("image/search.png"));
		city.add(r3);
		r3.addActionListener(this);
		r4=new JMenuItem("Delete STD code",new ImageIcon("image/logo.png"));
		r4.addActionListener(this);
		city.add(r4);
		
		//Categorie
		s1=new JMenuItem("New Category",new ImageIcon("image/cet1.png"));
		categorie.add(s1);
		s1.addActionListener(this);
		s2=new JMenuItem("Update Category",new ImageIcon("image/up1.png"));
		s2.addActionListener(this);
		categorie.add(s2);
		s3=new JMenuItem("Search Category",new ImageIcon("image/search.png"));
		categorie.add(s3);
		s3.addActionListener(this);
		s4=new JMenuItem("Delete Category",new ImageIcon("image/logo.png"));
		s4.addActionListener(this);
		categorie.add(s4);
		
		
		//Report
		m1=new JMenuItem("Customer Record",new ImageIcon("image/contacts.png"));
		report.add(m1);
		m1.addActionListener(this);
		m2=new JMenuItem("STD Code Record",new ImageIcon("image/record2.png"));
		m2.addActionListener(this);
		report.add(m2);
		m3=new JMenuItem("Category Record",new ImageIcon("image/up2.png"));
		report.add(m3);
		m3.addActionListener(this);
				
		//Help
		ro1=new JMenuItem("Help",new ImageIcon("image/phone.png"));
		help.add(ro1);
		ro1.addActionListener(this);

			
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){ System.exit(0);  }});
		
		JLabel img= new JLabel(new ImageIcon("image/main.jpg"));
		add(img);
		
		setIconImage(new ImageIcon("image/logo.png").getImage());

		
		setJMenuBar(m);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==f1)
		{    dispose(); new Login(); }

		if(e.getSource()==f2)
		{    System.exit(0); }
		
		if(e.getSource()==g1||e.getSource()==b1)
		{  
			new Customer(this);  	
		}
		if(e.getSource()==g2||e.getSource()==b2)
		{  
			new UpdateCustomer(this); 	
		}
		if(e.getSource()==g3||e.getSource()==b3)
		{  
			new SearchCustomer(this);  	
		}
		if(e.getSource()==g4||e.getSource()==b4)
		{  
			new DeleteCustomer(this); 	
		}
		
		if(e.getSource()==r1||e.getSource()==b5)
		{  
			new City(this); 	
		}
		if(e.getSource()==r2||e.getSource()==b6)
		{  
			new UpdateCity(this);  	
		}
		if(e.getSource()==r3||e.getSource()==b7)
		{  
			new SearchCity(this); 	
		}
		if(e.getSource()==r4||e.getSource()==b8)
		{  
			new DeleteCity(this); 
		}
		

		if(e.getSource()==s1||e.getSource()==b9)
		{  
			new Categorie(this);
		}
		if(e.getSource()==s2||e.getSource()==b10)
		{  
			new UpdateCategorie(this);
		}
		if(e.getSource()==s3||e.getSource()==b11)
		{  
			new SearchCategorie(this);	
		}
		if(e.getSource()==s4||e.getSource()==b12)
		{  
			new DeleteCategorie(this);	
		}


		if(e.getSource()==m1||e.getSource()==b13)
		{  
			try{new Record1(); } catch(Exception ea){}
		}
		if(e.getSource()==m2||e.getSource()==b14)
		{  
			try{new Record2(); } catch(Exception ea){}
		}
		if(e.getSource()==m3||e.getSource()==b15)
		{  
			try{new Record3(); } catch(Exception ea){}	
		}
		if(e.getSource()==ro1)
		{  
			new Help(this);	
		}
		
		


	}

public static void main(String arr[])  
	{  new Main(); }
}


