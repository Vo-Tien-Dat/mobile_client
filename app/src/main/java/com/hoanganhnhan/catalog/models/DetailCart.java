package com.hoanganhnhan.catalog.models;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.io.Serializable;

@IgnoreExtraProperties
public class DetailCart implements Serializable {
    @PropertyName("detail_cart_cart_id")
    public String detailCartCartId;
    @PropertyName("detail_cart_product_id")
    public String detailCartProductId;
    @PropertyName("detail_cart_product_quantity")
    public int detailCartProductQuantity;

    public DetailCart() {
    }

    public DetailCart(String detailCartCartId, String detailCartProductId, int detailCartProductQuantity) {
        this.detailCartCartId = detailCartCartId;
        this.detailCartProductId = detailCartProductId;
        this.detailCartProductQuantity = detailCartProductQuantity;
    }
//  Cart ID = Account ID
    public String getDetailCartCartId() {
        return detailCartCartId;
    }

    public void setDetailCartCartId(String detailCartCartId) {
        this.detailCartCartId = detailCartCartId;
    }

    public String getDetailCartProductId() {
        return detailCartProductId;
    }

    public void setDetailCartProductId(String detailCartProductId) {
        this.detailCartProductId = detailCartProductId;
    }

    public int getDetailCartProductQuantity() {
        return detailCartProductQuantity;
    }

    public void setDetailCartProductQuantity(int detailCartProductQuantity) {
        this.detailCartProductQuantity = detailCartProductQuantity;
    }
}
