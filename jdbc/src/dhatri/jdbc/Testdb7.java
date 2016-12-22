package dhatri.jdbc;
import java.sql.*;

public class Testdb7 
{

	public static void main(String[] args) 
	{
		Connection con=null;
		CallableStatement cst=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","venkatesh");
			cst=con.prepareCall("{call getSal(?,?)}");
			cst.setInt(1,111);
			cst.registerOutParameter(2, Types.FLOAT);
			
			cst.execute();
			
			System.out.println("Salary........."+cst.getFloat(2));
			
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
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}

		System.out.println("connection is closed");
	}

}
