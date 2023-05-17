package com.hoanganhnhan.catalog.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.fragments.CartFilledFragment;
import com.hoanganhnhan.catalog.fragments.CategoryFragment;
import com.hoanganhnhan.catalog.datas.data;
import com.hoanganhnhan.catalog.fragments.HomeFragment;
import com.hoanganhnhan.catalog.fragments.OrderFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;

    CategoryFragment categoryFragment;

    OrderFragment orderFragment;
    AutoCompleteTextView tvSearch;

    CartFilledFragment cartFilledFragment;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
        Banner();
    }

    private void setEvent(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, new data().suggestProduct());
        tvSearch.setHint("Bạn cần tìm gì ?");
        tvSearch.setAdapter(adapter);

        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.flContent,homeFragment).commit();
                        break;
                    case R.id.menu_category:
                        categoryFragment = new CategoryFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, categoryFragment).commit();
                        break;

                    case R.id.menu_order:
                        Intent orderIntentActivity = new Intent(MainActivity.this.getBaseContext(), OrderActivity.class);
                        startActivity(orderIntentActivity);
                        return false;


                    case R.id.menu_cart:
                        cartFilledFragment = new CartFilledFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, cartFilledFragment).commit();
                        break;
                    case R.id.menu_user:
                        break;

                    default:
                        break;
                }
                return true;
            }
        });
    }

    private void Banner(){


//        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r = 1- Math.abs(position);
//                float scale = 0.85f+r*0.15f;
//            }
//        });
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


    private void setControl() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        tvSearch  = findViewById(R.id.act_search);
    }
}