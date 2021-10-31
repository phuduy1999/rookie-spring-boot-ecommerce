package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.CustomerDto;
import com.nashtech.rookies.dto.UserDto;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto, String email);

    void updateCustomer(CustomerDto customerDto, Long id);

    void deleteCustomer(Long id);
}
