package com.myCompany.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myCompany.hibernate_one_to_one.model.Course;
import com.myCompany.hibernate_one_to_one.model.InstructorDetails;
import com.myCompany.hibernate_one_to_one.model.Instructor;



public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
        		  addAnnotatedClass(Instructor.class). addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
    
        Session session = factory.getCurrentSession();
        
        /*InstructorDetails detail = new InstructorDetails();
        detail.setHobby("Singing");
        detail.setYoutube("https:www.youtube.com/fun");
        
        Instructor i = new Instructor();
        i.setFirstname("Vaish");
        i.setLastname("A");
        i.setEmail("vais@a.com");
        i.setDetails(detail);
        
        session.getTransaction().begin();
        session.save(i);
        //session.persist(detail);
        //session.persist(i);
        session.getTransaction().commit();
        session.close();*/
        
        
        //Creating instructor part
       /* try {

			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

			InstructorDetails tempInstructorDetail = new InstructorDetails("http://www.youtube.com", "Guitar");

			tempInstructor.setDetails(tempInstructorDetail);

			session.beginTransaction();

			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
        
        
        //Delete part
       /* try {

			session.beginTransaction();

			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Found instructor: " + tempInstructor);

			if (tempInstructor != null)
			{

				System.out.println("Deleting: " + tempInstructor);

				session.delete(tempInstructor);
			}

			session.getTransaction().commit();

			System.out.println("Done!");
		} 
		finally 
		{
			factory.close();
		}*/
        
        
      //Creating course 
		/*try {

			session.beginTransaction();
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {

			session.close();

			factory.close();
        
		}*/
		
		
		//Deleting course
		/*try {

			session.beginTransaction();

			int theId = 1;
			Course tempCourse = session.get(Course.class, theId);

			System.out.println("Deleting course: " + tempCourse);

			session.delete(tempCourse);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();

			factory.close();
		}*/
        
        //Getting instructor courses
       /* try {

			session.beginTransaction();
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Instructor: " + tempInstructor);
			System.out.println("Courses: " + tempInstructor.getCourses());

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();

			factory.close();
		}*/
    
    }
}
