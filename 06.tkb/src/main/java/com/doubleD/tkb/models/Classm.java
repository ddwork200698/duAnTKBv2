package com.doubleD.tkb.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "classm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classm {
    @Id
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "object_id")
    private Objectm object;
}
