package inner.dhatri;

 class StaticOuter 
{
	int x,y;
	static float f1,f2;
public int funtionOne(int x,int y)
{
	this.x=x+y;
	this.y=x*y;
	return this.x+this.y;
}
static class Inner
{
	int x;
	StaticOuter so=new StaticOuter();
	public float functionTwo(int x)
	{
	this.x=x+so.funtionOne(2,3);
	f1=so.x;
	f2=f1+1.0f;
	return f1+f2;
	}
	static float pi=3.14f;
}
	public static void main(String[] args)
	{
		StaticOuter sm=new StaticOuter();
		StaticOuter.Inner si=StaticOuter.new Inner();
		float f1=si.functionTwo(50);
		System.out.println(f1);
		System.out.println(sm.f1);
		System.out.println(f2);
		System.out.println(si.x);
		System.out.println(sm.y);
		System.out.println(si.pi);
	}
}
