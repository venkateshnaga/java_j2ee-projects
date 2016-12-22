class A
{
void m1(){}
void m2(){}
}
class AnonymousInner
{
	A a=new A()
	{
		void m1()
		{
			System.out.println("hello");
		}
		void m2()
		{
			System.out.println("hai");
		}
	};
		public static void main(String[] args)
		{
		AnonymousInner i=new AnonymousInner();
		i.a.m1();
		i.a.m2();
	}
}
