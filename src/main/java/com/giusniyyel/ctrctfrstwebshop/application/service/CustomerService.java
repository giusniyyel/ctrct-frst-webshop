package com.giusniyyel.ctrctfrstwebshop.application.service;


import com.giusniyyel.ctrctfrstwebshop.domain.port.CustomerRepositoryDTO;
import com.giusniyyel.openapi.models.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepositoryDTO customerRepositoryDTO;
    
    public CustomerService(CustomerRepositoryDTO customerRepositoryDTO) {
        this.customerRepositoryDTO = customerRepositoryDTO;
    }

    public Iterable<Customer> getAll() {
        return customerRepositoryDTO.getAll();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepositoryDTO.getCustomerById(id);
    }

    public Customer save(Customer customer) {
        return customerRepositoryDTO.save(customer);
    }
}
