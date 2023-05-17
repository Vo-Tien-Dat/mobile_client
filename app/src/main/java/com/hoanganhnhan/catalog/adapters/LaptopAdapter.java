package com.hoanganhnhan.catalog.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.hoanganhnhan.catalog.activities.LaptopInfoActivity;
import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.models.Laptop;
import com.squareup.picasso.Picasso;

import java.util.List;


public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder> {
    private List<Laptop> listProducts;
    private Context context;
    public LaptopAdapter(Context context) {
        this.context = context;
    }

    public LaptopAdapter(Context context, List<Laptop> listProducts) {
        this.context = context;
        this.listProducts = listProducts;
    }

    public void setData(List<Laptop> listProducts){
        this.listProducts = listProducts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LaptopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_laptop,parent,false);
        return new LaptopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopViewHolder holder, int position) {
        Laptop product = listProducts.get(position);
        if(product == null){
            return;
        }

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").error(R.drawable.laptop_1).into(holder.ivLaptop);
        holder.tvNameProduct.setText(product.getLaptopName());
        holder.tvPriceProduct.setText(product.getLaptopPrice().toString());

        holder.cvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoProductDetail(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listProducts !=null){
            return listProducts.size();
        }
        return 0;
    }

    private void gotoProductDetail(Laptop product) {
        Intent intent = new Intent(context, LaptopInfoActivity.class);
        Bundle bundle = new Bundle();  //tao bundle de truyen du lieu
        bundle.putSerializable("product",product);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public class LaptopViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNameProduct;
        public TextView tvPriceProduct;
        public ImageView ivLaptop;
        public CardView cvProduct;

        public LaptopViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cvProduct = (CardView) itemView.findViewById(R.id.layout_item_product);
            this.tvNameProduct =(TextView) itemView.findViewById(R.id.tv_name_name_layout);
            this.tvPriceProduct =(TextView) itemView.findViewById(R.id.tv_name_price_layout);
            this.ivLaptop =(ImageView) itemView.findViewById(R.id.img_product);
        }
    }
}
