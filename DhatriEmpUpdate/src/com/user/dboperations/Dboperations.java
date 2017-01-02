package com.user.dboperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.user.bean.UserBean;

public class Dboperations
{
	Connection connection=null;
	PreparedStatement pst=null;
	ResultSet resultset=null;
	public Dboperations()
	{
		connection=MyConnection.getInstance().connection;
	}
	
	
	public int registration(UserBean ub)
	{
		int result=0;
		
		String query="insert into userdb values(?,?,?,?,?,?,?)";
		try
		{
			pst=connection.prepareStatement(query);
			pst.setString(1, ub.getEmpid());
			pst.setString(2, ub.getEmpname());
			pst.setString(3, ub.getEmpmailid());
			pst.setString(4, ub.getEmppwd());
			pst.setDouble(5, ub.getEmpsal());
			pst.setDouble(6, ub.getEmpexp());
			pst.setString(7, ub.getEmploc());
			result=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<UserBean> search(String umail)
	{
		ArrayList<UserBean> employeeList=new ArrayList<UserBean>();
		
		String query="select * from userdb where empmailid=?";
		
		try {
			pst=connection.prepareStatement(query);
			pst.setString(1, umail);
			
			resultset=pst.executeQuery();
			
			UserBean empBean=null;
			while(resultset.next())
			{
				empBean=new UserBean();
				empBean.setEmpid(resultset.getString(1));
				empBean.setEmpname(resultset.getString(2));
				empBean.setEmpmailid(resultset.getString(3));
				empBean.setEmppwd(resultset.getString(4));
				empBean.setEmpsal(resultset.getDouble(5));
				empBean.setEmpexp(resultset.getDouble(6));
				empBean.setEmploc(resultset.getString(7));
			
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
		
	}
}
