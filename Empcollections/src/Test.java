import java.util.*;

public class Test {
	
	Scanner sc = new Scanner(System.in);

	ArrayList<EmployeeList> alemp = new ArrayList<EmployeeList>();

	public void insert() throws Exception {

		EmployeeList emp = new EmployeeList();
		System.out.println("enter employee id");
		emp.setId(sc.nextInt());

		System.out.println("enter name");
		emp.setName(sc.next());
		
		System.out.println("enter employee location");
		emp.setLocation(sc.next());

		System.out.println("enter employee experience");
		emp.setExp(sc.nextInt());

		System.out.println("enter employee sal");
		emp.setSal(sc.nextLong());

		alemp.add(emp);
		
		for (EmployeeList a:alemp)
		{
			
		System.out.println("\n"+"Emp ID:"+a.getId()+"\n"+"Emp Name:"+a.getName()+"\n"+"Emp Exp:"+a.getExp()+"\n"+"Emp Location:"+a.getLocation()+"\n"+"Emp Salary:"+a.getSal());
		
		}
	}

	public void delete() throws Exception 
	{

		System.out.println("enter id to delete");
		int tempid = sc.nextInt();

		Iterator<EmployeeList> it = alemp.iterator();
		while (it.hasNext()) {

			EmployeeList e = (EmployeeList) it.next();

			if (e.getId() == tempid)
			
			{
				
				it.remove();

				System.out.println("id is deleted");

			}

		}

	}

	public void update() throws Exception {

		System.out.println("enter employee id to update");
		int tempid = sc.nextInt();

		Iterator<EmployeeList> it = alemp.iterator();
		
		while (it.hasNext()) 
		{

			EmployeeList e = (EmployeeList) it.next();
			if (e.getId() == tempid)
			{
				int n = alemp.indexOf(e);
				System.out.println(n);
				System.out.println("enter the name to update");
				e.setName(sc.next());
				System.out.println("enter the location to update");
				e.setLocation(sc.next());
				System.out.println("enter the sal to update");
				e.setSal(sc.nextInt());
				System.out.println("enter the exp to update");
				e.setExp(sc.nextInt());

				alemp.set(n, e);

				System.out.println(e.getName());
				System.out.println(e.getExp());
				System.out.println(e.getLocation());
				System.out.println(e.getSal());

			}

		}

	}

	public void view() throws Exception 
	{
		System.out.println("enter id to view");
		int tempid = sc.nextInt();
		for(EmployeeList emp:alemp)
		{
		if (emp.getId() == tempid) 
			{
			System.out.println("Emp ID:"+emp.getId()+"\n"+"Emp Name:"+emp.getName()+"\n"+"Emp Exp:"+emp.getExp()+"\n"+"Emp Location:"+emp.getLocation()+"\n"+"Emp Salary:"+emp.getSal());
				
			}
		}
	}

	public static void main(String[] args) throws Exception 
	{

		Scanner sc = new Scanner(System.in);

		Test t = new Test();
		while (true) {

			System.out.println("\n"+"1.insert");
			System.out.println("2.update");
			System.out.println("3.delete");

			System.out.println("4.view");

			System.out.println("enter your choice");
			int s = sc.nextInt();

			switch (s) {
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
				t.view();
				break;

			}
		}
	}
}
