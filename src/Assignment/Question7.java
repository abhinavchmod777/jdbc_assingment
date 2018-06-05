package Assignment;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Question7 
{
	static Connection con;
	
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
		
	/*	stmt.executeUpdate("update employee set dep_no = NULL");
		stmt.executeUpdate("alter table Company.employee drop Foreign key fk_dep_no ");
		stmt.executeUpdate("drop table department cascade");		
	*/	
		//System.out.println(" records deleted " );
		
	/*	DatabaseMetaData dbmd = con.getMetaData();
		String table[]= {"TABLE"};
		ResultSet rs = dbmd.getTables(null, null, null, table);
		while(rs.next())
		{
			System.out.println(rs.getString(3));
		}
	*/	//closing connection
		con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
