package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); //hide the title bar

        Button btnSignIn = findViewById(R.id.btnSignIn);
        final EditText username = findViewById(R.id.nameeditText);
        final EditText password = findViewById(R.id.passeditText);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(username.getText().toString().equals("Bob") && password.getText().toString().equals("bob123")){
                    Intent intent2=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent2);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Username or password is incorrect",Toast.LENGTH_SHORT);
                     toast.show();
                }
            }

        });
    }

    public void registration(View view){
        Intent intent2=new Intent(getApplicationContext(),RegistrationActivity.class);
        startActivity(intent2);
    }



}
