package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ShowPassesActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    double monthPassPrice = 0, weekPassPrice = 0, dailyPassPrice = 0;
    private int monthCount = 0, weekCount = 0, dailyCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_passes);

        dl = (DrawerLayout) findViewById(R.id.activity_avail_ticket);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent intent = null;
                switch (id) {
                    case R.id.home:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.buyTickets:
                        intent = new Intent(getApplicationContext(), BuyTicketActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.useTickets:
                        intent = new Intent(getApplicationContext(), AvailableTicketActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.transitApp:
                        intent = new Intent(getApplicationContext(), MainActivity.class);//Directly open a link of transit app or google map
                        startActivity(intent);
                        break;
                    case R.id.moreInfo:
                        intent = new Intent(getApplicationContext(), FeedbackActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.settings:
                        intent = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.loginSignout:
                        intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        return true;
                }
                return true;

            }
        });

        String monthname=(String)android.text.format.DateFormat.format("MMM/yyyy", new Date());
        Calendar c = Calendar.getInstance();
        //int year = c.get(Calendar.YEAR);
        //int month = c.get(Calendar.MONTH);

        final Bundle bundle = getIntent().getExtras();
        monthPassPrice = bundle.getDouble("perPassMonthPrice");
        weekPassPrice = bundle.getDouble("perPassWeekPrice");
        dailyPassPrice = bundle.getDouble("perPassDailyPrice");
        monthCount = bundle.getInt("monthCount");
        weekCount = bundle.getInt("weekCount");
        dailyCount = bundle.getInt("dailyCount");
        String passCategory = bundle.getString("passCategory");
        String passName = bundle.getString("passName");

        TextView lowerView = (TextView) findViewById(R.id.lowerTextView);
        lowerView.setText("METROPASS" + "                       "+ monthname);
        TextView upperView = (TextView) findViewById(R.id.upperTextView);
        if (passName.equals("AdultPass")) {
            if (passCategory.equals("monthly")) {
                upperView.setText(passName + "                      $"+ Double.toString(monthPassPrice) + "                     Passes :" + Integer.toString(monthCount));
            } else if (passCategory.equals("weekly")) {
                upperView.setText(passName + "                      $" +Double.toString(weekPassPrice) + "                      Passes:" + Integer.toString(weekCount));
            } else if (passCategory.equals("daily")) {
                upperView.setText(passName + "                      $"+Double.toString(dailyPassPrice) + "               Passes :" + Integer.toString(dailyCount));
            }
        } else if (passName.equals("StudentPass")) {
            if (passCategory.equals("monthly")) {
                upperView.setText(passName + "                      $"+ Double.toString(monthPassPrice) + "                     Passes :" + Integer.toString(monthCount));
            } else if (passCategory.equals("weekly")) {
                upperView.setText(passName + "                      $" +Double.toString(weekPassPrice) + "                      Passes:" + Integer.toString(weekCount));
            } else if (passCategory.equals("daily")) {
                upperView.setText(passName + "                      $"+Double.toString(dailyPassPrice) + "                      Passes :" + Integer.toString(dailyCount));
            }
        } else if (passName.equals("SeniorPass")) {
            if (passCategory.equals("monthly")) {
                upperView.setText(passName + "                      $"+ Double.toString(monthPassPrice) + "                     Passes :" + Integer.toString(monthCount));
            } else if (passCategory.equals("weekly")) {
                upperView.setText(passName + "                      $" +Double.toString(weekPassPrice) + "                      Passes:" + Integer.toString(weekCount));
            } else if (passCategory.equals("daily")) {
                upperView.setText(passName + "                      $"+Double.toString(dailyPassPrice) + "                      Passes :" + Integer.toString(dailyCount));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
