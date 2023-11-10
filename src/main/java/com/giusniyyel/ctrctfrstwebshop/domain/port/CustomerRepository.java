package com.giusniyyel.ctrctfrstwebshop.domain.port;


import com.giusniyyel.openapi.models.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Iterable<Customer> getAll();
    Optional<Customer> getCustomerById(Integer id);
    Customer save(Customer customer);
}
