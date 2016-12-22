package com.employeejsp;

import java.sql.*;

import java.util.ArrayList;
import java.util.Iterator;



public class DAOOperations {
	Connection connection;
	PreparedStatement pst;
	ResultSet resultSet;

	public DAOOperations() {
		connection = MyConnection.getInstance().connec;
	}

	public int insertData(EmployeeBean employeeBean) {
		int result = 0;
		String query = "insert into employee2 values(?,?,?,?,?,?)";

		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, employeeBean.getEmployeeId());
			pst.setString(2, employeeBean.getEmployeeName());
			pst.setDouble(3, employeeBean.getEmployeeSlary());
			pst.setDouble(4, employeeBean.getEmployeeLoan());
			pst.setDouble(5, employeeBean.getEmployeeExp());
			pst.setString(6, employeeBean.getEmployeeLoc());


			result = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}
	
	public int update(EmployeeBean employeeBean)
	{
		int result=0;
		
	try
	{
		
		pst=connection.prepareStatement("update employee2 set employeeName=?,employeeSlary=?,employeeExp=?,employeeLoc=? where employeeId=?");
		pst.setString(1,employeeBean.getEmployeeName());
		pst.setDouble(2,employeeBean.getEmployeeSlary());
		pst.setDouble(3,employeeBean.getEmployeeExp());
		pst.setString(4,employeeBean.getEmployeeLoc());
		pst.setString(5,employeeBean.getEmployeeId());
		
		 result=pst.executeUpdate();
		
		 System.out.println("updated rows:"+ result);
		
	}
		catch(SQLException ei)
		{
			ei.printStackTrace();
		
		}
	return result;
	
	}
	public void delete(String empId)
	{
		
		String query="delete from employee where eid=?";
		
		try 
		{
			pst=connection.prepareStatement(query);
			
			pst.setString(1, empId);
			
			int x=	pst.executeUpdate();
			System.out.println("deleted rows:"+ x);

		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public ArrayList<EmployeeBean> search()
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select * from employee ";
		
		try {
			pst=connection.prepareStatement(query);
			//preparedStatement.setString(1, searchElement);
			
			resultSet=pst.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultSet.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmployeeId(resultSet.getString(1));
				empBean.setEmployeeName(resultSet.getString(2));
				empBean.setEmployeeSlary(resultSet.getDouble(3));
				empBean.setEmployeeLoc(resultSet.getString(4));
				empBean.setEmployeeExp(resultSet.getInt(5));
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return employeeList;
	}
	public ArrayList<EmployeeBean> search(String searchElement)
	{
		ArrayList<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
		
		String query="select eid,ename,eexp from employee where eid=?";
		
		try {
			pst=connection.prepareStatement(query);
			pst.setString(1, searchElement);
			
			resultSet=pst.executeQuery();
			
			EmployeeBean empBean=null;
			while(resultSet.next())
			{
				empBean=new EmployeeBean();
				empBean.setEmployeeId(resultSet.getString(1));
				empBean.setEmployeeName(resultSet.getString(2));
				
				empBean.setEmployeeExp(resultSet.getInt(3));
				employeeList.add(empBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employeeList;
	}
		
	public void loan(int eLoan,String Id) throws Exception
		
		{
			
			ArrayList<EmployeeBean> loe=search(Id);
			Iterator<EmployeeBean> itt=loe.iterator();
			EmployeeBean ee=null;
			while(itt.hasNext())
			{
			ee=(EmployeeBean)itt.next();
			
			if(ee.getEmployeeExp()>2 && ee.getEmployeeExp()<4)
			{
				eLoan=(int)ee.getEmployeeSlary()+1000;
				ee.setEmployeeLoan(eLoan);
				System.out.println("loan=" +eLoan);
				
			}
			else
			{
				eLoan=(int)ee.getEmployeeSlary()+100;
				ee.setEmployeeLoan(eLoan);
				System.out.println("not eligible for loan");
				
			}
		}
			String query="update employee set eloan=? where eid=?";

			pst=connection.prepareStatement(query);
			pst.setInt(1, eLoan);
			pst.setString(2, Id);
			int x=pst.executeUpdate();
			
			System.out.println("Updated rows="+x);	
		}		*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

