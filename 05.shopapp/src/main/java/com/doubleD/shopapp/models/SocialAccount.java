package com.doubleD.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "social_accounts")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "provider", nullable = false, length = 20)
    private String provider;
    @Column(name = "provider_id", nullable = false, length = 150)
    private String providerId;
    @Column(name = "email", nullable = false, length = 150)
    private String email;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
