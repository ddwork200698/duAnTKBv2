package com.doubleD.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "token", nullable = false, length = 350)
    private String token;
    @Column(name = "token_type", nullable = false, length = 50)
    private String tokenType;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;
    private boolean revoked;
    private boolean expired;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
