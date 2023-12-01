package com.giusniyyel.ctrctfrstwebshop.infrastructure.adapter;

import com.giusniyyel.ctrctfrstwebshop.domain.dto.CustomerEntity;
import com.giusniyyel.ctrctfrstwebshop.domain.port.CustomerRepository;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions.CustomerPersistenceException;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions.ResourceNotFoundException;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.rest.mapper.CustomerMapper;
import com.giusniyyel.openapi.models.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
@Slf4j
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerCrudRepository customerCrudRepository;
    private final CustomerMapper mapper;

    @Override
    public Iterable<Customer> getAllCustomers() {
        log.debug("Getting list of customers");
        Iterable<CustomerEntity> customers = customerCrudRepository.findAll();
        return mapper.toCustomerIterable(customers);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        log.debug("Getting Customer with id: {}", id);
        CustomerEntity customer = customerCrudRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found")
        );
        return mapper.toCustomer(customer);
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = mapper.toCustomerEntity(customer);
        log.debug("Saving Customer: {}", customerEntity);
        try {
            return mapper.toCustomer(customerCrudRepository.save(customerEntity));
        } catch (DataAccessException e) {
            throw new CustomerPersistenceException("Failed to save customer", e);
        }
    }
}
