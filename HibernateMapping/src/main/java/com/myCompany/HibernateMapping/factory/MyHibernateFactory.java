package com.myCompany.HibernateMapping.factory;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myCompany.HibernateMapping.model.Instructor;
import com.myCompany.HibernateMapping.model.InstructorDetails;


public class MyHibernateFactory 
{
	private static SessionFactory factory;
	//private static Session session;
	
	public static SessionFactory getMySession()
	{
		factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
	return factory;
				
	}
	
}