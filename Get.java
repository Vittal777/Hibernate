package com.first.hibernate.a;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Get {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
		Configuration con = new Configuration().configure().addAnnotatedClass(App.class);
		StandardServiceRegistryBuilder sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sf= con.buildSessionFactory(sr.build()); 
		Session session = sf.openSession();
		//Transaction tx = session.beginTransaction();
		//app = (App)session.get(App.class,7);
		//tx.commit();
		try {
		Query query = session.createQuery("select cage,cid,cname from App");
		List<Object[]> customers = (List<Object[]>) query.list();
		for(Object[] c : customers) {
			System.out.println(c[0]+" : "+c[1]+" : "+c[2]);
		}
		
		Query q = session.createQuery("from App",App.class);
		q.setMaxResults(1);
		List<App> l = q.list();
		for(App a : l) {
			System.out.println(a.getCage()+" "+a.getCid()+" "+a.getCname());
		}
		// In Hibernate, database operations like inserts, updates, and deletes usually require an active transaction for data integrity and consistency.
		Transaction tx = session.beginTransaction();
		Query q2=session.createQuery("Delete from App where cid = :cid");
		q2.setParameter("cid",8);
		int rowsaffected=q2.executeUpdate();
		System.out.print("Rows affected : "+rowsaffected);
		tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		sf.close();
	}

}
