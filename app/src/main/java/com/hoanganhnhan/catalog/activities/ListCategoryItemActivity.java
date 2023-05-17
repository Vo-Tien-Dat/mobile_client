package com.hoanganhnhan.catalog.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.adapters.LaptopAdapter;
import com.hoanganhnhan.catalog.models.Laptop;
import com.hoanganhnhan.catalog.datas.data;

import java.util.ArrayList;
import java.util.List;

public class ListCategoryItemActivity extends AppCompatActivity {
    RecyclerView rvProduct;
    LaptopAdapter productAdapter;
    AutoCompleteTextView tvSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category_item);
        setControl();
        setEvent();
    }

    public void setControl(){
        rvProduct = findViewById(R.id.rv_product);
        tvSearch = findViewById(R.id.act_search);
    }

    public void setEvent() {
        setRvProduct();

        ImageButton imageButton = findViewById(R.id.ibtn_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finish();
            }
        });
        execSearch();
    }
    private void execSearch(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, new data().suggestProduct());
        tvSearch.setHint("Bạn cần tìm gì ?");
        tvSearch.setAdapter(adapter);
    }

    public void setRvProduct(){
        //        khoi tao gridlayout manage
        productAdapter = new LaptopAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rvProduct.setLayoutManager(gridLayoutManager);
        productAdapter.setData(getListProductByBrandId());
        rvProduct.setAdapter(productAdapter);
    }

    public String getBrandId(){  //lay brandId duoc click (duoc truyen tu adapter)
        Intent intent = getIntent();
        return intent.getStringExtra("brandId");
    }

    public List<Laptop> getListProductByBrandId(){ //lay ds sp theo brandId: vd: brandId =1 -> ds chua sp Apple
        data Data = new data();
        List<Laptop> listAllProduct = Data.getListProduct(); //lay toan bo sp
        List<Laptop> listProductById = new ArrayList<>();
        String brandId = getBrandId();

        if (brandId != null) {  //brand
            for (int i = 0; i < listAllProduct.size(); i++) {
                if (brandId.equals(listAllProduct.get(i).getLaptopBrandID())) {
                    System.out.println(listAllProduct.get(i));
                    listProductById.add(listAllProduct.get(i));
                }
            }
        }
        else { //brandId = null: demand
            listProductById = listAllProduct;
        }
        return listProductById;
    }

}