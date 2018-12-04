package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide(); //hide the title bar
        //Test Comment

        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Toast toast = Toast.makeText(getApplicationContext(),"User Registered",Toast.LENGTH_SHORT);
                toast.show();

                Intent intent2=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent2);
            }
        });
    }
}
