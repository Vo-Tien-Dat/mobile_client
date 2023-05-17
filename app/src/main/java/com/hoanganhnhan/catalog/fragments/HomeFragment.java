package com.hoanganhnhan.catalog.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.adapters.SlideAdapter;
import com.hoanganhnhan.catalog.models.Slider;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    ViewPager2 viewPager2;
    RecyclerView rvLaptopContent;
    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewHomeFragment = inflater.inflate(R.layout.fragment_home2, container, false);
        Banner(viewHomeFragment);
        return viewHomeFragment;
    }

    private void Banner(@NonNull View view){
        viewPager2 = view.findViewById(R.id.vp2_slider);
        List<Slider> sliders = new ArrayList<>();
        sliders.add(new Slider(R.drawable.slider_2));
        sliders.add(new Slider(R.drawable.slide_3));
        sliders.add(new Slider(R.drawable.slide_5));
        viewPager2.setAdapter(new SlideAdapter(sliders,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                float scale = 0.85f+r*0.15f;
            }
        });
//        viewPager2.setPageTransformer(compositePageTransformer);
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//
//                handler.removeCallbacks(sliderRunnable);
//                handler.postDelayed(sliderRunnable,2000);
//            }
//        });
    }

//    private  Runnable sliderRunnable = new Runnable() {
//        @Override
//        public void run() {
//            viewPager2.setCurrentItem(viewPager2.getCurrentItem() +1);
//        }
//    };

//    @Override
//    protected void onPause() {
//        super.onPause();
//        handler.removeCallbacks(sliderRunnable);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        handler.postDelayed(sliderRunnable,3000);
//    }

    private void setEvent(){

    }


    private void setControl(@NonNull View view) {
        rvLaptopContent = (RecyclerView) view.findViewById(R.id.rvLaptopContent);

    }
}