package com.cg.exception;

public class InsufficientFundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double balance;
	public InsufficientFundException() {
		// TODO Auto-generated constructor stub
	}
	public InsufficientFundException(String msg,double balance) {
		super(msg);
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "InsufficientFundException: [balance=" + balance + "] " +super.getMessage();
	}
	
}