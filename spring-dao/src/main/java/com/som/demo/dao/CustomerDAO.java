package com.som.demo.dao;

import com.som.demo.model.Customer;

public interface CustomerDAO {

	public void insert(Customer customer);

	public Customer findByCustomerId(int id);
}
