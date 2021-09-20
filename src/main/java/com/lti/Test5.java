package com.lti;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/*
 * 
 * 				MusicalInstrument
 * 				|play();
 * 		-------------
 * 			|
 * 	StringBasedMusicalInstrument
 * 				| tuneStrings();
 * 				| 
 * 	------------------------
 * 		|				|
 * 	Guitar				Violin				Sitar
 *  tuneStrings()			tuneString();	tuneStrings();
 *  play()					play()
 *  pluck()					bowing()
 *  --->					-->
 *  			JPA
 *  			|persist
 *  	-----------------
 *  	|				|
 *  Hibernate			JPA		..		?		?			?
 *  save				persist		persist		persist	persist
 *  get					find	
 *  update				merge
 *  delete				remove
 *  ORM					ORM
 *  implementation		implementation
 *  
 *  
 *  
 *  Ektara
 *  single string musical instrument
 *  
 *  
 * 
 */
public class Test5 {
	public static void main(String[] args) {
			//Garden         myGarden             =   Home	   .getGarden("hint")			
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA"); //this will read the persistence.xml file
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Got the EntityManager :  "+entityManager);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Got the EntityTransaction : "+entityTransaction);
		
		entityTransaction.begin();
															//sql -> select * from savings
				Query myQuery = entityManager.createQuery("from SavingsAccount"); // JPQL
				
				List<SavingsAccount> mySavingsList = myQuery.getResultList();
				
				for(SavingsAccount theAccount : mySavingsList ) { //
					
					System.out.println("Account Number  : "+theAccount.getAccountNumber());
					System.out.println("Account Name    : "+theAccount.getAccountHolderName());
					System.out.println("Account Balance : "+theAccount.getAccountBalance());
					System.out.println("--------------------");
				}
				
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




