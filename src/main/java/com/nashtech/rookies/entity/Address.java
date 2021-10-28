package com.nashtech.rookies.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(name = "street_and_number")
    @NotBlank
    private String streetAndNumber;

    @NotBlank
    private String city;

    @NotBlank
    private String district;

    @NotBlank
    private String ward;

    private String detail;

    @Column(name = "contact_name")
    @NotBlank
    private String contactName;

    @Column(name = "contact_number")
    @NotBlank
    private String contactNumber;

    @NotBlank
    private String tag;

    @Column(name = "is_default_address")
    private Boolean isDefaultAddress;

    @Column(name = "is_payment_address")
    private Boolean isPaymentAddress;

    @OneToMany(mappedBy = "address")
    private List<Order> orders;

}
