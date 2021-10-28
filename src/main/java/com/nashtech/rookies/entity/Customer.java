package com.nashtech.rookies.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(columnNames = {"phone_number"})},
        indexes = {@Index(name = "customer_name_index", columnList = "name")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    private LocalDate dob;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    private Boolean sex;

    @Column(name = "create_date")
    @NotNull
    private LocalDateTime createDate;

    public Customer(Long userId, String name, String phoneNumber, LocalDateTime createDate) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob + '\'' +
                ", sex=" + sex +
                ", createDate=" + createDate +
                '}';
    }
}
