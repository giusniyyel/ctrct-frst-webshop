package com.giusniyyel.ctrctfrstwebshop.infrastructure.rest.mapper;


import com.giusniyyel.ctrctfrstwebshop.domain.dto.CustomerEntity;
import com.giusniyyel.openapi.models.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "currentAddressId", target = "currentAddressId")
    @Mapping(source = "created", target = "created", qualifiedByName = "dateToOffsetDateTime")
    @Mapping(source = "updated", target = "updated", qualifiedByName = "dateToOffsetDateTime")
    Customer toCustomer(CustomerEntity customerEntity);

    Iterable<Customer> toCustomerIterable(Iterable<CustomerEntity> customerEntityList);

    @InheritInverseConfiguration
    @Mapping(source = "created", target = "created", qualifiedByName = "offsetDateTimeToDate")
    @Mapping(source = "updated", target = "updated", qualifiedByName = "offsetDateTimeToDate")
    CustomerEntity toCustomerEntity(Customer customer);

    @Named("dateToOffsetDateTime")
    default OffsetDateTime mapDateToOffsetDateTime(Date date) {
        if (date == null) {
            return null;
        }
        if (date instanceof Timestamp) {
            return date.toInstant().atOffset(ZoneOffset.UTC);
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toOffsetDateTime();
    }

    @Named("offsetDateTimeToDate")
    default Date mapOffsetDateTimeToDate(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        return Date.from(offsetDateTime.toInstant());
    }
}