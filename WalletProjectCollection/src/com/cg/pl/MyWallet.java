package com.cg.pl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.cg.bean.*;
import com.cg.exception.InsufficientFundException;
import com.cg.service.AccountService;
import com.cg.service.Validator;
public class MyWallet {

	public static void main(String[] args) throws InsufficientFundException, IOException {

	
		AccountService service=new AccountService();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String choice="";
		while(true)
		{
		System.out.println("Menu");
		System.out.println("===========================");
		System.out.println("1. Create New Account");
		System.out.println("2. Print all accounts");
		System.out.println("3. Update account");
		System.out.println("4. Delete Account");
		System.out.println("5. Deposit amount");
		System.out.println("6. Withdraw amount");
		System.out.println("7. Transfer to other account");
		System.out.println("8. Exit");
		System.out.println("Enter your choice");
		choice=br.readLine();
		switch(choice) {
		case "1":	System.out.println("*****************Create Account********************");
			
					int id=0;
					long mb=0L;
					String ah="";
					double bal=0.0;
					// Accepting and validating input for account number
					System.out.println("Enter Account Number: ");
					while(true) {
						String s_id=br.readLine();
						boolean ch1=Validator.validatedata(s_id, Validator.aidpattern);
						if(ch1==true) {
							try {
								id=Integer.parseInt(s_id);
								break;
							}catch(NumberFormatException e) {
								System.out.println("Account number must be numeric.\nRe-Enter");
							}
						}
						else {
							System.out.println("Re-Enter Account Number in 3 digits");
						}
					}	// End of account number while
					
					// Accepting and validating input for mobile number
					System.out.println("Enter Mobile Number: ");
					while(true) {
						String s_mb=br.readLine();
						boolean ch1=Validator.validatedata(s_mb, Validator.mobilepattern);
						if(ch1==true) {
							try {
								mb=Long.parseLong(s_mb);
								break;
							}catch(NumberFormatException e) {
								System.out.println("Mobile number must be numeric.\nRe-Enter");
							}
						}
						else {
							System.out.println("Re-Enter Mobile Number in 10 digits");
						}
					}	// End of mobile number while
					
					// Accepting and validating input for account holder
					System.out.println("Enter Account Holder Name: ");
					while(true) {
						ah=br.readLine();
						boolean ch1=Validator.validatedata(ah, Validator.namepattern);
						if(ch1==true) {
							break;
						}
						else {
							System.out.println("Re-Enter Account holder name");
						}
					}
					
					// Accepting and validating input for balance
					System.out.println("Enter initial balance ");
					while(true) {
						String s_bal=br.readLine();
						boolean ch1=Validator.validatedata(s_bal, Validator.balancepattern);
						if(ch1==true) {
							try {
								bal=Double.parseDouble(s_bal);
								break;
							}catch(NumberFormatException e) {
								System.out.println("Balance must be double.\nRe-Enter");
							}
						}
						else {
							System.out.println("Re-Enter Balance");
						}
					}
					Account ob=new Account(id, mb, ah, bal);
					boolean b=service.addAccount(ob);
					System.out.println("Account Added Successfully !");
					break;
					
		case "2":	System.out.println("*****************Print All Accounts********************");
			
					Map<Long, Account> accmap=service.getAllAccounts();
					Collection<Account> vc=accmap.values();
					List<Account> acclist=new ArrayList<Account> (vc);
		

					for(Account o:acclist) {
						service.printStatement(o);
					}
					break;
					
		case "3":	System.out.println("*****************Update Account********************");
			
			System.out.println("Enter Mobile number ");
		String s_mb=br.readLine();
		mb=Long.parseLong(s_mb);
		ob=service.findAccount(mb);
		System.out.println("Enter Account number to be updated: ");
		while(true) {
			String s_id=br.readLine();
			boolean ch1=Validator.validatedata(s_id, Validator.aidpattern);
			if(ch1==true) {
				try {
					id=Integer.parseInt(s_id);
					break;
				}catch(NumberFormatException e) {
					System.out.println("Account number must be numeric.\nRe-Enter");
				}
			}
			else {
				System.out.println("Re-Enter Account Number in 3 digits");
			}
		}	// End of account number while
	
		// Accepting and validating input for account holder
		System.out.println("Enter Account Holder Name to be updated:");
		while(true) {
			ah=br.readLine();
			boolean ch1=Validator.validatedata(ah, Validator.namepattern);
			if(ch1==true) {
				break;
			}
			else {
				System.out.println("Re-Enter Account holder name");
			}
		}
		
		// Accepting and validating input for balance
		System.out.println("Enter Initial Balance to be updated: ");
		while(true) {
			String s_bal=br.readLine();
			boolean ch1=Validator.validatedata(s_bal, Validator.balancepattern);
			if(ch1==true) {
				try {
					bal=Double.parseDouble(s_bal);
					break;
				}catch(NumberFormatException e) {
					System.out.println("Balance must be double.\nRe-Enter");
				}
			}
			else {
				System.out.println("Re-Enter Balance");
			}
		}
		ob=new Account(id, mb, ah, bal);
		 b=service.updateAccount(ob);
		System.out.println("Account Successfully Updated !"+b);
		break;
		
case "4":	System.out.println("*****************Delete Account********************");
	
		System.out.println("Enter Mobile number ");
		s_mb=br.readLine();
		mb=Long.parseLong(s_mb);
		service.deleteAccount(service.findAccount(mb));
		System.out.println("Account Successfully Deleted !");
		break;
		
case "5":	System.out.println("*****************Deposit********************");
	
		System.out.println("Enter Mobile Number ");
		s_mb=br.readLine();
		mb=Long.parseLong(s_mb);
		System.out.println("Enter the amount you want to deposit ");
		String s_amt=br.readLine();
		double amt=Double.parseDouble(s_amt);
		ob=service.findAccount(mb);
		bal=ob.getBalance()+amt;
		ob.setBalance(bal);

		System.out.println("Deposit Successful !");
		break;
		
case "6":	System.out.println("*****************Withdraw********************");
	
		System.out.println("Enter Mobile Number ");
		s_mb=br.readLine();
		mb=Long.parseLong(s_mb);
		System.out.println("Enter the Amount you want to Withdraw: ");
		s_amt=br.readLine();
		amt=Double.parseDouble(s_amt);
		ob=service.findAccount(mb);
		bal=ob.getBalance()-amt;
		ob.setBalance(bal);
		System.out.println("Withdrawl Successful !");
		break;
		
case "7":	System.out.println("*****************Transfer********************");
	
		System.out.println("Enter your Mobile number ");
		s_mb=br.readLine();
		long from=Long.parseLong(s_mb);
		System.out.println("Enter other Mobile number ");
		s_mb=br.readLine();
		long to=Long.parseLong(s_mb);
		System.out.println("Enter the amount you want to transfer: ");
		s_amt=br.readLine();
		amt=Double.parseDouble(s_amt);
		Account obj1=service.findAccount(from);
		Account obj2=service.findAccount(to);
		int flag=(int)service.transferMoney(obj1, obj2, amt);
		if(flag==1) {
			System.out.println("Money Transfered Successfully !");
		}
		else {
			System.out.println("Money Transfer Failed !");
		}
		break;


case "8":	System.out.println("Exiting Program");
		System.exit(0);
		break;
default :	System.out.println("Invalid choice");
		}
		
	}
		
	
	}

}