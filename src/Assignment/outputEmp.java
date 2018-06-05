package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class outputEmp {
	public static void main(String args[])
	{
		try 
		{
			//loading the driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//establishing connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Company","root","");
			
			//creating statement object
			Statement stmt = con.createStatement();		
			
			//getting output
			ResultSet rs = stmt.executeQuery("select * from employee");
			while(rs.next()) 
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDate(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" ");
			}
			
			//closing connection 
			con.close();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}

}
