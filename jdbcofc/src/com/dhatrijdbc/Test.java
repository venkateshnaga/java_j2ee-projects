package com.dhatrijdbc;
import java.util.*;

public class Test 
{

	public static void main(String[] args)
	{
	
		Scanner input=new Scanner(System.in);
		DataBaseOperations dbo=new DataBaseOperations();
		
		while(true)
		{
		System.out.println("Enter Your Choice:");
		System.out.println("1.Insert Employee Details");
		System.out.println("2.Update Employee Details");
		System.out.println("3.Delete Employee Details");
		System.out.println("4.Apply For Loan");
		System.out.println("5.View Employee Details");
		System.out.println("6.Exit");

		switch(input.nextInt())
			{
			
				case 1:
					Employee employeeBean=new Employee();
					
					System.out.println("Enter Employee Id");
					employeeBean.setEmployeeId(input.nextInt());
					System.out.println("Enter Employee Name");
					employeeBean.setEmployeeName(input.next());
					System.out.println("Enter Employee Salary");
					employeeBean.setEmployeeSlary(input.nextDouble());
					System.out.println("Enter Employee Location");
					employeeBean.setEmployeeLoc(input.next());
					System.out.println("Enter Employee Exp");
					employeeBean.setEmployeeExp(input.nextDouble());							
					
					//int result=dbo.insertData(employeeBean);		
					int result=dbo.insertDataUsingPrepared(employeeBean);
					System.out.println(result+ " Data Inserted");
					break;
			
					
				case 2:
					System.out.println("Enter Employee Id to Update");
					int empID=input.nextInt();
					System.out.println("Enter Employee Name to Update");
					String empName=input.next();
					System.out.println("Enter Employee Salary to Update");
					double empSal=input.nextDouble();
					System.out.println("Enter Employee Location to Update");
					String empLoc=input.next();
					System.out.println("Enter Employee Experience to Update");
					double empExp=input.nextDouble();
					double empLoan=0;
					double empEmi=0;
					
					dbo.update(empName,empSal,empLoc,empExp,empLoan,empEmi,empID);
					break;
			
					
				case 3:
						System.out.println("Enter Employee Id To Delete");
						int empId=input.nextInt();
						dbo.delete(empId);
						break;
			
				case 4:
						System.out.println("Enter Employee Id To Apply For Loan");
						int employeeid=input.nextInt();
						dbo.loan(employeeid);
						break;
					
				case 5:
						System.out.println("Enter Employee Id To View");
						int employeeId=input.nextInt();
					
						ArrayList<Employee> listOfEmp=  dbo.search(employeeId);
					
						Iterator<Employee> itr=listOfEmp.iterator();
					  
						System.out.println("Id \t Name \t Salary \t Location \t Exp \t Loan \t Emi");
						
						while(itr.hasNext())
						{
							Employee emp=(Employee)itr.next();
						  
							System.out.println(emp.getEmployeeId()+"\t"+emp.getEmployeeName()+"\t"+emp.getEmployeeSlary()+"\t"+emp.getEmployeeLoc()+"\t"+emp.getEmployeeExp()+"\t"+emp.getEmployeeLoan()+"\t"+emp.getEmployeeEmi()+"\t");
						}
						break;
			
				case 6:
						System.out.println("Thank You");
						input.close();
						System.exit(0);
						
						break;
			
				default:
					//System.out.println("Bye");
			}
		}
	}
}