package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UpdatePassesPrice extends AppCompatActivity {
    String[] usersArray = {"Student Pass","Adult Pass","Senior Pass"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_passes_price);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.admin_options, usersArray);

        ListView listView = (ListView) findViewById(R.id.adminoptionslist);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String itemselectedname = (String) parent.getItemAtPosition(position);

                if("Student Pass".equalsIgnoreCase(itemselectedname))
                {
                    Intent intent = new Intent(UpdatePassesPrice.this, StudentPassUpdate.class);
                    startActivity(intent);
                }
                if("Adult Pass".equalsIgnoreCase(itemselectedname))
                {
                    Intent intent = new Intent(UpdatePassesPrice.this, AdultPassUpdate.class);
                    startActivity(intent);
                }

                if("Senior Pass".equalsIgnoreCase(itemselectedname))
                {
                    Intent intent = new Intent(UpdatePassesPrice.this, SeniorPassUpdate.class);
                    startActivity(intent);
                }

            }
        });



    }
}
