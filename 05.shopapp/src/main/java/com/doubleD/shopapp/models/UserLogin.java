package com.doubleD.shopapp.models;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserLogin {
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "password")
    private String password;
}
