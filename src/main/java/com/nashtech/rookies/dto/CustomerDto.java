package com.nashtech.rookies.dto;

import com.nashtech.rookies.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Long userId;
    private LocalDateTime createDate;
    private String name;
    private String phoneNumber;
    private LocalDate dob;
    private List<Address> addresses;
    private Boolean sex;
}
