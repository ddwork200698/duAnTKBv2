package com.doubleD.shopapp.models;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Long id;
    private String name;
}
