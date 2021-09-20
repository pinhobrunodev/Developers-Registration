package com.pinhobrunodev.devregistration.repositories;

import com.pinhobrunodev.devregistration.entities.Address;
import com.pinhobrunodev.devregistration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
