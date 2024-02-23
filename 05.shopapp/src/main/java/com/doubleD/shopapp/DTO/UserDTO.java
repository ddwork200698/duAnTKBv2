package com.doubleD.shopapp.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    @NotNull(message="Phone number can not be null")
    private String phoneNumber;
    @NotNull(message = "Password can not be null")
    private String password;
    private Date dateOfBirth;
    private String address;
    private Date createAt;
    private Date updatedAt;
    private Long isActive;
    private Integer facebookAccountId;
    private Integer googleAccountId;
    private Long roleId;

}
