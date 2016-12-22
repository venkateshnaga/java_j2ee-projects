import java.util.*;
class Employee
{
	int empId=0;
	String empName="";
	public void setValues(int eId, String eName) 
	{
		empId=eId;
		empName=eName;
	}
		public void setempId(int empId)
		{
			this.empId=empId;
	}
		public int getempId()
		{
			return empId;
		}
		public void setempName(String empName)
		{
			this.empName=empName;
		}
		public String getempName()
		{
			return empName;
		}
		public String toString() {
	        return "Emp Id  : " + this.empId +"\nEmp Name: " + this.empName + " ";
	    }
}
public class Arrayexample 
{
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> empArr=new ArrayList<Employee>();
		Employee emp1=new Employee();
		System.out.println("enter emp id & emp Name");
		emp1.setValues(sc.nextInt(),sc.next());
		empArr.add(emp1);
		
		System.out.println("enter 2nd emp id & emp Name");
		Employee emp2=new Employee();
		emp2.setValues(sc.nextInt(),sc.next());
		empArr.add(emp2);
		
		Employee emp3=new Employee();
		System.out.println("enter 3rd emp id & emp Name");
		emp3.setValues(sc.nextInt(),sc.next());
		
		//Retrieving object
		System.out.println(empArr.get(0));
		
		//updating
		empArr.get(1).setempId(100);
	
		// delete
		 empArr.remove(2);
		 System.out.println("Current array list is:"+empArr);

		
		/*Iterator<Employee> ir= empArr.iterator();
		
		Employee emp=new Employee();
		 
		System.out.println("Output using Method 1\n");
		while(ir.hasNext())
		{
		emp=(Employee)empArr.get(1);
		ir.next();
		System.out.println(i+1 +" : " + "Employee Name : "+ emp.getempName());
		System.out.println(" Employee Code : "+ emp.getempId());
		System.out.println(" Salary : "+ emp.getSalary());
		i=i+1;
		}
		int id=sc.nextInt();
		for (Employee empN : empArr)
		{
		 
		System.out.println("Employee Name : "+ empN.toString());
		 
		//System.out.println(" Employee Code : "+ empN.getempId());
		 
		}*/
	}
}
