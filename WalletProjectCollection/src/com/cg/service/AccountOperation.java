    
package com.cg.service;

import java.util.Map;

import com.cg.bean.Account;

public interface AccountOperation {
	public boolean addAccount(Account ob);
	public boolean deleteAccount(Account ob);
	public Account findAccount(Long mobileno );
	public Map<Long,Account> getAllAccounts();
}