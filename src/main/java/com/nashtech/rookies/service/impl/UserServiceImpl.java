package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.dto.RateDto;
import com.nashtech.rookies.dto.UserDto;
import com.nashtech.rookies.entity.Role;
import com.nashtech.rookies.entity.RoleName;
import com.nashtech.rookies.entity.User;
import com.nashtech.rookies.repository.RoleRepository;
import com.nashtech.rookies.repository.UserRepository;
import com.nashtech.rookies.service.UserService;
import com.nashtech.rookies.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(s);
        if (user == null) {
            log.error("user not in db");
            throw new UsernameNotFoundException("user not in db");
        }
        log.info("user in db: {}", s);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public List<UserDto> findAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = MapperUtil.mapListToStream(users, UserDto.class).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return MapperUtil.mapOne(userRepository.findUserByEmail(email), UserDto.class);
    }

    @Override
    public RateDto findByIdUser(Long id) {
        return null;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = MapperUtil.mapOne(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String email, RoleName roleName) {
        User user = userRepository.findUserByEmail(email);
        Role role = roleRepository.findRoleByRoleName(roleName);
        user.getRoles().add(role);
    }
}
