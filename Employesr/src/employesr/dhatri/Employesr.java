package employesr.dhatri;

import java.io.*;
class NullException extends Exception
{
	public String toString()
	{
		return "No Employees";
	}
}
class MyException extends NullException
	{
		public String toString()
		{
			return "No employee to update";
		}
	}	
public class Employesr implements Serializable
{
	private int id;
	private String name;
	private String location;
	private double salary;
	private double loan;
	private double exp;
	private double emi;
	private double monthly;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getLoan() {
		return loan;
	}
	public void setLoan(double loan) {
		this.loan = loan;
	}
	public double getExp() {
		return exp;
	}
	public void setExp(double d) {
		this.exp = d;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public double getMonthly() {
		return monthly;
	}
	public void setMonthly(double monthly) {
		this.monthly = monthly;
	}
	public String toString() {
        return "Emp Id  : " + this.id +"\nEmp Name: " + this.name + " ";
    }
	
}
