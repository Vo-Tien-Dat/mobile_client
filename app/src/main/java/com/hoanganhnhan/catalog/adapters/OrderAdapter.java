package com.hoanganhnhan.catalog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.interfaces.OnRedirect;
import com.hoanganhnhan.catalog.models.Order;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{

    private ArrayList<Order> orderList;
    private Context context;


    OnRedirect onRedirect;

    public OrderAdapter(ArrayList<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }


    public void setListOrder(ArrayList<Order> orderList){
        this.orderList = orderList;
    }


    public void setOnRedirect(OnRedirect onRedirect){
        this.onRedirect = onRedirect;
    }

    public OrderAdapter(ArrayList<Order> orderList){
        this.orderList = orderList;
    }


    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_order, parent, false);
        return new OrderViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position){
        Order order = orderList.get(position);
        String maDonHang = order.getMaDonHang();
        holder.tvOrderProcessingID.setText(order.getMaDonHang());
        holder.tvOrderProcessingTime.setText(order.getThoiGian());
        holder.tvOrderProcessingPaymentMethod.setText(Integer.valueOf(order.getThanhTien()).toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("pprint on click view");
                if(onRedirect != null){
                    onRedirect.getId(v,maDonHang);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivOrderProcessing;
        private TextView tvOrderProcessingID;
        private TextView tvOrderProcessingPaymentMethod;
        private TextView tvOrderProcessingTime;
        private TextView tvOrderProcessingPrice;
        private TextView tvOrderProcessingCancel;
        public OrderViewHolder(@NonNull View itemView){
            super(itemView);
            ivOrderProcessing = itemView.findViewById(R.id.ivOrderProcessing);
            tvOrderProcessingID = itemView.findViewById(R.id.tvOrderProcessingID);
            tvOrderProcessingTime = itemView.findViewById(R.id.tvOrderProcessingTime);
            tvOrderProcessingPaymentMethod = itemView.findViewById(R.id.tvOrderProcessingPaymentMethods);
            tvOrderProcessingPrice = itemView.findViewById(R.id.tvOrderProcessingPrice);
        }
    }
}
