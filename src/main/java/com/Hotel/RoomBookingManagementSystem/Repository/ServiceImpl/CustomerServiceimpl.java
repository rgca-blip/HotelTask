package com.Hotel.RoomBookingManagementSystem.Repository.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.RoomBookingManagementSystem.Entity.CustomerEntity;
import com.Hotel.RoomBookingManagementSystem.Repository.CustomerRepository;

@Service
public class CustomerServiceimpl {

	@Autowired
	CustomerRepository customerRepository;

	// Return all students
	public List<CustomerEntity> getCustomers() {
		return customerRepository.findAll();
	}

	// Find the student with this id
	public Optional<CustomerEntity> getCustomerById(Long customer_id) {
		return customerRepository.findById(customer_id);
	}

	// Save a new student
	public CustomerEntity addNewCustomer(CustomerEntity customerEntity) {
		return customerRepository.save(customerEntity);
	}
}
