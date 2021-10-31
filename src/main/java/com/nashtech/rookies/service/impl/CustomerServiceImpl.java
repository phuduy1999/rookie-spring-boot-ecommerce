package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.dto.CustomerDto;
import com.nashtech.rookies.dto.UserDto;
import com.nashtech.rookies.entity.Customer;
import com.nashtech.rookies.entity.User;
import com.nashtech.rookies.repository.CustomerRepository;
import com.nashtech.rookies.repository.UserRepository;
import com.nashtech.rookies.service.CustomerService;
import com.nashtech.rookies.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    @Override
    public void createCustomer(CustomerDto customerDto, String email) {
        User user = userRepository.findUserByEmail(email);
        log.error(user.toString());
        Customer customer = MapperUtil.mapOne(customerDto, Customer.class);
        customer.setUser(user);
        customer.setUserId(user.getId());
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerDto customerDto, Long id) {

    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
