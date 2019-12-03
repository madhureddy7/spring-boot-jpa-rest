package com.javanotes.example.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javanotes.example.domain.AddressDto;
import com.javanotes.example.service.AddressService;

/**
 * Controller class for Performing address related operations
 * 
 * @author javaNotes
 *
 */
@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	/**
	 * Rest End point to get the Address based on the Address Id
	 * @param addressId- unique Id for Address
	 * @return AddressDto- response object containing address details
	 */
	@GetMapping(value="address")
	public AddressDto getAddress(@NotNull @RequestParam("addressId") int addressId) {
		
		return addressService.getAddress(addressId);
	}
	
	/**
	 * Rest End point to create the address
	 * @param addressDto- request object containing the address details to be created
	 * @return addressDto- response object with the created address details
	 */
	@PostMapping(value="address")
	public AddressDto createAddress(@Valid @RequestBody AddressDto addressDto) {
		
		return addressService.createAddress(addressDto);
	}
	
	/**
	 * Rest End point to update the address
	 * @param addressDto- request object containing the address details to be updated
	 * @return addressDto- response object with the updated address details
	 */
	@PutMapping(value="address")
	public AddressDto updateAddress(@Valid @RequestBody AddressDto addressDto) {
		
		return addressService.updateAddress(addressDto);
	}
	
	/**
	 *  Rest End point to delete the address based on the address Id
	 * @param addressId-unique Id for Address
	 */
	@DeleteMapping(value="address")
	public void deleteAddress(@NotNull @RequestParam("addressId") int addressId) {
		
		 addressService.deleteAddress(addressId);
	}

}
