package com.sql.sqlquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class GetvLoad {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con=new Configuration().configure().addAnnotatedClass(Product.class);
		StandardServiceRegistryBuilder sr=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sf = con.buildSessionFactory(sr.build());
		Session session=sf.openSession(); 
		Transaction tx = session.beginTransaction();
		Product pget = session.get(Product.class,2);
		if(pget!=null) {
		System.out.println(pget.getPname());
		}else {
			System.out.println("What you are trying to get does not exist");
		}
		Product pload = session.load(Product.class,3);
		if(pload!=null) {
		System.out.println(pload.getPname());
		}else {
			System.out.println("What you are trying to get does not exist");
		}
		tx.commit();
		session.close();
		sf.close();
	}

}
