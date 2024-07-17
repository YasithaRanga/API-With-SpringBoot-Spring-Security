package com.javaspringrecap.javaspringrecap.repository;

import com.javaspringrecap.javaspringrecap.model.ERole;
import com.javaspringrecap.javaspringrecap.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
