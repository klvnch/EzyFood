package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import com.example.ezyfood.adapters.BevAdapter;
import com.example.ezyfood.model.Beverage;
import com.example.ezyfood.model.Drinks;

public class DrinkActivity extends AppCompatActivity{
    ArrayList<Beverage> drinklist = new ArrayList<Beverage>(){
        {
            add(new Drinks("Air Mineral", 123));
            add(new Drinks("Jus Apel", 123));
            add(new Drinks("Jus Mangga", 123));
            add(new Drinks("Jus Alpukat", 123));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        RecyclerView mainRVDrinks = (RecyclerView) findViewById(R.id.RV_drink);
        BevAdapter adapter = new BevAdapter(drinklist);
        mainRVDrinks.setAdapter(adapter);
        mainRVDrinks.setLayoutManager(new LinearLayoutManager(this));
    }
}