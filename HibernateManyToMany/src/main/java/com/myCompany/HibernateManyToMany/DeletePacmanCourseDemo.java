package com.myCompany.HibernateManyToMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myCompany.HibernateManyToMany.model.Course;
import com.myCompany.HibernateManyToMany.model.Instructor;
import com.myCompany.HibernateManyToMany.model.InstructorDetails;
import com.myCompany.HibernateManyToMany.model.Review;
import com.myCompany.HibernateManyToMany.model.Student;


public class DeletePacmanCourseDemo 
{
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int courseId = 2;
			Course tempCourse = session.get(Course.class, courseId);

			System.out.println("Deleting course: " + tempCourse);

			session.delete(tempCourse);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();

			factory.close();
		}
	}
}
