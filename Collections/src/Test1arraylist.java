import java.util.*;

//Using instanceof

public class Test1arraylist 
{
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		ArrayList a=new ArrayList();
		a.add(10);
		a.add(new Emp(111,"naga"));
		a.add(new Student(222,"venkatesh"));
		a.add(null);
		System.out.println(a.toString());	//Output:[10, Emp@15db9742, Student@6d06d69c, null]

		/* Possible to print the data in two types
		 * 1.Override toString() 
		 * 2.Check the type of the object
		 */
		
		for(Object oo:a)
		{
			if(oo instanceof Emp)
			{
				Emp e=(Emp)oo;
				System.out.println(e.eid+"-----"+e.ename);
			}
			if(oo instanceof Student)
			{
				Student s=(Student)oo;
				System.out.println(s.sid+"----"+s.sname);
			}
			if(oo instanceof Integer)
			{
				System.out.println(oo);
			
			}
			
			if(oo==null)
			{
				System.out.println(oo);
			}
			
			
		}
		
	}

}
