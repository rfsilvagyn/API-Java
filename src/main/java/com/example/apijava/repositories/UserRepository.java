package com.example.apijava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apijava.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
