package com.example.a300985590.ttcpay;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String ORDERPREFERENCE = "OrderPrefs" ;


    SharedPreferences sharedpreferences;

    private Session session;//global variable

    final String userNameArray[]={"Shiva","Sidharth","Bob","admin"};//add more username for static code

    final String passwordArray[]={"shiva123","sid123","bob123","admin123"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        getSupportActionBar().hide(); //hide the title bar


        session = new Session(this);

        Button btnSignIn = findViewById(R.id.btnSignIn);

        final EditText username = findViewById(R.id.nameeditText);

        final EditText password = findViewById(R.id.passeditText);

        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String enteredUserName=username.getText().toString();

                String enteredPassword=password.getText().toString();

                boolean isValidUser=false;

                if("admin".equalsIgnoreCase(enteredUserName) && "admin123".equalsIgnoreCase(enteredPassword))
                {
                    Intent intent=new Intent(getApplicationContext(),AdminMainScreen.class);
                    session.setusename("Admin");
                    startActivity(intent);
                }

                else
                    {
                    for (int i = 0; i < userNameArray.length; i++) {
                        if (username.getText().toString().equalsIgnoreCase(userNameArray[i]) && password.getText().toString().equalsIgnoreCase(passwordArray[i])) {
                            Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                            session.setusename(userNameArray[i]);
                            isValidUser = true;
                            startActivity(intent2);

                            break;
                        }
                    }
                        if(!isValidUser)
                        {

                            Toast toast = Toast.makeText(getApplicationContext(),"Username or password is incorrect",Toast.LENGTH_SHORT);
                            toast.show();

                        }

                }

            }
        });
    }

    public void registration(View view){
        Intent intent2=new Intent(getApplicationContext(),RegistrationActivity.class);
        startActivity(intent2);
    }

}
