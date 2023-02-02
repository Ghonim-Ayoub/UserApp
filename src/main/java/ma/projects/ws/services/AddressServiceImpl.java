package ma.projects.ws.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projects.ws.entities.AddressEntity;
import ma.projects.ws.entities.UserEntity;
import ma.projects.ws.repositories.AddressRepository;
import ma.projects.ws.repositories.UserRepository;
import ma.projects.ws.services.AddressService;
import ma.projects.ws.utils.Utils;
import ma.projects.ws.dtos.AddressDto;
import ma.projects.ws.dtos.UserDto;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils util;

    @Override
    public List<AddressDto> getAllAddresses(String email) {

        UserEntity currentUser = userRepository.findByEmail(email);

        List<AddressEntity> addresses = currentUser.getAdmin() == true ? (List<AddressEntity>) addressRepository.findAll() : addressRepository.findByUser(currentUser);

        Type listType = new TypeToken<List<AddressDto>>() {}.getType();
        List<AddressDto> addressesDto = new ModelMapper().map(addresses, listType);

        return addressesDto;
    }


    @Override
    public AddressDto createAddress(AddressDto address, String email) {

        UserEntity currentUser = userRepository.findByEmail(email);

        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(currentUser, UserDto.class);

        address.setAddressId(util.generateStringId(30));
        address.setUser(userDto);

        AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class);

        AddressEntity newAddress = addressRepository.save(addressEntity);

        AddressDto addressDto = modelMapper.map(newAddress, AddressDto.class);

        return addressDto;
    }


    @Override
    public AddressDto getAddress(String addressId) {

        AddressEntity addressEntity = addressRepository.findByAddressId(addressId);

        ModelMapper modelMapper = new ModelMapper();

        AddressDto addressDto = modelMapper.map(addressEntity, AddressDto.class);

        return addressDto;
    }

    @Override
    public void deleteAddress(String addressId) {

        AddressEntity address = addressRepository.findByAddressId(addressId);

        if(address == null) throw new RuntimeException("Address not found");

        addressRepository.delete(address);

    }


}
