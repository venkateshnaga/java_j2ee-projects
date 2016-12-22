import java.util.*;

// Collections Using Contains() ,ContainsAll()

public class Test5arraylist 
{
	public static void main(String[] args) 
	{
		Emp e1=new Emp(111,"naga");
		Emp e2=new Emp(111,"venkatesh");
		Emp e3=new Emp(111,"venky");
		Emp e4=new Emp(111,"hhh");
		
		ArrayList<Emp>a1=new ArrayList<Emp>();
		a1.add(e1);
		a1.add(e2);
		
		ArrayList<Emp> a2=new ArrayList<Emp>();
		a2.addAll(a1);
		a2.add(e3);
		a2.add(e4);
		
		System.out.println(a2.contains(e1));
		System.out.println(a2.containsAll(a1));
		
		a2.remove(e1);
		
		System.out.println(a2.contains(e1));
		System.out.println(a2.containsAll(a1));
		
		for(Emp e:a2)
		{
			System.out.println(e.eid+"----"+e.ename);
		}
	}

}
