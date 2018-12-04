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

public class TicketDisplayActivity extends AppCompatActivity {

    private DrawerLayout d;
    private ActionBarDrawerToggle tg;
    private NavigationView n;
    private TableLayout ticketTableLayout;
    double adultPrice = 0, seniorPrice = 0, studentPrice = 0;
    private int adultCount = 0, seniorCount = 0, studentCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_display);

        d = (DrawerLayout) findViewById(R.id.activity_avail_ticket);
        tg = new ActionBarDrawerToggle(this, d, R.string.Open, R.string.Close);

        d.addDrawerListener(tg);
        tg.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        n = (NavigationView) findViewById(R.id.nv);
        n.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                int id = item.getItemId();
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
                        intent = new Intent(getApplicationContext(), MoreInfoActivity.class);
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
        ticketTableLayout = findViewById(R.id.ticketTable);
        ticketTableLayout.setStretchAllColumns(true);
        startLoadData();
    }

    public void startLoadData() {

        final Bundle bundle = getIntent().getExtras();
        // final String ticketName = bundle.getString("TicketName");
        final String adult = "adult";
        final String senior = "senior";
        final String student = "student";
        adultPrice = bundle.getDouble("adultPrice");
        seniorPrice = bundle.getDouble("seniorPrice");
        studentPrice = bundle.getDouble("studentPrice");
        adultCount = bundle.getInt("adultTicketCount");
        seniorCount = bundle.getInt("seniorTicketCount");
        studentCount = bundle.getInt("studentTicketCount");


       /* final TextView textView = new TextView(this);
        textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.LEFT);
        textView.setPadding(5, 15, 0, 15);
        textView.setText(student);*/

        final TextView textView2 = new TextView(this);
        textView2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView2.setGravity(Gravity.LEFT);
        textView2.setPadding(5, 15, 0, 15);
        textView2.setText("  $" + Double.toString(studentPrice));

        final TextView textView3 = new TextView(this);
        textView3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView3.setGravity(Gravity.LEFT);
        textView3.setPadding(5, 15, 0, 15);
        textView3.setText(Integer.toString(studentCount));

        final TextView textView4 = new TextView(this);
        textView4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView4.setGravity(Gravity.LEFT);
        textView4.setPadding(5, 15, 0, 15);
        textView4.setText(Integer.toString(adultCount));

        final TextView textView5 = new TextView(this);
        textView5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView5.setGravity(Gravity.LEFT);
        textView5.setPadding(5, 15, 0, 15);
        textView5.setText(Integer.toString(seniorCount));

        final TextView textView6 = new TextView(this);
        textView6.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView6.setGravity(Gravity.LEFT);
        textView6.setPadding(5, 15, 0, 15);
        textView6.setText("  $" + Double.toString(adultPrice));

        final TextView textView7 = new TextView(this);
        textView7.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView7.setGravity(Gravity.LEFT);
        textView7.setPadding(5, 15, 0, 15);
        textView7.setText("  $" + Double.toString(seniorPrice));

       /* final TextView textView8 = new TextView(this);
        textView8.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView8.setGravity(Gravity.LEFT);
        textView8.setPadding(5, 15, 0, 15);
        textView8.setText(adult);

        final TextView textView9 = new TextView(this);
        textView9.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView9.setGravity(Gravity.LEFT);
        textView9.setPadding(5, 15, 0, 15);
        textView9.setText(senior);
        */

        final TextView textView10 = new TextView(this);
        textView10.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView10.setGravity(Gravity.LEFT);
        textView10.setPadding(5,15,0,15);
        textView10.setText("adult");

        final TextView textView11 = new TextView(this);
        textView11.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView11.setGravity(Gravity.LEFT);
        textView11.setPadding(5,15,0,15);
        textView11.setText("student");

        final TextView textView12 = new TextView(this);
        textView12.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
        textView12.setGravity(Gravity.LEFT);
        textView12.setPadding(5,15,0,15);
        textView12.setText("senior");

        final TableRow tableRowTicket = new TableRow(this);
        TableLayout.LayoutParams trParams1 = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        trParams1.setMargins(0, 0, 0, 0);
        tableRowTicket.setPadding(0, 0, 0, 0);
        tableRowTicket.setLayoutParams(trParams1);


        ticketTableLayout.addView(tableRowTicket, trParams1);
        if (student == "student" && studentCount > 0) {

            final TableRow tableRow = new TableRow(this);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            trParams.setMargins(0, 0, 0, 0);
            tableRow.setPadding(0, 0, 0, 0);
            tableRow.setLayoutParams(trParams);


            tableRow.addView(textView11);
            tableRow.addView(textView2);
            tableRow.addView(textView3);
            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableRow tr = (TableRow) view;
                    Intent intentView = new Intent(TicketDisplayActivity.this, ShowTicketActivity.class);

                    Bundle bun = new Bundle();
                    bun.putDouble("studentPrice", studentPrice);
                    bun.putInt("studentCount", studentCount);
                    bun.putString("student", student);
                    // bun.putString("ticketCategory", student);
                    intentView.putExtras(bun);
                    startActivity(intentView);
                }
            });

            ticketTableLayout.addView(tableRow, trParams);

        }
        if (adult == "adult" && adultCount > 0) {
            final TableRow tableRow1 = new TableRow(this);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            trParams.setMargins(0, 0, 0, 0);
            tableRow1.setPadding(0, 0, 0, 0);
            tableRow1.setLayoutParams(trParams);

            tableRow1.addView(textView10);
            tableRow1.addView(textView6);
            tableRow1.addView(textView4);
            tableRow1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableRow tr = (TableRow) view;
                    Intent intentView = new Intent(TicketDisplayActivity.this, ShowTicketActivity.class);
                    Bundle bun = new Bundle();
                    bun.putDouble("adultPrice", adultPrice);
                    bun.putInt("adultCount", adultCount);
                    bun.putString("adult", adult);
                    //  bun.putString("ticketCategory", adult);
                    intentView.putExtras(bun);
                    startActivity(intentView);
                }
            });

            ticketTableLayout.addView(tableRow1, trParams);

        }
        if (senior == "senior" && seniorCount > 0) {
            final TableRow tableRow3 = new TableRow(this);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            trParams.setMargins(0, 0, 0, 0);
            tableRow3.setPadding(0, 0, 0, 0);
            tableRow3.setLayoutParams(trParams);

            tableRow3.addView(textView12);
            tableRow3.addView(textView7);
            tableRow3.addView(textView5);
            tableRow3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableRow tr = (TableRow) view;
                    Intent intentView = new Intent(TicketDisplayActivity.this, ShowTicketActivity.class);
                    Bundle bun = new Bundle();
                    bun.putDouble("seniorPrice", seniorPrice);
                    bun.putInt("seniorCount", seniorCount);
                    bun.putString("senior", senior);
                    //bun.putString("ticketCategory", senior);
                    intentView.putExtras(bun);
                    startActivity(intentView);
                }
            });

            ticketTableLayout.addView(tableRow3, trParams);
        }


    }
}


