package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView currbalance = findViewById(R.id.currbalance_main);
        currbalance.setText("Current Balance: "+TopupActivity.balance);
    }

    public void btn_drink_onclick(View view) {
        Intent intent = new Intent(this, DrinkActivity.class);
        startActivity(intent);
    }

    public void btn_snack_onclick(View view) {
        Intent intent = new Intent(this, SnackActivity.class);
        startActivity(intent);
    }

    public void btn_food_onclick(View view) {
        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);
    }

    public void btn_order_onclick(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    public void btn_tp_onclick(View view) {
        Intent intent = new Intent(this, TopupActivity.class);
        startActivity(intent);
    }
}