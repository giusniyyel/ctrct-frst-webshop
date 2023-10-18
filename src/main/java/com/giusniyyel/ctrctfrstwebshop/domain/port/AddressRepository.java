package com.giusniyyel.ctrctfrstwebshop.domain.port;


import com.giusniyyel.openapi.models.Address;
import java.util.List;

public interface AddressRepository {
    List<Address> getAll();
    Address getAddressById(Integer id);
    Address save(Address address);
}
