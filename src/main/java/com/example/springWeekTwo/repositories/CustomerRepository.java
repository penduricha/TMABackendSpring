package com.example.springWeekTwo.repositories;

import com.example.springWeekTwo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /*
    chung ta khai bao ham findByEmail trong Repository
     */
    public Customer findByEmail(String email) ;
}

