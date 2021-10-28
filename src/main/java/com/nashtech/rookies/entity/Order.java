package com.nashtech.rookies.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_customer", indexes = {@Index(name = "order_userid_index", columnList = "user_id"),
        @Index(name = "order_dates_index", columnList = "create_date, update_date")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    private Short status;

    @Column(name = "create_date")
    @NotNull
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "payment_method")
    @NotBlank
    private String paymentMethod;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "payment_status")
    @NotNull
    private Short paymentStatus;

    @Transient
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private Float total;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rate> rates;

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", address=" + address +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", paymenStatus=" + paymentStatus +
                ", total=" + total +
                '}';
    }
}
