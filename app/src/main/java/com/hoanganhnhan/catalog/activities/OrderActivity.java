package com.hoanganhnhan.catalog.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.adapters.OrderAdapter;
import com.hoanganhnhan.catalog.adapters.OrderProcessingAdapter;
import com.hoanganhnhan.catalog.fragments.OrderFilterFragment;
import com.hoanganhnhan.catalog.interfaces.OnChange;
import com.hoanganhnhan.catalog.interfaces.OnOrderCancel;
import com.hoanganhnhan.catalog.interfaces.OnRedirect;
import com.hoanganhnhan.catalog.mock.OrderItem;
import com.hoanganhnhan.catalog.models.Order;
import com.hoanganhnhan.catalog.utilize.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {

    RecyclerView rvOrderItem;
    OrderFilterFragment orderFilterFragment;
    ArrayList<Order> lOrder;
    OrderAdapter orderAdapter;
    OrderProcessingAdapter orderProcessingAdapter;
    LinearLayout llOrderItemEmpty;
    Integer orderStatusId = Constant.TRANG_THAI_DAT_HANG;
    Map<Integer, RecyclerView.Adapter<?>> mRCOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setAdapter();
        setControl();
        setEvent();
        renderOrderItemViewFirst();
    }

    private ArrayList<Order> handleOrderItem(Integer id){
        ArrayList<Order> lNewOrder = new ArrayList<>();
        for(Order orderItem: OrderItem.getOrders()){
            if(orderItem.getTrangThai() == id){
                lNewOrder.add(orderItem);
            }
        }
        return lNewOrder;
    }

    private void setAdapter(){
        this.orderAdapter = new OrderAdapter(lOrder);
        this.orderProcessingAdapter = new OrderProcessingAdapter(lOrder);
        this.lOrder = handleOrderItem(Constant.TRANG_THAI_DAT_HANG);
        mRCOrder = new HashMap<>();
        mRCOrder.put(Constant.TRANG_THAI_DANG_GIAO, this.orderAdapter);
        mRCOrder.put(Constant.TRANG_THAI_DAT_HANG, this.orderProcessingAdapter);
    }

    private void setControl(){
        rvOrderItem = (RecyclerView) findViewById(R.id.rvOrderItem);
        orderFilterFragment = (OrderFilterFragment) getSupportFragmentManager().findFragmentById(R.id.orderFilterFragment);
        llOrderItemEmpty = (LinearLayout) findViewById(R.id.llOrderItemEmpty);
    }

    private void renderOrderItemViewFirst(){
        Integer orderStatus = orderFilterFragment.getOrderStatus();
        lOrder = handleOrderItem(orderStatus);
        renderOrderItemAdapterView();
    }

    private void renderOrderAdapter(){
        rvOrderItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        RecyclerView.Adapter<?> generalOrderAdapter = null;
        if(mRCOrder.get(orderStatusId) instanceof OrderAdapter){
            this.orderAdapter.setListOrder(lOrder);
            generalOrderAdapter = this.orderAdapter;
        }

        if(mRCOrder.get(orderStatusId) instanceof  OrderProcessingAdapter){
            this.orderProcessingAdapter.setListOrder(lOrder);
            generalOrderAdapter = this.orderProcessingAdapter;

        }
        if(generalOrderAdapter != null){
            rvOrderItem.setAdapter(generalOrderAdapter);
        }
    }

    private void renderOrderItemEmpty(Boolean hide){
        rvOrderItem.setVisibility(!hide ? View.VISIBLE : View.GONE);
        llOrderItemEmpty.setVisibility(!hide ? View.GONE : View.VISIBLE);
    }


    private void renderOrderItemAdapterView(){

        if(lOrder.size() == 0){
            renderOrderItemEmpty(true);
        }
        else{
            renderOrderItemEmpty(false);
            renderOrderAdapter();
        }
    }

    private void sendOrderIDToOrderDetailActivity(@NonNull View v, String id){
//        Bundle bundle = new Bundle();
//        bundle.putString("order_id", id);
//        Intent intentOrderDetail = new Intent(v.getContext(), OrderDetailActivity.class);
//        intentOrderDetail.putExtras(bundle);
//        v.getContext().startActivity(intentOrderDetail);
    }

    private void setEvent(){

        this.orderAdapter.setOnRedirect(new OnRedirect() {
            @Override
            public void getId(View v, String id) {
                sendOrderIDToOrderDetailActivity(v, id);
            }
        });

        this.orderProcessingAdapter.setOnRedirect(new OnRedirect() {
            @Override
            public void getId(View v, String id) {
                sendOrderIDToOrderDetailActivity(v, id);
            }
        });


        orderProcessingAdapter.setOnOrderCancel(new OnOrderCancel() {
            @Override
            public void getId(View v, String id) {
                System.out.println("cancel view ");
            }
        });

        orderFilterFragment.setOnChange(new OnChange() {
            @Override
            public void run(Integer id) {
                orderStatusId = id;
                lOrder = handleOrderItem(id);
                renderOrderItemAdapterView();
            }
        });
    }
}