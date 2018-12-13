package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AdminMainScreen extends AppCompatActivity {

    String[] usersArray = {"Access Users","Access Tickets","Update tickets/passes price"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_screen);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.admin_options, usersArray);

        ListView listView = (ListView) findViewById(R.id.adminoptionslist);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String itemselectedname = (String) parent.getItemAtPosition(position);

                /*Toast toast = Toast.makeText(getApplicationContext(),"Selected Option is :"+itemselectedname,Toast.LENGTH_SHORT);
                toast.show();
                */

                if("Access Users".equalsIgnoreCase(itemselectedname))
                {
                    Intent intent = new Intent(AdminMainScreen.this, ViewUsers.class);
                    startActivity(intent);
                }
                if("Access Tickets".equalsIgnoreCase(itemselectedname))
                {
                    Intent intent = new Intent(AdminMainScreen.this, AvailbaleTicketsForAdmin.class);
                    startActivity(intent);
                }

            }
        });



    }


}
