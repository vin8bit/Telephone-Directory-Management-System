import java.awt.*;
import javax.swing.*;

public class Help 
{
	JDialog jd;
	public Help(Main m)
	{
		jd= new JDialog(m);
		jd.setSize(550,500);
		jd.setTitle("Help");
		jd.setIconImage(new ImageIcon("image/logo.png").getImage());
		jd.setLocationRelativeTo(null);
		jd.setLayout(null);
		JPanel p=new JPanel();
		p.setBounds(0,0,550,500);
		p.setBackground(Color.orange);
		p.setLayout(null);
		jd.add(p);
		JLabel l1= new JLabel("This Telephone Directory Make by AVSK ");
		l1.setBounds(30,50,550,30);
		l1.setForeground(Color.blue);
		JLabel l2= new JLabel("Any Help ");
		l2.setBounds(170,100,500,30);
		l2.setForeground(Color.blue);
		JLabel l3= new JLabel("Contact me  8510800127 ");
		l3.setBounds(60,150,500,30);
		l3.setForeground(Color.blue);
		JLabel l4= new JLabel("Email ID avsk10@gmail.com ");
		l4.setBounds(60,200,500,30);
		l4.setForeground(Color.blue);
		JLabel l5= new JLabel("Thank you for using Telephone Directory");
		l5.setBounds(60,250,500,30);
		l5.setForeground(Color.red);
		JLabel l6= new JLabel(new ImageIcon("image/fax.png"));
		l6.setBounds(20,320,500,70);
		l6.setForeground(Color.red);
		Font f1= new Font("Lucida Calligraphy",Font.BOLD,17);
		l1.setFont(f1);
		p.add(l1);
		l2.setFont(f1);
		p.add(l2);
		l3.setFont(f1);
		p.add(l3);
		l4.setFont(f1);
		p.add(l4);
		l5.setFont(f1);
		p.add(l5);
		p.add(l6);
	
	
	
		jd.setVisible(true);
	}
	
	
}