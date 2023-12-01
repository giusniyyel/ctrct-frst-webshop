package com.giusniyyel.ctrctfrstwebshop.application.service;


import com.giusniyyel.ctrctfrstwebshop.domain.port.CustomerRepository;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions.CustomerPersistenceException;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions.ResourceNotFoundException;
import com.giusniyyel.openapi.models.Customer;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> getAll() {
        return customerRepository.getAllCustomers();
    }

    public Customer getCustomerById(Integer id) throws ResourceNotFoundException {
        return customerRepository.getCustomerById(id);
    }

    public Customer save(Customer customer) throws CustomerPersistenceException {
        if (customer.getId() != null) {
            customer.setUpdated(OffsetDateTime.now());
        } else {
            customer.setCreated(OffsetDateTime.now());
            customer.setUpdated(OffsetDateTime.now());
        }
        return customerRepository.save(customer);
    }
}
