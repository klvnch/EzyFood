package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ezyfood.adapters.OrderAdapter;
import com.example.ezyfood.adapters.PaymentAdapter;

public class OrderCompActivity extends AppCompatActivity {
    int total =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_comp);
        TextView totalTV = findViewById(R.id.totalOC_tv);

        for(int i =0;i<MyOrderActivity.orderlist.size();i++){
            total += MyOrderActivity.orderlist.get(i).calculate();
        }
        String totalstr = Integer.toString(total);
        totalTV.setText("Total: "+totalstr);

        RecyclerView mainRVOrder = (RecyclerView) findViewById(R.id.RV_order);
        PaymentAdapter adapter = new PaymentAdapter(MyOrderActivity.orderlist);
        mainRVOrder.setAdapter(adapter);
        mainRVOrder.setLayoutManager(new LinearLayoutManager(this));
    }

    public void btn_home_onclick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        MyOrderActivity.orderlist.clear();
        startActivity(intent);
    }
}