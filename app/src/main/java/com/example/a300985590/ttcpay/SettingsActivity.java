package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        dl = (DrawerLayout)findViewById(R.id.activity_settings);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent=null;
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.home:
                        intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.buyTickets:
                        intent=new Intent(getApplicationContext(),BuyTicketActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.useTickets:
                        intent=new Intent(getApplicationContext(),AvailableTicketActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.transitApp:
                        intent=new Intent(getApplicationContext(),MainActivity.class);//Directly open a link of transit app or google map
                        startActivity(intent);
                        break;
                    case R.id.moreInfo:
                        intent=new Intent(getApplicationContext(),MoreInfoActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.settings:
                        intent=new Intent(getApplicationContext(),SettingsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.loginSignout:
                        intent=new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        return true;
                }
                return  true;

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
