package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ezyfood.adapters.BevAdapter;
import com.example.ezyfood.model.Beverage;
import com.example.ezyfood.model.Drinks;
import com.example.ezyfood.model.Snacks;

import java.util.ArrayList;

public class SnackActivity extends AppCompatActivity {
    ArrayList<Beverage> snacklist = new ArrayList<Beverage>(){
        {
            add(new Snacks("Potato Chip", 123));
            add(new Snacks("Doritos", 123));
            add(new Snacks("Cheetos", 123));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        RecyclerView mainRVDrinks = (RecyclerView) findViewById(R.id.RV_snack);
        BevAdapter adapter = new BevAdapter(snacklist);
        mainRVDrinks.setAdapter(adapter);
        mainRVDrinks.setLayoutManager(new LinearLayoutManager(this));
    }
}