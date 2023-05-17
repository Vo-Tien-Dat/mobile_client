package com.hoanganhnhan.catalog.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.activities.ListCategoryItemActivity;
import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.models.Brand;
import com.squareup.picasso.Picasso;


import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {
    private List<Brand> brands;
    private final Context context;

    public BrandAdapter(Context context) {
        this.context = context;
    }

    public BrandAdapter(Context context, List<Brand> brands) {
        this.context = context;
        this.brands = brands;
    }

    public void setData(List<Brand> brands){
        this.brands = brands;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_brand,parent,false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        Brand itemCataegory = brands.get(position);
        if(itemCataegory == null){
            return;
        }


        String brandImage = itemCataegory.getBrandImage();
        Picasso.get().load(brandImage).into(holder.ivBrand);
        holder.cvBrand.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                gotoListProduct(itemCataegory.getBrandId());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(brands !=null){
            return brands.size();
        }
        return 0;
    }

    public class BrandViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivBrand;
        private RecyclerView rvBrand;
        public CardView cvBrand;
        public BrandViewHolder(@NonNull View brandView){
            super(brandView);
            ivBrand =brandView.findViewById(R.id.ivBrand);
            rvBrand = brandView.findViewById(R.id.rvBrand);
            cvBrand = brandView.findViewById(R.id.cvBrand);
        }
    }

    private void gotoListProduct(String brandId) { //pthuc được sử dụng để chuyển đến một Activity mới (MainListItemInBrand) với thông tin về brandId,  khi người dùng chọn một item trong danh sách hiển thị
        Intent intent = new Intent(context, ListCategoryItemActivity.class); //Tạo một Intent mới, tham số đầu tiên là context của Adapter và tham số thứ hai là Activity mà sẽ được chuyển đến.
        intent.putExtra("brandId", brandId);  //truyen brandId cua item dc click sang activity
        context.startActivity(intent); //chay activity moi voi intent vưa tao
    }

}
