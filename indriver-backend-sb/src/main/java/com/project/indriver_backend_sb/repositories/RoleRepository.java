package com.project.indriver_backend_sb.repositories;

import com.project.indriver_backend_sb.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    boolean existsByName(String name);
}
