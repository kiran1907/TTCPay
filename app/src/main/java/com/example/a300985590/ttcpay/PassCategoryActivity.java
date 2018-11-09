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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;

public class PassCategoryActivity extends AppCompatActivity {

    private EditText monthCountDisplay;
    private LinearLayout shoppingLayout;
    private static int  monthCount=0, weekCount=0, dailyCount=0;
    private Button  cancelBtn, proceedBtn;

    private EditText weekCountDisplay;

    //Menu Attributes starts
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    //Menu Attributes ends

    HashMap<String,Integer> montlyMap;
    HashMap<String,Integer> weeklyMap;
    HashMap<String,Integer> dailyMap;

    double monthlyPrice=0;
    double weeklyPrice=0;
    double dailyPrice=0;
    private Intent intent;
    private EditText dayCountDisplay;

    TextView monthCatName, weekCatName, dayCatName;
    TextView monthcategoryQuantity, weekcategoryQuantity, daycategoryQuantity;
    TextView monthcategoryPrice, weekcategoryPrice, daycategoryPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_category);


        //Menu Code starts
        dl = (DrawerLayout)findViewById(R.id.activity_pass);
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
            //Menu code ends



        monthCountDisplay=(EditText)findViewById(R.id.monthlyCount);
        weekCountDisplay= (EditText)findViewById(R.id.weeklyCount);
        dayCountDisplay = (EditText)findViewById(R.id.dailyCount);


        shoppingLayout=(LinearLayout)findViewById(R.id.shoppingCartLayout);

        cancelBtn=(Button)findViewById(R.id.cancelBtn);
        proceedBtn=(Button)findViewById(R.id.proceedBtn);

        monthCount=0;
        weekCount=0;
        dailyCount=0;

        montlyMap=new HashMap<String,Integer>();
        weeklyMap=new HashMap<String,Integer>();
        dailyMap=new HashMap<String,Integer>();


        Bundle b = getIntent().getExtras();
        monthlyPrice= b.getDouble("monthlyPrice");
        weeklyPrice= b.getDouble("weeklyPrice");
        dailyPrice= b.getDouble("dailyPrice");

        TextView mtextView=(TextView)findViewById(R.id.monthlyPrice);
        mtextView.setText("  $"+Double.toString(monthlyPrice));

        TextView wtextView=(TextView)findViewById(R.id.weeklyPrice);
        wtextView.setText("  $"+Double.toString(weeklyPrice));

        TextView dtextView=(TextView)findViewById(R.id.dailyPrice);
        dtextView.setText("  $"+Double.toString(dailyPrice));


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),BuyPassActivity.class);
                startActivity(intent);
            }
        });

    }

    //Required  Method for Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    public void minusClick(View v)
    {

        switch(v.getId())
        {
            case R.id.monthlyMinus:
                if(monthCount>0) {
                    //monthCount=monthCount-1;
                    --monthCount;

                    if(monthCount==0)
                    {
                        if(shoppingLayout.getVisibility()==View.VISIBLE)
                            shoppingLayout.setVisibility(View.INVISIBLE);
                        if(proceedBtn.getVisibility()==View.VISIBLE)
                            proceedBtn.setVisibility(View.INVISIBLE);
                        if(cancelBtn.getVisibility()==View.VISIBLE)
                            cancelBtn.setVisibility(View.INVISIBLE);

                        Toast.makeText(this,"Quantity can not be less than 1.",Toast.LENGTH_SHORT).show();

                        break;
                    }
                    else
                    {

                        monthCountDisplay.setText(monthCount + "");
                        prepareShoppingCart("Monthly", monthCount);
                        monthCatName.setVisibility(View.VISIBLE);
                        monthcategoryQuantity.setVisibility(View.VISIBLE);
                        monthcategoryPrice.setVisibility(View.VISIBLE);
                    }
                }
                else {
                   /* monthCatName.setVisibility(View.INVISIBLE);
                    monthcategoryQuantity.setVisibility(View.INVISIBLE);
                    monthcategoryPrice.setVisibility(View.INVISIBLE);
                    shoppingLayout.setVisibility(View.INVISIBLE);
                    proceedBtn.setVisibility(View.INVISIBLE);
                    cancelBtn.setVisibility(View.INVISIBLE);*/

                    if(shoppingLayout.getVisibility()==View.VISIBLE)
                        shoppingLayout.setVisibility(View.INVISIBLE);
                    if(proceedBtn.getVisibility()==View.VISIBLE)
                        proceedBtn.setVisibility(View.INVISIBLE);
                    if(cancelBtn.getVisibility()==View.VISIBLE)
                        cancelBtn.setVisibility(View.INVISIBLE);

                    Toast.makeText(this,"Quantity can not be less than 1.",Toast.LENGTH_SHORT).show();


                    break;
                }
                break;
            case R.id.weeklyMinus:
                if(weekCount>0) {
                    weekCount=weekCount-1;
                    weekCountDisplay.setText(weekCount + "");
                    prepareShoppingCart("Weekly", weekCount);
                    weekCatName.setVisibility(View.VISIBLE);
                    weekcategoryQuantity.setVisibility(View.VISIBLE);
                    weekcategoryPrice.setVisibility(View.VISIBLE);
                }
                else
                    weekCatName.setVisibility(View.INVISIBLE);
                weekcategoryQuantity.setVisibility(View.INVISIBLE);
                weekcategoryPrice.setVisibility(View.INVISIBLE);

                break;
            case R.id.dailyMinus:
                if(dailyCount>0) {
                    dailyCount=dailyCount-1;
                    dayCountDisplay.setText(dailyCount + "");
                    prepareShoppingCart("Day", dailyCount);
                    dayCatName.setVisibility(View.VISIBLE);
                    daycategoryQuantity.setVisibility(View.VISIBLE);
                    daycategoryPrice.setVisibility(View.VISIBLE);
                }
                else
                    dayCatName.setVisibility(View.INVISIBLE);
                daycategoryQuantity.setVisibility(View.INVISIBLE);
                daycategoryPrice.setVisibility(View.INVISIBLE);

                break;

        }

    }

    public void monthlyCountClick(View view){
        monthCount+=1;
        monthCountDisplay.setText(monthCount+"");
        if(shoppingLayout.getVisibility()==View.INVISIBLE)
            shoppingLayout.setVisibility(View.VISIBLE);
        if(proceedBtn.getVisibility()==View.INVISIBLE)
            proceedBtn.setVisibility(View.VISIBLE);
        if(cancelBtn.getVisibility()==View.INVISIBLE)
            cancelBtn.setVisibility(View.VISIBLE);

        prepareShoppingCart("Monthly",monthCount);

    }

    public void weeklyCountClick(View view){
        weekCount+=1;
        weekCountDisplay.setText(weekCount+"");
        prepareShoppingCart("Weekly",weekCount);
    }

    public void dailyCountClick(View view){
        dailyCount+=1;
        dayCountDisplay.setText(dailyCount+"");
        prepareShoppingCart("Day",dailyCount);
    }
    public void prepareShoppingCart(String categoryName,int count)
    {
        switch (categoryName)
        {
            case "Monthly":
                montlyMap.put("Monthly",count);
                break;
            case "Weekly":
                weeklyMap.put("Weekly",count);
                break;
            case "Day":
                dailyMap.put("Day",count);
                break;
        }

        addToCart();
    }

    public void showHiddenBtn()
    {
        proceedBtn.setVisibility(View.VISIBLE);
        cancelBtn.setVisibility(View.VISIBLE);
    }

    public void addToCart()
    {
        shoppingLayout.removeAllViews();
        if(montlyMap.size()>=1)
        {
            try
            {
                LinearLayout ll=new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setPadding(5,20,0,5);


                monthCatName=new TextView(this);
                monthCatName.setWidth(400);
                monthCatName.setText("Monthly");
                monthCatName.setTextColor(getResources().getColor(R.color.black));
                monthCatName.setTextSize(18);
                ll.addView(monthCatName);

                monthcategoryQuantity=new TextView(this);
                monthcategoryQuantity.setWidth(400);
                monthcategoryQuantity.setText(monthCount+"");
                monthcategoryQuantity.setTextColor(getResources().getColor(R.color.black));
                monthcategoryQuantity.setTextSize(18);
                ll.addView(monthcategoryQuantity);

                double totalPrice=monthCount*monthlyPrice;

                monthcategoryPrice=new TextView(this);
                monthcategoryPrice.setWidth(200);
                monthcategoryPrice.setText("$"+totalPrice);
                monthcategoryPrice.setTextColor(getResources().getColor(R.color.black));
                monthcategoryPrice.setTextSize(18);
                ll.addView(monthcategoryPrice);

                shoppingLayout.addView(ll);
                monthCatName.setVisibility(View.VISIBLE);
                monthcategoryQuantity.setVisibility(View.VISIBLE);
                monthcategoryPrice.setVisibility(View.VISIBLE);
                showHiddenBtn();

            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.print("Inside prepare cart exception is : "+e.getMessage());
            }

        }
        else
        {
            monthCatName.setVisibility(View.INVISIBLE);
            monthcategoryQuantity.setVisibility(View.INVISIBLE);
            monthcategoryPrice.setVisibility(View.INVISIBLE);
            shoppingLayout.setVisibility(View.INVISIBLE);
            proceedBtn.setVisibility(View.INVISIBLE);
            cancelBtn.setVisibility(View.INVISIBLE);

        }
        if(weeklyMap.size()>=1)
        {
            try
            {
                LinearLayout ll=new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setPadding(5,40,0,5);

                weekCatName=new TextView(this);
                weekCatName.setWidth(400);
                weekCatName.setText("Weekly");
                weekCatName.setTextColor(getResources().getColor(R.color.black));
                weekCatName.setTextSize(18);
                ll.addView(weekCatName);

                weekcategoryQuantity=new TextView(this);
                weekcategoryQuantity.setWidth(400);
                weekcategoryQuantity.setText(weekCount+"");
                weekcategoryQuantity.setTextColor(getResources().getColor(R.color.black));
                weekcategoryQuantity.setTextSize(18);
                ll.addView(weekcategoryQuantity);

                double totalPrice=weekCount*weeklyPrice;

                weekcategoryPrice=new TextView(this);
                weekcategoryPrice.setWidth(200);
                weekcategoryPrice.setText("$"+totalPrice);
                weekcategoryPrice.setTextColor(getResources().getColor(R.color.black));
                weekcategoryPrice.setTextSize(18);
                ll.addView(weekcategoryPrice);

                shoppingLayout.addView(ll);
                weekCatName.setVisibility(View.VISIBLE);
                weekcategoryQuantity.setVisibility(View.VISIBLE);
                weekcategoryPrice.setVisibility(View.VISIBLE);

                showHiddenBtn();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.print("Inside prepare cart exception is : "+e.getMessage());
            }

        }
        if(dailyMap.size()>=1)
        {
            try
            {
                LinearLayout ll=new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setPadding(5,40,0,5);

                dayCatName=new TextView(this);
                dayCatName.setTextColor(getResources().getColor(R.color.black));
                dayCatName.setTextSize(18);
                dayCatName.setWidth(400);
                dayCatName.setText("Day");
                ll.addView(dayCatName);

                daycategoryQuantity=new TextView(this);
                daycategoryQuantity.setWidth(400);
                daycategoryQuantity.setText(dailyCount+"");
                daycategoryQuantity.setTextColor(getResources().getColor(R.color.black));
                daycategoryQuantity.setTextSize(18);
                ll.addView(daycategoryQuantity);

                double totalPrice=dailyCount*dailyPrice;

                daycategoryPrice=new TextView(this);
                daycategoryPrice.setWidth(200);
                daycategoryPrice.setTextColor(getResources().getColor(R.color.black));
                daycategoryPrice.setTextSize(18);
                daycategoryPrice.setText("$"+totalPrice);
                ll.addView(daycategoryPrice);

                shoppingLayout.addView(ll);
                showHiddenBtn();

                dayCatName.setVisibility(View.VISIBLE);
                daycategoryQuantity.setVisibility(View.VISIBLE);
                daycategoryPrice.setVisibility(View.VISIBLE);


            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.print("Inside prepare cart exception is : "+e.getMessage());
            }

        }

    }



}
