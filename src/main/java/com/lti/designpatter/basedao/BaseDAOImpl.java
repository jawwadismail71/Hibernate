package com.lti.designpatter.basedao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.SavingsAccount;

public class BaseDAOImpl {
	EntityManagerFactory entityManagerFactory ; //line number 21 will initialize it
	
	public BaseDAOImpl() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA"); //this will read the persistence.xml file
		System.out.println("Got the EntityManagerFactory : "+entityManagerFactory);
	}
	public void persist(Object obj) { //persist is a dummy/userdefined name
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Entity Manager ..."+entityManager);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Entity Transaction is created.."+entityTransaction);
		entityTransaction.begin();  	System.out.println("Entity Transaction begin()");
			entityManager.persist(obj);	System.out.println("Object persisted...");
		entityTransaction.commit();
		System.out.println("Entitty Transaction commited...");		entityManager.close();

	}
	public Object find(Class theClass, Serializable pk ) {
		// TODO Auto-generated method stub
					EntityManager entityManager = entityManagerFactory.createEntityManager();
					System.out.println("Entity Manager ..."+entityManager);
					EntityTransaction entityTransaction = entityManager.getTransaction();
					System.out.println("Entity Transaction is created.."+entityTransaction);
					entityTransaction.begin();  	System.out.println("Entity Transaction begin()");
					Object foundSavingsAccObj = entityManager.find(theClass, pk);	System.out.println("Object found...");
					entityTransaction.commit();
					System.out.println("Entitty Transaction commited...");		entityManager.close();
				return foundSavingsAccObj;
	}
	
	public void findAll(Class theClass, String pojo) {
		
	}
	public void merge(Object obj) {
		
	}
	public void remove(Object obj) {
		
	}
}
