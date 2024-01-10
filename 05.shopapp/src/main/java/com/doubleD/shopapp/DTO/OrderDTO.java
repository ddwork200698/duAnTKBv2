package com.doubleD.shopapp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    @JsonProperty("user_id")
    @NotNull(message = "user_id can not be null")
    private Long userId;
    private String fullname;
    private String email;
    @JsonProperty("phone_number")
    @NotNull(message = "phone_number can not be null")
    private String phoneNumber;
    private String address;
    private String note;
    @JsonProperty("total_money")
    @Min(value = 0, message = "total_money must be >= 0")
    private Float totalMoney;
    @JsonProperty("shipping_address")
    private String shippingAddress;
    @JsonProperty("shipping_method")
    private String shippingMethod;
}
