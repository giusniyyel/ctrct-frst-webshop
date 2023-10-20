package com.giusniyyel.ctrctfrstwebshop.domain.port;


import com.giusniyyel.ctrctfrstwebshop.domain.dto.CustomerEntity;
import com.giusniyyel.openapi.models.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryDTO {
    Iterable<Customer> getAll();
    Optional<Customer> getCustomerById(Integer id);
    Customer save(Customer customer);
}
