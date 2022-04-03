package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Customer;
import com.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		theModel.addAttribute("customers", customerService.getCustomers());

		return "customers-list";
	}

	@GetMapping("/showFormAdd")
	public String addNewCustomer(Model model) {

		model.addAttribute("customer", new Customer());
		return "add-customer";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";

	}

	@GetMapping("/showFormForUpdate")
	public String updateCustomerForm(@RequestParam("customerId") int customerId, Model model) {

		model.addAttribute("customer", customerService.getCustomer(customerId));
		return "add-customer";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId) {
		
		customerService.deleteCustomer(customerId);
		
		return "redirect:/customer/list";
	}
}
