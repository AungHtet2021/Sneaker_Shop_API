package com.example.demo.controller;

import com.example.demo.entity.LoginRequest;
import com.example.demo.entity.User;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	
//	@Autowired
//	BCryptPasswordEncoder psdEnconder;

	//User Register
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register(@Valid @RequestBody User user) {

		User createUser = userService.create(user);
		if (createUser == null) {
			return ResponseEntity.badRequest().body("Already exist gmail!");
		}
		return ResponseEntity.ok().body(createUser);
	}

	//User Login
	@PostMapping(value = "/login")
	public BaseResponse login(@Valid @RequestBody LoginRequest loginRequest) {
		User user = userService.checkLoginUser(loginRequest.getGmail(),loginRequest.getPassword());

		if(user == null){
			System.out.println(user);
			return new BaseResponse(404,"user not found",null);
		}
		return new BaseResponse(200,"success login",user);
	}

//
//	@PostMapping(value = "/login")
//	public ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest) {
//		User user = userService.checkLoginUser(loginRequest.getGmail(),loginRequest.getPassword());
//		System.out.println(user);
//		if(user == null) {
//			return ResponseEntity.badRequest().build();
//		}
//		return ResponseEntity.ok().body(user);
//	}

//	@PostMapping("/encrypt-psd")
//	public ResponseEntity<?> encryptePassword(@Param("psd") String psd) {
//
//		return ResponseEntity.ok().body(psdEnconder.encode(psd));
//	}
//
//	@PostMapping("/test")
//	public ResponseEntity<?> test(@Param("psd") String psd) {
//
//		return ResponseEntity.ok().body(psdEnconder.encode(psd));
//	}
}
