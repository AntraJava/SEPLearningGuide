package com.antra.sep.restapidemo.service;

import com.antra.sep.restapidemo.entity.Ingredient;
import com.antra.sep.restapidemo.exception.IngredientNotFoundException;
import com.antra.sep.restapidemo.repository.IngredientRepository;
import com.antra.sep.restapidemo.request.IngredientUpdateRequest;
import com.antra.sep.restapidemo.response.IngredientResponse;
import com.antra.sep.restapidemo.response.PageResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public Ingredient getIngredientById(int id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
        return ingredientOptional.orElseThrow(IngredientNotFoundException::new);
    }

    @Override
    public List<IngredientResponse> getAllIngredient() {
        return ingredientRepository.findAll().stream().map( ingredient -> {
            IngredientResponse resp = new IngredientResponse();
//            resp.setId(ingredient.getId());
//            resp.setName(ingredient.getName());
            BeanUtils.copyProperties(ingredient, resp);
            return resp;
        }).collect(Collectors.toList());

    }

    @Override
    public PageResponse<IngredientResponse> getAllIngredientByPage(int page, int rowPerPage) { //SQL :  limit  offset
        PageResponse<IngredientResponse> response = new PageResponse<>();
        Page<Ingredient> p  = ingredientRepository.findAll(PageRequest.of(page, rowPerPage));
        response.setTotalPage(p.getTotalPages());
        response.setTotalRow((int)p.getTotalElements());
        response.setCurrentPage(page);
        response.setData(
         p.stream().map( ingredient -> {
            IngredientResponse resp = new IngredientResponse();
            BeanUtils.copyProperties(ingredient, resp);
            return resp;
        }).collect(Collectors.toList()));
        return response;
    }

    @Override
    public IngredientResponse addIngredient(IngredientUpdateRequest request) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(request.getName());
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        IngredientResponse resp = new IngredientResponse();
        BeanUtils.copyProperties(savedIngredient, resp);
        return resp;
    }

    @Override
    public IngredientResponse updateIngredient(IngredientUpdateRequest request) {
        Ingredient ingredient = this.getIngredientById(request.getId());
        ingredient.setName(request.getName());
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        IngredientResponse resp = new IngredientResponse();
        BeanUtils.copyProperties(savedIngredient, resp);
        return resp;
    }

    @Override
    public IngredientResponse deleteIngredientById(int id) {
        Ingredient ingredient = this.getIngredientById(id);
        ingredientRepository.deleteById(id);
        IngredientResponse resp = new IngredientResponse();
        BeanUtils.copyProperties(ingredient, resp);
        return resp;
    }
}
