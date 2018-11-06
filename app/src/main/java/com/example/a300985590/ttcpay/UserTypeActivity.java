package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UserTypeActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private Session session;//global variable


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        session = new Session(this);
        session.setusename("GUEST");

        getSupportActionBar().hide(); //hide the title bar
    }

    public void proceedButtonClick(View view)
    {
        radioGroup = (RadioGroup) findViewById(R.id.userRadioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);

        String selectedRadioButton=radioButton.getText().toString();//code to get text of selected radio button

        //Toast.makeText(UserTypeActivity.this,
        //       radioButton.getText(), Toast.LENGTH_SHORT).show();

        if("Registered User".equalsIgnoreCase(selectedRadioButton))
        {
            Intent intent2=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent2);
        }
        if("Guest User".equalsIgnoreCase(selectedRadioButton))
        {
            Intent intent2=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent2);
        }
    }


}
