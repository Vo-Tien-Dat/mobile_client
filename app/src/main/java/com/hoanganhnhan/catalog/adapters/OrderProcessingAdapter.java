package com.hoanganhnhan.catalog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.interfaces.OnOrderCancel;
import com.hoanganhnhan.catalog.interfaces.OnRedirect;
import com.hoanganhnhan.catalog.models.Order;

import java.util.ArrayList;

public class OrderProcessingAdapter extends RecyclerView.Adapter<OrderProcessingAdapter.OrderProcessingViewHolder>{

    private ArrayList<Order> orderList;
    private Context context;

    OnOrderCancel onOrderCancel;

    OnRedirect onRedirect;

    String orderStatusID;

    public OrderProcessingAdapter(ArrayList<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }




    public void setOnRedirect(OnRedirect onRedirect){
        this.onRedirect = onRedirect;
    }

    public void setOnOrderCancel(OnOrderCancel onOrderCancel){
        this.onOrderCancel = onOrderCancel;
    }

    public OrderProcessingAdapter(ArrayList<Order> orderList){
        this.orderList = orderList;
    }

    public void setListOrder(ArrayList<Order> orderList){
        this.orderList = orderList;
        this.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public OrderProcessingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_order_processing, parent, false);
        return new OrderProcessingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderProcessingViewHolder holder, int position){
        Order order = orderList.get(position);
        String orderID = order.getMaDonHang();
        holder.tvOrderProcessingID.setText(order.getMaDonHang());
        holder.tvOrderProcessingTime.setText(order.getThoiGian());
        holder.tvOrderProcessingPaymentMethod.setText(Integer.valueOf(order.getThanhTien()).toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onRedirect != null){
                    onRedirect.getId(v, orderID);
                }
            }
        });
        holder.tvOrderProcessingCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onOrderCancel != null){
                    onOrderCancel.getId(v, orderID);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }


    public class OrderProcessingViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivOrderProcessing;
        private TextView tvOrderProcessingID;
        private TextView tvOrderProcessingPaymentMethod;
        private TextView tvOrderProcessingTime;
        private TextView tvOrderProcessingPrice;
        private TextView tvOrderProcessingCancel;

        FrameLayout flOrderFragment;
        public OrderProcessingViewHolder(@NonNull View itemView){
            super(itemView);
            ivOrderProcessing = itemView.findViewById(R.id.ivOrderProcessing);
            tvOrderProcessingID = itemView.findViewById(R.id.tvOrderProcessingID);
            tvOrderProcessingTime = itemView.findViewById(R.id.tvOrderProcessingTime);
            tvOrderProcessingPaymentMethod = itemView.findViewById(R.id.tvOrderProcessingPaymentMethods);
            tvOrderProcessingPrice = itemView.findViewById(R.id.tvOrderProcessingPrice);
            tvOrderProcessingCancel = itemView.findViewById(R.id.btnOrderProcessingCancel);
        }
    }
}
