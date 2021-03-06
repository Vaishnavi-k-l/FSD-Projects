package com.myCompany.spring_rest_application.dao;

import com.myCompany.spring_rest_application.entity.Todo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoDAOImpl implements ToDoDAO {
@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Todo> getAllToDo() {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM Todo",Todo.class);
		return query.getResultList();
	}

}