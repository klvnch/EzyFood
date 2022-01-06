package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TopupActivity extends AppCompatActivity {
    public static int balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
        TextView currbalance = findViewById(R.id.currbalance);
        currbalance.setText("Current Balance: "+balance);
    }

    public void btn_tp_onclick(View view) {
        int topUp_input = Integer.parseInt(((EditText) findViewById(R.id.etm_balance)).getText().toString());
        balance += topUp_input;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}