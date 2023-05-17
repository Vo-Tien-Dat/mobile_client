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
import com.hoanganhnhan.catalog.models.Demand;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DemandAdapter extends RecyclerView.Adapter<DemandAdapter.DemandViewHolder> {

    private List<Demand> listDemand;
    private Context context;

    public DemandAdapter(Context context) {
        this.context = context;
    }

    public DemandAdapter(Context context, ArrayList<Demand> listDemand) {
        this.context = context;
        this.listDemand = listDemand;
    }

    public void setData(List<Demand> listDemand){
        this.listDemand = listDemand;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DemandAdapter.DemandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_demand,parent,false);
        return new DemandAdapter.DemandViewHolder(view);
    }
    //    Function set data and show
    @Override
    public void onBindViewHolder(@NonNull DemandAdapter.DemandViewHolder holder, int position) {
        //set data
        Demand itemCataegory = listDemand.get(position);
        if(itemCataegory == null){
            return;
        }
        String demandImage = itemCataegory.getDemandImage();
        Picasso.get().load(demandImage).into(holder.ivDemand);
        holder.cvDemand.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                gotoListProduct();

            }
        });
    }

    @Override
    public int getItemCount() {
        if(listDemand !=null){
            return listDemand.size(); //tra item tai vi tri position
        }
        return 0;
    }

    public class DemandViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivDemand;
        private RecyclerView rvDemand;
        private CardView cvDemand;
        public DemandViewHolder(@NonNull View demandView){
            super(demandView);
            ivDemand =demandView.findViewById(R.id.ivDemand);
            rvDemand = demandView.findViewById(R.id.rvDemand);
            cvDemand = demandView.findViewById(R.id.cvDemand);
        }
    }

    private void gotoListProduct() {
        Intent intent = new Intent(context, ListCategoryItemActivity.class);
        context.startActivity(intent);
    }

}
