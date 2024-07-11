package com.example.springWeekTwo.services.demploy;


import com.example.springWeekTwo.models.Customer;
import com.example.springWeekTwo.repositories.CustomerRepository;
import com.example.springWeekTwo.services.i_Service.I_CustomerService;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements I_CustomerService {

    private final CustomerRepository customerRepository;//them autowired

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer)throws JpaObjectRetrievalFailureException, JpaSystemException {
        return customerRepository.save(customer);
    }


    @Override
    public List<Customer> getAllCustomers() throws JpaObjectRetrievalFailureException, JpaSystemException {
        return customerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        //DESC la giam
    }

    @Override
    public Customer findCustomerByEmail(String email)throws JpaObjectRetrievalFailureException, JpaSystemException {
        return customerRepository.findByEmail(email);
    }

    @Override
    public String getAllCustomersToString() {
        StringBuilder s= new StringBuilder();
        for(Customer customer:getAllCustomers())
        {
            s.append(customer.toString()).append("\n");
        }
        return s.toString();
        //xuat ra chuoi
    }

    @Override
    public void deleteCustomerByEmail(String email) throws JpaObjectRetrievalFailureException, JpaSystemException{
        Customer customer=findCustomerByEmail(email);
        if(customer!=null){
            customerRepository.delete(customer);
        }
    }
// Customer customerAdd=new Customer(
//                5L,
//                "minhnguyenson@edu.com",
//                "Vietnam (+84)",
//                "0412544098",
//                "1234",
//                "Nguyen Van Son",
//                "HCM",
//                "Male");
    @Override
    public void updateCustomerByEmail(Customer customer) throws JpaSystemException {
        Customer customerFind=findCustomerByEmail(customer.getEmail());
        if(customerFind!=null){
            customerFind.setEmail(customer.getEmail());
            customerFind.setCodeCountry(customer.getCodeCountry());
            customerFind.setPhoneNumber(customer.getPhoneNumber());
            customerFind.setPassword(customer.getPassword());
            customerFind.setName(customer.getName());
            customerFind.setAddress(customer.getAddress());
            customerFind.setGender(customer.getGender());
            customerRepository.save(customerFind);
        }
    }

    @Override
    public Long getCustomerIdMax() {
        Long idMax=Long.MIN_VALUE;
        if(getAllCustomers().isEmpty()){
            return 0L;
        }else{
            for(Customer customer:getAllCustomers())
            {
                /*
                if (product.getProductId() > maxProductId)
				maxProductId = product.getProductId();
                 */
                if(customer.getId()>idMax){
                    idMax=customer.getId();
                }
            }
            return idMax;
        }
    }

    @Override
    public List<Customer> getAllCustomers_SortById() {
        return customerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        //giai thich: cta toi gian truy van dua tren method findAll sort tu spring boot
    }

    @Override
    public Customer getCustomerById(Long id) throws JpaSystemException,JpaObjectRetrievalFailureException{
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer with ID " + id + " not found"));
    }
}
