package com.nashtech.rookies.repository;

import com.nashtech.rookies.entity.Role;
import com.nashtech.rookies.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(RoleName roleName);
}
