package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Question1 
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
//		int i=0;
	
/*		i+=stmt.executeUpdate("insert into Department values(6,'Developement','Hyderbad')");
		i+=stmt.executeUpdate("insert into Department values(7,'Creative','Chennai')");
		i+=stmt.executeUpdate("insert into Department values(8,'Technical','Delhi')");
		i+=stmt.executeUpdate("insert into Department values(9,'Organising','Delhi')");
		i+=stmt.executeUpdate("insert into Department values(10,'IT','Banglore')");
		i+=stmt.executeUpdate("insert into Department values(1,'Blogging','Banglore')");
		i+=stmt.executeUpdate("insert into Department values(2,'Testing','Mumbai')");
		i+=stmt.executeUpdate("insert into Department values(3,'Deployment','Hyderbad')");
		i+=stmt.executeUpdate("insert into Department values(4,'HR','Mumbai')");
		i+=stmt.executeUpdate("insert into Department values(5,'Analysis','Chennai')");

		System.out.println(i+" records updated of Department Table");
*/
		int j =0;
		
		j+=stmt.executeUpdate("insert into employee values(1,'Deepak','Sharma',40000,'2012-09-23','HR',4,'deepaksharma123@gmail.com')");
		j+=stmt.executeUpdate("insert into employee values(2,'Shivani','Verma',50000,'2012-08-13','',2,'ShivaniVermaa123@gmail.com')");		
		j+=stmt.executeUpdate("insert into employee values(3,'Mansi','Arora',40000,'2013-01-17','',3,'mansi98786@gmail.com')");
		j+=stmt.executeUpdate("insert into employee values(4,'Nilesh','Gautam',70000,'2014-06-21','',4,'GautamNilesh23@gmail.com')");		
		j+=stmt.executeUpdate("insert into employee values(5,'Vikas','Chauhan',10000,'2012-07-23','',6,'Viksaa1098@gmail.com')");
		j+=stmt.executeUpdate("insert into employee values(6,'Yusuf','Parvez',70000,'2015-08-23','',1,'yousuf45123@gmail.com')");		
		j+=stmt.executeUpdate("insert into employee values(7,'Prashant','Tiwari',80000,'2016-07-02','',1,'Tiwarii0808@gmail.com')");
		j+=stmt.executeUpdate("insert into employee values(8,'Jasmine','Sharma',20000,'2017-09-01','',4,'JasmineSharma9097@gmail.com')");		
		j+=stmt.executeUpdate("insert into employee values(9,'Anjali','Sajwan',20000,'2017-09-09','',5,'Sajwan90753123@gmail.com')");
		j+=stmt.executeUpdate("insert into employee values(10,'Rahul','Sharma',30000,'2018-01-23','',5,'Rahuldj98@gmail.com')");		

		System.out.println(j+" records updated of Employee Table");

		//closing connection 
		con.close();
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
