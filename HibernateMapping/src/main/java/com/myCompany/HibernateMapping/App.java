package com.myCompany.HibernateMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myCompany.HibernateMapping.factory.MyHibernateFactory;
import com.myCompany.HibernateMapping.model.Instructor;
import com.myCompany.HibernateMapping.model.InstructorDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try
    	{
    		
    		SessionFactory sessionfactory = MyHibernateFactory.getMySession();
	    	
	    	Session session = sessionfactory.openSession();
	    	
	       InstructorDetails details = new InstructorDetails();
	       Instructor instructor = new Instructor();
	       
	       details.setHobby("Playing chess");
	       details.setYoutube("https://www.youtube/fsd");
	       
	       instructor.setFirst_name("Vaish");
	       instructor.setLast_name("A");
	       instructor.setEmail("vaish@gmail.com");
	       instructor.setDetails(details);
	       
	       session.getTransaction().begin();
	       session.persist(details);
	       session.persist(instructor);
	       session.getTransaction().commit();
	       session.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
       
    }
}
