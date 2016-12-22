package dhatri.jdbc;
import java.sql.*;

//Using MYSQL Database

public class Testdb6 {


	public static void main(String[] args) 
	{
		Connection con=null;
		Statement st=null;
		ResultSet set=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/venkatesh","root","root");
			st=con.createStatement();
			set=st.executeQuery("select * from emp");
			while(set.next())
			{
				System.out.println(set.getInt(1)+"---"+set.getString(2)+"----"+set.getDouble(3));
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
				set.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Connections Closed");
	}

}
