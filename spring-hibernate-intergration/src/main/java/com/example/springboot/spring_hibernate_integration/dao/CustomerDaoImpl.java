
package com.example.springboot.spring_hibernate_integration.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.spring_hibernate_integration.entity.Customer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository

public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Customer createcustomer(Customer theCustomer) {
		Session session = this.sessionFactory.openSession();
		session.save(theCustomer);
		System.out.println("Saved!");
		return theCustomer;

	}

	@Override
	public List<Customer> getAllCustomer() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer", Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public List<Customer> getCustomerByFirstName(String fname) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer where firstname=: firstName", Customer.class);
		query.setParameter("firstName", fname);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Customer updateCustomer(String fname, String lname, String email, int id) {
		Session session = sessionFactory.openSession();
		Customer cust = session.find(Customer.class, id);
		if (cust != null) {
			cust.setFirstname(fname);
			cust.setLastname(lname);
			cust.setEmail(email);

			session.getTransaction().begin();
			session.saveOrUpdate(cust);
			session.getTransaction().commit();
		}

		return cust;
	}

}
