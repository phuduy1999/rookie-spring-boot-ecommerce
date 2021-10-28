package com.nashtech.rookies.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "organization", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})},
        indexes = {@Index(name = "organization_name_index", columnList = "name", unique = true)})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organization {
    @Id
    @SequenceGenerator(
            name = "organization_sequence",
            sequenceName = "organization_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "organization_sequence"
    )
    private Long id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "organization")
    private List<Brand> brands;

    @OneToMany(mappedBy = "organization")
    private List<Address> addresses;
}
