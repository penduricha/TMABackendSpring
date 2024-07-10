package com.example.springWeekTwo.services.i_Service;

import com.example.springWeekTwo.models.Customer;

import java.util.List;

public interface I_CustomerService {
    public Customer saveCustomer(Customer customer) ;
    public List<Customer> getAllCustomers();
    public Customer findCustomerByEmail(String email);
    public String getAllCustomersToString();
    public void deleteCustomerByEmail(String email);
    public void updateCustomerByEmail(Customer customer) ;
    public Long getCustomerIdMax();
    //sort
    public List<Customer> getAllCustomers_SortById();
    public Customer getCustomerById(Long id);

}
