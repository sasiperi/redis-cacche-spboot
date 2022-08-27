package com.example.cache.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cache.entity.Customer;
import com.example.cache.service.CustomerService;

import io.lettuce.core.RedisCommandExecutionException;
import jakarta.persistence.EntityNotFoundException;

@RestController
public class CustomerController 
{
	 
	private CustomerService customerService;
	
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
	
    //look aside catching test
    @GetMapping(value = "/customer")
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();

    }
    
	// look aside catching test
    @GetMapping(value = "/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) throws InterruptedException
    {
        return customerService.getCustomerById(id);

    }
    
    
    @GetMapping(value = "/customer/ssn/{ssn}")
    public Customer getCustomerBySsn(@PathVariable("ssn") int ssn) throws EntityNotFoundException, RedisCommandExecutionException, InterruptedException
    {
        return customerService.getCustomerBySsn(ssn);

    }
    
    //look aside catching test
    @PostMapping(value = "/customer")
    public Customer createCustomerById(@RequestBody Customer aCustomer)
    {
        return customerService.saveCustomer(aCustomer);

    }


}
