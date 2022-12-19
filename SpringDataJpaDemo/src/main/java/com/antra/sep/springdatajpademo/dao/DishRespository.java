package com.antra.sep.springdatajpademo.dao;

import com.antra.sep.springdatajpademo.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRespository extends JpaRepository<Dish, Integer> {
    List<Dish> findByNameaAndAndCategoryIgnoreCaseOrderByIdDesc(String name, String category);
}
