package com.offcl.spring_security_workout.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offcl.spring_security_workout.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	
	boolean existsByRoleName(String roleName);
	

}
