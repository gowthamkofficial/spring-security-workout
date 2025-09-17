package com.offcl.spring_security_workout.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcl.spring_security_workout.common.response.ApiResponse;
import com.offcl.spring_security_workout.dto.UserLoginRequestDto;
import com.offcl.spring_security_workout.dto.UserRegisterRequest;
import com.offcl.spring_security_workout.dto.UserResponseDto;
import com.offcl.spring_security_workout.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<Map<String,Object>>> login(@RequestBody UserLoginRequestDto dto){
		return ResponseEntity.status(HttpStatus.OK).body(this.userService.login(dto));
	}
	
	
	@PostMapping("/resgister")
	public ResponseEntity<ApiResponse<UserResponseDto>> register(@RequestBody UserRegisterRequest dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(dto));
	}
	
	


}
