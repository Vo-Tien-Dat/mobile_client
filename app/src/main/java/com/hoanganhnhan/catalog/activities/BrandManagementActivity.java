package com.hoanganhnhan.catalog.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.adapters.BrandManagementAdapter;
import com.hoanganhnhan.catalog.datas.data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BrandManagementActivity extends AppCompatActivity {

    RecyclerView rvBrandManagement;
    ImageButton btnAddBrand;

    data datalist = new  data();

    BrandManagementAdapter brandManagementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_management);
        setControl();
        setEvent();
    }

    public void setControl(){
        rvBrandManagement = findViewById(R.id.rvBrandManagement);
        btnAddBrand = findViewById(R.id.btnAdd);
    }

    public void setEvent(){
        setRvBrandManagement();

        btnAddBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BrandAdditionActivity.class);
                startActivity(intent);
            }
        });

    }

    public void setRvBrandManagement(){
        brandManagementAdapter = new BrandManagementAdapter(this);  //this: tham chieu den activity hien tai
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        rvBrandManagement.setLayoutManager(gridLayoutManager);
        brandManagementAdapter.setData(datalist.getListBrand());
        rvBrandManagement.setAdapter(brandManagementAdapter);
    }


}