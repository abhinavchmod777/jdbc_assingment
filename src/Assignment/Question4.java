package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Question4 
{
	static Connection con;
	static PreparedStatement pstmt;
	
	public static void main(String[] args)
	{
		try 
		{

		//loading the driver class
		Class.forName("com.mysql.jdbc.Driver");
		
		//establishing connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Company","root","");
		
		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		
		stmt.addBatch("insert into employee values(11,'Akansha','Sharma',15000,'2014-09-23','',6,'akansha23@gmail.com')");
		stmt.addBatch("insert into employee values(12,'Ayush','Parashari',18000,'2016-02-13','',7,'ayushparas563@gmail.com')");
		stmt.addBatch("insert into employee values(15,'Antriksh','Mourya',10000,'2012-01-26','',1,'galaxy12323@gmail.com')");

		stmt.executeBatch();
		System.out.println(" records updated of Employee Table");
		
		con.commit();
		
		//closing connection 
		con.close();
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
