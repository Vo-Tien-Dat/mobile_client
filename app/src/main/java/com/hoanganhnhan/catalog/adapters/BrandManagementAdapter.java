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
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.activities.BrandUpdateActivity;
import com.hoanganhnhan.catalog.models.Brand;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BrandManagementAdapter extends RecyclerView.Adapter<BrandManagementAdapter.BrandManagementViewHolder> {

    private List<Brand> listBrand;
    private Context context;

    public BrandManagementAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Brand> listBrand){
        this.listBrand = listBrand;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BrandManagementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_brand_management,parent,false);
        return new BrandManagementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandManagementAdapter.BrandManagementViewHolder holder, int position) {
        //set data
        Brand itemBrand = listBrand.get(position);
        if(itemBrand == null){
            return;
        }
        holder.tvNameBrandManagement.setText(itemBrand.getBrandName());
        Picasso.get().load("https://i.imgur.com/DvpvklR.png").error(R.drawable.demand_camung).into(holder.ivBrandManagement);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUpdateBrandScreen(itemBrand);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(listBrand !=null){
            return listBrand.size();
        }
        return 0;
    }

    public class BrandManagementViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivBrandManagement;
        private TextView tvNameBrandManagement;

        public BrandManagementViewHolder(@NonNull View brandCRUDView){
            super(brandCRUDView);
            ivBrandManagement =brandCRUDView.findViewById(R.id.ivBrandManagement);
            tvNameBrandManagement = brandCRUDView.findViewById(R.id.tvNameBrandManagement);

        }
    }
    public void goToUpdateBrandScreen(Brand itemBrand){
        Intent intent = new Intent(context, BrandUpdateActivity.class);
        Bundle bundle = new Bundle();  //tao bundle de truyen du lieu
        bundle.putSerializable("itemBrand", itemBrand);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
