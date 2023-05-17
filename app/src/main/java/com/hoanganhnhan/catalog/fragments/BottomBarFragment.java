package com.hoanganhnhan.catalog.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.hoanganhnhan.catalog.R;

public class BottomBarFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_bottom_bar, container, false);
        setControl();
        setEvent();
        return view;
    }

    public void setControl() {

    }

    public void setEvent() {

    }
}
