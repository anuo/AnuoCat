package com.anuo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserLoginTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		UserLogin ul=new UserLogin();
		ul.setId(2);
		ul.setUserName("anuo");
		ul.setPassword("qaz00");
		session.save(ul);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
