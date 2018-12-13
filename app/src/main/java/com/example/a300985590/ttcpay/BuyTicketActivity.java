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

public class BuyTicketActivity extends AppCompatActivity {

    private EditText adultCountDisplay;
    private LinearLayout shoppingLayout;
    private Button cancelBtn, proceedBtn;

    private EditText seniorCountDisplay;

    private HashMap<String,Integer> adultTicketMap=null;
    private HashMap<String,Integer> seniorTicketMap=null;
    private HashMap<String,Integer> studentTicketMap=null;


    private static int adultQuantityCount=0;
    private static int studentQuantityCount=0;
    private static int seniorQuantityCount=0;


    //Menu Attributes starts
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    //Menu Attributes ends

    HashMap<String,Integer> adultMap;
    HashMap<String,Integer> seniorMap;
    HashMap<String,Integer> studentMap;

    double adultPrice=3.25;
    double seniorPrice=2.0;
    double studentPrice=2.10;
    private Intent intent;
    private EditText studentCountDisplay;

    TextView adultCatName, seniorCatName, studentCatName,totalField,totalFieldPrice;
    TextView adultcategoryQuantity, seniorcategoryQuantity, studentcategoryQuantity;
    TextView adultcategoryPrice, seniorategoryPrice, studentcategoryPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
        adultTicketMap=new HashMap<String,Integer>();
        seniorTicketMap=new HashMap<String,Integer>();
        studentTicketMap=new HashMap<String,Integer>();

        adultQuantityCount=0;
        studentQuantityCount=0;
        seniorQuantityCount=0;

        //Menu Code starts
        dl = (DrawerLayout)findViewById(R.id.activity_buy_ticket);
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
        //Menu code ends



        adultCountDisplay=(EditText)findViewById(R.id.adultCount);
        seniorCountDisplay= (EditText)findViewById(R.id.seniorCount);
        studentCountDisplay = (EditText)findViewById(R.id.studentCount);


        shoppingLayout=(LinearLayout)findViewById(R.id.shoppingCartLayout);

        cancelBtn=(Button)findViewById(R.id.cancelBtn);
        proceedBtn=(Button)findViewById(R.id.proceedBtn);


        adultMap=new HashMap<String,Integer>();
        seniorMap=new HashMap<String,Integer>();
        studentMap=new HashMap<String,Integer>();


        TextView mtextView=(TextView)findViewById(R.id.adultPrice);
        mtextView.setText("  $"+Double.toString(adultPrice));

        TextView wtextView=(TextView)findViewById(R.id.seniorPrice);
        wtextView.setText("  $"+Double.toString(seniorPrice));

