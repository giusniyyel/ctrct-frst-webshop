package com.giusniyyel.ctrctfrstwebshop.infrastructure.rest.mapper;

import com.giusniyyel.ctrctfrstwebshop.domain.dto.AddressEntity;
import com.giusniyyel.openapi.models.Address;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AddressMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "address1", target = "address1")
    @Mapping(source = "address2", target = "address2")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "zip", target = "zip")
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    Address toAddress(AddressEntity addressEntity);

    List<Address> toAddressList(List<AddressEntity> addressEntityList);

    @InheritInverseConfiguration
    AddressEntity toAddressEntity(Address address);
}
