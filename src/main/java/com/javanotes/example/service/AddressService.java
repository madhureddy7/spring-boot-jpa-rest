package com.javanotes.example.service;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.javanotes.example.dao.AddressRepository;
import com.javanotes.example.domain.AddressDto;
import com.javanotes.example.entities.Address;

@Service
public class AddressService {

	private static final String PLEASE_PROVIDE_A_VALID_ADDRESS_ID = "please provide a valid address Id";

	private static final String NO_RECORDS_FOUND = "no records found";

	private static final String PLEASE_PROVIDE_A_VALID_REQUEST_PAYLOAD = "please provide a valid request payload";

	@Autowired
	private AddressRepository addressRepository;

	/**
	 * This method is used to fetch the address based on the addressId
	 * @param addressId- unique Id of the address
	 * @return AddressDto- response object containing the address details
	 */
	public AddressDto getAddress(@NotNull int addressId) {

		final Optional<Address> addressResponse=addressRepository.findById(addressId);
		if(!addressResponse.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,NO_RECORDS_FOUND);
		}
		final Address address=addressResponse.get();
		return addressDtoMapper(address);

	}

	/**
	 * Method used to create the address
	 * @param addressDto- request object containing the address information to be created
	 * @return AddressDto- response object containing the address details created
	 */
	public AddressDto createAddress(@Valid AddressDto addressDto) {
		final Address address= new Address();
		 addressEntityMapper(addressDto,address);
		final Address addressCreated=addressRepository.save(address);
		return addressDtoMapper(addressCreated);
	}


	/**
	 * Method used to update the address
	 * @param addressDto- request object containing the address information to be created
	 * @return AddressDto- response object containing the address details updated
	 */
	public AddressDto updateAddress(@Valid AddressDto addressDto) {
		final Optional<Address> addressResponse=addressRepository.findById(addressDto.getAddressId());
		if(!addressResponse.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,PLEASE_PROVIDE_A_VALID_REQUEST_PAYLOAD);
		}
		final Address address=addressResponse.get();
		addressEntityMapper(addressDto,address);
		addressRepository.save(address);
		return addressDto;
	}

	/**
	 * Method used to delete the address based on the addressId
	 * @param addressDto
	 */
	public void deleteAddress(@Valid @NotNull int  addressId) {
		final Optional<Address> addressResponse=addressRepository.findById(addressId);
		if(!addressResponse.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,PLEASE_PROVIDE_A_VALID_ADDRESS_ID);
		}
		final Address address = addressResponse.get();
		addressRepository.delete(address);
	}

	/**
	 * Method used to map the DTO object to the Entity object of address
	 */
	private Address addressEntityMapper(AddressDto addressDto,Address address) {
		address.setAddressLineOne(addressDto.getAddressLineOne());
		address.setAddressLineTwo(addressDto.getAddressLineTwo());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setState(addressDto.getState());
		address.setZipCode(addressDto.getZipCode());
		return address;
	}

	/**
	 * Method used to map the Entity object to the DTO object of address
	 */
	private AddressDto addressDtoMapper(Address address) {
		final AddressDto addressDto= new AddressDto();
		addressDto.setAddressId(address.getAddressId());
		addressDto.setAddressLineOne(address.getAddressLineOne());
		addressDto.setAddressLineTwo(address.getAddressLineTwo());
		addressDto.setCity(address.getCity());
		addressDto.setCountry(address.getCountry());
		addressDto.setState(address.getState());
		addressDto.setZipCode(address.getZipCode());
		return addressDto;
	}

}
