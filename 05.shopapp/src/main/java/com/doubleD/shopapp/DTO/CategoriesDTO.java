package com.doubleD.shopapp.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data // to String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesDTO {
    @NotEmpty (message = "Category's name cannot empty")
    private String name;
}
