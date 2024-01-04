package com.doubleD.shopapp.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data // to String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
    @NotEmpty (message = "Category's name cannot empty")
    private String name;
}
