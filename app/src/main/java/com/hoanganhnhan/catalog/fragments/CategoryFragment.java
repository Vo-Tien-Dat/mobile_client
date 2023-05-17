package com.hoanganhnhan.catalog.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.adapters.BrandAdapter;
import com.hoanganhnhan.catalog.adapters.DemandAdapter;
import com.hoanganhnhan.catalog.datas.data;
import com.hoanganhnhan.catalog.models.Brand;
import com.hoanganhnhan.catalog.models.Demand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CategoryFragment extends Fragment {
    LinearLayout llCategoryContent;
    ProgressBar pbCategoryLoading;
    RecyclerView rvBrand;
    RecyclerView rvDemand;
    data dataList = new data();
    BrandAdapter brandAdapter;
    DemandAdapter demandAdapter;

    List<Brand> brands;
    List<Demand> demands;
    DatabaseReference databaseReferenceBrands;
    DatabaseReference databaseReferenceDemands;
    Boolean isLoading;
    Boolean isLoadingBrand;
    Boolean isLoadingDemand;
    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCategoryFragment = inflater.inflate(R.layout.fragment_category, container, false);
        setControl(viewCategoryFragment);
        fetchData();
        execLoading(true);
        return viewCategoryFragment;
    }

    public void fetchData(){
        databaseReferenceBrands.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    brands.clear();
                    int size =(int) snapshot.getChildrenCount();
                    for(DataSnapshot dsBrand: snapshot.getChildren()){
                        Brand brand = dsBrand.getValue(Brand.class);
                        updateBrandAdapterImage(brand, size);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        databaseReferenceDemands.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    demands.clear();
//                    int size = (int) snapshot.getChildrenCount();
//                    for(DataSnapshot dsDemand: snapshot.getChildren()){
//                        Demand demand = dsDemand.getValue(Demand.class);
//                        updateDemandAdapterImage(demand, size);
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }
    public void setControl(@NonNull View view){

        databaseReferenceBrands = FirebaseDatabase.getInstance().getReference("brands");
        databaseReferenceDemands = FirebaseDatabase.getInstance().getReference("demands");
        isLoadingDemand = false;
        isLoadingBrand = false;
        isLoading = isLoadingBrand && isLoadingDemand;

        llCategoryContent = (LinearLayout) view.findViewById(R.id.llCategoryContent);
        llCategoryContent.setVisibility(View.GONE);
        pbCategoryLoading = (ProgressBar) view.findViewById(R.id.pbCategoryLoading);
        pbCategoryLoading.setVisibility(View.VISIBLE);

        rvBrand = (RecyclerView) view.findViewById(R.id.rvBrand);
        rvDemand = (RecyclerView) view.findViewById(R.id.rvDemand);

        rvBrand.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        rvDemand.setLayoutManager(new GridLayoutManager(view.getContext(), 3));

        brandAdapter = new BrandAdapter(view.getContext());
        demandAdapter = new DemandAdapter(view.getContext());

        rvBrand.setAdapter(brandAdapter);
        rvDemand.setAdapter(demandAdapter);

        brands = new ArrayList<>();
        demands = new ArrayList<>();

    }

    private void isBrand(int size){
        isLoadingDemand = brands.size() == size;
    }

    private void isDemand(int size){
        isLoadingBrand = demands.size() == size;
    }
    private void updateBrandAdapterImage(Brand brand, int size){
        String brandImage = brand.getBrandImage();
        String imageUrl = generateImagePath("brand",brandImage);
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child(imageUrl);
        storageReference.getDownloadUrl().addOnSuccessListener(uri -> {
            brand.setBrandImage(uri.toString());
            brands.add(brand);
            isBrand(size);
            isLoading();
        }).addOnFailureListener(uri -> {brand.setBrandImage("oke"); brands.add(brand);  isBrand(size); isLoading(); });

    }

    private void updateDemandAdapterImage(Demand demand, int size){

        String demandImage = demand.getDemandImage();
        String imageUrl = generateImagePath("demand", demandImage);
        System.out.println(demand.getDemandId() + demand.getDemandImage());
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child(imageUrl);
        storageReference.getDownloadUrl().addOnSuccessListener(uri -> {
            System.out.println(uri.toString());
            demand.setDemandImage(uri.toString());
            demands.add(demand);
            isDemand(size);
            isLoading();
        }).addOnFailureListener(uri -> {demand.setDemandImage("oke"); demands.add(demand); isDemand(size); isLoading();});
    }
    private void checkLoading(){

    }
    private void execLoading(Boolean isLoading){
        if(isLoading){
            llCategoryContent.setVisibility(View.GONE);
            pbCategoryLoading.setVisibility(View.VISIBLE);
        }
        else{
            llCategoryContent.setVisibility(View.VISIBLE);
            pbCategoryLoading.setVisibility(View.GONE);
        }
    }

    private void isLoading(){
        this.isLoading = this.isLoadingBrand && isLoadingDemand;
        brandAdapter.setData(brands);
//        demandAdapter.setData(demands);
        execLoading(false);
    }

    private String generateImagePath(String entity, String imageID){
        return entity + "/" + imageID;
    }

}