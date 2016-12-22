public class Emp 
{
int eid;
String ename;
double esal;
long exp;
double loan;
float emi;

//Constructor For Employee Insertion
Emp(int eid, String ename, double esal, long exp)
{
	this.eid=eid;
	this.ename=ename;
	this.esal=esal;
	this.exp=exp;
}

//Constructor to Update
Emp(int eid, String ename, double esal)
{
	this.eid=eid;
	this.ename=ename;
	this.esal=esal;
	
}

// Constructor For Loan & EMI
Emp(int eid,String ename,double esal,double loan,float emi)
{
	this.eid=eid;
	this.ename=ename;
	this.esal=esal;
	this.loan=loan;
	this.emi=emi;
}

}
