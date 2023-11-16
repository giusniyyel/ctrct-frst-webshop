package com.giusniyyel.ctrctfrstwebshop.application.service;

import com.giusniyyel.ctrctfrstwebshop.domain.port.CustomerRepository;
import com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions.ResourceNotFoundException;
import com.giusniyyel.openapi.models.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void getAllCustomersAndValidAllAreReturned() {
        when(customerRepository.getAll()).thenReturn(Arrays.asList(
                createCustomer(1, null, Customer.GenderEnum.MALE, LocalDate.now(), "Daniel", "Campos", "john@example.com"),
                createCustomer(2, null, Customer.GenderEnum.FEMALE, LocalDate.now(), "Linda", "May", "lin@example.com")
        ));

        Iterable<Customer> customers = customerService.getAll();

        assertEquals(2, ((List<Customer>) customers).size());
    }

    @Test
    void getCustomerByIdAndValidateThatCustomerExists() {
        when(customerRepository.getCustomerById(1)).thenReturn(
                Optional.of(createCustomer(1, null, Customer.GenderEnum.MALE, LocalDate.now(), "Daniel", "Campos", "john@example.com"))
        );

        Optional<Customer> result = customerService.getCustomerById(1);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
    }

    @Test
    void getCustomerByIdAndValidCustomerDoesNotExists() {
        when(customerRepository.getCustomerById(1)).thenReturn(
                Optional.empty()
        );

        Optional<Customer> result = customerService.getCustomerById(1);

        assertTrue(result.isEmpty());
    }

    @Test
    void saveNewCustomerAndValidItIsCreated() {
        Customer customer = createCustomer(null, 1, Customer.GenderEnum.MALE, LocalDate.now(), "Daniel", "Campos", "john@example.com");
        customer.setCreated(null);
        customer.setUpdated(null);

        customerService.save(customer);

        assertNotNull(customer.getCreated());
        assertNotNull(customer.getUpdated());
        verify(customerRepository, times(1)).save(customer);

    }

    @Test
    void updateExistingCustomerAndValidItIsUpdated() {
        Customer customer = createCustomer(1, 1, Customer.GenderEnum.MALE, LocalDate.now(), "Daniel", "Campos", "john@example.com");
        customer.setUpdated(null);

        customerService.save(customer);

        assertNotNull(customer.getUpdated());
        verify(customerRepository, times(1)).save(customer);

    }

    private Customer createCustomer(Integer id, Integer currentAddressId, Customer.GenderEnum gender, LocalDate dateOfBirth,
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