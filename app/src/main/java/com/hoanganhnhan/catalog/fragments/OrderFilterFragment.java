package com.hoanganhnhan.catalog.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.interfaces.OnChange;
import com.hoanganhnhan.catalog.utilize.Constant;

import java.util.HashMap;
import java.util.Map;

public class OrderFilterFragment extends Fragment {

    TextView tvDatHang;

    TextView tvDangGiao;

    TextView tvDaGiao;

    Map<Integer, TextView>  mTextView;

    OnChange onChange;

    Integer orderStatus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View orderFilterView = inflater.inflate(R.layout.fragment_order_filter, container, false);
        setControl(orderFilterView);
        setFilterConfiguration();
        setEvent();
        return orderFilterView;
    }

    public void setOnChange(OnChange onChange){
        this.onChange = onChange;
    }

    private void setFilterConfiguration(){
       mTextView = new HashMap<>();
       mTextView.put(Constant.TRANG_THAI_DAT_HANG, this.tvDatHang);
       mTextView.put(Constant.TRANG_THAI_DANG_GIAO,this.tvDangGiao);
       mTextView.put(Constant.TRANG_THAI_DA_GIAO, this.tvDaGiao);
       renderOrderFilterView(Constant.TRANG_THAI_DAT_HANG);
       this.orderStatus = Constant.TRANG_THAI_DAT_HANG;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    private void renderOrderFilterView(Integer filterId){
        for(Integer iOrderStatus: mTextView.keySet()){
            if(iOrderStatus == filterId){
                mTextView.get(iOrderStatus).setSelected(true);
            }
            else{
                mTextView.get(iOrderStatus).setSelected(false);
            }
        }
    }

    private void setControl(@NonNull View view){
        tvDatHang = (TextView) view.findViewById(R.id.tvDatHang);
        tvDangGiao = (TextView) view.findViewById(R.id.tvDangGiao);
        tvDaGiao = (TextView) view.findViewById(R.id.tvDaGiao);
    }
    private void setEvent(){
        for(Integer iOrderStatus: mTextView.keySet()){
            TextView tvValue = mTextView.get(iOrderStatus);
            tvValue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onChange != null){
                        onChange.run(iOrderStatus);
                    }
                    renderOrderFilterView(iOrderStatus);
                }
            });
        }
    }
}