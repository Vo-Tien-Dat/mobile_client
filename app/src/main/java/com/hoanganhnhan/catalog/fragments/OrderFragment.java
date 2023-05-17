package com.hoanganhnhan.catalog.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoanganhnhan.catalog.R;


public class OrderFragment extends Fragment {


    public OrderFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View orderFragmentView = inflater.inflate(R.layout.fragment_order, container, false);
        return orderFragmentView;
    }


}