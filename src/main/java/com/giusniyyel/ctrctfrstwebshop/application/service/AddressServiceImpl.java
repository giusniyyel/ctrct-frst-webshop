package com.giusniyyel.ctrctfrstwebshop.application.service;

import com.giusniyyel.ctrctfrstwebshop.domain.port.AddressRepository;
import com.giusniyyel.openapi.models.Address;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.getAddressById(id);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.getAll();
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }
}
