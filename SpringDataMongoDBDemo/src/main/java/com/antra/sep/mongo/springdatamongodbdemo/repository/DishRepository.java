package com.antra.sep.mongo.springdatamongodbdemo.repository;

import com.antra.sep.mongo.springdatamongodbdemo.entity.Dish;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DishRepository extends MongoRepository<Dish, String> {
}
