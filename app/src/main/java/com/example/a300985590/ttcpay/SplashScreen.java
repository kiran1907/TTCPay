package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        getSupportActionBar().hide(); //hide the title bar

        Thread th=new Thread()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(1500);
                    Intent intent=new Intent(getApplicationContext(),UserTypeActivity.class);//After splash choose user type window will open
                    startActivity(intent);
                    finish();
                }
                catch(Exception E)
                {
                }
            }
        };
        th.start();

    }
}
