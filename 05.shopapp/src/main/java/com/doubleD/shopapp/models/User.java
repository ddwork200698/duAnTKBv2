package com.doubleD.shopapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @NotNull(message="Phone number can not be null")
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotNull(message = "Password can not be null")
    @Column(name = "password")
    private String password;
    private String address;
    @Column(name = "created_at")
    private Date createAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "is_active")
    private Long isActive;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "facebook_account_id")
    private Integer facebookAccountId;
    @Column(name = "google_account_id")
    private Integer googleAcountId;
    @NotNull(message = "Role id cannot be null")
    @Column(name = "role_id")
    private Long roleId;
}
