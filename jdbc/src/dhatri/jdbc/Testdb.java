package dhatri.jdbc;

import java.sql.*;

//Basic JDBC Program 

public class Testdb 
{
	public static void main(String[] args) 
	{
	Connection con=null;
	Statement st=null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","venkatesh");
		st=con.createStatement();
		String q1="create table emp(eid number,ename varchar2(30),esal number)";
		int x=st.executeUpdate(q1);
		System.out.println("Table Created Succesfully= "+x);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		
		try {
			con.close();
			st.close();
			} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	

	}

}
