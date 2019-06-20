package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.bean.Account;

public class AccountDAOImpl implements  AccountDAO{
	public static Map<Long,Account> accmap=new HashMap<Long,Account>();
	public boolean addAccount(Account ob) {
		accmap.put(ob.getMobile(),ob);
		return true;
	}

	@Override
	public boolean updateAccount(Account ob) {
		accmap.put(ob.getMobile(),ob);
		// TODO Auto-generated method stub
		//Account ob1=new Account();
		//accmap.replace(ob.getMobile(), ob, ob1);
		return true;
	}
	@Override
	public boolean deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		accmap.remove(ob.getMobile());
		return true;
	}
	@Override
	public Account findAccount(Long mobileno) {
		Account ob=accmap.get(mobileno);
		
		// TODO Auto-generated method stub
		return ob;
	}
	@Override
	public Map<Long, Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accmap;
	}
	@Override
	public boolean transferMoney(Account from, Account to) {
		// TODO Auto-generated method stub
		accmap.put(from.getMobile(),from);
		accmap.put(to.getMobile(),to);
		
		return false;
	}
}