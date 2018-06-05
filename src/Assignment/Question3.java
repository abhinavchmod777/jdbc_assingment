package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Question3 
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
			
			ResultSet rs = stmt.executeQuery("select * from employee , department where employee.dep_no = department.dep_no and department.dep_name='HR'");
			int count=0;
			ArrayList<Integer> id= new ArrayList<Integer>();
			
			System.out.println("Employees of HR Department ");
			while(rs.next())
			{
				count++;
				id.add(rs.getInt(1));
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDate(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" ");
			}
			
			String mail;
			Scanner s = new Scanner(System.in);
			for(int i=0;i<count;i++)
			{
				int x= id.get(i);
				System.out.println("Enter the new Email for employee id "+x);
				mail = s.nextLine();
				String query = "update employee set emp_mail ='"+mail+"where emp_id ="+x;
				System.out.println(query);
				System.out.println(stmt.executeUpdate(query)+" record updated");
			}

			s.close();
			
			//closing connection
			con.close();


		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
