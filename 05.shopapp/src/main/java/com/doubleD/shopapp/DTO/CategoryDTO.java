package com.doubleD.shopapp.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data // to String
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @NotEmpty (message = "Category's name cannot empty")
    private String name;
}
