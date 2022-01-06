package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.model.Order;

import java.util.ArrayList;

public class TransActivity extends AppCompatActivity {
    String item_name;
    int item_price;
    int quantity;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);

        EditText etm_quantity = (EditText) findViewById(R.id.etm_quantity);
        TextView itemName_tv = findViewById(R.id.item_name);
        TextView itemPrice_tv = findViewById(R.id.item_price);

        intent = getIntent();
        item_name = intent.getStringExtra("name").toString();
        item_price = Integer.parseInt(intent.getStringExtra("price").toString());


        itemName_tv.setText(item_name);
        itemPrice_tv.setText("Rp. "+item_price);

    }

    public void btn_myorder_onclick(View view) {
        intent = getIntent();
        quantity = Integer.parseInt(((EditText) findViewById(R.id.etm_quantity)).getText().toString());
        MyOrderActivity.orderlist.add(new Order(item_name, item_price, quantity));
        Intent intents = new Intent(this, MyOrderActivity.class);
        startActivity(intents);
    }

    public void btn_ordermore_onclick(View view) {
        intent = getIntent();
        quantity = Integer.parseInt(((EditText) findViewById(R.id.etm_quantity)).getText().toString());
        MyOrderActivity.orderlist.add(new Order(item_name, item_price, quantity));
        Intent intents = new Intent(this, MainActivity.class);
        startActivity(intents);
        finish();
    }
}