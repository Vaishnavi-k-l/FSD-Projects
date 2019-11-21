package com.example.dao;

import java.util.List;



import javax.persistence.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.ToDo;
import com.example.entity.ToDoList;


public class DaoImplementation implements DaoInterface
{
	private SessionFactory sessionFactory = null;
	private Session session = null;
	
	private List<ToDo>list = null;
	private List<ToDoList> todolist = null;
	
	
	public DaoImplementation()
	{
		sessionFactory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ToDo.class).
				addAnnotatedClass(ToDoList.class).buildSessionFactory();
	}
	

	@Override
	public List<ToDo> getUser()
	{
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from ToDo");
		session.getTransaction().commit();
		list = query.getResultList();
		return list;
	}


	@Override
	public List<ToDoList> getTodolist()
	{
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from ToDoList");
		session.getTransaction().commit();
		todolist = query.getResultList();
		return todolist;
	}


	@Override
	public void insertTodo(String name)
	{
		ToDoList tdl = new ToDoList();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		tdl.setName(name);
		session.save(tdl);
		session.getTransaction().commit();
	}


	@Override
	public ToDoList getListbyId(int id)
	{
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		ToDoList list = session.get(ToDoList.class,id);
		session.getTransaction().commit();
		return list;
	}


	@Override
	public void Delete(ToDoList list) 
	{
		try 
		{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.remove(list);
			session.getTransaction().commit();
		}
		finally 
		{
			session.close();
		}
		
	}

	
	
	
}
