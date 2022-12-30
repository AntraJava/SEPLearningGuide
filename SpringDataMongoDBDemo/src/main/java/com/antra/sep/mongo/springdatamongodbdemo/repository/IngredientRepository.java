package com.antra.sep.mongo.springdatamongodbdemo.repository;

import com.antra.sep.mongo.springdatamongodbdemo.entity.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    List<Ingredient> findByNameIgnoreCase(String name);
}
