package com.hoanganhnhan.catalog.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.activities.PaymentActivity;
import com.hoanganhnhan.catalog.adapters.CartAdapter;
import com.hoanganhnhan.catalog.api.CartApi;
import com.hoanganhnhan.catalog.api.LaptopApi;
import com.hoanganhnhan.catalog.interfaces.OnChangeCart;
import com.hoanganhnhan.catalog.models.Cart;
import com.hoanganhnhan.catalog.models.DetailCart;
import com.hoanganhnhan.catalog.models.Laptop;
import com.hoanganhnhan.catalog.utilize.MoneyFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.hoanganhnhan.catalog.utilize.Constant;
public class CartFilledFragment extends Fragment {
    String accountID = "003cb386-e2c1-4968-b04d-652a5dbc86a0";

    List<DetailCart> listDetailCarts;
    private RecyclerView rvCart;
    private List<Cart> carts;
    private Button btnMuaHang;
    private CheckBox checkboxChooseAll;
    private TextView tvTotalPrice;
    private CartAdapter cartAdapter;
    private Boolean isCheckedAll;

    private LinearLayout llCartContent;
    
    private LinearLayout llCartEmpty; 

    private ProgressBar pbCart;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_cart_filled, container, false);
        fetchData();
        setControl(view);
        setEvent();
        return view;
    }

    private  Cart convertLaptopToCart(Laptop laptop){
        String cartID = laptop.getLaptopID();
        String cartName = laptop.getLaptopName();
        double cartOriginalPrice = laptop.getLaptopOriginPrice();
        double cartPrice = laptop.getLaptopPrice();
        String cartImage = laptop.getLaptopImagePath();
        System.out.println(laptop.getLaptopName());
        return new Cart(cartID, cartName, cartImage, cartOriginalPrice, cartPrice, 0);
    }

    private void fetchData(){

       CartApi.readCarts(accountID, new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               if(snapshot.exists()){
                   carts.clear();

                   List<String> laptopIDs = new ArrayList<>();

                    for(DataSnapshot laptopDS: snapshot.getChildren()){
                        String laptopID = laptopDS.getKey();
                        laptopIDs.add(laptopID);
                    }

                    if(laptopIDs.size() == 0){
                        updateCartContentStatus(Constant.EMPTY_STATUS);
                        return;
                    }

                   for(String laptopID: laptopIDs){
                        LaptopApi.readLaptop(laptopID, new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    Laptop laptop = snapshot.getValue(Laptop.class);
                                    if(laptop != null){
                                        Cart cart = convertLaptopToCart(laptop);
                                        carts.add(cart);
                                        cartAdapter.setCarts(carts);
                                        updateCartContentStatus(Constant.EXIST_STATUS);
                                    }
                                    checkboxChooseAll.setText("Tất cả (" + String.valueOf(carts.size()) + " sản phẩm)");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
    }

    public void setEvent() {
        checkboxChooseAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheckedAll = !isCheckedAll;
                for(Cart cart: carts){
                    cart.setChecked(isCheckedAll);
                }
                cartAdapter.setCarts(carts);
            }
        });

        cartAdapter.setOnChangeCart(new OnChangeCart() {
            @SuppressLint("SetTextI18n")
            @Override
            public void getId(String id) {

                double sum = cartAdapter.getCartSum();
                if (sum == 0) {
                    tvTotalPrice.setText("Vui lòng chọn sản phẩm");
                } else {
                    tvTotalPrice.setText(new MoneyFormat(sum).toVND());
                }

                int count = cartAdapter.getCheckCount();
                int sCarts = carts.size();


                if(count < sCarts){
                    isCheckedAll = false;
                }

                if(count == sCarts){
                    isCheckedAll = true;
                }

                checkboxChooseAll.setChecked(isCheckedAll);
            }
        });

        btnMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cartCount = cartAdapter.getCheckCount();

                if(cartCount == 0 ){
                    Log.d("NOT CHECKED", "No item was selected");
                    showAlert();
                    return;
                }

                ArrayList<Cart> newCarts = (ArrayList) updateSelectedCart();
                Bundle bundleCart = new Bundle();
                bundleCart.putSerializable("carts", newCarts);
                Intent paymentActivityIntent = new Intent(view.getContext(), PaymentActivity.class);
                paymentActivityIntent.putExtras(bundleCart);
                view.getContext().startActivity(paymentActivityIntent);
            }
        });
    }

    public void updateCartContentStatus(Integer cartStatus){
       if(Objects.equals(cartStatus, Constant.EMPTY_STATUS)) {
           llCartEmpty.setVisibility(View.VISIBLE);
           llCartContent.setVisibility(View.GONE);
           pbCart.setVisibility(View.GONE);
       }

       if(Objects.equals(cartStatus, Constant.EXIST_STATUS)){
           llCartEmpty.setVisibility(View.GONE);
           llCartContent.setVisibility(View.VISIBLE);
           pbCart.setVisibility(View.GONE);
       }

       if(Objects.equals(cartStatus, Constant.LOADING_STATUS)){
           llCartEmpty.setVisibility(View.GONE);
           llCartContent.setVisibility(View.GONE);
           pbCart.setVisibility(View.VISIBLE);
       }
    }

    public void setControl(View view) {

        carts = new ArrayList<>();
        isCheckedAll = false;

        btnMuaHang = view.findViewById(R.id.btnMuaHang);
        checkboxChooseAll = view.findViewById(R.id.checkboxChooseAll);
        tvTotalPrice = view.findViewById(R.id.tvTotalPrice);
        rvCart = view.findViewById(R.id.listItemGioHang);
        
        llCartEmpty = view.findViewById(R.id.llCartEmpty); 
        llCartEmpty.setVisibility(View.GONE);
        
        llCartContent = view.findViewById(R.id.llCartContent);
        llCartContent.setVisibility(View.GONE);

        pbCart = view.findViewById(R.id.pbCart);
        pbCart.setVisibility(View.VISIBLE);

        checkboxChooseAll.setText("Tất cả (" + String.valueOf(carts.size()) + " sản phẩm)");

        cartAdapter = new CartAdapter(getContext(), carts);

        rvCart.setLayoutManager(new GridLayoutManager(getContext(), LinearLayoutManager.VERTICAL));
        rvCart.setAdapter(cartAdapter);
    }
    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Bạn chưa chọn sản phẩm nào");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
        // CENTER BUTTON
        Button button = alert.getButton(AlertDialog.BUTTON_POSITIVE);
        button.setTextSize(20);
        button.setTextColor(Color.parseColor("#EA4335"));
        LinearLayout parent = (LinearLayout) button.getParent();
        parent.setGravity(Gravity.CENTER_HORIZONTAL);
        View leftSpacer = parent.getChildAt(1);
        leftSpacer.setVisibility(View.GONE);
        // CHANGE TEXT VIEW
        TextView textView = (TextView) alert.findViewById(android.R.id.message);
        textView.setTextSize(20);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
    }
    private List<Cart> updateSelectedCart(){
        List<Cart> newCarts = new ArrayList<>();
        for(Cart cart: this.carts){
            Boolean isChecked = cart.getChecked();
            if(isChecked){
                newCarts.add(cart);
            }
        }
        return newCarts;
    }
}