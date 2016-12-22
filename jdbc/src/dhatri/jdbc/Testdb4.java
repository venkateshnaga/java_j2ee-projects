package dhatri.jdbc;
import java.sql.*;

// Using BatchUpdations

	public class Testdb4 
	{


		public static void main(String[] args) 
		{
			Connection con=null;
			Statement st=null;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","venkatesh");
				
				String q1="create table student(sid number,sname varchar2(30),smarks number)";
				String q2="insert into student values(111,'venkatesh',550)";
				String q3="insert into student values(222,'naga',525)";
				
				st=con.createStatement();
				st.addBatch(q1);
				st.addBatch(q2);
				st.addBatch(q3);
				st.addBatch("insert into student values(333,'venky',560)");
				st.addBatch("update student set smarks=smarks+10 where smarks>530");
				//st.addBatch("drop table student");
				int[] a=st.executeBatch();
				for(int aa:a)
				{
					System.out.println(aa);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					con.close();
					st.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("connections closed");
		}

}
