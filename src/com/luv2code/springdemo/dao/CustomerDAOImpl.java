package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Customer> getCustomers() {

		//get current hibernate session
		Session session=factory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery=session.createQuery("from Customer order by lastName", 
				Customer.class);
		
		//execute query and get result list
		List<Customer> customers=theQuery.getResultList();
		
		//System.out.println("in DAO: "+customers);
		
		//return the results
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get current hibernate session
		Session session=factory.getCurrentSession();
		
		//save / update the customer
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session session=factory.getCurrentSession();
		
		Customer theCustomer=session.get(Customer.class, theId);
		
		return theCustomer;
	
	}

}
