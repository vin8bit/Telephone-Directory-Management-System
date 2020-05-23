import java.sql.*;
import java.io.*;

class Count1
{ 
	
	 Connection con;
	 Statement stm;
	 ResultSet rs;
	int rowCount,rowCount2,rowCount3,rowCount4;
	String user="system";
	String pass="system";
	public Count1() throws Exception
	{         
	}
	public  int call() throws Exception
	{
			
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT COUNT(*)  FROM customer ");
			rs.next();
			int rowCount=rs.getInt(1);	
			rs.close();
			stm.close();
			con.close();
			
			return rowCount;
	}
	
	public  int call2() throws Exception
	{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		           	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT COUNT(*)  FROM city ");
			rs.next();
			int rowCount2=rs.getInt(1);	
			rs.close();
			stm.close();
			con.close();
			return rowCount2;
	}
	public  int call3() throws Exception
	{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		           	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT COUNT(*)  FROM categorie ");
			rs.next();
			int rowCount3=rs.getInt(1);	
			rs.close();
			stm.close();
			con.close();
			return rowCount3;
	}
public static void main(String []args) throws Exception
	{
		Count1 d=new Count1();	
	}
}	





















