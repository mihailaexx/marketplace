package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.Address;
import org.example.marketplace.repository.AddressRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(long id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Address not found")
        );
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddressById(long id) {
        addressRepository.deleteById(id);
    }
}
