package com.nashtech.rookies.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "product_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetail {
    @Id
    @SequenceGenerator(
            name = "product_detail_sequence",
            sequenceName = "product_detail_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_detail_sequence"
    )
    private Long id;

    @NotBlank
    private String color;

    @NotNull
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0", message = "Price must be not below 0")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "productDetail", fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rate> rates;

    public ProductDetail(String color, Integer quantity, Float price, Product product) {
        this.color = color;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
