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
    private String phone_name;
    private String address;
    private String password;
    private Date created_at;
    private Date updated_at;
    private int is_active;
    private int role_id;
}
