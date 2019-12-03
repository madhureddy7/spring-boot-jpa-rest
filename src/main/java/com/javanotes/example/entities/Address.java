package com.javanotes.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="Address")
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Address_Id")
	private int addressId;
	
	@Column(name="Address_Line_One")
	private String addressLineOne;
	
	@Column(name="Address_Line_Two")
	private String addressLineTwo;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Country")
	private String country;
	
	@Column(name="Zip_Code")
	private String zipCode;

}
