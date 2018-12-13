package com.example.a300985590.ttcpay;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class AvailbaleTicketsForAdmin extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    ListView list;

    private List<Ticket> ticketsList=new ArrayList<Ticket>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availbale_tickets_for_admin);

      /*  dl = (DrawerLayout)findViewById(R.id.activity_avail_ticket);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();*/
       showList();

    }
    public void showList()
    {
        InputStream is= getResources().openRawResource(R.raw.android);

        BufferedReader reader=new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line;

        try
        {
            reader.readLine();
            while((line=reader.readLine()) !=null)
            {
                String[] tokens=line.split(",");
                Ticket ticket=new Ticket();
                ticket.setTicketId(Integer.parseInt(tokens[0]));
                ticket.setTicketType(tokens[1]);
                ticket.setNumberOfTickets(Integer.parseInt(tokens[2]));
                ticketsList.add(ticket);
            }

            if (ticketsList!= null && ticketsList.size() > 0) {
                final String[] ticketType;
                Integer[] imgId;
                final String[] numberOfTickets;

                ticketType=new String[ticketsList.size()];
                imgId=new Integer[ticketsList.size()];
                numberOfTickets=new String[ticketsList.size()];


                for(int i=0;i<ticketsList.size();i++)
                {
                    Ticket s=ticketsList.get(i);
                    ticketType[i]=   s.getTicketType();
                    imgId[i]=R.drawable.location;
                    numberOfTickets[i]="Total number of "+s.getTicketType()+" tickets"+"####"+s.getNumberOfTickets();
                }

                CustomListAdapter adapter=new CustomListAdapter(this, ticketType, imgId,numberOfTickets);
                list=(ListView)findViewById(R.id.availableTicketsListForAdmin);
                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {

                        // TODO Auto-generated method stub
                        //String Slecteditem= ticketType[+position];
                        //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                       /* Intent intent=null;
                        intent=new Intent(getApplicationContext(),TicketDisplayActivity.class);
                        startActivity(intent);
                        */

                    }
                });
            }
        }
        catch(IOException e)
        {
            Log.e("Exception:","Exception in available ticket screen while generating ticket list : ",e);
            e.printStackTrace();

        }
        catch (Exception ex)
        {
            Log.e("Exception:","Exception in available ticket screen while generating ticket list : ",ex);
            ex.printStackTrace();
        }


    }

}
