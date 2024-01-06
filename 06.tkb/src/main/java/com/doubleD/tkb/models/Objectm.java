package com.doubleD.tkb.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "objects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Objectm {
    @Id
    private int id;
    private String name;

}
