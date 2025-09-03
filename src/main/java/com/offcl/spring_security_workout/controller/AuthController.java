package com.offcl.spring_security_workout.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcl.spring_security_workout.dto.UserRegisterRequestDto;
import com.offcl.spring_security_workout.dto.UserResponseDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	
	@PostMapping("/register")
	public UserResponseDto registerUser(@RequestBody UserRegisterRequestDto dto) {
		
		return null;
	}
	
	


}
