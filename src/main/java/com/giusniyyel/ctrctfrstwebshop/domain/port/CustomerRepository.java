package com.giusniyyel.ctrctfrstwebshop.domain.port;


import com.giusniyyel.openapi.models.Customer;
import java.util.List;

public interface CustomerRepository {
    List<Customer> getAll();
    Customer getCustomerById(Integer id);
    Customer save(Customer customer);
}
