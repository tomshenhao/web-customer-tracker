package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the customer dao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get customers from the dao
		List<Customer> theCustomers=customerService.getCustomers();
		
		//System.out.println("in controller"+theCustomers);
		
		//add customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
}
