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

    private HashMap<String,Integer> monthlyPassMap=null;
    private HashMap<String,Integer> weeklyPassMap=null;
    private HashMap<String,Integer> dailyPassMap=null;

    private static int monthlyPassQuantityCount=0;
    private static int weeklyPassQuantityCount=0;
    private static int dailyPassQuantityCount=0;


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

    TextView monthCatName, weekCatName, dayCatName,totalField,totalFieldPrice;
    TextView monthcategoryQuantity, weekcategoryQuantity, daycategoryQuantity;
    TextView monthcategoryPrice, weekcategoryPrice, daycategoryPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_category);


        monthlyPassMap=new HashMap<String,Integer>();
        weeklyPassMap=new HashMap<String,Integer>();
        dailyPassMap=new HashMap<String,Integer>();

        monthlyPassQuantityCount=0;
        weeklyPassQuantityCount=0;
        dailyPassQuantityCount=0;

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

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent=new Intent(PassCategoryActivity.this,AvailablePassesActivity.class);
                Bundle bundle = new Bundle();
                if(monthlyPrice == 150){
                    bundle.putDouble("monthlyPrice",monthlyPassQuantityCount*monthlyPrice);
                    bundle.putString("PassName","AdultPass");
                    bundle.putInt("monthCount",monthlyPassQuantityCount);
                    bundle.putDouble("WeeklyPrice",weeklyPassQuantityCount*weeklyPrice);
                    bundle.putInt("weekCount",weeklyPassQuantityCount);
                    bundle.putDouble("dailyPrice",dailyPrice*dailyPassQuantityCount);
                    bundle.putInt("dailyCount",dailyPassQuantityCount);
                    intent.putExtras(bundle);
                }else if(monthlyPrice == 117){
                    bundle.putDouble("monthlyPrice",monthlyPassQuantityCount*monthlyPrice);
                    bundle.putString("PassName","StudentPass");
                    bundle.putInt("monthCount",monthlyPassQuantityCount);
                    bundle.putDouble("WeeklyPrice",weeklyPassQuantityCount*weeklyPrice);
                    bundle.putInt("weekCount",weeklyPassQuantityCount);
                    bundle.putDouble("dailyPrice",dailyPrice*dailyPassQuantityCount);
                    bundle.putInt("dailyCount",dailyPassQuantityCount);
                    intent.putExtras(bundle);
                } else {
                    bundle.putDouble("monthlyPrice",monthlyPassQuantityCount*monthlyPrice);
                    bundle.putString("PassName","SeniorPass");
                    bundle.putInt("monthCount",monthlyPassQuantityCount);
                    bundle.putDouble("WeeklyPrice",weeklyPassQuantityCount*weeklyPrice);
                    bundle.putInt("weekCount",weeklyPassQuantityCount);
                    bundle.putDouble("dailyPrice",dailyPrice*dailyPassQuantityCount);
                    bundle.putInt("dailyCount",dailyPassQuantityCount);
                    intent.putExtras(bundle);
                }
                Toast toast = Toast.makeText(getApplicationContext(),"PAYMENT RECIEVED",Toast.LENGTH_SHORT);
                toast.show();
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


    public void  plusClick(View view)
    {

        switch(view.getId())
        {
            case R.id.monthlyPlus:
                monthlyPassQuantityCount=monthlyPassQuantityCount+1;
                if(monthlyPassQuantityCount>0 && monthlyPassQuantityCount<6) {
                    monthCountDisplay.setText(monthlyPassQuantityCount + "");
                    monthlyPassMap.put("monthlyPass", monthlyPassQuantityCount);
                }
                else
                {
                    monthlyPassQuantityCount=monthlyPassQuantityCount-1;
                    Toast.makeText(this,"You can only purchase maximum of 5 passes of same category.",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.dailyPlus:
                dailyPassQuantityCount=dailyPassQuantityCount+1;
                if(dailyPassQuantityCount>0 && dailyPassQuantityCount<6) {

                    dayCountDisplay.setText(dailyPassQuantityCount + "");
                    dailyPassMap.put("dailyPass", dailyPassQuantityCount);
                }
                else
                {
                    dailyPassQuantityCount=dailyPassQuantityCount-1;
                    Toast.makeText(this,"You can only purchase maximum of 5 passes of same category.",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.weeklyPlus:
                weeklyPassQuantityCount=weeklyPassQuantityCount+1;
                if(weeklyPassQuantityCount>0 && weeklyPassQuantityCount<6) {

                    weekCountDisplay.setText(weeklyPassQuantityCount + "");
                    monthlyPassMap.put("weeklyPass", weeklyPassQuantityCount);
                }
                else
                {
                    weeklyPassQuantityCount=weeklyPassQuantityCount-1;
                    Toast.makeText(this,"You can only purchase maximum of 5 passes of same category.",Toast.LENGTH_SHORT).show();
                }
                break;

        }
        addToCart();
    }
    public void  minusClick(View view)
    {
        try {
            switch (view.getId()) {
                case R.id.monthlyMinus:
                    monthlyPassQuantityCount = monthlyPassQuantityCount - 1;
                    if (monthlyPassQuantityCount >= 0) {
                        monthCountDisplay.setText(monthlyPassQuantityCount + "");
                        monthlyPassMap.put("monthlyPass", monthlyPassQuantityCount);
                    } else {
                        monthlyPassQuantityCount = monthlyPassQuantityCount + 1;
                        Toast.makeText(this, "Quantity can not be less than 0.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.dailyMinus:
                    dailyPassQuantityCount = dailyPassQuantityCount - 1;
                    if (dailyPassQuantityCount >= 0) {
                        dayCountDisplay.setText(dailyPassQuantityCount + "");
                        dailyPassMap.put("dailyPass", dailyPassQuantityCount);
                    } else {
                        dailyPassQuantityCount = dailyPassQuantityCount + 1;
                        Toast.makeText(this, "Quantity can not be less than 0.", Toast.LENGTH_SHORT).show();

                    }
                    break;
                case R.id.weeklyMinus:
                    weeklyPassQuantityCount = weeklyPassQuantityCount - 1;
                    if (weeklyPassQuantityCount >= 0) {
                        weekCountDisplay.setText(weeklyPassQuantityCount + "");
                        monthlyPassMap.put("weeklyPass", weeklyPassQuantityCount);
                    } else {
                        weeklyPassQuantityCount = weeklyPassQuantityCount + 1;
                        Toast.makeText(this, "Quantity can not be less than 0.", Toast.LENGTH_SHORT).show();
                    }
                    break;

            }
            addToCart();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void addToCart()
    {
        shoppingLayout.removeAllViews();
        if(monthlyPassQuantityCount>0)
        {
            try
            {
                LinearLayout ll=new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setId(R.id.layout1);
                ll.setPadding(5,20,0,5);


                monthCatName=new TextView(this);
                monthCatName.setWidth(400);
                monthCatName.setText("Monthly");
                monthCatName.setTextColor(getResources().getColor(R.color.black));
                monthCatName.setTextSize(18);
                ll.addView(monthCatName);

                monthcategoryQuantity=new TextView(this);
                monthcategoryQuantity.setWidth(400);
                monthcategoryQuantity.setText(monthlyPassQuantityCount+"");
                monthcategoryQuantity.setTextColor(getResources().getColor(R.color.black));
                monthcategoryQuantity.setTextSize(18);
                ll.addView(monthcategoryQuantity);

                double totalPrice=monthlyPassQuantityCount*monthlyPrice;

                monthcategoryPrice=new TextView(this);
                monthcategoryPrice.setWidth(200);
                monthcategoryPrice.setText("$"+totalPrice);
                monthcategoryPrice.setTextColor(getResources().getColor(R.color.black));
                monthcategoryPrice.setTextSize(18);
                ll.addView(monthcategoryPrice);

                shoppingLayout.addView(ll);

            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.print("Inside prepare cart exception is : "+e.getMessage());
            }

        }

        if(weeklyPassQuantityCount>0)
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
                weekcategoryQuantity.setText(weeklyPassQuantityCount+"");
                weekcategoryQuantity.setTextColor(getResources().getColor(R.color.black));
                weekcategoryQuantity.setTextSize(18);
                ll.addView(weekcategoryQuantity);

                double totalPrice=weeklyPassQuantityCount*weeklyPrice;

                weekcategoryPrice=new TextView(this);
                weekcategoryPrice.setWidth(200);
                weekcategoryPrice.setText("$"+totalPrice);
                weekcategoryPrice.setTextColor(getResources().getColor(R.color.black));
                weekcategoryPrice.setTextSize(18);
                ll.addView(weekcategoryPrice);

                shoppingLayout.addView(ll);

            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.print("Inside prepare cart exception is : "+e.getMessage());
            }

        }
        if(dailyPassQuantityCount>0)
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
                daycategoryQuantity.setText(dailyPassQuantityCount+"");
                daycategoryQuantity.setTextColor(getResources().getColor(R.color.black));
                daycategoryQuantity.setTextSize(18);
                ll.addView(daycategoryQuantity);

                double totalPrice=dailyPassQuantityCount*dailyPrice;

                daycategoryPrice=new TextView(this);
                daycategoryPrice.setWidth(200);
                daycategoryPrice.setTextColor(getResources().getColor(R.color.black));
                daycategoryPrice.setTextSize(18);
                daycategoryPrice.setText("$"+totalPrice);
                ll.addView(daycategoryPrice);

                shoppingLayout.addView(ll);



            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.print("Inside prepare cart exception is : "+e.getMessage());
            }

        }


        if(monthlyPassQuantityCount>0 || weeklyPassQuantityCount>0 || dailyPassQuantityCount>0)
        {


            float totalPrice=Float.parseFloat( (monthlyPassQuantityCount*monthlyPrice + dailyPassQuantityCount*dailyPrice + weeklyPassQuantityCount*weeklyPrice)+"");

            LinearLayout ll=new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setPadding(5,40,0,5);
            totalField=new TextView(this);
            totalField.setTextColor(getResources().getColor(R.color.black));
            totalField.setTextSize(24);
            totalField.setWidth(400);
            totalField.setText("Total Price : ");
            ll.addView(totalField);


            totalFieldPrice=new TextView(this);
            totalFieldPrice.setTextColor(getResources().getColor(R.color.black));
            totalFieldPrice.setTextSize(24);
            totalFieldPrice.setWidth(400);
            totalFieldPrice.setText("$"+totalPrice);
            ll.addView(totalFieldPrice);


            shoppingLayout.addView(ll);


            proceedBtn.setVisibility(View.VISIBLE);
            cancelBtn.setVisibility(View.VISIBLE);
        }
        else
        {
            proceedBtn.setVisibility(View.INVISIBLE);
            cancelBtn.setVisibility(View.INVISIBLE);
        }
    }

}
