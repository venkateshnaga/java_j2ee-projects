import java.util.*;

// Using Generics Concept Example


public class Test2arraylist 
	{
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) 
	
	{
		//Arrays are type safe
		int[] a={10,20,30};
		for(int aa:a)
		{
			System.out.println(aa);
		}
		
		//Collections are not type safe
		
		ArrayList a1=new ArrayList();
		a1.add(new Emp(111,"ratan"));
		a1.add(new Student(222,"venkatesh"));
		for(Object oo:a1)
		{
			if(oo instanceof Emp)
			{
			Emp e=(Emp)oo;
			System.out.println(e.eid+"-----"+e.ename);
			}
			if(oo instanceof Student)
			{
				Student s=(Student)oo;
				System.out.println(s.sid+"------"+s.sname);
			}
		}
		
		//Provide the type safe to the collections by using Generics
		
		ArrayList<Emp> a2=new ArrayList<Emp>();
		a2.add(new Emp(111,"naga"));
		a2.add(new Emp(222,"venkatesh"));
		for(Emp ee:a2)
		{
			System.out.println(ee.eid+"----"+ee.ename);
		}
			

	}

}
