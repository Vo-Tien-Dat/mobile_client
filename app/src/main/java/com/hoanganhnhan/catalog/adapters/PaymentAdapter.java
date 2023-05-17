package com.hoanganhnhan.catalog.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.fragments.PaymentVoucherFragment;
import com.hoanganhnhan.catalog.models.Product;
import com.hoanganhnhan.catalog.utilize.MoneyFormat;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder> {
    private  ArrayList<Product> products;
    private final Context context;

    public PaymentAdapter(ArrayList<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_payment, parent, false);
        return new PaymentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        Product product = products.get(position);
        holder.productName.setText(product.getProductName());
        holder.price.setText(new MoneyFormat(product.getProductPrice()).toVND());
        holder.number.setText(String.valueOf(product.getProductQuantity()));
        holder.layoutVoucherPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaymentVoucherFragment bottomSheet = new PaymentVoucherFragment();
                bottomSheet.show(((FragmentActivity) context).getSupportFragmentManager(), "paymentVoucher");
//                Toast.makeText(context, "You click voucher", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class PaymentViewHolder extends RecyclerView.ViewHolder {

        private TextView productName, number, price;
        private ImageView productImg;
        private LinearLayout layoutVoucherPayment;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.tvProductNamePayment);
            number = itemView.findViewById(R.id.tvNumberItemPayment);
            price = itemView.findViewById(R.id.tvPricePayment);
            productImg = itemView.findViewById(R.id.imgItemPayment);
            layoutVoucherPayment = itemView.findViewById(R.id.layoutVoucherPayment);
        }

    }
}
