package com.antra.sep.mongo.springdatamongodbdemo;

import com.antra.sep.mongo.springdatamongodbdemo.entity.Dish;
import com.antra.sep.mongo.springdatamongodbdemo.entity.Ingredient;
import com.antra.sep.mongo.springdatamongodbdemo.repository.DishRepository;
import com.antra.sep.mongo.springdatamongodbdemo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataMongoDbDemoApplication implements CommandLineRunner {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    DishRepository dishRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataMongoDbDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Ingredient ingredient = new Ingredient();
//        ingredient.setName("Banana");
//        ingredient.setPrice(1000);
//        ingredientRepository.save(ingredient);

//        ingredientRepository.findAll().forEach(System.out::println);

        Dish d = dishRepository.findById("63af167341e04f7ed120f73e").get();
        d.getIngredients().get(0).setName("aabbccdd123");
//        Dish dish = new Dish();
//        dish.setName("Mac&Cheese2");
//        dish.setPrice(new BigDecimal("10.99"));
//        List<Ingredient> ingredientList = new ArrayList<>();
//        ingredientList.add(new Ingredient("1","Cheese"));
//        ingredientList.add(new Ingredient("2","Pineapple"));
//        ingredientList.add(new Ingredient("3","Pepper"));
//        dish.setIngredients(ingredientList);

        dishRepository.save(d);
    }
}
