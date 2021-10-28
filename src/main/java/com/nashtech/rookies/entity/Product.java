package com.nashtech.rookies.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product", indexes = {@Index(name = "product_name_index", columnList = "name")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    @NotBlank
    private String name;

    private String description;

    private String model;

    private String size;

    private Float weight;

    private String material;

    private short warranty;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_date")
    @NotNull
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductDetail> productDetails;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    public Product(Long id, String name, String description, String model,
                   String size, Float weight, String material, short warranty,
                   String imageUrl, LocalDateTime createDate, Category category,
                   Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.model = model;
        this.size = size;
        this.weight = weight;
        this.material = material;
        this.warranty = warranty;
        this.imageUrl = imageUrl;
        this.createDate = createDate;
        this.category = category;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                ", warranty=" + warranty +
                ", imageUrl='" + imageUrl + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}