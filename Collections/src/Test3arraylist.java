import java.util.*;

//Basic Operations on ArrayList

public class Test3arraylist 

{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) 
	{
	
		ArrayList a=new ArrayList();
		a.add("A");
		a.add("B");
		a.add('a');
		a.add(190);
		a.add(null);
		System.out.println(a);
		System.out.println("ArrayList Size---->"+a.size());
		a.add(1,"A1");
		System.out.println("After adding ArrayList Size---->"+a.size());
		System.out.println(a);
		a.remove(1);
		a.remove("A");
		System.out.println("After Removing elements,ArrayList Size---->"+a.size());
		System.out.println(a);
		a.set(2,"Venkatesh");
		System.out.println(a);
		System.out.println(a.isEmpty());
		a.clear();
		System.out.println(a.isEmpty());
	}

}
