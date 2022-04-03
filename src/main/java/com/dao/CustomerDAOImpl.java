package com.dao;	

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by last_name", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		var session = sessionFactory.getCurrentSession();

		session.save(customer);

	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		var session = sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		
		var session = sessionFactory.getCurrentSession();
		
		var query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
		
	}

}
