package com.giusniyyel.ctrctfrstwebshop.infrastructure.rest.mapper;


import com.giusniyyel.ctrctfrstwebshop.domain.dto.CustomerEntity;
import com.giusniyyel.openapi.models.Customer;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "currentAddressId", target = "currentAddressId")
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    Customer toCustomer(CustomerEntity customerEntity);

    List<Customer> toCustomerList(List<CustomerEntity> customerEntityList);

    @InheritInverseConfiguration
    CustomerEntity toCustomerEntity(Customer customer);
}