package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.RateDto;
import com.nashtech.rookies.dto.UserDto;

import java.util.Set;

public interface UserService {
    public Set<UserDto> findAllUser();

    public RateDto findByIdUser(Long id);

    public void createUser(UserDto userDto);

    public void updateUser(UserDto userDto, Long id);

    public void deleteUser(Long id);
}
