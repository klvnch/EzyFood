package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.adapters.BevAdapter;
import com.example.ezyfood.adapters.OrderAdapter;
import com.example.ezyfood.model.Order;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {
    public static ArrayList<Order> orderlist = new ArrayList<Order>();
    int total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView totalTV = findViewById(R.id.total_tv);

        for(int i =0;i<orderlist.size();i++){
            total += orderlist.get(i).calculate();
        }
        String totalstr = Integer.toString(total);
        totalTV.setText("Total: "+totalstr);

        RecyclerView mainRVOrder = (RecyclerView) findViewById(R.id.RV_order);
        OrderAdapter adapter = new OrderAdapter(orderlist);
        mainRVOrder.setAdapter(adapter);
        mainRVOrder.setLayoutManager(new LinearLayoutManager(this));
    }

    public void btn_back_onclick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btn_pay_onclick(View view) {
        if(total > 0){
            if(TopupActivity.balance < total){
                Toast.makeText(this, "Insufficient Balance", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TopupActivity.class);
                startActivity(intent);
            }else{
                TopupActivity.balance = TopupActivity.balance - total;
                Intent intent = new Intent(this, OrderCompActivity.class);
                startActivity(intent);
            }
        }else{
            Toast.makeText(this, "No Item at the moment", Toast.LENGTH_SHORT).show();
        }
    }

}