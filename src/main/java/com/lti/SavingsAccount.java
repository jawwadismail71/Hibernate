package com.lti;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity					//<-- declared as an Entity, which must have a PK
@Table(name="savings3") //<-- table name is savings
public class SavingsAccount {
	
	@Id
	@Column(name="acno")
	private int accountNumber;
	
	@Column(name="acholder")
	private String accountHolderName;
	
	@Column(name="acbal")
	private double accountBalance;
	
	@Embedded
	PanCard panCard;  //hasA relation
	
	@Embedded
	Address homeAddress;	//hasA relation	

	public SavingsAccount() {
		super();
		System.out.println("SavingsAccount() ctor...");
		// TODO Auto-generated constructor stub
	}

	
	public Address getHomeAddress() {
		return homeAddress;
	}


	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}


	public PanCard getPanCard() {
		return panCard;
	}


	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}




	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	
	
}
