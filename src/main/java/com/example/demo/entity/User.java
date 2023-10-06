package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length=15, nullable = false)
    @NotBlank(message = "Required")
    private  String name;

    @Column (length = 50 ,nullable = false,unique = true)
    @NotBlank(message = "Required")
    private  String gmail;

    @Column (nullable = false)
    @NotBlank (message = "Required")
    private String password;

    @Column (nullable = false)
    @NotBlank (message = "Required")
    private String confirm_password;

    @Column (length = 20,nullable = false,unique = true)
    @NotBlank (message = "Required")
    private String phone;

}
