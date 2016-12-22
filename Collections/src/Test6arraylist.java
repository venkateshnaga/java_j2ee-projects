import java.util.*;


//Using Iterator(Normal & Generic Versions),Remove() using Iterator

public class Test6arraylist 
{
	public static void main(String[] args) 
	{
		ArrayList<String> a= new ArrayList<String>();
		a.add("ratan");
		a.add("anu");
		a.add("durga");
		System.out.println(a.toString());
		
		//By Using For Each
		for(String s:a)
		{
			System.out.println(s);
		}
		
		//By Using Iterator Normal Version
		
		Iterator iterator=a.iterator();
		while(iterator.hasNext())
		{
			String s=(String)iterator.next();
			System.out.println(s);
		}
		
		//By Using Iterator Generic version
		Iterator<String> it1=a.iterator();
		while(it1.hasNext()){
			String s=it1.next();
			System.out.println(s);
		}
		
		//By using get()
		String s =a.get(1);
		System.out.println(s);
		
	//Remove Data By Using Iterator
		Iterator<String> it2=a.iterator();
		while(it2.hasNext())
		{
			String ss=it2.next();
			if(ss.equals("ratan"))
			{
				it2.remove();
			}
			
		}
		System.out.println(a.toString());
	}
	

}
