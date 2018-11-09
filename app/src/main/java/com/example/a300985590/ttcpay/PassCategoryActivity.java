package com.example.a300985590.ttcpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PassCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_category);


        Bundle b = getIntent().getExtras();
        double monthlyPrice = b.getDouble("monthlyPrice");
        double weeklyPrice = b.getDouble("weeklyPrice");
        double dailyPrice = b.getDouble("dailyPrice");

    }
}
