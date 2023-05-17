package com.hoanganhnhan.catalog.models;


import android.os.Parcelable;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.io.Serializable;

@IgnoreExtraProperties
public class Cart implements Serializable {

    private String cartID;
    private String cartName;

    private String cartImage;

    private double cartOriginalPrice;

    private double cartPrice;

    @PropertyName("cart_quantity")
    public  Integer cartQuantity;

    private Boolean isChecked;

    public Cart(){
    }

    public Cart(String cartID, String cartName, String cartImage, double cartOriginalPrice, double cartPrice, Integer cartQuantity) {
        this.cartID = cartID;
        this.cartName = cartName;
        this.cartImage = cartImage;
        this.cartOriginalPrice = cartOriginalPrice;
        this.cartPrice = cartPrice;
        this.cartQuantity = cartQuantity;
        this.isChecked = false;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public String getCartImage() {
        return cartImage;
    }

    public void setCartImage(String cartImage) {
        this.cartImage = cartImage;
    }

    public double getCartOriginalPrice() {
        return cartOriginalPrice;
    }

    public void setCartOriginalPrice(double cartOriginalPrice) {
        this.cartOriginalPrice = cartOriginalPrice;
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }

    @Exclude
    public Integer getCartQuantity() {
        return cartQuantity;
    }

    @Exclude
    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
}
