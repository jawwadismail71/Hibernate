package com.lti.designpatter.basedao;

import java.util.List;

import com.lti.SavingsAccount;

public interface SavingsAccountDAO { //crud methods
	void insertSavingsAccount(SavingsAccount ref);
	SavingsAccount selectSavingsAccountByAccountNumber(int acno);
	List<SavingsAccount> selectAllSavingsAccounts();
	void updateSavingsAccount(SavingsAccount ref);
	void deleteSavingsAccount(SavingsAccount ref);
}