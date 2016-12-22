package employee.dhatri1;


import java.util.*;

public class Test 
{
	
static
{
	System.out.println("Enter Number of Employees to Insert");
}
static Scanner s1=new Scanner(System.in);
	static int size=s1.nextInt();
	
	static Employee[] empArray=new Employee[size];
	
	public void insert()
	{
		Scanner sc=new Scanner(System.in);
		Employee empBean;
		for(int i=0;i<=empArray.length-1;i++)
		{
		empBean=new Employee();
		System.out.println("Enter Employee Id");
		empBean.setId(sc.nextInt());
		System.out.println("Enter Employee Name");
		empBean.setName(sc.next());
		System.out.println("Enter Location");
		empBean.setLocation(sc.next());
		System.out.println("Enter Salary");
		empBean.setSalary(sc.nextDouble());
		System.out.println("Enter Exp");
		empBean.setExp(sc.nextDouble());
		empArray[i]=empBean;
		}
		
		for(int i=0;i<=empArray.length-1;i++)
		{
			Employee emp=(Employee)empArray[i];
			System.out.println(i+1 +" Emp details");
			System.out.println("Id = "+ emp.getId());
			System.out.println("Name = " +emp.getName());
			
		}
	
	}
	public void update()
	{
		System.out.println("Enter the Employee Id to Update");
		Scanner sc1=new Scanner(System.in);
		int tempId=sc1.nextInt();
		for(int i=0;i<=empArray.length-1;i++)
		{
			Employee emp=(Employee)empArray[i];
			if(tempId==emp.getId())
			{
				System.out.println("Enter the Name to Update of Emp Id: "+tempId);
				emp.setName(s1.next());
				System.out.println("Enter the Location to Update of Emp Id:"+tempId);
				emp.setLocation(s1.next());
				empArray[i]=emp;
				
			}
			
		}
		System.out.println("After update");
		for(int i=0;i<=empArray.length-1;i++)
		{
			
			Employee emp=(Employee)empArray[i];
			System.out.println(i+1 +" Emp details");
			System.out.println("Id = "+ emp.getId());
			System.out.println("Name = " +emp.getName());
			System.out.println("Location= " +emp.getLocation());
			
		}	
	}
	public void delete()throws NullPointerException
	{
	System.out.println("Enter the Emp Id to Delete");
	Scanner sc2=new Scanner(System.in);
	int tempId=sc2.nextInt();
	for(int i=0;i<=empArray.length-1;i++)
	{
		Employee emp=(Employee)empArray[i];
		if(tempId==emp.getId())
		{
	
			empArray[i]=null;
		}
	}

	System.out.println("Employee "+tempId + " Deleted");
	
	/*for(int i=0;i<=empArray.length-1;i++)
	{
		
		Employee emp=(Employee)empArray[i];
		System.out.println(i+1 +" Emp details");
		System.out.println("Id = "+ emp.getId());
		System.out.println("Name = " +emp.getName());
		
	}*/
	
		
}

	public void loan()
	{
		System.out.println("Enter the Employee Id");
		Scanner sc3=new Scanner(System.in);
		int tempId=sc3.nextInt();
		for(int i=0;i<=empArray.length-1;i++)
		{
			Employee emp=(Employee)empArray[i];
			if(tempId==emp.getId())
			{
			 if(emp.getExp()<=2 &&emp.getExp()>1 && emp.getSalary()<=240000)
			
			{
				System.out.println("Your Are Eligible To Get Loan ");
				System.out.println("You Can Get Loan Amount Of :"+emp.getSalary()/2);
				emp.setLoan(emp.getSalary()/2);
				//System.out.println("Loan = " +emp.getLoan());
				
			}
			else if(emp.getExp()>2 &&emp.getExp()<5 && emp.getSalary()>=300000 && emp.getSalary()<=500000)
			{
				System.out.println("Your Are Eligible To Get Loan");
				System.out.println("You Can Get Loan Amount Of : "+ 3*emp.getSalary()/4);
				emp.setLoan(3*emp.getSalary()/4);
				//System.out.println("Loan = " +emp.getLoan());
			}
			else
			{
			System.out.println("You Are Not Eligible for loan");	
			}
		}
	}
}
	public void emi()
	{
		System.out.println("Enter the EMP Id to Know EMI");
		Scanner sc4=new Scanner(System.in);
		int tempId=sc4.nextInt();
		for(int i=0;i<=empArray.length-1;i++)
		{
			Employee emp=(Employee)empArray[i];
			if(tempId==emp.getId())
			{
			double em=emp.getLoan()*14/900;
			emp.setEmi(em);
			System.out.println("emi of " +tempId + " " +emp.getEmi());
			}
			
		}
	}
	public void view()
	{
		
		System.out.println("Enter the Employee Id to View Details");
		Scanner sc5=new Scanner(System.in);
		int tempId=sc5.nextInt();
		for(int i=0;i<=empArray.length-1;i++)
		{
			Employee emp=(Employee)empArray[i];
			if(tempId==emp.getId())
			{
				System.out.println(i+1 +" Emp details");
				System.out.println("Id = "+ emp.getId());
				System.out.println("Name = " +emp.getName());
				System.out.println("Location = " +emp.getLocation());
				System.out.println("Annual Package = " +emp.getSalary());
				System.out.println("Take Home(PM)=" +(emp.getSalary()/12-emp.getEmi()));
			}
			
		}
		
	}
		
	public static void main(String[] args) 
	{
		Test t= new Test();
		while(true)
		{
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Your Choice");
		System.out.println("1.Enter Emp Details");
		System.out.println("2.Update Emp Details");
		System.out.println("3.Delete Emp Details");
		System.out.println("4.Apply For Loan");
		System.out.println("5.Emi");
		System.out.println("6.View");
		System.out.println("7.Exit");
		switch(sc1.nextInt())
		{
		case 1:
			t.insert();
			
			break;
		case 2:
			t.update();
			
			break;
		case 3:
			t.delete();
			break;
		case 4:
			t.loan();
			break;
		case 5:
			t.emi();
			break;
		case 6:
			t.view();
			break;
		case 7:
			System.out.println("Thank You");
			System.exit(0);
			break;
			default:
				//System.out.println("Bye");
		}
		
	}

	}

		
}


