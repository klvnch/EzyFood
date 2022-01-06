package com.example.ezyfood.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.DrinkActivity;
import com.example.ezyfood.R;
import com.example.ezyfood.TransActivity;
import com.example.ezyfood.model.Beverage;
import com.example.ezyfood.model.Drinks;

import java.util.ArrayList;

public class BevAdapter extends RecyclerView.Adapter<BevAdapter.ViewHolder>{
    ArrayList<Beverage> listitem;

    public BevAdapter(ArrayList<Beverage> listDrink) {
        this.listitem = listDrink;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View viewItems = layoutInflater.inflate(R.layout.item_view, parent, false);

        ViewHolder holder = new ViewHolder(viewItems);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Beverage beverage = listitem.get(position);

        TextView itemTV = holder.itemTV;
        itemTV.setText(beverage.getBeverageName() + "  -    Rp. " +beverage.getPrice());
        Button itemBtn = holder.itemBtn;
        itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TransActivity.class);
                String name = beverage.getBeverageName();
                String price = Integer.toString(beverage.getPrice());
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView itemTV;
        public Button itemBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTV = itemView.findViewById(R.id.item_tv);
            itemBtn = itemView.findViewById(R.id.item_btn);

        }
    }
}
