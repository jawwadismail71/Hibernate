package com.lti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test3 {
	public static void main(String[] args) {
			//Garden         myGarden             =   Home	   .getGarden("hint")			
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA"); //this will read the persistence.xml file
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManager :  "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Got the EntityTransaction : "+entityTransaction);
		
		entityTransaction.begin();
				
				//SavingsAccount savObj = new SavingsAccount(); //detached from hibernate
				
				SavingsAccount savObj = entityManager.find(SavingsAccount.class, 101); //this will fire the insert query
				entityManager.remove(savObj);
				
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




