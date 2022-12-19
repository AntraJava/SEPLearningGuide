package com.antra.sep.springdatajpademo;

import com.antra.sep.springdatajpademo.dao.DishRespository;
import com.antra.sep.springdatajpademo.entity.Dish;
import com.antra.sep.springdatajpademo.entity.DishIngredientAssoc;
import com.antra.sep.springdatajpademo.entity.Ingredient;
import com.antra.sep.springdatajpademo.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@SpringBootApplication
public class SpringDataJpaDemoApplication implements CommandLineRunner {

    @Autowired
    EntityManager em;

    @Autowired
    DishRespository dishRespository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        System.out.println(dishRespository.findByName("bacon burger"));

        //  m.getDishes().forEach(System.out::println);
//        System.out.println(em.find(Ingredient.class, 5));
//        System.out.println(em.find(Dish.class, 4));
//        System.out.println(em.find(DishIngredientAssoc.class, 6));
    }
}
