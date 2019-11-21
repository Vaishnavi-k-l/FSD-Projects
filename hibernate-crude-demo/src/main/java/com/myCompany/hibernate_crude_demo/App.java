package com.myCompany.hibernate_crude_demo;

import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myCompany.hibernate_crude_demo.dao.EmployeeDAO;
import com.myCompany.hibernate_crude_demo.dao.EmployeeDAOImpl;
import com.myCompany.hibernate_crude_demo.model.Employee;

import com.myCompany.hibernate_crude_demo.shared.SharedEmployee;

import static java.lang.System.in;

public class App {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		EmployeeDAO dao = new EmployeeDAOImpl();
		try {

			int choice = 0;
			do {
				System.out.println("1. Create employee");
				System.out.println("2. Display available employee");
				System.out.println("3. Find employee by id");
				System.out.println("4. Find employee by Customid");
				System.out.println("5. Update employee");
				System.out.println("6. Remove employee by id");
				System.out.println("0. Exit");
				System.out.println("Your choice:");
				choice = in.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter the firstname");
					String fName = in.next();
					System.out.println("Enter the lastname");
					String lName = in.next();
					System.out.println("Enter the email");
					String email = in.next();
					dao.createEmployee(new SharedEmployee(fName, lName, email));
					System.out.println("inserted");
					break;

				case 2:
					List<SharedEmployee> se = dao.getAllEmployee();
					for (SharedEmployee see : se) {
						System.out.println(see);
						// System.out.printf("%s %s %s" , see.getFirstName(), see.getLastName(),
						// see.getEmail());
					}
					break;

				case 3:
					System.out.println("Enter employee id");
					int id = in.nextInt();
					SharedEmployee sEmployee = dao.findById(id);
					if (sEmployee == null) {
						System.out.println("No records found");
					} else {
						System.out.println(sEmployee);
					}
					break;

				case 4:
					System.out.println("custom id: ");
					String cid = in.next();
					dao.findByCustomId(cid);
					break;
					
				case 5: System.out.println("Enter the employee id to update");
						id = in.nextInt();
						dao.updateEmployee(id);
						break;

				case 6:
					System.out.print("enter employee id: ");
					id = in.nextInt();
					dao.deleteEmployee(id);
					break;
				case 0:
					System.exit(0);
				default: break;
				}
			} while (choice != 0);

		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		
		
			System.out.println("success");

		}
	}	
}
		
		

		/*
		 * SessionFactory factory = new
		 * Configuration().configure().addAnnotatedClass(Employee.class).
		 * buildSessionFactory(); Session session = factory.getCurrentSession();
		 * Employee employee = new Employee();
		 * 
		 * employee.setFirstName("Advika"); employee.setLastName("A");
		 * employee.setEmail("ad@gmail.com"); session.getTransaction().begin();
		 * session.persist(employee); session.getTransaction().commit();
		 */


