package Assignment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question6 
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
			pstmt = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");		
			
			//taking input
			Scanner s = new Scanner(System.in);
			String c;
			do {
				
				System.out.println("Enter employee Details as");
				System.out.println("emp_id,first_name,last_name,salary,joining_day,department,dep_no,emp_mail");
				String details = s.nextLine();
			//	String details = "23,Aishwarya,Parashari,40000,2012-09-09,,6,aishParashari@gmai.com";
				
				List<String> values = new ArrayList<String>(Arrays.asList(details.split(","))) ;
					
				pstmt.setInt(1,Integer.parseInt(values.get(0)));
				pstmt.setString(2,values.get(1));
				pstmt.setString(3,values.get(2));
				pstmt.setInt(4,Integer.parseInt(values.get(3)));
				pstmt.setDate(5,java.sql.Date.valueOf(values.get(4)));
				pstmt.setString(6,values.get(5));
				pstmt.setInt(7,Integer.parseInt(values.get(6)));
				pstmt.setString(8,values.get(7));
				
				int i = pstmt.executeUpdate();
				System.out.println(i+"record updated");
				
				System.out.println("enter y to enter more records ");
				c= s.nextLine();	
				
			}while(c.startsWith("y"));

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
