package com.antra.sep.restapidemo.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class IngredientResponse implements Serializable {
    private int id;
    private String name;
}
