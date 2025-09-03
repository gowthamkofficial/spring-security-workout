package com.offcl.spring_security_workout.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleRequestDto {

	@NotBlank(message="Kindly provide rolename")
	private String roleName;
}
