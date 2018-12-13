package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AvailablePassesActivity extends AppCompatActivity {


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private TableLayout passesTableLayout;
    double monthlyPrice = 0, weeklyPrice = 0, dailyPrice = 0;
    private int monthCount = 0, weekCount = 0, dailyCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_passes);

        dl = (DrawerLayout)findViewById(R.id.activity_avail_pass);
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
                        intent=new Intent(getApplicationContext(),FeedbackActivity.class);
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

        passesTableLayout = findViewById(R.id.passesTable);
        passesTableLayout.setStretchAllColumns(true);
        startLoadData();

    }

    public void startLoadData(){

        final Bundle bundle = getIntent().getExtras();
        final String passName = bundle.getString("PassName");
        final String monthly = "monthly";
        final String weekly = "weekly";
        final String daily = "daily";
        monthlyPrice = bundle.getDouble("monthlyPrice");
        weeklyPrice = bundle.getDouble("WeeklyPrice");
        monthCount = bundle.getInt("monthCount");
        weekCount = bundle.getInt("weekCount");
        dailyCount = bundle.getInt("dailyCount");
        dailyPrice = bundle.getDouble("dailyPrice");

        final TextView textView = new TextView(this);
        textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.LEFT);
        textView.setPadding(5,15,0,15);
        textView.setText(monthly);

        final TextView textView2 = new TextView(this);
        textView2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView2.setGravity(Gravity.LEFT);
        textView2.setPadding(5,15,0,15);
        textView2.setText("  $"+Double.toString(monthlyPrice));

        final TextView textView3 = new TextView(this);
        textView3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView3.setGravity(Gravity.LEFT);
        textView3.setPadding(5,15,0,15);
        textView3.setText(Integer.toString(monthCount));

        final TextView textView4 = new TextView(this);
        textView4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView4.setGravity(Gravity.LEFT);
        textView4.setPadding(5,15,0,15);
        textView4.setText(Integer.toString(weekCount));

        final TextView textView5 = new TextView(this);
        textView5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView5.setGravity(Gravity.LEFT);
        textView5.setPadding(5,15,0,15);
        textView5.setText(Integer.toString(dailyCount));

        final TextView textView6 = new TextView(this);
        textView6.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView6.setGravity(Gravity.LEFT);
        textView6.setPadding(5,15,0,15);
        textView6.setText("  $"+Double.toString(weeklyPrice));

        final TextView textView7 = new TextView(this);
        textView7.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView7.setGravity(Gravity.LEFT);
        textView7.setPadding(5,15,0,15);
        textView7.setText("  $"+Double.toString(dailyPrice));

        final TextView textView8 = new TextView(this);
        textView8.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView8.setGravity(Gravity.LEFT);
        textView8.setPadding(5,15,0,15);
        textView8.setText(weekly);

        final TextView textView9 = new TextView(this);
        textView9.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView9.setGravity(Gravity.LEFT);
        textView9.setPadding(5,15,0,15);
        textView9.setText(daily);

        final TextView textView10 = new TextView(this);
        textView10.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView10.setGravity(Gravity.LEFT);
        textView10.setPadding(5,15,0,15);
        textView10.setText("adult Pass");

        final TextView textView11 = new TextView(this);
        textView11.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView11.setGravity(Gravity.LEFT);
        textView11.setPadding(5,15,0,15);
        textView11.setText("Student Pass");

        final TextView textView12 = new TextView(this);
        textView12.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView12.setGravity(Gravity.LEFT);
        textView12.setPadding(5,15,0,15);
        textView12.setText("Senior Pass");

        final TableRow tableRowPass = new TableRow(this);
        TableLayout.LayoutParams trParams1 = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        trParams1.setMargins(0,0,0,0);
        tableRowPass.setPadding(0,0,0,0);
        tableRowPass.setLayoutParams(trParams1);

        if(passName.equals("AdultPass")){
            tableRowPass.addView(textView10);
        }else if(passName.equals("StudentPass")){
            tableRowPass.addView(textView11);
        }else if(passName.equals("SeniorPass")){
            tableRowPass.addView(textView12);
        }

        passesTableLayout.addView(tableRowPass,trParams1);
        if(monthly == "monthly" && monthCount > 0){

            final TableRow tableRow = new TableRow(this);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            trParams.setMargins(0,0,0,0);
            tableRow.setPadding(0,0,0,0);
            tableRow.setLayoutParams(trParams);


            tableRow.addView(textView);
            tableRow.addView(textView2);
            tableRow.addView(textView3);
            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableRow tr = (TableRow) view;
                    Intent intentView = new Intent(AvailablePassesActivity.this,ShowPassesActivity.class);

                    Bundle bun = new Bundle();
                    bun.putDouble("perPassMonthPrice",monthlyPrice/monthCount);
                    bun.putInt("monthCount",monthCount);
                    bun.putString("passName",passName);
                    bun.putString("passCategory",monthly);
                    intentView.putExtras(bun);
                    startActivity(intentView);
                }
            });

            passesTableLayout.addView(tableRow,trParams);

        }
        if (weekly == "weekly" && weekCount > 0){
            final TableRow tableRow1 = new TableRow(this);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            trParams.setMargins(0,0,0,0);
            tableRow1.setPadding(0,0,0,0);
            tableRow1.setLayoutParams(trParams);

            tableRow1.addView(textView8);
            tableRow1.addView(textView6);
            tableRow1.addView(textView4);
            tableRow1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableRow tr = (TableRow) view;
                    Intent intentView = new Intent(AvailablePassesActivity.this,ShowPassesActivity.class);
                    Bundle bun = new Bundle();
                    bun.putDouble("perPassWeekPrice", weeklyPrice/weekCount);
                    bun.putInt("weekCount",weekCount);
                    bun.putString("passName",passName);
                    bun.putString("passCategory",weekly);
                    intentView.putExtras(bun);
                    startActivity(intentView);
                }
            });

            passesTableLayout.addView(tableRow1,trParams);

        } if (daily == "daily" && dailyCount > 0){
            final TableRow tableRow3 = new TableRow(this);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            trParams.setMargins(0,0,0,0);
            tableRow3.setPadding(0,0,0,0);
            tableRow3.setLayoutParams(trParams);

            tableRow3.addView(textView9);
            tableRow3.addView(textView7);
            tableRow3.addView(textView5);
            tableRow3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableRow tr = (TableRow) view;
                    Intent intentView = new Intent(AvailablePassesActivity.this,ShowPassesActivity.class);
                    Bundle bun = new Bundle();
                    bun.putDouble("perPassDayPrice",dailyPrice/dailyCount);
                    bun.putInt("dailyCount",dailyCount);
                    bun.putString("passName",passName);
                    bun.putString("passCategory",daily);
                    intentView.putExtras(bun);
                    startActivity(intentView);
                }
            });

            passesTableLayout.addView(tableRow3,trParams);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}
