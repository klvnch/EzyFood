package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ezyfood.adapters.BevAdapter;
import com.example.ezyfood.model.Beverage;
import com.example.ezyfood.model.Drinks;
import com.example.ezyfood.model.Foods;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    ArrayList<Beverage> foodlist = new ArrayList<Beverage>(){
        {
            add(new Foods("Nasi Goreng", 123));
            add(new Foods("Omelette", 123));
            add(new Foods("Smoked Beef", 123));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        RecyclerView mainRVDrinks = (RecyclerView) findViewById(R.id.RV_food);
        BevAdapter adapter = new BevAdapter(foodlist);
        mainRVDrinks.setAdapter(adapter);
        mainRVDrinks.setLayoutManager(new LinearLayoutManager(this));
    }
}