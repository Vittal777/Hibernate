package com.sql.sqlquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Productprop pp = new Productprop();
		pp.setColor("black");
		pp.setWeight(10);
		Product p = new Product();
		p.setPid(5);
		p.setPname("Edokati");
		p.setPrice(200);
		p.setProps(pp);
		Configuration con=new Configuration().configure().addAnnotatedClass(Product.class);
		StandardServiceRegistryBuilder sr=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sf = con.buildSessionFactory(sr.build());
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
		sf.close();
	}

}
