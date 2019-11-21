package com.myCompany.InheritanceDemo.model;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunAccountCode {

	public static void main(String[] args )
	{
		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Account.class)
					.addAnnotatedClass(SavingsAccount.class).addAnnotatedClass(CurrentAccount.class).buildSessionFactory();

			Session session = factory.getCurrentSession();
			
			Account acc = new Account("Vaish", 123, 10000);
			SavingsAccount sav_acc = new SavingsAccount("Vaish", 123, 10000, 10, new Date());
			CurrentAccount cur_acc = new CurrentAccount("Vaish", 123, 10000, "vaish@gmail.com");
			
			session.getTransaction().begin();
			session.save(acc);
			session.save(sav_acc);
			session.save(cur_acc);
			session.getTransaction().commit();
			System.out.println("ok..");
		} 
		catch (HibernateException e) {
			
			e.printStackTrace();
		}

	}
	
}