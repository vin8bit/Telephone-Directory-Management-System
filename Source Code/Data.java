import java.sql.*;


public class Data
{
	String user="system";
	String pass="system";
	PreparedStatement stm;
	PreparedStatement preparedStmt;
	public Data()
	{
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
				String query = "CREATE TABLE  LOGIN9 (USER_ID VARCHAR2(100), USER_PASSWORD VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query);
      				preparedStmt.execute();
				stm =  conn.prepareStatement("insert into login9 values(?,?)");
			                stm.setString(1,"avsk");
				stm.setString(2,"456");
				stm.executeUpdate();
				String query2 = "CREATE TABLE  CUSTOMER (C_ID VARCHAR2(100), C_NAME VARCHAR2(100), C_ADDRESS VARCHAR2(100), GENDER VARCHAR2(100), CITY VARCHAR2(100), EMAIL_ID VARCHAR2(100), CONTACT_NO VARCHAR2(100), ID_PROOF VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query2);
      				preparedStmt.execute();				
				String query3 = "CREATE TABLE  CITY (STD_ID VARCHAR2(100), CITY_NAME VARCHAR2(100), STD_CODE VARCHAR2(100), STATE VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query3);
      				preparedStmt.execute();
				String query4 = "CREATE TABLE  CATEGORIE (C_ID VARCHAR2(100), C_NAME VARCHAR2(100), C_CITY VARCHAR2(100), C_PHONE_NO VARCHAR2(100), C_SECOND_NO VARCHAR2(100), ADDRESS VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query4);
      				preparedStmt.execute();
				System.out.println("Create Table Success");

				
				    }
				catch(Exception v) {    }
		}
public static void main(String []args)
	{  new Data();  }
}