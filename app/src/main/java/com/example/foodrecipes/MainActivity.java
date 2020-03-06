package com.example.foodrecipes;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.foodrecipes.Adapters.RecyclerViewHomeAdapter;
import com.example.foodrecipes.Adapters.ViewPagerHeadAdapter;
import com.example.foodrecipes.Models.Categories;
import com.example.foodrecipes.Models.Meals;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.viewPagerHeader)
    ViewPager viewPagerMeal;

    @BindView(R.id.recyclerViewCategory)
    RecyclerView recyclerViewCategory;

    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new HomePresenter(this);
        presenter.getMeals();
        presenter.getCategory();
    }

    @Override
    public void showLoading() {

        findViewById(R.id.shimmerMeal).setVisibility(View.VISIBLE);
        findViewById(R.id.category_shimmer).setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {

        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
        findViewById(R.id.category_shimmer).setVisibility(View.GONE);

    }

    @Override
    public void setMeal(List<Meals.Meal> meal) {

        ViewPagerHeadAdapter viewPagerHeadAdapter = new ViewPagerHeadAdapter(meal, this);
        viewPagerMeal.setAdapter(viewPagerHeadAdapter);
        viewPagerMeal.setPadding(20, 0, 150, 0);
        viewPagerHeadAdapter.notifyDataSetChanged();
    }

    @Override
    public void setCategory(List<Categories.Category> category) {

        RecyclerViewHomeAdapter recyclerViewHomeAdapter = new RecyclerViewHomeAdapter(category, this);
        recyclerViewCategory.setAdapter(recyclerViewHomeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerViewCategory.setLayoutManager(layoutManager);
        recyclerViewCategory.setNestedScrollingEnabled(true);
        recyclerViewHomeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "title", message);

    }
}
