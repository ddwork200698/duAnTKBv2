package com.doubleD.shopapp.DTO;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserLoginDTO {
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "password")
    private String password;
}
