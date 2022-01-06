package com.example.ezyfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;
import com.example.ezyfood.model.Order;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolder> {
    ArrayList<Order> orders;

    public PaymentAdapter(ArrayList<Order> orders) {
        this.orders = orders;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View viewItems = layoutInflater.inflate(R.layout.order2_item_view, parent, false);

        PaymentAdapter.ViewHolder holder = new PaymentAdapter.ViewHolder(viewItems);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);

        TextView itemTV = holder.itemTV;
        itemTV.setText(order.getItemName() + "  -    Rp. " +order.getItemPrice() + "\nQuantity: "+order.getQuantity()+"\nPrice: Rp. "+order.calculate());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView itemTV;
        public Button itemBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTV = itemView.findViewById(R.id.itemOR_tv);
            itemBtn = itemView.findViewById(R.id.itemOR_btn);

        }
    }
}
