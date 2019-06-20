package com.cg.service;

import com.cg.bean.Account;
import com.cg.exception.InsufficientFundException;

public interface Transaction extends AccountOperation {
	 public double withdraw(Account ob,double amount) throws InsufficientFundException;
	 public double deposit(Account ob,double amount);
	 public double transferMoney(Account from,Account to,double amount);
	 public default void printStatement(Account ob) {
		 
		 System.out.println("========================================");
		 System.out.println("Statement for Account NO.: "+ob.getAid());

		 System.out.println("Account Holder: "+ob.getAccountholder());
		 System.out.println("Balance is => "+ob.getBalance());
		 System.out.println("========================================");
		 
	 }
	 
}