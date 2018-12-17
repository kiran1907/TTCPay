package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudentPassUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_pass_update);

        Button btnUpdate = (Button)findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),UpdatedStudentPass.class);

                Toast toast = Toast.makeText(getApplicationContext(),"Price Updated",Toast.LENGTH_SHORT);
                toast.show();

                startActivity(intent);
            }
        });
    }
}
