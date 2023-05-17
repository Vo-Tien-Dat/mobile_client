package com.hoanganhnhan.catalog.api;

import com.hoanganhnhan.catalog.models.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandApi {

    private final static String KEY_BRAND_ENTITY = "brands";

    static public List<Brand> readBrands(){
        List<Brand> brands = new ArrayList<>();
        return brands;
    }

    static public Boolean writeNewBrand(Brand brand){
        return false;
    }


    static public void writeAllBrand(){

    }
}
