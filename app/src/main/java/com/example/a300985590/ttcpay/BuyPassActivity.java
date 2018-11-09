package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class BuyPassActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_pass);

        dl = (DrawerLayout)findViewById(R.id.activity_buy_pass);
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
    public void openPassCategory(View view){
        Intent intent = new Intent(BuyPassActivity.this, PassCategoryActivity.class);
        Bundle b = new Bundle();
        double adultMonthlyPassPrice=150, adultDailyPassPrice=10, adultWeeklyPassPrice=45;
        double studentMonthlyPassPrice=117, studentDailyPassPrice=6, studentWeeklyPassPrice=35;
        double seniorMonthlyPassPrice=100, seniorDailyPassPrice=5, seniorWeeklyPassPrice=30;


        switch (view.getId()) {
            case R.id.buyAdultPassBtn:
                b.putDouble("monthlyPrice",adultMonthlyPassPrice);
                b.putDouble("weeklyPrice",adultWeeklyPassPrice);
                b.putDouble("dailyPrice",adultDailyPassPrice);
                intent.putExtras(b);
                startActivity(intent);

                break;
            case R.id.buySeniorPassBtn:
                b.putDouble("monthlyPrice",studentMonthlyPassPrice);
                b.putDouble("weeklyPrice",studentWeeklyPassPrice);
                b.putDouble("dailyPrice",studentDailyPassPrice);
                intent.putExtras(b);
                startActivity(intent);
                break;
            case R.id.buyStudentPassBtn:
                b.putDouble("monthlyPrice",seniorMonthlyPassPrice);
                b.putDouble("weeklyPrice",seniorWeeklyPassPrice);
                b.putDouble("dailyPrice",seniorDailyPassPrice);
                intent.putExtras(b);
                startActivity(intent);
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
