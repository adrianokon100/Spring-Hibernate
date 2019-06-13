package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.LastModified;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	
	// need to inject the session factory
	@Autowired 
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query - sort by last name
		Query<Customer> theQuery = currentSession.createQuery("FROM Customer ORDER BY lastName", Customer.class);
				
		// execute query and get Result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results
		
		
		return customers;
	}

	@Override
	public Customer getCustomer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		int theId = theCustomer.getId();
		String theFirstName = theCustomer.getFirstName();
		String theLastName = theCustomer.getLastName();

	System.out.println("Id is = "+theId);
	System.out.println("firstName is = "+theFirstName);
	System.out.println("lastName is = "+theLastName);
		
		// save/update the customer ... 
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public void deleteCustomer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete FROM Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			
			theQuery = currentSession.createQuery("FROM Customer WHERE lower(firstName) like :theName OR"
					+ " lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		}
		
		else {
			//theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("FROM Customer", Customer.class);	
		}
		
		List<Customer> theCustomers = theQuery.getResultList();				
		return theCustomers;	
	}
	
}
