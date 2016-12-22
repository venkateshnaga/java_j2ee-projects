package dhatri.jdbc;
import java.sql.*;
import java.util.*;

// Using Prepared Statement

public class Testdb3 
{

	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pst=null;
		Scanner sc=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","venkatesh");
			pst=con.prepareStatement("insert into emp values(?,?,?)");
			sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("Enter Emp Id");
				int eid=sc.nextInt();
				System.out.println("Enter Emp Name");
				String ename=sc.next();
				System.out.println("Enter Emp Salary");
				double esal=sc.nextDouble();
				
				pst.setInt(1, eid);
				pst.setString(2, ename);
				pst.setDouble(3, esal);
				pst.executeUpdate();
				System.out.println("Do You Want To Add One More Record(yes/no)");
				String option=sc.next();
				if(option.equals("no"))
				{
					break;
				}
			}
			pst=con.prepareStatement("update emp set esal=esal+? where esal>?");
			pst.setInt(1,1000);
			pst.setDouble(2,25000);
			int y=pst.executeUpdate();
			System.out.println("Updated rows="+y);
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
				sc.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Connections Cloased");
	}

}
