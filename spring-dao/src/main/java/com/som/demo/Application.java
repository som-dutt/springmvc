package com.som.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.som.demo.dao.CustomerDAO;
import com.som.demo.model.Customer;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
//		Customer customer = new Customer(2, "Shyam");
//		customerDAO.insert(customer);
		Customer c1 = customerDAO.findByCustomerId(2);
		System.out.println(c1);
	}
}
