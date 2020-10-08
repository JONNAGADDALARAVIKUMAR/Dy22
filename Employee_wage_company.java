package Day22;

import java.util.Random;
import java.util.Scanner;

public class Employee_wage_company {
	static int hrs=0,present=0,max=0,totalPay,type,company;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		
		System.out.print("\n\n\t\t\tWelcome to Employee Wage Computation programme\n\n\tEnter Employee Name : ");
		String name = scan.nextLine();
		System.out.print("\n\n\tChoose the Employee's Company\n\n\t\t1.Tcs\n\t\t2.Wipro\n\t\t3.Infossys\n\n\tCompany : ");
		
		company = scan.nextInt();
		System.out.print("\tChoose type of Employee\n\t\t1.Full Time\n\t\t2.Part Time\n\tEnter Choice : ");
		type = scan.nextInt();
		System.out.print("\n\n*********************************************************************************************\n\n\tName : "+name+"\n\n\tCompany : ");
		
		if(company==1)
		{
			System.out.println("Tata Consultency Services");

			Tcs tcs = new Tcs();
			switch(type)
			{
			case 1:
				tcs.fullTime();
				break;
		
			case 2:
				tcs.partTime();
				break;
			default :
				System.out.println("Wrong choice in choosing type of job");
			}
		}
		else if(company==2)
		{
			System.out.println("Wipro Pvt Ltd");
			Wipro wipro = new Wipro();
			switch(type)
			{
			case 1:
				wipro.fullTime();
				break;
		
			case 2:
				wipro.partTime();
				break;
			default :
				System.out.println("Wrong choice in choosing type of job");
			}
		}
		else if(company==3)
		{
			System.out.println("Infosys");
			Infosys info = new Infosys();
			switch(type)
			{
			case 1:
				info.fullTime();
				break;
		
			case 2:
				info.partTime();
				break;
			default :
				System.out.println("Wrong choice in choosing type of job");
			}
		}
		else
			System.out.println("Wrong choice in choosing company");
		
		//System.out.println("***********************************************");
	}

}
class Tcs {
	int max=120,min=60,wagehour=45,workingDays=21;
	Wage_calculation wage = new Wage_calculation(max,min,wagehour,workingDays);
	public void partTime() {
		wage.partTime();
	}
	public void fullTime() {
		wage.fullTime();		
	}
	
	
}
class Wipro {
	
	int max=140,min=70,wagehour=60,workingDays=22;
	Wage_calculation wage = new Wage_calculation(max,min,wagehour,workingDays);
	public void partTime() {
		wage.partTime();		
	}
	public void fullTime() {
		wage.fullTime();		
	}

}
class Infosys {
	
	int max=130,min=65,wagehour=55,workingDays=23;
	Wage_calculation wage = new Wage_calculation(max,min,wagehour,workingDays);
	public void fullTime() {
		wage.fullTime();		
		
	}
	public void partTime() {
		wage.partTime();		
	}

}

class Wage_calculation {
	
	int max,min,wagehour,hrs=0,present=0,workingDays,totalPay;
	
	public Wage_calculation(int max, int min, int wagehour, int workingDays) {
		
		this.max=max;
		this.min=min;
		this.wagehour=wagehour;
		this.workingDays=workingDays;
		
	}
	
	public void fullTime()
	{
		Random random = new Random();
		System.out.println("\n\n\t\tDay\tAttendence\tHours Worked\tDaily Wage\t    Total Wage");
		for(int i=1;i<=workingDays;i++)
		{
			int randValue = random.nextInt(9);
			if(randValue <= 4)
			{
				if(hrs<max)
				{
					present++;
					hrs+=8;
					System.out.println("\t\t "+i+"\t    PR\t\t    "+hrs+"\t\t   "+(wagehour*8)+".00\t\t"+(hrs*wagehour));
				}
				else if(hrs>=max)
				{
					System.out.println("\t\t "+i+"\t    AB\t\t    "+hrs+"\t\t   0.00\t\t\t"+(hrs*wagehour));
				}
			}
			else
			{
				System.out.println("\t\t "+i+"\t    AB\t\t    "+hrs+"\t\t   0.00\t\t\t"+(hrs*wagehour));
			}
		}
		if(hrs>max)
		{
			totalPay=max*wagehour;
		}
		else
		{
			totalPay=hrs*wagehour;
		}
		System.out.println("\t\t\t\t\t\t\t\t\t      --------\n\t\t\t\t\t\t\t\t\tTotal\t: "+totalPay+"\n\n\n\t\tNo. of Working days\t: "+workingDays+" \n\n\t\tNo. of days Worked\t: "+present+"\n\n\t\tNo. of Absents\t\t: "+(workingDays-present)+"\n\n\t\ttotal Working Hours\t: "+hrs+"\n\n\t\tMaximum Working Hours\t: "+max);
		System.out.println("\n\t\tTotal wage\t\t: "+totalPay);
		
	}
	public void partTime()
	{
		Random random = new Random();
		max=50;
		System.out.println("\n\n\t\tDay\tAttendence\tHours Worked\tDaily Wage\t   Total Wage");
		for(int i=1;i<=workingDays;i++)
		{
			int randValue = random.nextInt(9);
			if(randValue <= 4)
			{
				if(hrs<min)
				{
					
					present++;
					hrs+=4;
					System.out.println("\t\t "+i+"\t    PR\t\t    "+hrs+"\t\t   "+(wagehour*4)+".00\t\t"+(hrs*wagehour));
				}
				else if(hrs >=min)
				{
					System.out.println("\t\t "+i+"\t    AB\t\t    "+hrs+"\t\t   0.00\t\t\t"+(hrs*wagehour));
				}
					
			}
			else
			{
				System.out.println("\t\t "+i+"\t    AB\t\t    "+hrs+"\t\t   0.00\t\t\t"+(hrs*wagehour));
			}
		}
		
	
	if(hrs>max)
	{
		totalPay=max*wagehour;
	}
	else
	{
		totalPay=hrs*wagehour;
	}
	System.out.println("\t\t\t\t\t\t\t\t\t      --------\n\t\t\t\t\t\t\t\t\tTotal\t: "+totalPay+"\n\n\n\t\tNo. of Working days\t: "+workingDays+" \n\n\t\tNo. of days Worked\t: "+present+"\n\n\t\tNo. of Absents\t\t: "+(workingDays-present)+"\n\n\t\ttotal Working Hours\t: "+hrs+"\n\n\t\tMaximum Working Hours\t: "+max);
	System.out.println("\n\t\tTotal wage\t\t: "+totalPay);
	
	}
	
}
