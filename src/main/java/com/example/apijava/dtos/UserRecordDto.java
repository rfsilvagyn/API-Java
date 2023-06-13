package com.example.apijava.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRecordDto(
                @NotBlank String name,
                @NotBlank @Size(min = 5, max = 60) String password) {
}