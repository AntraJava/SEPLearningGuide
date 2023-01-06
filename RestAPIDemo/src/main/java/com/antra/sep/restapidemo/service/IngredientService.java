package com.antra.sep.restapidemo.service;

import com.antra.sep.restapidemo.entity.Ingredient;
import com.antra.sep.restapidemo.request.IngredientUpdateRequest;
import com.antra.sep.restapidemo.response.IngredientResponse;
import com.antra.sep.restapidemo.response.PageResponse;

import java.util.List;

public interface IngredientService {
    IngredientResponse getIngredientById(int id);

    List<IngredientResponse> getAllIngredient();

    PageResponse<IngredientResponse> getAllIngredientByPage(int page, int rowPerPage);

    IngredientResponse addIngredient(IngredientUpdateRequest request);

    IngredientResponse updateIngredient(IngredientUpdateRequest request);

    IngredientResponse deleteIngredientById(int id);
}
