package com.example.cache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.cache.entity.Customer;
import com.example.cache.repository.CustomerRepository;

import io.lettuce.core.RedisCommandExecutionException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerService
{

    @Autowired
    CustomerRepository custRepo;
    
    
    /*
     * Look aside (read through cache).
     */

    @Cacheable("customer")
    public Customer getCustomerById(Long id) throws EntityNotFoundException, InterruptedException, RedisCommandExecutionException
    {
        Thread.sleep(10000);
        Optional<Customer> customerOp = custRepo.findById(id);
        return customerOp.get();
    }
    
    @Cacheable("customer")
    public Customer getCustomerBySsn(int ssn) throws EntityNotFoundException, RedisCommandExecutionException
    {
        return custRepo.findBySsn(ssn);
    }

    
    /*
     * Writethrough cache.
     */
    @Cacheable(value = "customer", key = "#aCustomer.getSsn()")
    //@Cacheable(value = "customer")
    public Customer saveCustomer(Customer aCustomer) throws IllegalArgumentException, RedisCommandExecutionException
    {
        return custRepo.save(aCustomer);
    }

    public List<Customer> getAllCustomers()
    {
        return custRepo.findAll(Sort.by(Direction.ASC, "customerId"));
    }

    /*
    @CacheEvict("cutomer")
    public void resetCounter(Long id) {
        // TO - DO
    }
    */
    
}
