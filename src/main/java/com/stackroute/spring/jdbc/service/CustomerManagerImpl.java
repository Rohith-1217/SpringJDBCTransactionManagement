package com.stackroute.spring.jdbc.service;

import com.stackroute.spring.jdbc.model.Movie;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.spring.jdbc.dao.CustomerDAO;
import com.stackroute.spring.jdbc.model.Movie;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional
	public void createMovie(Movie movie ) {
		customerDAO.create(movie);
	}

}