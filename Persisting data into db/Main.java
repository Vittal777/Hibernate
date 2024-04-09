package com.first.hibernate.a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Main {
	public static void main(String[] args) {
		App app = new App();
		app.setCid(10);
		app.setCname("Srinivas");
		app.setCage(22);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(App.class);
        StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        SessionFactory sf = con.buildSessionFactory(reg.build());
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(app);
        tx.commit();
        session.close(); 
        sf.close(); 
	}
}
