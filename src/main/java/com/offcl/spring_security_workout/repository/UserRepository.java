package com.offcl.spring_security_workout.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.offcl.spring_security_workout.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByEmail(String email);
	boolean existsByMobileNumber(String mobileNumber);
	
	Optional<User> findByEmail(String email);

}
