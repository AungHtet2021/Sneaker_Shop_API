package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserService {
    public User create(User user);
    public User checkLoginUser(String gmail,String  password);
}
