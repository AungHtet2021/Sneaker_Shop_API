package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    public User create(User user) {

        user.setName(user.getName());
        user.setGmail(user.getGmail());
        
//        String psdEncode = passwordEncoder.encode("user_psd");
//        System.out.println("psdEncode -- " + psdEncode);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirm_password(passwordEncoder.encode(user.getConfirm_password()));
        user.setPhone(user.getPhone());
        return userRepository.save(user);

    }

    //User Login
    public User checkLoginUser(String gmail,String password) {
        User user = userRepository.findByGmail(gmail);
        if(user == null) {
            return null;
        }
        if(!passwordEncoder.matches(password,user.getPassword())) {
            return null;
        }
        return user;
    }


}
