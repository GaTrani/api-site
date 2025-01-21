package com.gestorauto.api_site.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestorauto.api_site.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

}
