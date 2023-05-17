package com.hoanganhnhan.catalog.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.models.Promotion;

import java.util.ArrayList;

public class PaymentVoucherAdapter extends RecyclerView.Adapter<PaymentVoucherAdapter.PaymentVoucherViewHolder> {
    ArrayList<Promotion> listVouchers;

    private Context context;

    public PaymentVoucherAdapter(ArrayList<Promotion> listVouchers, Context context) {
        this.listVouchers = listVouchers;
        this.context = context;
    }

    @NonNull
    @Override
    public PaymentVoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_payment_voucher, parent, false);
        return new PaymentVoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentVoucherViewHolder holder, int position) {
        Promotion voucher = listVouchers.get(position);
        holder.tvNameVoucher.setText(voucher.getPromotionName());
        holder.tvNumberVoucher.setText(String.valueOf(voucher.getPromotionQuantity()));
        holder.tvHanSuDung.setText(voucher.getPromotionEndDate());
    }

    @Override
    public int getItemCount() {
        return listVouchers.size();
    }

    public class PaymentVoucherViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNameVoucher, tvNumberVoucher, tvHanSuDung;

        public PaymentVoucherViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameVoucher = itemView.findViewById(R.id.tvNameVoucher);
            tvNumberVoucher = itemView.findViewById(R.id.tvNumberVoucher);
            tvHanSuDung = itemView.findViewById(R.id.tvHanSuDung);
        }
    }
}
