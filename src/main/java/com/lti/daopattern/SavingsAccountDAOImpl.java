package com.lti.daopattern;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.SavingsAccount;
//DATABASE, HIBERNATE<- ECLIPSE STS-> SPRING, POSTMAN, VSCODE

public class SavingsAccountDAOImpl implements SavingsAccountDAO {
	EntityManagerFactory entityManagerFactory ; //line number 21 will initialize it
	public SavingsAccountDAOImpl() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA"); //this will read the persistence.xml file
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
	}
	public void insertSavingsAccount(SavingsAccount ref) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Entity Manager ..."+entityManager);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Entity Transaction is created.."+entityTransaction);
		entityTransaction.begin();  	System.out.println("Entity Transaction begin()");
			entityManager.persist(ref);	System.out.println("Object persisted...");
		entityTransaction.commit();
		System.out.println("Entitty Transaction commited...");		entityManager.close();
	}

	public SavingsAccount selectSavingsAccountByAccountNumber(int acno) {
		// TODO Auto-generated method stub
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Entity Manager ..."+entityManager);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			System.out.println("Entity Transaction is created.."+entityTransaction);
			entityTransaction.begin();  	System.out.println("Entity Transaction begin()");
			SavingsAccount foundSavingsAccObj = entityManager.find(SavingsAccount.class, acno);	System.out.println("Object found...");
			entityTransaction.commit();
			System.out.println("Entitty Transaction commited...");		entityManager.close();
		return foundSavingsAccObj;
	}

	public List<SavingsAccount> selectAllSavingsAccounts() {
					EntityManager entityManager = entityManagerFactory.createEntityManager();
					System.out.println("Entity Manager ..."+entityManager);
					EntityTransaction entityTransaction = entityManager.getTransaction();
					System.out.println("Entity Transaction is created.."+entityTransaction);
					entityTransaction.begin();  	System.out.println("Entity Transaction begin()");
					
					Query myQuery = entityManager.createQuery("from SavingsAccount"); // JPQL
					List<SavingsAccount> mySavingsList = myQuery.getResultList();
					
					entityTransaction.commit();
					System.out.println("Entitty Transaction commited...");		entityManager.close();
				return mySavingsList;
		
	}

	public void updateSavingsAccount(SavingsAccount ref) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Entity Manager ..."+entityManager);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Entity Transaction is created.."+entityTransaction);
		entityTransaction.begin();  	System.out.println("Entity Transaction begin()");
		SavingsAccount foundSavingsAccObj = entityManager.merge(ref);	System.out.println("Object updated...");
		entityTransaction.commit();
		System.out.println("Entitty Transaction commited...");		entityManager.close();
	}

	public void deleteSavingsAccount(SavingsAccount ref) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Entity Manager ..."+entityManager);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Entity Transaction is created.."+entityTransaction);
		entityTransaction.begin();  	System.out.println("Entity Transaction begin()");
		SavingsAccount foundSavingsAccObj = entityManager.find(SavingsAccount.class,ref.getAccountNumber());	
		System.out.println("Object found...");
		entityManager.remove(foundSavingsAccObj);
		System.out.println("Object deleted...");
		entityTransaction.commit();
		System.out.println("Entitty Transaction commited...");		entityManager.close();
	}

}
