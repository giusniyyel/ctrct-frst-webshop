package com.giusniyyel.ctrctfrstwebshop.infrastructure.rest.controller;

import com.giusniyyel.ctrctfrstwebshop.application.service.CustomerService;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions.ResourceNotFoundException;
import com.giusniyyel.openapi.models.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    private static Customer expectedCustomer1;
    private static Customer expectedCustomer2;

    @BeforeAll
    static void init() {
        expectedCustomer1 = createCustomer(1, null, Customer.GenderEnum.MALE, LocalDate.now(), "Daniel", "Campos", "john@example.com");
        expectedCustomer2 = createCustomer(2, null, Customer.GenderEnum.FEMALE, LocalDate.now(), "Linda", "May", "lin@example.com");
    }

    @Test
    void getAllCustomersAndReturnListOfCustomers() {
        when(customerService.getAll()).thenReturn(Arrays.asList(expectedCustomer1, expectedCustomer2));

        ResponseEntity<Iterable<Customer>> responseEntity = customerController.getCustomers();
        List<Customer> customersList = (List<Customer>) responseEntity.getBody();


        verify(customerService, times(1)).getAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, customersList.size());
    }

    @Test
    void getCustomerByIdIfCustomerExistsReturnsCustomer() {
        int customerId = expectedCustomer1.getId();
        when(customerService.getCustomerById(customerId)).thenReturn(expectedCustomer1);

        ResponseEntity<Object> response = customerController.getCustomerById(customerId);

        verify(customerService, times(1)).getCustomerById(customerId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCustomer1.getFirstname(), Objects.requireNonNull((Customer) response.getBody()).getFirstname());
    }

    @Test
    void getCustomerByIdIfCustomerDoesNotExistsReturnsNotFound() throws ResourceNotFoundException {
        int customerId = 99;
        when(customerService.getCustomerById(customerId)).thenThrow(ResourceNotFoundException.class);

        ResponseEntity<Object> response = customerController.getCustomerById(customerId);

        verify(customerService, times(1)).getCustomerById(customerId);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void saveCustomer() {
    }

    private static Customer createCustomer(Integer id, Integer currentAddressId, Customer.GenderEnum gender, LocalDate dateOfBirth,
                                           String firstname, String lastname, String email) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setCurrentAddressId(currentAddressId);
        customer.setGender(gender);
        customer.setDateOfBirth(dateOfBirth);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setEmail(email);
        return customer;
    }
}