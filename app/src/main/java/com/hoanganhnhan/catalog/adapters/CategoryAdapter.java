package com.hoanganhnhan.catalog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.models.Category;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<Category> mCategories;

    public CategoryAdapter(Context context) {
        this.mContext = context;
    }
    public void setData(Context context,List<Category> categories){
        this.mContext = context;
        this.mCategories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_hoder_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mCategories.get(position);
        if(category == null){
            return;
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2);
        holder.rcvProduct.setLayoutManager(gridLayoutManager);
        holder.tvNameCategory.setText(category.getNameCagetory());
        LaptopAdapter productAdapter = new LaptopAdapter(mContext, category.getProducts());
        holder.rcvProduct.setAdapter(productAdapter);
    }


    @Override
    public int getItemCount() {
        if(mCategories != null){
            return mCategories.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNameCategory;
        public RecyclerView rcvProduct;
        public ImageView imvTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameCategory = itemView.findViewById(R.id.tv_name_category);
            rcvProduct = itemView.findViewById(R.id.rcv_laptops);
            imvTitle = itemView.findViewById(R.id.imv_title_home);
        }
    }
}
