package com.dhatrijdbc;

import java.sql.*;
import java.util.*;

public class DataBaseOperations 
{
	Connection connection;
	java.sql.Statement statementRef;
	PreparedStatement statement;
	ResultSet resultSet;
	
	public DataBaseOperations()
	{
		connection=MyConnection.getInstance().connection;
	}
	
	/*
	//Insertion Using Statement
	public int insertData(Employee employee)
	{
		int result=0;
	String query="insert into employee values("+ employee.getEmployeeId()+','+"'"+employee.getEmployeeName()+"',"+employee.getEmployeeSlary()+",'"+employee.getEmployeeLoc()+"',"+employee.getEmployeeExp()+","+employee.getEmployeeLoan()+ ")";
		try {
			statementRef=connection.createStatement();
			result=statementRef.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}*/
	
	
	//Insertion Using Prepared Statement
	public int insertDataUsingPrepared(Employee employee)
	{
		int result=0;
		
		String query="insert into employee values(?,?,?,?,?,?,?)";
		
		try
		{
			statement=connection.prepareStatement(query);
			
			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getEmployeeName());
			statement.setDouble(3, employee.getEmployeeSlary());
			statement.setString(4, employee.getEmployeeLoc());
			statement.setDouble(5, employee.getEmployeeExp());
			statement.setDouble(6, employee.getEmployeeLoan());
			statement.setDouble(7, employee.getEmployeeEmi());
			result=statement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void update(String empName,double empSal,String empLoc,double empExp,double empLoan, double empEmi,int empID)
	{
		String query="update employee set employeeName=?,employeeSlary=?,employeeLoc=?,employeeExp=?,employeeLoan=?,employeeEmi=? where employeeId=?";
		try 
		{
			statement=connection.prepareStatement(query);
			statement.setString(1, empName);
			statement.setDouble(2, empSal);
			statement.setString(3, empLoc);
			statement.setDouble(4,empExp);
			statement.setDouble(5,empLoan);
			statement.setDouble(6,empEmi);
			statement.setInt(7, empID);
			int x=statement.executeUpdate();
			System.out.println("Updated Rows="+x);
		}
		
		catch (SQLException e)
		{
				e.printStackTrace();
		}

	}
	
	public void delete(int empId)
	{
		
		String query="delete from employee where employeeId=?";
		
		try 
		{
			statement=connection.prepareStatement(query);
			
			statement.setInt(1, empId);
			
			int x=	statement.executeUpdate();
			System.out.println("Deleted Rows: "+ x);

		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loan(int employeeid)
	
	{
		
		ArrayList<Employee> ref=search(employeeid);
		
		Iterator<Employee> it=ref.iterator();
		Employee ee=null;
		
		while(it.hasNext())
		{
			
		ee=(Employee)it.next();
		
		double empLoan=0.0;
		double isalary=ee.getEmployeeSlary();
		
		if(ee.getEmployeeExp()<=2 && ee.getEmployeeExp()>1 && ee.getEmployeeSlary()<=240000)
		{
			empLoan=isalary/2;
			ee.setEmployeeLoan(empLoan);
			double emi=((ee.getEmployeeLoan()*0.14+ee.getEmployeeLoan())/9);
			ee.setEmployeeEmi(emi);
			System.out.println("Loan: "+"Rs"+empLoan);
			System.out.println("Emi: "+"Rs"+emi);
		}
		else if(ee.getEmployeeExp()>2 && ee.getEmployeeExp()<=5 && ee.getEmployeeSlary()>=300000 && ee.getEmployeeSlary()<=500000)
		{
			empLoan=(3*isalary/4);
			ee.setEmployeeLoan(empLoan);
			double emi=((ee.getEmployeeLoan()*0.14+ee.getEmployeeLoan())/9);
			ee.setEmployeeEmi(emi);
			System.out.println("Loan: "+"Rs"+empLoan);
			System.out.println("Emi: "+"Rs"+emi);

		}
		
		else
		{
			System.out.println("Not Eligible For Loan");
			
		}
	}

		String query="update employee set employeeLoan=?,employeeEmi=? where employeeId=?";

		try 
		{
			statement=connection.prepareStatement(query);
			statement.setDouble(1, ee.getEmployeeLoan());
			statement.setDouble(2,ee.getEmployeeEmi());
			statement.setInt(3, employeeid);
			int x=statement.executeUpdate();
			System.out.println("Updated Rows="+x);	
		}
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
	}


/*	public ArrayList<Employee> search()
{
	ArrayList<Employee> listOfEmployee=new ArrayList<Employee>();
	
	Employee employeeRef=null;
	
	String query="select * from employee";
	
	try
	{
		statement=connection.prepareStatement(query);
		resultSet=statement.executeQuery();
		
		while(resultSet.next())
		{
			employeeRef=new Employee();
			employeeRef.setEmployeeId(resultSet.getInt(1));
			employeeRef.setEmployeeName(resultSet.getString(2));
			employeeRef.setEmployeeSlary(resultSet.getDouble(3));
			listOfEmployee.add(employeeRef);
		}
	}
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listOfEmployee;
}*/

	public ArrayList<Employee> search(int employeeId)
	{
		ArrayList<Employee> listOfEmployee=new ArrayList<Employee>();
		
		Employee employeeRef=null;
		
		String query="select * from employee where employeeId=?";
		
		try 
		{
			statement=connection.prepareStatement(query);
			
			statement.setInt(1, employeeId);
			
			resultSet=statement.executeQuery();
			
			while(resultSet.next())
			{
				employeeRef=new Employee();
				employeeRef.setEmployeeId(resultSet.getInt(1));
				employeeRef.setEmployeeName(resultSet.getString(2));
				employeeRef.setEmployeeSlary(resultSet.getDouble(3));
				employeeRef.setEmployeeLoc(resultSet.getString(4));
				employeeRef.setEmployeeExp(resultSet.getDouble(5));
				employeeRef.setEmployeeLoan(resultSet.getDouble(6));
				employeeRef.setEmployeeEmi(resultSet.getDouble(7));

				
				
				listOfEmployee.add(employeeRef);
			}
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOfEmployee;
	}
	
}

