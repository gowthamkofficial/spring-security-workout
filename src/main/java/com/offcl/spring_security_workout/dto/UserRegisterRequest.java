package com.offcl.spring_security_workout.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterRequest {
	
	@NotBlank(message="Kindly provide name")
	private String name;
	
	@NotBlank(message="Kindly provide email")
	@Email(message="Kindly provide a valid email")
	private String email;
	
	@NotBlank(message="Kindly provide  mobile number")
	private String mobileNumber;
	
	@NotNull(message="Kindly provide  the role")
	private Long roleId;
	
	@NotBlank(message="Kindly provide password")
	@Size(min=8,message="Password should have atleast 8 characters ")
	private String password;

}
