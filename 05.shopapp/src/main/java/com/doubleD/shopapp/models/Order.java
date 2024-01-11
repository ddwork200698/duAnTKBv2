package com.doubleD.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @Column(name = "email", nullable = false, length = 150)
    private String email;
    @Column(name = "note", nullable = false, length = 255)
    private String note;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @PrePersist
    protected void onCreate(){
        this.orderDate = LocalDateTime.now();
    }
    @Column(name = "status")
    private String status;
    @Column(name = "total_money")
    private Float totalMoney;
    @Column(name = "active")
    private boolean active;
    @Column(name = "shipping_method", nullable = false, length = 100)
    private String shippingMethod;
    @Column(name = "shipping_address", nullable = false, length = 100)
    private String shippingAddress;
    @Column(name = "shipping_date")
    private LocalDateTime shippingDate;
    @Column(name = "tracking_number", nullable = false, length = 100)
    private String trackingNumber;
    @Column(name = "payment_method", nullable = false, length = 10)
    private String paymentMethod;
}
