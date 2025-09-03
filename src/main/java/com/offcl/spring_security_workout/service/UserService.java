package com.offcl.spring_security_workout.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcl.spring_security_workout.common.enums.ResponseStatus;
import com.offcl.spring_security_workout.common.response.ApiResponse;
import com.offcl.spring_security_workout.dto.UserRegisterRequest;
import com.offcl.spring_security_workout.dto.UserResponseDto;
import com.offcl.spring_security_workout.entity.Role;
import com.offcl.spring_security_workout.entity.User;
import com.offcl.spring_security_workout.exception.AlreadyExistsException;
import com.offcl.spring_security_workout.exception.NotFoundException;
import com.offcl.spring_security_workout.mappers.UserMapper;
import com.offcl.spring_security_workout.repository.RoleRepository;
import com.offcl.spring_security_workout.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserRepository userRepo;

    public ApiResponse<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> userList = this.userRepo.findAll()
                .stream()
                .map(UserMapper::mapUserResponse)
                .collect(Collectors.toList());

        return new ApiResponse<>(ResponseStatus.Success, "Listed users successfully", userList);
    }

    public ApiResponse<UserResponseDto> createUser(UserRegisterRequest dto) {
        if (this.userRepo.existsByEmail(dto.getEmail())) {
            throw new AlreadyExistsException("Email already exists " + dto.getEmail());
        }

        if (this.userRepo.existsByMobileNumber(dto.getMobileNumber())) {
            throw new AlreadyExistsException("Mobile number already exists " + dto.getMobileNumber());
        }

        Role role = this.roleRepo.findById(dto.getRoleId())
                .orElseThrow(() -> new NotFoundException("Role not found with ID " + dto.getRoleId()));

        User user = User.builder()
                .email(dto.getEmail())
                .mobileNumber(dto.getMobileNumber())
                .name(dto.getName())
                .role(role)
                .password(dto.getPassword())
                .build();

        User saved = this.userRepo.save(user);

        return new ApiResponse<>(ResponseStatus.Success, "Created user successfully", UserMapper.mapUserResponse(saved));
    }

    public ApiResponse<UserResponseDto> getUserById(Long id) {
        User user = this.userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID " + id));

        return new ApiResponse<>(ResponseStatus.Success, "Fetched user successfully", UserMapper.mapUserResponse(user));
    }

    public ApiResponse<UserResponseDto> updateUser(Long id, UserRegisterRequest dto) {
        User user = this.userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID " + id));

        if (this.userRepo.existsByEmail(dto.getEmail()) && !user.getEmail().equals(dto.getEmail())) {
            throw new AlreadyExistsException("Email already exists " + dto.getEmail());
        }

        if (this.userRepo.existsByMobileNumber(dto.getMobileNumber()) && !user.getMobileNumber().equals(dto.getMobileNumber())) {
            throw new AlreadyExistsException("Mobile number already exists " + dto.getMobileNumber());
        }

        Role role = this.roleRepo.findById(dto.getRoleId())
                .orElseThrow(() -> new NotFoundException("Role not found with ID " + dto.getRoleId()));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setMobileNumber(dto.getMobileNumber());
        user.setPassword(dto.getPassword());
        user.setRole(role);

        User updated = this.userRepo.save(user);

        return new ApiResponse<>(ResponseStatus.Success, "Updated user successfully", UserMapper.mapUserResponse(updated));
    }

    public ApiResponse<Void> deleteUser(Long id) {
        User user = this.userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID " + id));

        this.userRepo.delete(user);

        return new ApiResponse<>(ResponseStatus.Success, "Deleted user successfully", null);
    }
}
