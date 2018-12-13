package com.example.a300985590.ttcpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewUsers extends AppCompatActivity {

    String[] usersArray = {" Username: shiva \n Email : shiva.bhalla@gmail.com \n Phone Number : 4379878669",
            " Username: sidharth \n Email : gr8sid7981@gmail.com \n Phone Number : 4678594563",
            " Username: bob \n Email : bob@gmail.com \n Phone Number : 4167852147",
            " Username: admin \n Email : admin123@gmail.com \n Phone Number : 4378523698"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
try {


    ArrayAdapter adapter = new ArrayAdapter<String>(this,
            R.layout.viewuserslist, usersArray);

    ListView listView = (ListView) findViewById(R.id.userslist);
    listView.setAdapter(adapter);
}
catch(Exception e)
{
    System.out.print("Exception in class is : "+e.getMessage());
e.printStackTrace();
}
    }
}
