package com.hoanganhnhan.catalog.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.hoanganhnhan.catalog.R;


public class CartNotLoginFragment extends Fragment {

    ImageView imgView;
    TextView txtView;
    Button btnDangNhap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_cart_not_login, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setControl(View view) {
        imgView = view.findViewById(R.id.imgViewGioHangNotLogin);
        txtView = view.findViewById((R.id.textViewGioHangNotLogin));
        btnDangNhap = view.findViewById(R.id.btnDangNhapGioHangNotLogin);
    }

    private void setEvent() {

    }
}