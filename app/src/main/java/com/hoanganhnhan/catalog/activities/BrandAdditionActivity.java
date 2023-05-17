package com.hoanganhnhan.catalog.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hoanganhnhan.catalog.R;

public class BrandAdditionActivity extends AppCompatActivity {

    ImageButton btnAddBrand;
    TextView txtViewScreenTitle;

    Bitmap bmBrandImage;

    ImageView ivBrandAddition;

    LinearLayout llUploadImageBrand;

    FrameLayout flUploadImage;

    ActivityResultLauncher<Intent> activityImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            updateImageUri(result);
        }
    });


    private void updateImageUri(ActivityResult result){
        Intent data;
        if(result.getResultCode() == -1 && (data = result.getData()) != null && data.getData() != null){
            Uri selectedImageUri = data.getData();
            try{
                bmBrandImage = MediaStore.Images.Media.getBitmap(this.getApplicationContext().getContentResolver(), selectedImageUri);
                ivBrandAddition.setImageBitmap(bmBrandImage);
                llUploadImageBrand.setVisibility(View.GONE);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_addition);
        setControl();
        setEvent();
    }

    public void setControl(){
        btnAddBrand = findViewById(R.id.btnAdd);
        txtViewScreenTitle = findViewById(R.id.txtViewScreenTitle);
        ivBrandAddition = findViewById(R.id.ivBrandAddition);
        llUploadImageBrand = findViewById(R.id.llUploadImageBrand);
        flUploadImage = findViewById(R.id.flUploadImage);
    }

    public void setEvent(){
        btnAddBrand.setVisibility(View.GONE);
        txtViewScreenTitle.setText("Thêm hãng");

        llUploadImageBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                activityImage.launch(intent);
            }
        });
    }
}