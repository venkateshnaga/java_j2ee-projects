package com.employee.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.employee.bean.EmployeeBean;
import com.employee.bean.EmployeeCompanyBean;

public class Dboperations
{
	Connection connection=null;
	PreparedStatement pst=null;
	ResultSet resultSet=null;

	public Dboperations()
	{
		connection=MyConnection.getInstance().connection;
	}
	
	
	public int employeeregistration(EmployeeBean emp,EmployeeCompanyBean empc)
	{
		int result=0;
		String query="insert into emppersonal values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String query1="insert into empcompany values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try 
		{
			pst=connection.prepareStatement(query);
			
			pst.setString(1,emp.getEmpid());
			pst.setString(2,emp.getFname());
			pst.setString(3,emp.getLname());	
			pst.setString(4,emp.getDob());
			pst.setString(5,emp.getMobileno());			
			pst.setString(6,emp.getEmialid());
			pst.setString(7,emp.getAltmobileno());
			pst.setString(8,emp.getAltemialid());
			pst.setString(9,emp.getPresentaddress());			
			pst.setString(10,emp.getPermanentaddress());
			pst.setString(11,emp.getFathername());
			pst.setString(12,emp.getFatheroccupation());
			result=pst.executeUpdate();
			
			pst=connection.prepareStatement(query1);
			pst.setString(1, empc.getEmpid());
			pst.setString(2,empc.getExp());
			pst.setString(3,empc.getPastcompanyname());	
			pst.setString(4,empc.getPastcompanyperiod());
			pst.setString(5,empc.getDoj());			
			pst.setString(6,empc.getCurrentctc());
			pst.setString(7,empc.getPastctc());
			pst.setString(8,empc.getPasthikedate());
			pst.setString(9,empc.getAdvsal());			
			pst.setString(10,empc.getAdvsaldate());
			pst.setString(11,empc.getAdvsalterms());
			pst.setString(12,empc.getDesignation());
			pst.setString(13,empc.getTechnology());
			result=pst.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	public ArrayList<EmployeeBean> loginsearch(String employeeid)
	{
		
		ArrayList<EmployeeBean> empref=new ArrayList<EmployeeBean>();
		
String query="select empid,empdob,empmailid from emppersonal where empid=?";
		
		try {
			pst=connection.prepareStatement(query);
			pst.setString(1, employeeid);
			
			resultSet=pst.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultSet.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmpid(resultSet.getString(1));
				empBean.setDob(resultSet.getString(2));
				empBean.setEmialid(resultSet.getString(3));
				
			
				empref.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return empref;
		
	}
	
	public ArrayList<EmployeeBean> userprofile(String employeeid)
	{
		
		ArrayList<EmployeeBean> empref=new ArrayList<EmployeeBean>();
		
		
		String query="select * from emppersonal where empid=?";
		
		try {
			pst=connection.prepareStatement(query);
			pst.setString(1, employeeid);
			
			resultSet=pst.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultSet.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmpid(resultSet.getString(1));
				empBean.setFname(resultSet.getString(2));
				empBean.setLname(resultSet.getString(3));
				empBean.setDob(resultSet.getString(4));
				empBean.setMobileno(resultSet.getString(5));
				empBean.setEmialid(resultSet.getString(6));
				empBean.setAltmobileno(resultSet.getString(7));
				empBean.setAltemialid(resultSet.getString(8));
				empBean.setPresentaddress(resultSet.getString(9));
				empBean.setPermanentaddress(resultSet.getString(10));
				empBean.setFathername(resultSet.getString(11));
				empBean.setFatheroccupation(resultSet.getString(12));
				empref.add(empBean);
				
			}
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empref;
		
	}
	
	public ArrayList<EmployeeCompanyBean> usercompanyprofile(String employeeid)
	{
		ArrayList<EmployeeCompanyBean> empref1=new ArrayList<EmployeeCompanyBean>();
		String query1="select * from empcompany where empid=?";
		
		try {
			pst=connection.prepareStatement(query1);
			pst.setString(1, employeeid);
			
			resultSet=pst.executeQuery();
			
			EmployeeCompanyBean empBean=null;
			while(resultSet.next())
			{
				empBean=new EmployeeCompanyBean();
				empBean.setEmpid(resultSet.getString(1));
				empBean.setExp(resultSet.getString(2));
				empBean.setPastcompanyname(resultSet.getString(3));
				empBean.setPastcompanyperiod(resultSet.getString(4));
				empBean.setDoj(resultSet.getString(5));
				empBean.setCurrentctc(resultSet.getString(6));
				empBean.setPastctc(resultSet.getString(7));
				empBean.setPasthikedate(resultSet.getString(8));
				empBean.setAdvsal(resultSet.getString(9));
				empBean.setAdvsaldate(resultSet.getString(10));
				empBean.setAdvsalterms(resultSet.getString(11));
				empBean.setDesignation(resultSet.getString(12));
				empBean.setTechnology(resultSet.getString(13));
				empref1.add(empBean);
				
			}
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empref1;
	}
	
	
	public int employeeupdate(EmployeeBean empbean)
	{
		int result=0;
		
	String query="update emppersonal set empfirstname=?,emplastname=?,empdob=?,empmobileno=?,empmailid=?  where empid=?";
		
	try {
		pst=connection.prepareStatement(query);
		pst.setString(1, empbean.getFname());
		pst.setString(2, empbean.getLname());
		pst.setString(3, empbean.getDob());
		pst.setString(4, empbean.getMobileno());
		pst.setString(5, empbean.getEmialid());
		pst.setString(6, empbean.getEmpid());
		
		
		result=pst.executeUpdate();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
		
		
		return result;
	}
}
