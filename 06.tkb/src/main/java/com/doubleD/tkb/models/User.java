package com.doubleD.tkb.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private int id;
    private String fullname;
    @Column(unique = true)
    private String phoneNumber;
    private String address;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private int is_active;
    private int role_id;

    public User(String fullname, String phone_number, String address, String password, Date created_at, Date updated_at, int is_active, int role_id) {
        this.fullname = fullname;
        this.phoneNumber = phone_number;
        this.address = address;
        this.password = password;
        this.createdAt = created_at;
        this.updatedAt = updated_at;
        this.is_active = is_active;
        this.role_id = role_id;
    }
}
