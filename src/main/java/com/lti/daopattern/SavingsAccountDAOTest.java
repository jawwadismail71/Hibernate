package com.lti.daopattern;

import com.lti.SavingsAccount;

public class SavingsAccountDAOTest {
	public static void main(String[] args) {
		SavingsAccountDAO savAccDAO = new SavingsAccountDAOImpl(); 
		SavingsAccount savObj= new SavingsAccount();
		savObj.setAccountNumber(111); savObj.setAccountHolderName("Julia"); savObj.setAccountBalance(8000);
		savAccDAO.insertSavingsAccount(savObj); //transaction + persist
	}
}
