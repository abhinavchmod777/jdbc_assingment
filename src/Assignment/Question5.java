package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Question5 
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
		
		//creating statement
		Statement stmt = con.createStatement();
		
		//sql query
		String query ="delete from employee where salary < 20000";
				
		int i = stmt.executeUpdate(query);
		
		System.out.println(i+" records deleted " );
		
		//closing connection
		con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
