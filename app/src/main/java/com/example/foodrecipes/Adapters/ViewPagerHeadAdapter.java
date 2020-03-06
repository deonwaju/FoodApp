package com.example.foodrecipes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.foodrecipes.Models.Meals;
import com.example.foodrecipes.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerHeadAdapter extends PagerAdapter {

    private List<Meals.Meal> mealsList;
    private Context context;
    private static ClickListener clickListener;

    public ViewPagerHeadAdapter(List<Meals.Meal> mealsList, Context context) {
        this.mealsList = mealsList;
        this.context = context;
    }

    public static void setClickListener(ClickListener clickListener) {
        ViewPagerHeadAdapter.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return mealsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_header_layout, container, false);

        ImageView mealThumb = view.findViewById(R.id.mealThumb);
        TextView mealName = view.findViewById(R.id.mealName);

        String strMealThumb =mealsList.get(position).getStrMealThumb();
        Picasso.get().load(strMealThumb).into(mealThumb);

        String strMealName = mealsList.get(position).getStrMeal();
        mealName.setText(strMealName);

        view.setOnClickListener(v -> clickListener.onClick(v, position));


        container.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    private interface ClickListener {
        void onClick(View v, int position);
    }
}
