package com.example.apijava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.apijava.dtos.UserRecordDto;
import com.example.apijava.models.UserModel;
import com.example.apijava.repositories.UserRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<UserModel> add(@RequestBody @Valid UserRecordDto userRecordDto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> get(@PathVariable(value = "id") Integer id) {
        Optional<UserModel> userObject = userRepository.findById(id);

        if (userObject.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userObject.get());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id,
            @RequestBody @Valid UserRecordDto userRecordDto) {
        Optional<UserModel> userObject = userRepository.findById(id);

        if (userObject.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        var userModel = userObject.get();
        BeanUtils.copyProperties(userRecordDto, userModel);

        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userModel));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
        Optional<UserModel> userObject = userRepository.findById(id);

        if (userObject.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        userRepository.delete(userObject.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }

}
