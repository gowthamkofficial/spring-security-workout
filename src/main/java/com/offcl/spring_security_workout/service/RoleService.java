package com.offcl.spring_security_workout.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcl.spring_security_workout.common.enums.ResponseStatus;
import com.offcl.spring_security_workout.common.response.ApiResponse;
import com.offcl.spring_security_workout.dto.RoleRequestDto;
import com.offcl.spring_security_workout.dto.RoleResponseDto;
import com.offcl.spring_security_workout.entity.Role;
import com.offcl.spring_security_workout.exception.AlreadyExistsException;
import com.offcl.spring_security_workout.mappers.UserMapper;
import com.offcl.spring_security_workout.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;

    public ApiResponse<RoleResponseDto> createRole(RoleRequestDto dto) {
        if (this.roleRepo.existsByRoleName(dto.getRoleName())) {
            throw new AlreadyExistsException("Role already exists " + dto.getRoleName());
        }

        Role role = Role.builder().roleName(dto.getRoleName())
                .build();

        Role saved = this.roleRepo.save(role);

        return new ApiResponse<>(ResponseStatus.Success, "Created role successfully", UserMapper.mapRoleResponse(saved));
    }

    public ApiResponse<List<RoleResponseDto>> getAllRoles() {
        List<RoleResponseDto> roleList = this.roleRepo.findAll()
                .stream()
                .map(UserMapper::mapRoleResponse)
                .collect(Collectors.toList());

        return new ApiResponse<>(ResponseStatus.Success, "Listed roles successfully", roleList);
    }
}
