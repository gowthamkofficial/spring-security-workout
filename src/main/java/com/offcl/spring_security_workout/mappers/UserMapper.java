package com.offcl.spring_security_workout.mappers;



import com.offcl.spring_security_workout.dto.RoleResponseDto;
import com.offcl.spring_security_workout.dto.UserResponseDto;
import com.offcl.spring_security_workout.entity.Role;
import com.offcl.spring_security_workout.entity.User;

public class UserMapper {

	
	
	public static UserResponseDto mapUserResponse(User user) {
		
		return UserResponseDto.builder()
				.userId(user.getId())
				.email(user.getEmail())
				.name(user.getName())
				.mobileNumber(user.getMobileNumber())
				.roleDetails(UserMapper.mapRoleResponse(user.getRole())).build();
	}
	
	
	public static RoleResponseDto mapRoleResponse(Role role) {
		return RoleResponseDto.builder().roleId(role.getId()).roleName(role.getRoleName()).build();
				
	}
} 
