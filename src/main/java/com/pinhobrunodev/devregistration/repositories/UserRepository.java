package com.pinhobrunodev.devregistration.repositories;

import com.pinhobrunodev.devregistration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
