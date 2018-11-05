package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); //hide the title bar
    }

    public void registration(View view){
        Intent intent2=new Intent(getApplicationContext(),RegistrationActivity.class);
        startActivity(intent2);
    }
    public void openMainActivity(View view){

        //Please add code to authenticate user here and then open activity

        Intent intent2=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent2);
    }


}
