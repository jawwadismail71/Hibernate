package com.lti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test4 {
	public static void main(String[] args) {
			//Garden         myGarden             =   Home	   .getGarden("hint")			
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA"); //this will read the persistence.xml file
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManager :  "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Got the EntityTransaction : "+entityTransaction);
		
		entityTransaction.begin();
		
				SavingsAccount savObj = entityManager.find(SavingsAccount.class,102); //this will fire the insert query
				//attached to the EntityManager/hibernate  
				/*
				 * select 	savingsacc0_.acno 		as acno1_0_0_, 
				 * 			savingsacc0_.acbal 		as acbal2_0_0_, 
				 * 			savingsacc0_.acholder 	as acholder3_0_0_ 
				 * from savings savingsacc0_ 
				 * where savingsacc0_.acno=?
				*/
				System.out.println("Account Number            : "+savObj.getAccountNumber());
				System.out.println("Current : Account Name    : "+savObj.getAccountHolderName());
				System.out.println("Current :Account Balance  : "+savObj.getAccountBalance());
				
				//on the attached object, if you call any setter method, means 
				//the attached object is modified... this will trigger the update query on that 
				//object
				
				savObj.setAccountBalance(166000);
				savObj.setAccountHolderName("JULIA ROBERTS");
				
				entityManager.merge(savObj); // it will fire the update query 
				
				SavingsAccount savObj2 = new SavingsAccount();//detached
				savObj2.setAccountNumber(999);
				savObj2.setAccountHolderName("SING");
				savObj2.setAccountBalance(19999);
				entityManager.merge(savObj2); // it will create 
				//a new record if object is not found   saveOrUpdate
				
				
		entityTransaction.commit();
		System.out.println("Object is persisted....ß");
		
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("Resources closed...");
	}
	
}
/*
  
  layer1		database		savings
  layer2		POJO			SavngsAccount
  layer3		REPO			Hibernate JPA coding
  layer4		GLADIATOR		your project coding
  layer5		Controller		SpringREST
  layer6		Angular			Angular Services + Components + Pipes + Routing 
 
 FileHandling - Serialization
 OR
 Persistence - storing the "JAVA Object" on the database table as a "ROW
 
 
 	Persistence					- MyHome <--- Lodha | Hiranandani | 
	to retrieve the object 
	of EntityManagerFactory

	EntityManagerFactory		- Garden
	
	EntityManager				- Rose, Lotus, Lily
	|
	save(), get(),
	update(), delete()
	
	
	EntityTransaction			- rollback, commit

	Query						- custom queries
	
	persistence.xml				configurations of the EntityManagerFactory
								DriverName,URL, Username, Password
								other hibernate/jpa details
								
	

*/




