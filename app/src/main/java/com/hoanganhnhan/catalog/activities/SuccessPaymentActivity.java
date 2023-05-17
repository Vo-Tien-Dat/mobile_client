package com.hoanganhnhan.catalog.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hoanganhnhan.catalog.R;

public class SuccessPaymentActivity extends AppCompatActivity {

    Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        setControl();
        setEvent();
    }

    private void setControl() {
        btnBackToHome = findViewById(R.id.btnBackToHome);
    }

    private void setEvent() {
        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}