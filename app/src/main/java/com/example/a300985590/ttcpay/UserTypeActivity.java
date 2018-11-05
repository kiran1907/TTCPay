package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
    }

    public void proceedButtonClick(View view){

        //Please add code here based on radio selection
        Intent intent2=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent2);
    }

}
