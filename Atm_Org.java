package Atm_Org;
import java.util.*;
import java.text.*;
class Account
{
	private int CN;
	private int PN;
	double CB=2000;
	double SB=5000;
	DecimalFormat df=new DecimalFormat("'Rupee'###,##0.00");
	Scanner sc=new Scanner(System.in);
	

    void SetCustomerNo(int CustomerNumber)
	{
		CN=CustomerNumber;  // We can use This keyword as well if parameter name is same as CN
		//System.out.println("CN");
	}
	void SetPinNo(int PIN_Number)
	{
		PN=PIN_Number;
		//System.out.println("PN");
    }
	int getCustomerNo()
	{
		return CN;
		
	}
	int getPinNo()
	{
		return PN;

	}
	double getCurrentBalance()
	{
		return CB;
	}
	double getSavingBalance()
	{
		return SB;
	}
	
	double calcCurrentWithdraw(double Money) 
	{
		CB = CB-Money;
		return CB;
	}
	
	void getCurrentWithdrawInput()
	{
		System.out.println("Your current account balance is :  "+ df.format(CB));
		System.out.println("Amount you want to withdraw from your current account : ");
		double Amount = sc.nextDouble();
		
		if((CB - Amount) >= 0)
		{
			calcCurrentWithdraw(Amount);
			System.out.println("Your new checking account balance is : " +df.format(CB));
		}
		else
		{
			System.out.println("Insufficient Balance for this transaction. ");
		}
	}
	double calcSavingWithdraw(double Money1)
	{
		SB = SB-Money1;
		return SB;
	}
	void getSavingWithdrawInput() 
	{
		System.out.println("Your saving account balance is :  "+ df.format(SB));
		System.out.println("Amount you want to withdraw from your saving account : ");
		double Amount1 = sc.nextDouble();
		
		if((SB - Amount1) >= 0)
		{
			calcSavingWithdraw(Amount1);
			System.out.println("Your new checking account balance is : " +df.format(SB));
		}
		else
		{
			System.out.println("Insufficient Balance for this transaction. ");
		}

	}
	double calcCurrentDeposite(double Deposite_CB)
	{
		CB=Deposite_CB+CB;
		return CB;
		
	}
	double calcSavingDeposite(double Saving_SB)
	{
		SB=Saving_SB+SB;
		return SB;
		
	}
	void getCurrentDepositeInput()
	{
		System.out.println("Checking Account Balance : " + df.format(CB));
		System.out.println("Amount you want to deposite to your account : ");
        double Deposite_CB = sc.nextDouble();
		
		if((CB+ Deposite_CB) >= 0)
		{
			calcCurrentDeposite(Deposite_CB);
			System.out.println("Your new checking account balance is : " +df.format(CB));
		}
		else
		{
			System.out.println("Error");
		}
	}
	void getSavingDepositeInput()
	{
		System.out.println("Checking Saving Account Balance : " + df.format(SB));
		System.out.println("Amount you want to deposite to your saving account : ");
        double Saving_SB = sc.nextDouble();
		
		if((SB+ Saving_SB) >= 0)
		{
			calcSavingDeposite(Saving_SB);
			System.out.println("Your new checking account balance is : " +df.format(SB));
		}
		else
		{
			System.out.println("Enter Valid Amount");
		}

	}


}
class OptionMenu extends Account 
{
	Scanner sc= new Scanner(System.in);
	HashMap <Integer,Integer> hm= new HashMap<Integer,Integer>();
	DecimalFormat df=new DecimalFormat("'Rupee'###,##0.00");
    void getLogin()
    {
    	int x=1;
    	do
    	{
    		try
        	{
        		System.out.println("                                                           Welcome to our ATM    ");
                System.out.println("\n");
        		
        		
        	    System.out.println("-------------------------------------------------------------------------------------------------------------------------*---");
        		System.out.println("\n");
        	    System.out.print("1. Enter your Customer Number : ");
        		SetCustomerNo(sc.nextInt());
        		System.out.print("2. Enter your PIN Number : ");
        		SetPinNo(sc.nextInt());
        		hm.put(11111, 111);
        		hm.put(22222, 222);
        		hm.put(33333, 333);
        		hm.put(44444, 111);
        		hm.put(55555, 444);
        		
        		int a = getCustomerNo();
        		int b = getPinNo();

        		
        		if(hm.containsKey(a) && hm.get(a)==b)
        		{
        			//System.out.println("You are logged in successfully");
        			getAccountType();
        			{
        				
        			}
        		}
        		else
        		{
        			System.out.println("Error! Try Again");

        		}
        	}
        	catch(InputMismatchException a)
        	{
        		System.out.println(a);
        		x=2;
        	}
        	
    }while(x==1);
}
    
    
   void getAccountType()
    {
    	System.out.println("Select type of account you want to access");
    	System.out.println("Type 1 : Saving Account");
    	System.out.println("Type 2 : Current Account");
    	System.out.println("Type 3 : Exit");
    	System.out.println("Choice : ");
    	
    	Scanner sc=new Scanner(System.in);
    	int choice=sc.nextInt();
    	switch(choice)
    	{
    	case 1:
    		getSaving();
            break;
    	case 2:
    		getCurrent();
            break;
    	case 3:
    		System.out.println("Thank you for visiting !! Visit Again");
    		//getAccountType();
    		break;
    	default:
    		System.out.println("Invalid choice ! Please Enter Valid Choice");
            break;
    	}
   }
    	
 
void getCurrent()
{
	System.out.println("-----Current Account-----");
	System.out.println("Type 1 : View Balance");
	System.out.println("Type 2 : Withdraw Funds");
	System.out.println("Type 3 : Deposite Funds");
	System.out.println("Type 4 : Exit");
    System.out.println("Choice : ");
    int choice=sc.nextInt();
    switch(choice)
    {
    case 1:
    	System.out.println("Your Current Account Balance : "+ df.format(getCurrentBalance()));
    	getAccountType();
    	break;
    case 2:
    	getCurrentWithdrawInput();
    	getAccountType();
    	//System.out.println();
    	break;
    case 3:
    	getCurrentDepositeInput();
    	getAccountType();
    	break;
    case 4:
		System.out.println("Thank you for visiting !! Visit Again");
		getAccountType();
        break;
    default:
		System.out.println("Invalid choice ! Please Enter Valid Choice");
		getCurrent();
        break;
    		
    }
}

void getSaving()
{
	System.out.println("---- Saving Accounts----");
	System.out.println("Type 1 : View Balance");
	System.out.println("Type 2 : Withdraw Funds");
	System.out.println("Type 3 : Deposite Funds");
	System.out.println("Type 4 : Exit");
    System.out.println("Choice : ");
    int choice=sc.nextInt();
    switch(choice)
    {
    case 1:
    	System.out.println("Your Saving Account Balance : " + df.format(getSavingBalance()));
    	getAccountType();
        break;
    case 2:
    	getSavingWithdrawInput();
    	getAccountType();
    	break;
    case 3:
    	getSavingDepositeInput();
    	getAccountType();

    	break;
    case 4:
		System.out.println("Thank you for visiting !! Visit Again");
		getAccountType();
        break;
    default:
		System.out.println("Invalid choice ! Please Enter Valid Choice");
		getSaving();
		break;
    }		
}
}

public class Atm_Org extends OptionMenu 
{
    public static void main(String[] args) 
	{
         OptionMenu si = new OptionMenu();
     	 si.getLogin();
	}

}