package inner.dhatri;

public class NonStatic 
{

	int x,y;
	static float f1,f2;
public int funtionOne(int x,int y)
{
	this.x=x+y;
	this.y=x*y;
	return this.x+this.y;
}
class Inner
{
	int x;
	public float functionTwo(int x)
	{
	this.x=x+funtionOne(2,3);
	f1=this.x;
	f2=f1+1.0f;
	return f1+f2;
	}
}
public static void main(String[] args)
{
	NonStatic o=new NonStatic();
	NonStatic.Inner i=o.new Inner();
	float f1=i.functionTwo(5);
	System.out.println(f1);
	System.out.println(NonStatic.f1);
	System.out.println(NonStatic.f2);
	System.out.println(o.x);
	System.out.println(o.y);
}
}
