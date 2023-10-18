package com.giusniyyel.ctrctfrstwebshop.application.service;


import com.giusniyyel.ctrctfrstwebshop.domain.port.CustomerRepository;
import com.giusniyyel.openapi.models.Customer;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
