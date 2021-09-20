package com.lti.designpatter.basedao;

import com.lti.SavingsAccount;

public class SavingsAccountDAOTest {
	public static void main(String[] args) {
		SavingsAccountDAO savAccDAO = new SavingsAccountDAOImpl2(); 
		SavingsAccount savObj= new SavingsAccount();
		savObj.setAccountNumber(111); savObj.setAccountHolderName("Julia"); savObj.setAccountBalance(8000);
		savAccDAO.insertSavingsAccount(savObj); //transaction + persist
	}
}
