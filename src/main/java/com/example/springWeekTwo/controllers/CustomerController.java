package com.example.springWeekTwo.controllers;

import com.example.springWeekTwo.models.Customer;
import com.example.springWeekTwo.services.demploy.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    //private final DatabaseConfiguration databaseConfiguration;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) throws JpaSystemException {
        return customerService.saveCustomer(customer);
        //return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) throws JpaSystemException{
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
    /*
    Chung ta co the find theo cac field khac
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Customer customer = customerService.getCustomerByEmail(id);
        return ResponseEntity.ok(customer);
    }
     */
    //doi voi field khac thi phai them 1 cai
    // duong dan la thuoc tinh sau do moi dc truyen
    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) throws JpaSystemException {
        Customer customer = customerService.findCustomerByEmail(email);
        return ResponseEntity.ok(customer);
    }
    @PutMapping("/email/{email}")
    public ResponseEntity<Customer> updateCustomerByEmail(@PathVariable String email, @RequestBody Customer updatedCustomer)throws JpaSystemException{
        try {
            if(customerService.findCustomerByEmail(email)!=null){
                customerService.updateCustomerByEmail(updatedCustomer);
                return ResponseEntity.ok(updatedCustomer);
            }
            return ResponseEntity.notFound().build();
        } catch (JpaSystemException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deleteCustomerByEmail(@PathVariable String email) {
        try {
            Customer customer = customerService.findCustomerByEmail(email);
            if (customer != null) {
                customerService.deleteCustomerByEmail(email);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (JpaSystemException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}

