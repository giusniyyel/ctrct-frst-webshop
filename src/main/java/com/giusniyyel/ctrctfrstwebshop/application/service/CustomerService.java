package com.giusniyyel.ctrctfrstwebshop.application.service;


import com.giusniyyel.ctrctfrstwebshop.domain.port.CustomerRepository;
import com.giusniyyel.openapi.models.Customer;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> getAll() {
        return customerRepository.getAll();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.getCustomerById(id);
    }

    public Customer save(Customer customer) {
        if (customer.getId() != null) {
            customer.setUpdated(OffsetDateTime.now());
        } else {
            customer.setCreated(OffsetDateTime.now());
            customer.setUpdated(OffsetDateTime.now());
        }
        return customerRepository.save(customer);
    }
}
