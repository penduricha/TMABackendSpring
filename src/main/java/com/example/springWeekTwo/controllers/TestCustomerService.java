package com.example.springWeekTwo.controllers;

import com.example.springWeekTwo.models.Customer;
import com.example.springWeekTwo.services.demploy.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCustomerService {
    //import class de goi cac func sang controller
    private final CustomerService customerService;

    @Autowired
    public TestCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    @RequestMapping("/post")
    public String postDataCustomer()throws JpaObjectRetrievalFailureException {
        Customer customerAdd=new Customer(
                customerService.getCustomerIdMax()+1,
                "minhnguyensonlam@edu.com",
                "Vietnam (+84)",
                "0212544098",
                "1234",
                "Nguyen Lam Minh Son",
                "HCM",
                "Male");
//        Customer customerAdd=new Customer();
//        customerAdd.setEmail("minhnguyen@edu.com");
//        customerAdd.setCodeCountry("Vietnam (+84)");
//        customerAdd.setPhoneNumber("0312544098");
//        customerAdd.setPassword("1234");
//        customerAdd.setName("Nguyen Van Minh");
//        customerAdd.setAddress("HCM");
//        customerAdd.setGender("Male");
        if(customerService.saveCustomer(customerAdd)!=null){
            return "Adding customer successfully";
        }else{
            return "Adding customer failed";
        }
    }
    @RequestMapping("/get")
    public String getDataCustomer()throws JpaObjectRetrievalFailureException {
        return customerService.getAllCustomersToString();
    }
    @RequestMapping("/delete")
    public String deleteDataCustomer() throws JpaObjectRetrievalFailureException {
        String emailDelete="minhnguyen@edu.com";
        customerService.deleteCustomerByEmail(emailDelete);
        return "Del Success";
    }
    @RequestMapping("/put")
    public String updateDataCustomer() throws JpaObjectRetrievalFailureException {
        Customer customerUpdate=new Customer(
                5L,
                "minhnguyenson@edu.com",
                "Vietnam (+84)",
                "0581646635",
                "12345",
                "Nguyen Van Ngoc Son",
                " Vn",
                "Male");
        customerService.updateCustomerByEmail(customerUpdate);
        return "Put (Update) Success";
    }
    @RequestMapping("/maxid")
    public String getIdMax() throws JpaObjectRetrievalFailureException {
        return Long.toString(customerService.getCustomerIdMax());
    }

}
