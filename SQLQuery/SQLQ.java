package com.sql.sqlquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLQ {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con=new Configuration().configure().addAnnotatedClass(Product.class);
		StandardServiceRegistryBuilder sr=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sf = con.buildSessionFactory(sr.build());
		Session session=sf.openSession(); 
		Transaction tx = session.beginTransaction();
		NativeQuery sqlq=session.createNativeQuery("select count(*) from Product");
		/*select count(*) from Product only returns a single column with the count of records, not the actual Product entities. should remove the addEntity(Product.class) call since you're not selecting Product entities from the database. */
		//sqlq.addEntity(Product.class);
		//addEntity() instruct Hibernate to map the result of the SQL query to the Product class.
		List<Product> l = sqlq.list();
		/*for(Product p : l) {
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice());
		}*/
		System.out.print("Number of records : "+l);
		tx.commit();
	}

}
