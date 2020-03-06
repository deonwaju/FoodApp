package com.example.foodrecipes;

import com.example.foodrecipes.Models.Categories;
import com.example.foodrecipes.Models.Meals;

import java.util.List;

public interface HomeView {

    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> Meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);

}
