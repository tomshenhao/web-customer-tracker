package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {

		//get current hibernate session
		Session session=factory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery=session.createQuery("from Customer", Customer.class);
		
		//execute query and get result list
		List<Customer> customers=theQuery.getResultList();
		
		//System.out.println("in DAO: "+customers);
		
		//return the results
		return customers;
		
	}

}
