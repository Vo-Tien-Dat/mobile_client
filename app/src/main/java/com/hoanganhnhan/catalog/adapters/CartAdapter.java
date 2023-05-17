package com.hoanganhnhan.catalog.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.interfaces.OnChangeCart;
import com.hoanganhnhan.catalog.models.Cart;
import com.hoanganhnhan.catalog.models.Product;
import com.hoanganhnhan.catalog.utilize.MoneyFormat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private CheckBox checkFromParent;
    private OnChangeCart onChangeCart;
    private List<Cart> carts;

    private static  int checkCount = 0 ;

    private static double cartSum = 0 ;
    public List<Cart> getCarts() {
        return carts;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setCarts(List<Cart> carts) {
        this.carts = carts;
        notifyDataSetChanged();
    }

    public void setOnChangeCart(OnChangeCart onChangeCart){
        this.onChangeCart = onChangeCart;
    }
    public CartAdapter( Context context) {
        this.carts = new ArrayList<>();
    }
    public CartAdapter(Context context,List<Cart> carts) {
        this.carts = carts;
    }

    public  int getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(int checkCount) {
        CartAdapter.checkCount = checkCount;
    }

    public double getCartSum() {
        return cartSum;
    }

    public void setCartSum(double cartSum) {
        CartAdapter.cartSum = cartSum;
    }

    public static class  CartViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox checked;

        private final ImageView cartImage;

        private final TextView cartName;

        private final TextView cartOriginalPrice;

        private final TextView cartPrice;

        private final TextView btnIncrease;

        private final TextView btnDecrease;

        private final TextView cartQuantity;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartName = itemView.findViewById(R.id.tvTenSPGioHang);
            cartOriginalPrice = itemView.findViewById(R.id.tvGiaGocSPGioHang);
            cartPrice = itemView.findViewById(R.id.tvGiaBanSPGioHang);
            cartQuantity = itemView.findViewById(R.id.tvNumberItemGioHang);
            cartImage = itemView.findViewById(R.id.imgItemGioHang);
            btnIncrease = itemView.findViewById(R.id.btnTang);
            btnDecrease= itemView.findViewById(R.id.btnGiam);
            checked = itemView.findViewById(R.id.checkboxItem);
        }
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cart = carts.get(position);
        Boolean isChecked = cart.getChecked();

        holder.cartName.setText(cart.getCartName());

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").error(R.drawable.laptop_1).into(holder.cartImage);

        holder.cartPrice.setText(new MoneyFormat(cart.getCartPrice()).toVND());

        holder.cartOriginalPrice.setText(new MoneyFormat(cart.getCartOriginalPrice()).toVND());

        holder.cartQuantity.setText(String.valueOf(cart.getCartQuantity()));

        holder.checked.setChecked(isChecked);
        setEvent(holder, cart);
    }

    private void setEvent(@NonNull CartViewHolder cartViewHolder,Cart cart){

        cartViewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cart.setChecked(b);

                checkCount += (b ? 1 : -1);

                double price = cart.getCartPrice();
                int quantity = cart.getCartQuantity();
                cartSum += ( (b ? 1 : -1 ) * price * quantity) ;

                if (onChangeCart != null){
                    onChangeCart.getId(cart.getCartID());
                }
            }
        });

        cartViewHolder.btnIncrease.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                cart.setCartQuantity(cart.getCartQuantity() + 1);

                Boolean isChecked = cart.getChecked();
                if(isChecked){
                    double price = cart.getCartPrice();
                    cartSum += price;
                }


                notifyDataSetChanged();
                if (onChangeCart != null && cart.getChecked()){
                    onChangeCart.getId(cart.getCartID());
                }
            }
        });

        cartViewHolder.btnDecrease.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                if (cart.getCartQuantity() > 1) {

                    cart.setCartQuantity(cart.getCartQuantity() - 1);

                    Boolean isChecked = cart.getChecked();
                    if(isChecked){
                        double price = cart.getCartPrice();
                        cartSum -= price;
                    }

                    notifyDataSetChanged();
                    if (onChangeCart != null && cart.getChecked()){
                        onChangeCart.getId(cart.getCartID());
                    }
                } else {
                    Log.d("Limit reached", "1 is minium");
                    Toast.makeText(view.getContext(), "Limit reached, 1 is minium", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

//    @SuppressLint("NotifyDataSetChanged")
//    public void checkAll() {
//        for (Product item : products) {
//            item.setChecked(true);
//        }
//        notifyDataSetChanged();
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    public void unCheckAll() {
//        for (Product item : products) {
//            item.setChecked(false);
//        }
//        notifyDataSetChanged();
//    }

}
