package com.antra.sep.restapidemo.service;

import com.antra.sep.restapidemo.entity.Ingredient;
import com.antra.sep.restapidemo.exception.IngredientNotFoundException;
import com.antra.sep.restapidemo.repository.IngredientRepository;
import com.antra.sep.restapidemo.request.IngredientUpdateRequest;
import com.antra.sep.restapidemo.response.IngredientResponse;
import com.antra.sep.restapidemo.response.PageResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    @Cacheable(cacheNames = "ingredient", key = "#id")
    public IngredientResponse getIngredientById(int id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
        IngredientResponse resp = new IngredientResponse();
        BeanUtils.copyProperties(ingredientOptional.get(), resp);
        return resp;
    }

    @Override
    @Cacheable(cacheNames = "ingredient", key = "'AllIngredient'")
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
    @CacheEvict(cacheNames = "ingredient", allEntries = true)
    public IngredientResponse addIngredient(IngredientUpdateRequest request) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(request.getName());
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        IngredientResponse resp = new IngredientResponse();
        BeanUtils.copyProperties(savedIngredient, resp);
        return resp;
    }

    @Override
    @CachePut(cacheNames = "ingredient", key = "#request.id")
    public IngredientResponse updateIngredient(IngredientUpdateRequest request) {
        Ingredient ingredient = ingredientRepository.findById(request.getId()).get();
        ingredient.setName(request.getName());
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        IngredientResponse resp = new IngredientResponse();
        BeanUtils.copyProperties(savedIngredient, resp);
        return resp;
    }

    @Override
    public IngredientResponse deleteIngredientById(int id) {
        Ingredient ingredient = ingredientRepository.findById(id).get();
        ingredientRepository.deleteById(id);
        IngredientResponse resp = new IngredientResponse();
        BeanUtils.copyProperties(ingredient, resp);
        return resp;
    }
}
