package com.dbo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.regbean.RegBean;


public class DBoperations
{
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rset=null;
	
	public DBoperations()
	{
		con=MyConnection.getInstance().connection;
	}
	
	
	public int insert(RegBean db)
	{
		int result=0;
		
		
		
		String query="insert into reg values(?,?,?)";
		
		try 
		{
			pst=con.prepareStatement(query);
			pst.setString(1,db.getUname());
			pst.setString(2,db.getUpwd());
			pst.setString(3,db.getUloc());	
		
			
			result=pst.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public ArrayList<RegBean> login(RegBean db)
	{ 
	
		
		ArrayList<RegBean> reg=new ArrayList<RegBean>();
		String query="slecet * from reg";
		try
		{
			pst=con.prepareStatement(query);
			
			rset=pst.executeQuery();
			RegBean rg=null;
			
			while(rset.next())
			{
				rg=new RegBean();
				rg.setUname(rset.getString(1));
				/*rg.setUpwd(rset.getString(2));
				rg.setUloc(rset.getString(3));*/
				reg.add(rg);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return reg;
		
	}
}
