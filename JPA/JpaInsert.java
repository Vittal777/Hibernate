package com.sql.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setPid(10);
		p.setPname("Kajal");
		p.setPrice(10000);
		p.setColor("White");
		p.setWeight(60);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persis");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.print(p);
	}

}
