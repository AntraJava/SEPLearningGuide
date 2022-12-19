package com.antra.sep.springdatajpademo.entity;

import javax.persistence.*;

@Entity
@Table(name = "dish_ingredient_association")
public class DishIngredientAssoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "DishIngredientAssoc{" +
                "id=" + id +
                ", dish=" + dish +
                ", ingredient=" + ingredient +
                '}';
    }
}
