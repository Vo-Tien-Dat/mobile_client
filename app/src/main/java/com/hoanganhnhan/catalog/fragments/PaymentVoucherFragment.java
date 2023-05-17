package com.hoanganhnhan.catalog.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.api.HardData;
import com.hoanganhnhan.catalog.models.Promotion;

import java.util.ArrayList;
import java.util.List;


public class PaymentVoucherFragment extends BottomSheetDialogFragment {
    TextView voucherName, remainNumber, hanSuDung;
    private RecyclerView recyclerView;
    private PaymentVoucherAdapter adapter;
    private ArrayList<Promotion> listVouchers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_payment_voucher, container, false);
        setControl(view);
        setEvent(view);
        return view;
    }

    private void setControl(View view) {
        voucherName = view.findViewById(R.id.tvNameVoucher);
        remainNumber = view.findViewById(R.id.tvNumberVoucher);
        hanSuDung = view.findViewById(R.id.tvHanSuDung);
    }

    private void setEvent(View view) {
        getVouchers();
        pushDataToView(view);
        Log.d("number item", String.valueOf(listVouchers.size()));

    }

    private void pushDataToView(View view) {
        recyclerView = view.findViewById(R.id.listItemPaymentVoucher);
        //Add data from list to adapter class
        adapter = new PaymentVoucherAdapter(listVouchers, getContext());
        //Set grid layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(getContext()
                , 1);
        //Set adapter to recycler view
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void getVouchers() {
        listVouchers = new ArrayList<>();
        HardData data = new HardData();
        List<Promotion> tempList = data.getListVoucher();
        for (Promotion item : tempList) {
            listVouchers.add(item);
        }
    }
}
