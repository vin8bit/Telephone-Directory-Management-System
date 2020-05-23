import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.regex.*;
import java.sql.*;

public class Record1 extends JFrame implements ActionListener
{
	JTextField tf1;
	JButton b1,b2;
	String columns[]={"Customer ID","Customer Name","Address","Gender","City","Email ID","Contact no","ID Proof"};
	TableModel tmodel;
	JTable jtable;
	TableRowSorter<TableModel> rsorter;
	int i=0,k=0,l=0,p=0,y=0,j=0,y2=0,j2=0;
	Connection con;
	Statement stm;
	String user="system";
	String pass="system";
	Count1 count=new Count1();
	int g=8+count.call();
	Object array[][] = new Object[g][10];
	
	ResultSet rs;
	public Record1() throws Exception
	{
		setIconImage(new ImageIcon("image/logo.png").getImage());
		
			
		try
			{
			
	
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		            	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT *  FROM customer ");	
			
			while(rs.next())
			{   
				array[i++][0]=rs.getObject("C_ID");
				array[k++][1]=rs.getObject("C_NAME");
				array[l++][2]=rs.getObject("C_ADDRESS");
				array[p++][3]=rs.getObject("GENDER");
				array[y++][4]=rs.getObject("CITY");
				array[j++][5]=rs.getObject("EMAIL_ID");
				array[y2++][6]=rs.getObject("CONTACT_NO");
				array[j2++][7]=rs.getObject("ID_PROOF");

				
				
			}      
			con.close();	
				
			}
		catch(SQLException e)
		{   	JOptionPane.showMessageDialog(this,e,"Success",JOptionPane.INFORMATION_MESSAGE);
			 } 



		setTitle("Customer Record");
		setSize(650,450);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		
		p1.setBackground(Color.orange);
		add(p1,BorderLayout.EAST);
		p2.setBackground(Color.orange);
		add(p2,BorderLayout.NORTH);
		
				
		JLabel l1=new JLabel("Customer Record");
		Font font=new Font("French Script MT",Font.BOLD,25);
		l1.setFont(font);
		p2.add(l1);
		tf1= new JTextField(10);
		p1.add(tf1);		
		b1= new JButton("Search",new ImageIcon("image/se.png"));
		b1.addActionListener(this);
		p1.add(b1);
		tmodel= new DefaultTableModel(array,columns);
		jtable=new JTable(tmodel);
		rsorter = new TableRowSorter<TableModel>(tmodel);
		JScrollPane jspane=new JScrollPane(jtable);
		jtable.setRowSorter(rsorter);
		add(jspane,BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent er)
		{
			if(er.getSource()==b1)
				{ 
				String text=tf1.getText();
					if(text.length()==0)
					{     rsorter.setRowFilter(null);  }
					rsorter.setRowFilter(RowFilter.regexFilter(text));
				}
				

		}

public static void main(String []args) throws Exception
	{ new Record1(); }

}
		