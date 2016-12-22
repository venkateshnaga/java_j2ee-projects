import java.util.*;

class OversException extends Exception
{
	public String toString()
	{
	return "Overs limit is exceeded";
}
}

class Cricket
{
    float overs1, runrate1,score1, score;
	public float score(float overs1, float runrate1)
	{
	 score=overs1*runrate1;
		return  score;
	}
	
	public int total(float runrate1, int ss, String team1)
	{
		if(runrate1>6)
		{
			System.out.println(team1+" Total Score "+ss +"/7");
		}
		else
		{
			System.out.println(team1+" Total Score "+ss+"/9");
		}
		return ss;
	}
	 
	public float score1(float overs2, float runrate2)
	{
	    score1=overs2*runrate2;
		return  score1;
	}
	
	/*public int total1(float runrate2, int ss1, String team2)
	{
		if(runrate2>6)
		{
			System.out.println(team2+" Total Score "+ss1 +"/7");
		}
		else
		{
			System.out.println(team2+" Total Score "+ss1+"/9");
		}
		return ss1;
	}*/
	public void result(int ss, int ss1,String team1,String team2)
	{
		int won;
		if(ss>ss1)
		{
			won=ss-ss1;
			System.out.println(team2+" Scored "+ss1);
			System.out.println(team1+" Won By "+won+" Runs");
		}
		else
		{
			
			System.out.println("Aus Won By 3 wickets");
		}
	}
	public static void main(String[] args) throws Exception
	{
		Cricket cr=new Cricket();
		System.out.println("Welcome To 50 Overs ODI Match");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Team One Name");
		String team1=sc.next();
		
		System.out.println("Enter The Team Two Name");
		String team2=sc.next();
		
		System.out.println("India Won the Toss & Elected To Bat First");
		System.out.println("");

		//1st Innings
		System.out.println("1st Innings");
		System.out.println("Enter The Overs Played By "+team1);
		float overs1=sc.nextFloat();
		if(overs1>50)
		{
			throw new OversException();
		}
		else
		{
			System.out.print("");
		}
		
		System.out.println("Enter The RunRate of "+team1);
		float runrate1=sc.nextFloat();
		
		int ss=(int)cr.score(overs1,runrate1);
		int total=cr.total(runrate1,ss,team1);
		System.out.println();
		
		//2nd Innings
		System.out.println("2nd Innings");
		System.out.println("");
		System.out.println("Enter The Overs Played By "+team2);
		float overs2=sc.nextFloat();
		
		System.out.println("Enter The RunRate of "+team2);
		float runrate2=sc.nextFloat();
		int ss1=(int)cr.score1(overs2,runrate2);
		//int total1=cr.total(runrate2,ss1,team2);
		cr.result(ss, ss1,team1,team2);
 }
}