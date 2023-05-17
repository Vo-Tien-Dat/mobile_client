package com.hoanganhnhan.catalog.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.adapters.PaymentAdapter;
import com.hoanganhnhan.catalog.models.Cart;
import com.hoanganhnhan.catalog.models.Product;

import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity {

    TextView tvScreenTitle;
    Button btnPay;

    private RecyclerView rvPayment;
    private ArrayList<Product> products;

    private PaymentAdapter paymentAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setControl();
        setData();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
    }



    private void setControl() {
        products = new ArrayList<>();

        btnPay = findViewById(R.id.btnThanhToan);
        rvPayment = findViewById(R.id.rvPayment);

        rvPayment.setLayoutManager(new GridLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL));
        paymentAdapter = new PaymentAdapter(products, getApplicationContext());
        rvPayment.setAdapter(paymentAdapter);
    }


    private ArrayList<Product> convertCartsToProducts(ArrayList<Cart> carts){
        ArrayList<Product> newProducts = new ArrayList<>();
        for(Cart cart: carts){
            String name = cart.getCartName();
            double price = cart.getCartPrice();
            int quantity = cart.getCartQuantity();

            Product newProduct = new Product();
            newProduct.setProductName(name);
            newProduct.setProductPrice(price);
            newProduct.setProductQuantity(quantity);

            newProducts.add(newProduct);
        }

        return newProducts;
    }

    private void setData(){
        Bundle bundleCart = getIntent().getExtras();
        if(bundleCart != null){
            ArrayList<Cart> carts = (ArrayList<Cart>) bundleCart.getSerializable("carts");
            this.products = convertCartsToProducts(carts);
            paymentAdapter.setProducts(this.products);
        }
    }

    private void setEvent() {
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SuccessPaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}
