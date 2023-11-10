package com.giusniyyel.ctrctfrstwebshop.infrastructure.adapter;

import com.giusniyyel.ctrctfrstwebshop.domain.dto.CustomerEntity;
import com.giusniyyel.ctrctfrstwebshop.domain.port.CustomerRepository;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions.ResourceNotFoundException;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.rest.mapper.CustomerMapper;
import com.giusniyyel.openapi.models.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
@Slf4j
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerCrudRepository customerCrudRepository;
    private final CustomerMapper mapper;

    @Override
    public Iterable<Customer> getAll() {
        log.info("Getting list of customers");
        Iterable<CustomerEntity> customers = customerCrudRepository.findAll();
        return mapper.toCustomerIterable(customers);
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        log.info("Getting Customer with id: {}", id);
        CustomerEntity customer = customerCrudRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found")
        );
        return Optional.of(mapper.toCustomer(customer));
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = mapper.toCustomerEntity(customer);
        log.info("Saving Customer: {}", customerEntity);
        return mapper.toCustomer(customerCrudRepository.save(customerEntity));
    }
}
