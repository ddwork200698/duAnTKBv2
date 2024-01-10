package com.doubleD.shopapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "fullname", length = 100)
    private String fullname;
    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;
    @Column(name = "address", length = 200)
    private String address;
    @Column(name = "password", length = 200)
    private String password;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "facebook_account_id")
    private Integer facebookAccountId;
    @Column(name = "google_account_id")
    private Integer googleAccountId;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
