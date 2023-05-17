package com.hoanganhnhan.catalog.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.hoanganhnhan.catalog.R;

public class TopBarFragment extends Fragment {

    ImageButton btnBack, btnNotify, btnMessage;
    TextView txtViewScreenTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_top_bar, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setControl(View view) {
      //  btnBack = view.findViewById(R.id.btnBack);
        btnMessage = view.findViewById(R.id.btnMessage);
        btnNotify = view.findViewById(R.id.btnNotify);
        //txtViewScreenTitle = view.findViewById(R.id.txtViewScreenTitle);
    }

    private void setEvent() {

    }

}