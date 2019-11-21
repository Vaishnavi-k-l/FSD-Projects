package com.myCompany.HibernateManyToMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myCompany.HibernateManyToMany.model.Course;
import com.myCompany.HibernateManyToMany.model.Instructor;
import com.myCompany.HibernateManyToMany.model.InstructorDetails;
import com.myCompany.HibernateManyToMany.model.Review;
import com.myCompany.HibernateManyToMany.model.Student;

public class CreateCourseAndReviewDemo 
{
		
public static void main(String[] args) {

		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {			
			
		
			session.beginTransaction();
			
			
		
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			
			tempCourse.addReview(new Review("Great course ... loved it!"));
			tempCourse.addReview(new Review("Cool course, job well done"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
						
			// save the course ... and leverage the cascade all :-)
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
		
			session.close();
			
			factory.close();
		}
	}
}
