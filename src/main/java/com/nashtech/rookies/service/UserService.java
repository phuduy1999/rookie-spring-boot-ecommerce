package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.RateDto;
import com.nashtech.rookies.dto.UserDto;
import com.nashtech.rookies.entity.RoleName;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<UserDto> findAllUser();

    UserDto findUserByEmail(String email);

    RateDto findByIdUser(Long id);

    void createUser(UserDto userDto);
//
//    void updateUser(UserDto userDto, Long id);
//
//    void deleteUser(Long id);

    void addRoleToUser(String email, RoleName roleName);

}
