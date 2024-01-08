package com.doubleD.tkb.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "objectm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Objectm {
    @Id
    private int id;
    private String name;

}
