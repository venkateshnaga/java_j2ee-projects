package cricketup.dhatri;

import java.util.*;

class OversException extends Exception
{
	public String toString()
	{
	return "Overs limit is exceeded";
}
	
}

class Cricketup
{

	static	Scanner sc=new Scanner(System.in);

	public void weather(String team1, String team2,int ss)throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Weather Condition");
		System.out.println("Weather it is Rainy(1.Yes/2.No):");
		int weather=sc.nextInt();
		if(weather==1)
		{
			System.out.println("match Delayed due to rain");
			System.out.println("after 2 hrs:");
			overs40(team1,team2,ss);
			
		}
		else
		{
			overs50(team1,team2, ss);
		}
	}
	public void overs50(String team1,String team2,int ss) throws OversException
	{
		System.out.println("50-50 Overs Match");
		System.out.println(team1+" won the Toss & Elected to Bat First");
		System.out.println("Enter The Overs Played By "+team1);
		float overs1=sc.nextFloat();
		if(overs1>50)
		{
			throw new OversException();
		}
		else
		{
			fi(team1,team2,overs1);
		}
		System.out.println("Enter The Overs Played By "+team2);
		float overs2=sc.nextFloat();
		if(overs2>50)
		{
			throw new OversException();
		}
		else
		{
			secondi(team1,team2,ss);
		}
	}
	public void overs40(String team1,String team2,int ss)throws OversException
	{
		
		System.out.println("Weather Condition");
		System.out.println("Weather it is Rainy(1.Yes/2.No):");
		int weather=sc.nextInt();
		if(weather==1)
		{
			System.out.println("match Delayed due to rain");
			System.out.println("after 1 hrs:");
			overs20(team1,team2,ss);
			
		}
		else
		{
			//overs40(team1,team2);
			System.out.println("Match reduced To 40-Overs");
			System.out.println(team1+" won the Toss & Elected to Bat First");
			System.out.println("Enter The Overs Played By "+team1);
			float overs1=sc.nextFloat();
			if(overs1>40)
			{
				throw new OversException();
			}
			else
			{
				fi(team1,team2,overs1);
			}
			
		}
		System.out.println("Enter The Overs Played By "+team2);
		float overs2=sc.nextFloat();
		if(overs2>40)
		{
			throw new OversException();
		}
		else
		{
			secondi(team1,team2,ss);
		}
		
	}
	public void overs20(String team1,String team2,int ss) throws OversException
	{
		System.out.println("Match reduced To 20-Overs");
		System.out.println(team1+" won the Toss & Elected to Bat First");
		
		System.out.println("Enter The Overs Played By "+team1);
		float overs1=sc.nextFloat();
		if(overs1>20)
		{
			throw new OversException();
		}
		else
		{
			fi(team1,team2,overs1);
		}
		
		System.out.println("Enter The Overs Played By "+team2);
		float overs2=sc.nextFloat();
		if(overs2>20)
		{
			throw new OversException();
		}
		else
		{
			secondi(team1,team2,ss);
		}
		
		
	}
	
	public void fi(String team1, String team2, float overs1) throws OversException
	{
		Cricketup cr1=new Cricketup();
		
		System.out.println("");
		
		//1st Innings
		System.out.println("1st Innings");
		
		System.out.println("Enter The RunRate of "+team1);
		float runrate1=sc.nextFloat();
		
		int ss=(int)cr1.score(overs1,runrate1);
		int tota=cr1.total(runrate1,ss,team1,overs1);
		System.out.println();
	}
	
		public void secondi(String team1, String team2, int ss)throws OversException
		{
			Cricketup cr1=new Cricketup();
			
		//2nd Innings
		System.out.println("2nd Innings");
		System.out.println("");
		System.out.println("Enter The Overs Played By "+team2);
		float overs2=sc.nextFloat();
		
		System.out.println("Enter The RunRate of "+team2);
		float runrate2=sc.nextFloat();
		int ss1=(int)cr1.score1(overs2,runrate2);
		//int total1=cr.total(runrate2,ss1,team2);
		cr1.result(ss, ss1,team2,team1);
	}
		
	public float score(float overs1, float runrate1)
	{
	 float score=overs1*runrate1;
		return  score;
	}
	
	public int total(float runrate1, int ss, String team1, float overs1)
	{
		if(overs1==55)
		{
			System.out.println("Overs Exceded");
		}
		else if(runrate1>=6 && overs1==50)//success
		{
			System.out.println(team1+" Total Score "+ss+"/7");
		}
		else if(runrate1<6 && overs1==50)//success
		{
			System.out.println(team1+" Total Score "+ss+"/9");
			
		}
		else if(runrate1>=6 && overs1<50)//success
		{
			System.out.println(team1+" Total Score "+ss+"/10");
		}
		else if(runrate1<6 && overs1<50)
		{
			System.out.println(team1+" Total Score "+ss+"/10");
		}
		else
		{
			System.out.println("invalid");
		}
		return ss;
	}
	 
	public float score1(float overs2, float runrate2)
	{
	 float score1=overs2*runrate2;
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
	public void result(int ss, int ss1,String team2,String team1)
	{
		int won;
		if(ss>ss1)
		{
			won=ss-ss1;
			System.out.println(team2+" Scored "+ss1);
			System.out.println( team1+" Won By"+won);
		}	
		else if(ss==ss1)
		{
			System.out.println(team2+" Scored "+ss1+"/7");
			System.out.println("Match Tie");
			
		}
		else{
			System.out.println(team2+" Won By 3 wickets");
		}
	}
	public static void main(String[] args) throws Exception
	{
		Cricketup cr=new Cricketup();
		System.out.println("Welcome To 50 Overs ODI Match");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Team One Name");
		String team1=sc.next();
		
		System.out.println("Enter The Team Two Name");
		String team2=sc.next();
		int ss=0;
		cr.weather(team1,team2,ss);
		
	
		
		/*System.out.println("");
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
		int tota=cr.total(runrate1,ss,team1,overs1);
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
		cr.result(ss, ss1,team2,team1);*/
}
}