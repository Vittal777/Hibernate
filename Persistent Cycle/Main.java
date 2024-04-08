package com.sql.life;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration().configure().addAnnotatedClass(Life.class);
		StandardServiceRegistryBuilder sr=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sf=con.buildSessionFactory(sr.build());
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Life l = new Life();	//Here, obj l goes to transient state with 'new' keyword
		l.setAge(69);
		l.setProb("Few");
		l.setName("Ayyo");
		
		session.persist(l);	//Since the obj is in persistent state...changes made to obj reflects in db.
		l.setAge(45);
		
		session.getTransaction().commit();
		session.evict(l);	//After detaching the obj...although we try to make a change for obj...it wont
		l.setAge(30);
		session.persist(l);
	}

}
