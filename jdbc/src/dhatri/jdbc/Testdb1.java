package dhatri.jdbc;
import java.sql.*;
//JDBC Operations Insert,Select,Update, Delete,Drop 


public class Testdb1 
{
	public static void main(String[] args) 
	{
	Connection con=null;
	Statement st=null;
	ResultSet set=null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","venkatesh");
		st=con.createStatement();
		
		String q1="create table emp(eid number,ename varchar2(20),esal number)";
		st.executeUpdate(q1);
		
		String q2="insert into emp values(111,'naga',25000)";
		String q3="insert into emp values(222,'venky',23000)";
		String q4="insert into emp values(333,'venkatesh',28000)";
		st.executeUpdate(q2);
		st.executeUpdate(q3);
		st.executeUpdate(q4);
		System.out.println("Insertion Completed");
		
		String q5="select * from emp";
		set=st.executeQuery(q5);
		while(set.next())
		{
			System.out.println(set.getInt(1)+"-----"+set.getString(2)+"----"+set.getDouble(3));
		}
		System.out.println("Data Retrived Successfully");
		
		String q6="update emp set esal=esal+100 where esal>24000";
		int y=st.executeUpdate(q6);
		System.out.println("Updated Records Are= "+y);
		
		String q7="delete from emp where eid=111";
		st.executeUpdate(q7);
		Thread.sleep(20000);
		
	String q8="drop table emp";
	int z=st.executeUpdate(q8);
	System.out.println("Table Dropped Successfully ="+z);
											
											//con=null;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
											//if(con!=null)
											//{
	try {
		con.close();
		st.close();
	}
	catch (SQLException e) 
	{
	
		e.printStackTrace();
	}
	
											//}
	
	}

}
}