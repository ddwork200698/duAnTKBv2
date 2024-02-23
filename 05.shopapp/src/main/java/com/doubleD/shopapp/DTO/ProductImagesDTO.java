package com.doubleD.shopapp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImagesDTO {
    @JsonProperty("product_id")
    @NotNull(message = "product_id can not be null")
    private Long productID;
    private String url;
}
