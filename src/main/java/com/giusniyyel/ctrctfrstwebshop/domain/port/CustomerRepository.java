package com.giusniyyel.ctrctfrstwebshop.domain.port;


import com.giusniyyel.openapi.models.Customer;

public interface CustomerRepository {
    Iterable<Customer> getAllCustomers();
    Customer getCustomerById(Integer id);
    Customer save(Customer customer);
}
