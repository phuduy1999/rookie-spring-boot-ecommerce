package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.entity.Role;
import com.nashtech.rookies.repository.RoleRepository;
import com.nashtech.rookies.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
