package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Question2
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
		String query ="Select * from employee inner join department "+
						"on employee.dep_no = department.dep_no and salary = "+
						"(select max(salary) from employee where salary in ("+
						"select salary from employee where salary < (select max(salary) from employee where salary in (select salary from employee" +
						" where salary < (Select max(salary) from employee)))))";

		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDate(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getInt(9)+" "+rs.getString(10)+" "+rs.getString(11));
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
