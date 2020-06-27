package com.Hotel.RoomBookingManagementSystem.Repository.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hotel.RoomBookingManagementSystem.Entity.CustomerEntity;
import com.Hotel.RoomBookingManagementSystem.Repository.ServiceImpl.CustomerServiceimpl;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustomerServiceimpl customerServiceimpl;

	//This method give the customer details.
	@GetMapping(value = "/all")
	public List<CustomerEntity> getCustomers() {
		//System.out.println(this.getClass().getSimpleName() + "Get all Customers service is invoked.");
		return customerServiceimpl.getCustomers();
	}
	//This method get Customer details by id.
	@GetMapping(value = "/{id}")
	public CustomerEntity getCustomerById(@PathVariable Long id) throws Exception {
		//System.out.println(this.getClass().getSimpleName() + "Get Customer details by id is invoked.");

		Optional<CustomerEntity> customer = customerServiceimpl.getCustomerById(id);
		if (!customer.isPresent())
			throw new Exception("Could not find Customer with id- " + id);

		return customer.get();
	}

	//This method create new Customer details.
	@PostMapping(value = "/add")
	public CustomerEntity createCustomer(@RequestBody CustomerEntity customerEntity) {
		//System.out.println(this.getClass().getSimpleName() + "Create new Customer method is invoked.");
		return customerServiceimpl.addNewCustomer(customerEntity);
	}
}
