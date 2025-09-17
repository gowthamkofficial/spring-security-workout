package com.offcl.spring_security_workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcl.spring_security_workout.common.response.ApiResponse;
import com.offcl.spring_security_workout.dto.RoleRequestDto;
import com.offcl.spring_security_workout.dto.RoleResponseDto;
import com.offcl.spring_security_workout.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/createRole")
	public ResponseEntity<ApiResponse<RoleResponseDto>> createRole(@RequestBody RoleRequestDto dto){
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(this.roleService.createRole(dto));
	}
	
	
	
	@GetMapping("/getAllRoles")
	public ResponseEntity<ApiResponse<List<RoleResponseDto>>> getAllRoles() {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.roleService.getAllRoles());
	}


}
