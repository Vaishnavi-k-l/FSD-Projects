package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao
{
	private SessionFactory factory = null;
	private Session session;

	{
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomer() 
	{
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer", Customer.class);
		List<Customer> list = query.getResultList();
		session.getTransaction().commit();
		return list;
	}

	public void createCustomer(Customer c)
	{
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.persist(c);
			session.getTransaction().commit();

		} finally {
			session.close();
		}
		
	}

	@Override
	public void deleteCustomer(Customer customer)
	{
		try 
		{
			session = factory.openSession();
			session.getTransaction().begin();
			session.remove(customer);
			session.getTransaction().commit();
		}
		finally 
		{
			session.close();
		}
		
	}

	@Override
	public Customer getCustomerById(int id)
	{
		session = factory.openSession();
		session.getTransaction().begin();
		Customer c= session.get(Customer.class,id);
		session.getTransaction().commit();
		return c;
	}

	@Override
	public void updateCustomer(Customer c)
	{
		
		session = factory.openSession();
		session.getTransaction().begin();
		session.update(c);
		session.getTransaction().commit();
	}

	@Override
	public List<Customer> findCustomer(String str)
	{
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Customer WHERE name like concat('%',:customerName,'%') or type like concat('%',:customermail, '%') or email like concat('%',:customertype, '%')");
        query.setParameter("customerName", str);
        query.setParameter("customermail", str);
        query.setParameter("customertype",str);
        session.getTransaction().commit();

		return query.getResultList();
	}

	@Override
	public List<Customer> getAscending() 
	{
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer c ORDER BY c.name ASC", Customer.class);
		List<Customer> list = query.getResultList();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<Customer> getDescending()
	{
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer c ORDER BY c.name DESC", Customer.class);
		List<Customer> list = query.getResultList();
		session.getTransaction().commit();
		return list;
	}

}
