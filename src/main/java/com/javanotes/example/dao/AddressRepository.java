package com.javanotes.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javanotes.example.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
