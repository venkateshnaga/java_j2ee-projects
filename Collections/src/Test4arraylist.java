import java.util.*;

// Collections Using addAll()

public class Test4arraylist
	{

	public static void main(String[] args)
	{
	
		ArrayList<Emp>a = new ArrayList<Emp>();
		a.add(new Emp(111,"naga"));
		a.add(new Emp(222,"Venkatesh"));
		
		ArrayList<Emp> a1 = new ArrayList<Emp>(a);
		 //a1.addAll(a);
		a1.add(new Emp(333,"naga"));
		a1.add(new Emp(444,"Venkatesh"));
		for(Emp e:a1)
		{
			System.out.println(e.eid+"-----"+e.ename);
		}
		

	}

}
