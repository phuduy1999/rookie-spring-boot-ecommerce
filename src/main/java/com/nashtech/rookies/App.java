package com.nashtech.rookies;

import com.nashtech.rookies.dto.CustomerDto;
import com.nashtech.rookies.dto.UserDto;
import com.nashtech.rookies.entity.RoleName;
import com.nashtech.rookies.service.CustomerService;
import com.nashtech.rookies.service.RoleService;
import com.nashtech.rookies.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner run(RoleService roleService, UserService userService, CustomerService customerService) {
        return args -> {
//            CustomerDto customerDto = new CustomerDto(null, LocalDateTime.now(),
//                    "duy", null, null, null, null);
//            UserDto userDto = new UserDto(null, "duy123@gmail.com","1234", null, (short) 1);
//            userService.createUser(userDto);
//            customerService.createCustomer(customerDto, "duy123@gmail.com");
//            userService.addRoleToUser("duy123@gmail.com", RoleName.ROLE_CUSTOMER);
//            userService.addRoleToUser("duy123@gmail.com", RoleName.ROLE_EMPLOYEE);
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
