package employesr.dhatri;



import java.util.*;
import java.io.*;


public class Test implements Serializable
{
	
static
{
	System.out.println("Enter Number of Employees to Insert");
}
	static Scanner s1=new Scanner(System.in);
	static int size=s1.nextInt();
	
	static Employesr[] empArray=new Employesr[size];
	
	public void insert()throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Employesr empBean;
		for(int i=0;i<=empArray.length-1;i++)
		{
		empBean=new Employesr();
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
		serialization();
		
		for(int i=0;i<=empArray.length-1;i++)
		{
			Employesr emp=(Employesr)empArray[i];
			/*System.out.println(i+1 +" Emp details");
			System.out.println("Id = "+ emp.getId());
			System.out.println("Name = " +emp.getName());*/
			
		}
	}
	
	public void serialization()throws Exception
			{
		
		
				FileOutputStream fos=new FileOutputStream(new File ("D:/emp21.txt"));
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				try{
				oos.writeObject(empArray);
				}
				catch(Exception e)
				{
					System.out.println("hello");
				}
			}
		
			
	public  void deserialization()throws Exception
	{
		
		FileInputStream fis=new FileInputStream("D:/emp21.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Object obj=ois.readObject();
	
		Employesr[] emp12=(Employesr[])obj;
		
		System.out.println("after deserialization");
		for(int i=0;i<=empArray.length-1;i++)
		{
			if(empArray[i]!=null)
			{
			
			Employesr emp3=(Employesr)emp12[i];
			
			System.out.println(i+1 +" Emp details");
			System.out.println("Id = "+ emp3.getId());
			System.out.println("Name = " +emp3.getName());
			System.out.println("Id = "+ emp3.getLocation());
			System.out.println("Name = " +emp3.getSalary());
			System.out.println("Id = "+ emp3.getExp());
			}
		}
		
	}
	
	public void update()throws Exception
	{
		System.out.println("Enter the Employee Id to Update");
		Scanner sc1=new Scanner(System.in);
		int tempId=sc1.nextInt();
		for(int i=0;i<=empArray.length-1;i++)
		{
			Employesr emp=(Employesr)empArray[i];
			if(empArray[i]!=null)
			{
			if(tempId==emp.getId())
			{
				System.out.println("Enter the Name to Update of Emp Id: "+tempId);
				emp.setName(s1.next());
				System.out.println("Enter the Location to Update of Emp Id:"+tempId);
				emp.setLocation(s1.next());
				empArray[i]=emp;
			}
		}
			throw new MyException();
	}
		serialization();
		System.out.println("After update");
		deserialization();
	}
	public void delete()throws Exception
	{
		System.out.println("Enter the Emp Id to Delete");
		Scanner sc2=new Scanner(System.in);
		int tempId=sc2.nextInt();
		for(int i=0;i<=empArray.length-1;i++)
		{
			if(empArray[i]==null)
			{
				throw new NullException();
			}
			Employesr emp=(Employesr)empArray[i];
			if(tempId==emp.getId())
			{
	
				empArray[i]=null;
			}
		}
		serialization();
	System.out.println("Employee "+tempId + " Deleted");
	deserialization();
	
	
}

	public void loan()throws Exception
	{
		System.out.println("Enter the Employee Id");
		Scanner sc3=new Scanner(System.in);
		int tempId=sc3.nextInt();
		for(int i=0;i<=empArray.length-1;i++)
		{
			if(empArray[i]==null)
			{
				throw new NullException();
			}
			Employesr emp=(Employesr)empArray[i];
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
	public void emi() throws Exception
	{
		System.out.println("Enter the EMP Id to Know EMI");
		Scanner sc4=new Scanner(System.in);
		int tempId=sc4.nextInt();
		for(int i=0;i<=empArray.length-1;i++)
		{
			if(empArray[i]==null)
			{
				throw new NullException();
			}
			Employesr emp=(Employesr)empArray[i];
			if(tempId==emp.getId())
			{
			double em=((emp.getLoan()*0.14+emp.getLoan())/9);
			emp.setEmi(em);
			System.out.println("emi of " +tempId + " " +emp.getEmi());
			}
			
		}
	}
	
	public void view() throws Exception
	{
		System.out.println("Enter the Employee Id to View Details");
		Scanner sc2=new Scanner(System.in);
		int tempId=sc2.nextInt();
		for(int i=0;i<=empArray.length-1;i++)
		{
			if(empArray[i]!=null)
			{
				
			Employesr emp=(Employesr)empArray[i];
			
				if(tempId==emp.getId())
				{
					System.out.println(i+1 +" Emp details");
					System.out.println("Id = "+ emp.getId());
					System.out.println("Name = " +emp.getName());
					System.out.println("Id = "+ emp.getLocation());
					System.out.println("Name = " +emp.getSalary());
					System.out.println("Id = "+ emp.getExp());
			}
			
		}
			else{System.out.println("no details");}
	}
}
		

		
	public static void main(String[] args) throws Exception
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
		System.out.println("7.Desrialization");
		System.out.println("8.Exit");
		
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
					t.deserialization();
					break;
			
				case 8:
					System.out.println("Thank You");
					System.exit(0);
					break;
			
				default:
					//System.out.println("Bye");
			}
		
		}

	}		
}


