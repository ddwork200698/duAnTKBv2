package com.doubleD.tkb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String phone_number;
    private String address;
    private String password;
    private Date created_at;
    private Date updated_at;
    private int is_active;
    private int role_id;

    public User(String fullname, String phone_number, String address, String password, Date created_at, Date updated_at, int is_active, int role_id) {
        this.fullname = fullname;
        this.phone_number = phone_number;
        this.address = address;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.is_active = is_active;
        this.role_id = role_id;
    }
}
