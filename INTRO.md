To get started with hibernate in eclipse...
Firstly create a maven quickstart project in eclipse...
Install JBoss tools in eclipse workplace which installs Hibernate plugins.
Then go to mvnrepository and copy the hibernate dependency and sqldialect dependency which you are using(mysql,postgresql etc..) and paste them in pom.xml of maven.
And then java file..create a java code like encapsulation with setters and getters 
Add an annotation named @Entity on top of the class which maps the Hibernate that it will be the name of the table.
If you want to have a table name different than that of class name..use annotation @Table(name="table_name") on top of class name..
Primary key is mandatory to have in a db...so use annotation @Id on top of column which want to be a primary key. 
And then right click on src/main/java new->other and then search hibernate.cfg.xml
We need to configure hibernate in this xml file..it will ask for sqldialect,dbdriver,url,username,password.
<property name="hbm2ddl.auto">create|update</property>  => write this statement in xml file based on ur requirements create or update.Although u created a table already even though it's written create in xml file it will overwrites the table.
Now,like JDBC which have several steps such as Connection,Statement etc...Hibernate also have several steps

Configuration con = new Configuration().configure().addAnnotatedClass(ClassName.class);
Creates a Hibernate configuration object, loads configuration from hibernate.cfg.xml, and adds annotated entity class ClassName to the configuration.

StandardServiceRegistryBuilder sr=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
Builds a StandardServiceRegistryBuilder using settings from Configuration and applies them.

SessionFactory sf=con.buildSessionFactory(sr.build());
Builds a session factory using the configuration settings from Configuration and the service registry from StandardServiceRegistryBuilder

Session session=sf.openSession();
Opens a new Hibernate session from the session factory.

Transaction tx=session.beginTransaction();
Begins a new transaction on the opened session.

With these steps..it's like the connection is established and we can perform the operations
