package com.project.indriver_backend_sb.repositories;

import com.project.indriver_backend_sb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
