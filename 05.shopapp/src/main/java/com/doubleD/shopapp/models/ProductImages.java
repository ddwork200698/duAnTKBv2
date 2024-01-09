package com.doubleD.shopapp.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImages {
    private Long id;
    @Column(name = "product_id")
    @NotNull(message = "product_id can not be null")
    private Long productID;
    private String url;
}
