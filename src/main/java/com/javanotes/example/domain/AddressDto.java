package com.javanotes.example.domain;

import lombok.Data;

@Data
public class AddressDto {

	private int addressId;
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String state;
	private String country;
	private String zipCode;
}
