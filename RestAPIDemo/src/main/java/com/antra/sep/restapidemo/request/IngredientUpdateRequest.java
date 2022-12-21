package com.antra.sep.restapidemo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class IngredientUpdateRequest {
    private int id;
    @Length(min=3, max = 20, message = "Ingredient Name Should be 3-20 characters")
    private String name;
}
