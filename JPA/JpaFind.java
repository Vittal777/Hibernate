package com.sql.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("persis");
		EntityManager em = emf.createEntityManager();
		Product p = em.find(Product.class,900);
		System.out.print(p);
	}

}
