package com.sql.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persis");
		EntityManager em = emf.createEntityManager();
		Product p = em.find(Product.class,10);
		em.persist(p);
		/*We get the data using find() method and persisted it to available for modifications.
		  Then..to perform CRUD operations we need to begin Transaction..and modified the Price to 5000
		  which was 10000 before.
		 */
		em.getTransaction().begin();
		p.setPrice(5000);
		em.getTransaction().commit();
		System.out.print(p);
	}

}
