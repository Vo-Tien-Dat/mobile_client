package com.hoanganhnhan.catalog.models;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

@IgnoreExtraProperties
public class Promotion {

    @PropertyName("promotion_id")
    private String promotionId;
    @PropertyName("promotion_name")
    private String promotionName;
    @PropertyName("promotion_quantity")
    private int promotionQuantity;
    @PropertyName("promotion_end_date")
    private String promotionEndDate;

    public Promotion() {
    }

    public Promotion(String promotionId, String promotionName, int promotionQuantity, String promotionEndDate) {
        this.promotionId = promotionId;
        this.promotionName = promotionName;
        this.promotionQuantity = promotionQuantity;
        this.promotionEndDate = promotionEndDate;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public int getPromotionQuantity() {
        return promotionQuantity;
    }

    public void setPromotionQuantity(int promotionQuantity) {
        this.promotionQuantity = promotionQuantity;
    }

    public String getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(String promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }
}
