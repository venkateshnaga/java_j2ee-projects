import java.util.*;

//ListIterator Printing forward and Backward Direction & Using Remove(),Replacement(set()) methods

public class Test7arraylist 
{

	public static void main(String[] args) 
	{
		ArrayList<String> a= new ArrayList<String>();
		a.add("ratan");
		a.add("anu");
		a.add("durga");
//		System.out.println(a.toString());
		
//By Using Iterator Generic version
		ListIterator<String> lii=a.listIterator();
		
		while(lii.hasNext())
		{
			String s=lii.next();
			System.out.println(s);
		
		}
		
		ListIterator<String> li1=a.listIterator();
		
		while(lii.hasPrevious())
		{
			String ss=lii.previous();
			
			System.out.println(ss);
		}

		ListIterator<String> li2=a.listIterator();
		while(li2.hasNext())
		{
			String ss=li2.next();
			if(ss.equals("ratan"))
			
				li2.remove();
			
			if(ss.equals("anu"))
				
				li2.set(("naga"));
			
			
		}
		System.out.println(a.toString());
	}

}




































