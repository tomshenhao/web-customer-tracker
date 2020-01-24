package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get customers from the dao
		List<Customer> theCustomers=customerDAO.getCustomers();
		
		//System.out.println("in controller"+theCustomers);
		
		//add customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
}
