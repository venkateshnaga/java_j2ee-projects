class ThreadDemo
{
	public static void main(String[] args) 
	{
		new Thread()
		{
			public void run()
			{
			System.out.println("thread 1");
			}
		}.start();
		
		new Thread()
		{	
			public void run()
			{
			System.out.println("thread 2");		
			}
		}.start();
	
		System.out.println("main thread");
	}
}
