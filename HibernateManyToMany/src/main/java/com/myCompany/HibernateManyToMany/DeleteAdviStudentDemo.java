package com.myCompany.HibernateManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myCompany.HibernateManyToMany.model.Course;
import com.myCompany.HibernateManyToMany.model.Instructor;
import com.myCompany.HibernateManyToMany.model.InstructorDetails;
import com.myCompany.HibernateManyToMany.model.Review;
import com.myCompany.HibernateManyToMany.model.Student;

public class DeleteAdviStudentDemo 
{
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);

			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());

			System.out.println("\nDeleting student: " + tempStudent);
			session.delete(tempStudent);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();

			factory.close();
		}
	}
}
