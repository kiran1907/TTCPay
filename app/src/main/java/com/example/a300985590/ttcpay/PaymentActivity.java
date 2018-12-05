package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);




        final Bundle bundle = getIntent().getExtras();


        Button btnPaymentProceed = findViewById(R.id.btnPaymentProceed);
        btnPaymentProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),TicketDisplayActivity.class);

                intent.putExtras(bundle);

                Toast toast = Toast.makeText(getApplicationContext(),"Order Received!",Toast.LENGTH_SHORT);
                toast.show();

                startActivity(intent);
            }
        });



    }
}