        TextView dtextView=(TextView)findViewById(R.id.studentPrice);
        dtextView.setText("  $"+Double.toString(studentPrice));


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),BuyPassActivity.class);
                startActivity(intent);
            }
        });

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent=new Intent(BuyTicketActivity.this,PaymentActivity.class);
                Bundle bundle = new Bundle();
                if(adultQuantityCount > 0){
                    bundle.putDouble("adultPrice",adultQuantityCount*adultPrice);
                    // bundle.putString("TicketName","AdultTicket");
                    bundle.putInt("adultTicketCount",adultQuantityCount);
                    intent.putExtras(bundle);
                }
                if(seniorQuantityCount > 0){
                    bundle.putDouble("seniorPrice",seniorQuantityCount*seniorPrice);
                    // bundle.putString("TicketName","SeniorTicket");
                    bundle.putInt("seniorTicketCount",seniorQuantityCount);
                    intent.putExtras(bundle);
                }
                if(studentQuantityCount > 0)
                {
                    bundle.putDouble("studentPrice",studentQuantityCount*studentPrice);
                    // bundle.putString("TicketName","StudentTicket");
                    bundle.putInt("studentTicketCount",studentQuantityCount);
                    intent.putExtras(bundle);
                }
               /* Toast toast = Toast.makeText(getApplicationContext(),"PAYMENT RECIEVED",Toast.LENGTH_SHORT);
                toast.show();*/
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
            case R.id.adultPlus:
                adultQuantityCount=adultQuantityCount+1;
                if(adultQuantityCount>0 && adultQuantityCount<6) {
                    adultCountDisplay.setText(adultQuantityCount + "");
                    adultMap.put("monthlyPass", adultQuantityCount);
                }
                else
                {
                    adultQuantityCount=adultQuantityCount-1;
                    Toast.makeText(this,"You can only purchase maximum of 5 tickets of same category.",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.seniorPlus:
                seniorQuantityCount=seniorQuantityCount+1;
                if(seniorQuantityCount>0 && seniorQuantityCount<6) {

                    seniorCountDisplay.setText(seniorQuantityCount + "");
                    seniorMap.put("dailyPass", seniorQuantityCount);
                }
                else
                {
                    seniorQuantityCount=seniorQuantityCount-1;
                    Toast.makeText(this,"You can only purchase maximum of 5 tickets of same category.",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.studentPlus:
                studentQuantityCount=studentQuantityCount+1;
                if(studentQuantityCount>0 && studentQuantityCount<6) {

                    studentCountDisplay.setText(studentQuantityCount + "");
                    studentMap.put("weeklyPass", studentQuantityCount);
                }
                else
                {
                    studentQuantityCount=studentQuantityCount-1;
                    Toast.makeText(this,"You can only purchase maximum of 5 tickets of same category.",Toast.LENGTH_SHORT).show();
                }
                break;

        }
        addToCart();
    }
    public void  minusClick(View view)
    {
        try {
            switch (view.getId()) {
                case R.id.adultMinus:
                    adultQuantityCount = adultQuantityCount - 1;
                    if (adultQuantityCount >= 0) {
                        adultCountDisplay.setText(adultQuantityCount + "");
                        adultMap.put("monthlyPass", adultQuantityCount);
                    } else {
                        adultQuantityCount = adultQuantityCount + 1;
                        Toast.makeText(this, "Quantity can not be less than 0.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.seniorMinus:
                    seniorQuantityCount = seniorQuantityCount - 1;
                    if (seniorQuantityCount >= 0) {
                        seniorCountDisplay.setText(seniorQuantityCount + "");
                        seniorMap.put("dailyPass", seniorQuantityCount);
                    } else {
                        seniorQuantityCount = seniorQuantityCount + 1;
                        Toast.makeText(this, "Quantity can not be less than 0.", Toast.LENGTH_SHORT).show();

                    }
                    break;
                case R.id.studentMinus:
                    studentQuantityCount = studentQuantityCount - 1;
                    if (studentQuantityCount >= 0) {
                        studentCountDisplay.setText(studentQuantityCount + "");
                        studentMap.put("weeklyPass", studentQuantityCount);
                    } else {
                        studentQuantityCount = studentQuantityCount + 1;
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
        if(adultQuantityCount>0)
        {
            try
            {
                LinearLayout ll=new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setId(R.id.layout1);
                ll.setPadding(5,20,0,5);


                adultCatName=new TextView(this);
                adultCatName.setWidth(400);
                adultCatName.setText("ADULT");
                adultCatName.setTextColor(getResources().getColor(R.color.black));
                adultCatName.setTextSize(18);
                ll.addView(adultCatName);

                adultcategoryQuantity=new TextView(this);
                adultcategoryQuantity.setWidth(400);
                adultcategoryQuantity.setText(adultQuantityCount+"");
                adultcategoryQuantity.setTextColor(getResources().getColor(R.color.black));
                adultcategoryQuantity.setTextSize(18);
                ll.addView(adultcategoryQuantity);

                double totalPrice=adultQuantityCount*adultPrice;

                adultcategoryPrice=new TextView(this);
                adultcategoryPrice.setWidth(200);
                adultcategoryPrice.setText("$"+totalPrice);
                adultcategoryPrice.setTextColor(getResources().getColor(R.color.black));
                adultcategoryPrice.setTextSize(18);
                ll.addView(adultcategoryPrice);

                shoppingLayout.addView(ll);

            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.print("Inside prepare cart exception is : "+e.getMessage());
            }

        }

        if(seniorQuantityCount>0)
        {
            try
            {
                LinearLayout ll=new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setPadding(5,40,0,5);

                seniorCatName=new TextView(this);
                seniorCatName.setWidth(400);
                seniorCatName.setText("SENIOR");
                seniorCatName.setTextColor(getResources().getColor(R.color.black));
                seniorCatName.setTextSize(18);
                ll.addView(seniorCatName);

                seniorcategoryQuantity=new TextView(this);
                seniorcategoryQuantity.setWidth(400);
                seniorcategoryQuantity.setText(seniorQuantityCount+"");
                seniorcategoryQuantity.setTextColor(getResources().getColor(R.color.black));
                seniorcategoryQuantity.setTextSize(18);
                ll.addView(seniorcategoryQuantity);

                double totalPrice=seniorQuantityCount*seniorPrice;

                seniorategoryPrice=new TextView(this);
                seniorategoryPrice.setWidth(200);
                seniorategoryPrice.setText("$"+totalPrice);
                seniorategoryPrice.setTextColor(getResources().getColor(R.color.black));
                seniorategoryPrice.setTextSize(18);
                ll.addView(seniorategoryPrice);

                shoppingLayout.addView(ll);

            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.print("Inside prepare cart exception is : "+e.getMessage());
            }

        }
        if(studentQuantityCount>0)
        {
            try
            {
                LinearLayout ll=new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setPadding(5,40,0,5);

                studentCatName=new TextView(this);
                studentCatName.setTextColor(getResources().getColor(R.color.black));
                studentCatName.setTextSize(18);
                studentCatName.setWidth(400);
                studentCatName.setText("STUDENT");
                ll.addView(studentCatName);

                studentcategoryQuantity=new TextView(this);
                studentcategoryQuantity.setWidth(400);
                studentcategoryQuantity.setText(studentQuantityCount+"");
                studentcategoryQuantity.setTextColor(getResources().getColor(R.color.black));
                studentcategoryQuantity.setTextSize(18);
                ll.addView(studentcategoryQuantity);

                double totalPrice=studentQuantityCount*studentPrice;

               studentcategoryPrice=new TextView(this);
                studentcategoryPrice.setWidth(200);
                studentcategoryPrice.setTextColor(getResources().getColor(R.color.black));
                studentcategoryPrice.setTextSize(18);
                studentcategoryPrice.setText("$"+totalPrice);
                ll.addView(studentcategoryPrice);

                shoppingLayout.addView(ll);



            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.print("Inside prepare cart exception is : "+e.getMessage());
            }

        }


        if(adultQuantityCount>0 || seniorQuantityCount>0 || studentQuantityCount>0)
        {


            float totalPrice=Float.parseFloat( (adultQuantityCount*adultPrice + seniorQuantityCount*seniorPrice + studentQuantityCount*studentPrice)+"");

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
