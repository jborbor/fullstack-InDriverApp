package com.project.indriver_backend_sb.repositories;

import com.project.indriver_backend_sb.models.UserHasRoles;
import com.project.indriver_backend_sb.models.id.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHasRolesRepository extends JpaRepository<UserHasRoles, UserRoleId> {
}
