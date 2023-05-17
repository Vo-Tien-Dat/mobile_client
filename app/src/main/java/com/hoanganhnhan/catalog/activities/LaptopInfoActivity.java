package com.hoanganhnhan.catalog.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.adapters.PathProductAdapter;
import com.hoanganhnhan.catalog.fragments.CategoryFragment;
import com.hoanganhnhan.catalog.models.ItemPathProduct;
import com.hoanganhnhan.catalog.models.Laptop;
import  com.hoanganhnhan.catalog.datas.data;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class LaptopInfoActivity extends AppCompatActivity {
    private RecyclerView rvPathProduct;
    private LinearLayout llShowInfoConfiguration;
    private TextView tvNameProduct,tvPriceProduct;
    private ImageView ivLaptop;
    protected LinearLayout llShowInfoProduct;
    static Integer numbersIndexInfoConfiguration = 13;
    AutoCompleteTextView tvSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_info);
        setControl();
        setEvent();
    }

    private void setEvent(){
        ImageButton imageButton = findViewById(R.id.ibtn_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        if(getIntent() !=null && getIntent().getExtras()!= null && getIntent().hasExtra(CategoryFragment.ACTIVITY_SERVICE));
//        Laptop product = (Laptop) getIntent().getSerializableExtra("product");

//        execSearch();
//        getInfoProduct(product);
//        getInfoConfiguration(product);
//        execCategoryProduct();
    }

    private View onCreateViewHolder(@NonNull ViewGroup parent,String keyInfoConfiguration, String valueInfoConfiguration){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info_configuration, parent, false);
        ItemInfoConfigurationHolder viewHolder = new ItemInfoConfigurationHolder(view);
        viewHolder.tvItemInfoProductKey.setText(keyInfoConfiguration);
        viewHolder.tvItemInfoProductValue.setText(valueInfoConfiguration);
        return viewHolder.itemView;
    }

    public class ItemInfoConfigurationHolder extends RecyclerView.ViewHolder{

        public TextView tvItemInfoProductKey;
        public TextView tvItemInfoProductValue;

        public ItemInfoConfigurationHolder(@NonNull View itemView) {
            super(itemView);
            this.tvItemInfoProductKey = (TextView) itemView.findViewById(R.id.tvItemInfoProductKey);
            this.tvItemInfoProductValue = (TextView) itemView.findViewById(R.id.tvInfoProductValue);
        }
    }


    private void getInfoProduct(Laptop laptop){
        TextView textView = new TextView(this);
        textView.setText(laptop.getLaptopDescription());
        llShowInfoProduct.addView(textView);
        Picasso.get().load(laptop.getLaptopImagePath()).error(com.denzcoskun.imageslider.R.drawable.error).into(ivLaptop);
        tvNameProduct.setText(laptop.getLaptopName());
        tvPriceProduct.setText(laptop.getLaptopPrice().toString());
    }

    private List<String> infoConfiguration(Laptop laptop){
        List<String> infos = new ArrayList<>();
        infos.add(laptop.getLaptopCPU());
        infos.add(laptop.getLaptopOS());
        infos.add(laptop.getLaptopRAM());
        infos.add(laptop.getLaptopGPU());
        infos.add(laptop.getLaptopScreenResolution());
        infos.add(laptop.getLaptopHardDisk());
        infos.add(laptop.getLaptopBluetooth());
        infos.add(laptop.getLaptopWifi());
        infos.add(laptop.getLaptopCommunicationGateway());
        infos.add(laptop.getLaptopKeyboard());
        infos.add(laptop.getLaptopBattery());
        infos.add(laptop.getLaptopScreenSize());
        infos.add(laptop.getLaptopWeight());
        return infos;
    }

    private void getInfoConfiguration(Laptop product){
        List<String> infoConfiguration = infoConfiguration(product);
        data data = new data();
        List<String> keysConfiguration = data.getKeyInfoConfiguration();
        for(int i =0; i < numbersIndexInfoConfiguration; ++i){
            View view = onCreateViewHolder(llShowInfoConfiguration,keysConfiguration.get(i),infoConfiguration.get(i));
            if(i%2==0){
                view.setBackgroundColor(0xFF4E85D7);
                view.invalidate();
            }
            else{
                view.setBackgroundColor(0xFFFFFFFF);
                view.invalidate();
            }
            view.setPadding(32,16,0,16);
            llShowInfoConfiguration.addView(view);
        }
    }

    private void execSearch(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, new data().suggestProduct());
        tvSearch.setHint("Bạn cần tìm gì ?");
        tvSearch.setAdapter(adapter);
    }

    private void execCategoryProduct(){
        PathProductAdapter productAdapter = new PathProductAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false); //cac item nam ngang
        rvPathProduct.setLayoutManager(linearLayoutManager);
        productAdapter.setData(getPaths());
        rvPathProduct.setAdapter(productAdapter);
    }

    private void setControl(){
        llShowInfoConfiguration = findViewById(R.id.llShowInfoConfiguration);
        llShowInfoProduct = findViewById(R.id.llItemInfoProduct);
        rvPathProduct = findViewById(R.id.rcv_path_product);
        tvNameProduct = findViewById(R.id.tv_name_product);
        tvPriceProduct = findViewById(R.id.tv_price_product);
        ivLaptop = findViewById(R.id.iv_laptop_detail);
        tvSearch = findViewById(R.id.act_search);
    }

    private List<ItemPathProduct> getPaths(){
        List<ItemPathProduct> itemPathProducts = new ArrayList<>();
        itemPathProducts.add(new ItemPathProduct("Laptop"));
        itemPathProducts.add(new ItemPathProduct("Macbook"));
        itemPathProducts.add(new ItemPathProduct("Macbook Air M1"));
        return itemPathProducts;
    }
}
