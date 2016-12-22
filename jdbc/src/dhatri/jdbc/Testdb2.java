package dhatri.jdbc;
import java.sql.*;
import java.util.*;

//Taking Input From Keyboard


public class Testdb2 
{
	public static void main(String[] args) 
	{
		
	Connection con=null;
	Statement st=null;
	Scanner sc=null;
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","venkatesh");
	st=con.createStatement();
	
	sc=new Scanner(System.in);
	System.out.println("Enter Taable Name:");
	String tname=sc.next();
	
	String q1="create table "+tname+"(eid number,ename varchar2(30),esal number)";
	System.out.println(q1);
	int x=st.executeUpdate(q1);
	System.out.println("Table Created Successfully= "+x);
	while(true)
	{
		System.out.println("Enter Emp Id");
		int eid=sc.nextInt();
		System.out.println("Enter Emp Name");
		String ename=sc.next();
		System.out.println("Enter Emp Salary");
		double esal=sc.nextDouble();
		String q2="insert into "+tname+" values("+eid+",'"+ename+"',"+esal+")";
		System.out.println(q2);
		st.executeUpdate(q2);
		System.out.println("Do you want one more record(yes/no)");
		String option=sc.next();
		if(option.equals("no"))
		{
		break;
		}
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try{
		con.close();
		st.close();
		sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Connections Closed");
	}

	}

}
