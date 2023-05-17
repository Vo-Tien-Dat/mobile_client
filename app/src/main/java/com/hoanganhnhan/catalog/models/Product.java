package com.hoanganhnhan.catalog.models;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

@SuppressLint("ParcelCreator")
public class Product implements Parcelable {

    private String productId;
    private String productName;
    private double productPrice, productOriginPrice;
    private int productQuantity;
    private String productImagePath;
    private Boolean checked;

    public Product() {
    }

    public Product(String productId, String productName, double productPrice, double productOriginPrice, int productQuantity, String productImagePath) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productOriginPrice = productOriginPrice;
        this.productQuantity = productQuantity;
        this.productImagePath = productImagePath;
        this.checked = false;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductOriginPrice() {
        return productOriginPrice;
    }

    public void setProductOriginPrice(double productOriginPrice) {
        this.productOriginPrice = productOriginPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.productId);
        parcel.writeString(this.productName);
        parcel.writeDouble(this.productPrice);
        parcel.writeDouble(this.productOriginPrice);
        parcel.writeInt(this.productQuantity);
        parcel.writeString(this.productImagePath);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeBoolean(checked);
        }
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            // Read your object data from the Parcel
            return new Product();
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

}