package com.example.cache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cache.entity.Customer;


/**
 * Created by sp on 03/15/2017.
 */
@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    List<Customer> findAllByFirstName(@Param("firstName") String firstName);

    //@Cacheable("books")
    List<Customer> findAllByLastName(@Param("lastName") String lastName);

    Customer findBySsn(@Param("ssn") int ssn);

}
