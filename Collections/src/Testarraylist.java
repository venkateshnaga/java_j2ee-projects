import java.util.ArrayList;

public class Testarraylist 

{
	@SuppressWarnings({ "rawtypes", "unchecked" })

	public static void main(String... args)
	{
		//Upto 1.4 version
		ArrayList a1=new ArrayList();
		a1.add(new Integer(10));
		a1.add(new Character('a'));
		a1.add(new Double(30.5));
		a1.add(new Double(30.5));
		a1.add(null);
		System.out.println(a1.toString());
		
		//1.5 version   auto-boxing   Primitive----->Wrapper
		ArrayList a=new ArrayList();
		a.add(10);
		a.add(30.5);
		a.add('a');
		a.add(30.5);
		a.add(null);
		System.out.println(a.toString());
		
	}
	

}
