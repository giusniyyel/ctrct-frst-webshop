package com.giusniyyel.ctrctfrstwebshop.infrastructure.rest.controller;

import com.giusniyyel.ctrctfrstwebshop.application.service.CustomerService;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions.CustomerPersistenceException;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions.ResourceNotFoundException;
import com.giusniyyel.openapi.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Integer id) throws ResourceNotFoundException {
        try {
            Customer customer = customerService.getCustomerById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PutMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) throws CustomerPersistenceException {
        try {
            return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
        } catch (CustomerPersistenceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
