package com.nashtech.rookies.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @DecimalMin(value = "0", message = "Price must be not below 0")
    @Column(name = "price")
    private float price;

//    @Column(name = "image_url")
//    private String imageUrl;

    @Column(name = "image_url")
    @ElementCollection
    @JoinTable(name = "product_image_url", joinColumns = @JoinColumn(name = "product_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<String> imageUrls;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Category category;

    @OneToMany(mappedBy = "product")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Rate> rates;
}