package com.example.foodrecipes.api;

import com.example.foodrecipes.Models.Categories;
import com.example.foodrecipes.Models.Meals;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {

    @GET("random.php")
    Call<Meals> getMeals();

    @GET("categories.php")
    Call<Categories> getCategories();

}
