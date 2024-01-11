package com.doubleD.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_details")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "oder_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Float price;
    @Column(name = "number_of_products")
    private String numberOfProducts;
    @JoinColumn(name = "total_money")
    private Float totalMoney;
    private String color;

}
