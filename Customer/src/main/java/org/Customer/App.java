package org.Customer;

import java.util.List;
import java.util.Scanner;

import org.Customer.app.factory.CustomerFactory;
import org.Customer.app.factory.CustomerFactoryImpl;
import org.Customer.app.module.Customer;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			CustomerFactory impl = new CustomerFactoryImpl();
			int choice;

			do {
				System.out.println("1. Create customer.");
				System.out.println("2. Display customer details.");
				System.out.println("3. Find customer by Id.");
				System.out.println("4. Update customer.");
				System.out.println("5. Remove customer.");
				System.out.println("0. Exit customer.");
				System.out.println("Enter your choice:");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.print("ID: ");
					int id = scanner.nextInt();
					System.out.print("NAME: ");
					String name = scanner.next();
					System.out.print("EMAIL: ");
					String email = scanner.next();

					// CustomerFactory impl = new CustomerFactoryImpl();
					Customer customer = impl.createCustomer(id, name, email);
					System.out.println(customer.toString());

					break;

				case 2:
					List<Customer> list = impl.getAllCustomer();
					for (Customer c : list) {
						System.out.println(c);
					}
					break;

				case 3:
					System.out.println("Enter id to search");
					int id1 = scanner.nextInt();
					impl.findById(id1);
					break;
				case 4:
					System.out.println("Enter id to update");
					int id2 = scanner.nextInt();
					impl.updateCustomer(id2);
					break;

				case 5:
					System.out.println("Enter id to delete");
					int id3 = scanner.nextInt();
					impl.deleteCustomer(id3);
					break;

				case 0:
					System.exit(0);
					System.out.println("Bye");
					break;
				default:
					System.out.println("Invalid choice");
				}

			} while (choice != 0);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
