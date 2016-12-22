import java.util.*;



public class Test 
{
	static Scanner sc=new Scanner(System.in);
	
	static ArrayList<Emp> a=new ArrayList<Emp>();
	

	public void insert()
	{
		System.out.println("Enter Emp Id,Name,Salary & Experience");
		a.add(new Emp(sc.nextInt(),sc.next(),sc.nextDouble(),sc.nextLong()));
	}
	
	
	public void delete()
	{
		System.out.println("Enter Id to Delete:");
		
		int tempid=sc.nextInt();
		
		Iterator<Emp> it=a.iterator();
		
		while(it.hasNext())
		{
			Emp ee=(Emp)it.next();
		
			if((ee.eid)==(tempid))
			{
				it.remove();
				
			}
		}
		
		for(Emp ee:a)
		{
			System.out.println(ee.eid+"----"+ee.ename);
		}
		System.out.println("Present Size of the Array:"+ a.size());
	}
	
	public void update()
	
	{
		System.out.println("Enter id to Update:");
		int tempid=sc.nextInt();

		Iterator<Emp> li = a.iterator();
	
		while(li.hasNext())
		{
			Emp ee=(Emp)li.next();
			
			if((ee.eid)==(tempid))
			{
				int m=a.indexOf(ee);
				System.out.println("Enter Name, Salary  to Update:");
				ee=new Emp(tempid,sc.next(),sc.nextDouble());
				a.set(m,ee);
		
				System.out.println("Updated Succesfully");	
				
			}
			
		}
		
		System.out.println("Present Size of the Array----->"+ a.size());
	}
	
	public void loan() throws Exception
	{
		
		System.out.println("enter Emp Id For Loan");
		int tempid=sc.nextInt();
		
		
			Iterator<Emp> it=a.iterator();
			
			while(it.hasNext())
			{
				
			Emp emp1=(Emp)it.next();
			
			if(emp1.eid==tempid)
			{
			
			int index=a.indexOf(emp1);
			
			if(emp1.exp>=2&&emp1.exp<=3&&emp1.esal>=240000&&emp1.esal<=300000)
			{
			
				double loan=emp1.esal/2;
				
				//System.out.println("the loan will be" +loan);
				
				float emi=(float) ((loan*14)/(9*100));
				//System.out.println("Emi : "+emi);
				
				emp1=new Emp(tempid,emp1.ename,emp1.esal,loan,emi);
				
				a.set(index,emp1);
				
			}
			else if(emp1.exp>=3&&emp1.esal>=300000)
			{
			
				double loan=(3*emp1.esal)/4;
				System.out.println("the loan will be" +loan);
				int emi=(int)(loan*14)/(9*100);
				
				
				emp1=new Emp(tempid,emp1.ename,loan,emi);
				a.set(index,emp1);
				
			}
			else
			{
				System.out.println("Not Eligible For loan");
			}
		}
		
	}	 
		
		for(Emp a1:a)
			{
				System.out.println(a1.eid+"----"+a1.ename+"-----"+a1.esal+"----"+a1.loan+"----"+a1.emi);
			}
	}
	
	public void view()
	{
		System.out.println("Enter Emp Id To View:");
		
		int tempid=sc.nextInt();
		
		for(Emp ee:a)
		{
			if(ee.eid!=1)
			{
			if(ee.eid==tempid)
			{
			System.out.println(ee.eid+"----"+ee.ename+"-----"+ee.esal+"-----"+ee.loan+"-----"+ee.emi);
			}
			else
			{
			System.out.println("emp not details available to display");
			}
		}
	}
}
	public static void main(String[] args) throws Exception 
	{
		
		Test t=new Test();
		while(true)
		{
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Your Choice:");
		System.out.println("1.Insert Emp Details");
		System.out.println("2.Update Emp Details");
		System.out.println("3.Delete Emp Details");
		System.out.println("4.Apply For Loan");
		//System.out.println("5.Emi");
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
