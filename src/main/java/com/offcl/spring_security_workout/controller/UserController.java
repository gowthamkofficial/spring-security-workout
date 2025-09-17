package com.offcl.spring_security_workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcl.spring_security_workout.common.response.ApiResponse;
import com.offcl.spring_security_workout.dto.UserResponseDto;
import com.offcl.spring_security_workout.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<ApiResponse<List<UserResponseDto>>> getAllUsers() {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllUsers());
	}
	
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@PathVariable(name="userId",required=true) Long userId) {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.userService.getUserById(userId));
	}
	
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse<String>> updateUser(@PathVariable(name="userId",required=true) Long userId ) {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.userService.deleteUser(userId));
	}
	

}
