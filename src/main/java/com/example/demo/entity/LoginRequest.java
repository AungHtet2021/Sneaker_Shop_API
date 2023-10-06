package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

        @NotBlank(message = "Required")
        private String gmail;

        @NotBlank(message = "Required")
        private  String password;
}
