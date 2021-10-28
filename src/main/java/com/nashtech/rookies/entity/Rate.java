package com.nashtech.rookies.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "rate", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"order_id", "product_detail_id", "user_id"})},
        indexes = {@Index(name = "rate_product_detail_id_index", columnList = "product_detail_id"),
                @Index(name = "rate_create_date_index", columnList = "create_date"),
                @Index(name = "rate_user_id_index", columnList = "user_id"),
                @Index(name = "rate_order_id_index", columnList = "order_id")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rate {
    @Id
    @SequenceGenerator(
            name = "rate_sequence",
            sequenceName = "rate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rate_sequence"
    )
    private Long id;

    @Column(name = "rating")
    private Short rating;

    @Column(name = "rate_review")
    private String rateReview;

    @Column(name = "create_date")
    @NotNull
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_detail_id", nullable = false)
    private ProductDetail productDetail;

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", rating=" + rating +
                ", rateReview='" + rateReview + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
