package com.hoanganhnhan.catalog.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.hoanganhnhan.catalog.R;


public class CartEmptyFragment extends Fragment {

    ImageButton btnBack, btnNotify, btnMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_cart_empty, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    public void setControl(View view) {
        btnBack = view.findViewById(R.id.btnBack);
        btnMessage = view.findViewById(R.id.btnMessage);
        btnNotify = view.findViewById(R.id.btnNotify);
    }

    public void setEvent() {

    }
}
