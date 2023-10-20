package com.giusniyyel.ctrctfrstwebshop.infrastructure.adapter;

import com.giusniyyel.ctrctfrstwebshop.domain.dto.CustomerEntity;
import com.giusniyyel.ctrctfrstwebshop.domain.port.CustomerRepositoryDTO;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.rest.mapper.CustomerMapper;
import com.giusniyyel.openapi.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepository implements CustomerRepositoryDTO {

    private final CustomerCrudRepository customerCrudRepository;
    private final CustomerMapper mapper;

    public CustomerRepository(CustomerCrudRepository customerCrudRepository, CustomerMapper mapper) {
        this.customerCrudRepository = customerCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public Iterable<Customer> getAll() {
        Iterable<CustomerEntity> customers = customerCrudRepository.findAll();
        return mapper.toCustomerIterable(customers);
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return customerCrudRepository.findById(id).map(mapper::toCustomer);
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = mapper.toCustomerEntity(customer);
        return mapper.toCustomer(customerCrudRepository.save(customerEntity));
    }
}
