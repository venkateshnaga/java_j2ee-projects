package dhatri.jdbc;
import java.sql.*;

// Using BatchUpdations With Prepared Statement

public class Testdb5 
{

	public static void main(String[] args) 
	{
		
		Connection con=null;
		PreparedStatement pst=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","venkatesh");
			pst=con.prepareStatement("update student set sname=? where sid=?");
			
			pst.setString(1, "Nagavenkatesh");
			pst.setInt(2, 111);
			pst.addBatch();
			
			int[] b=pst.executeBatch();
			for(int bb:b)
			{
				System.out.println(bb);
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
				pst.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("Connections Closed");

	}

}
