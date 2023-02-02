package ma.projects.ws.services;

import java.util.List;

import ma.projects.ws.dtos.AddressDto;

public interface AddressService {

    List<AddressDto> getAllAddresses(String email);

    AddressDto createAddress(AddressDto address, String email);

    AddressDto getAddress(String addressId);

    void deleteAddress(String addressId);
}

