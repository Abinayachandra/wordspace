package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class View_Complaints_Listview extends AppCompatActivity {
    TextView tv_name,tv_place;
    ListView lv_listview;

    ArrayList<String> Name=new ArrayList<String>();
    ArrayList<String> Phone_no=new ArrayList<String>();
    ArrayList<String> City=new ArrayList<String>();
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints_listview);

        tv_name=findViewById(R.id.tv_complaint_Listview1);
        tv_place=findViewById(R.id.tv_complaint_Listview2);
        lv_listview=findViewById(R.id.listview_id_complaint1);

        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);

        Intent obname1=getIntent();
        String M1=obname1.getStringExtra("myl_1");
        String M2=obname1.getStringExtra("myl_2");
        startActivity(obname1);
        tv_name.setText(M1);
        tv_place.setText(M2);

        Intent obname2=getIntent();
        String K1=obname2.getStringExtra("kum1");
        String K2=obname2.getStringExtra("kum2");
        startActivity(obname2);
        tv_name.setText(K1);
        tv_place.setText(K2);

        Intent obname3=getIntent();
        String N1=obname3.getStringExtra("ngp1");
        String N2=obname3.getStringExtra("ngp2");
        startActivity(obname3);
        tv_name.setText(N1);
        tv_place.setText(N2);

        Intent obname4=getIntent();
        String T1=obname4.getStringExtra("tj1");
        String T2=obname4.getStringExtra("tj2");
        startActivity(obname4);
        tv_name.setText(T1);
        tv_place.setText(T2);


        if(tv_name.equals(M1)){


            db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
            try {
                Cursor c= db.rawQuery("select * from Mayiladuthurai_Police_Station_complaint", null);
                if(c != null) {
                    if (c.moveToFirst()){
                        do{
                            String ffhost1=c.getString(0);
                            String ffhost2=c.getString(1);
                            String ffhost3=c.getString(2);


                            Name.add(ffhost1);
                            Phone_no.add(ffhost2);
                            City.add(ffhost3);
                        }
                        while (c.moveToNext());
                    }
                    Design_view_complaints ob1=new Design_view_complaints(Name,Phone_no,City,View_Complaints_Listview.this);
                    lv_listview.setAdapter(ob1);

                }

            }catch(Exception e)
            {
                Toast.makeText(this, " not data", Toast.LENGTH_SHORT).show();
            }
        }
        else if(tv_name.equals(K1)){
            db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
            try {
                Cursor c= db.rawQuery("select * from Kumbhakonam_Police_Station_complaint", null);
                if(c != null) {
                    if (c.moveToFirst()){
                        do{
                            String ffhost11=c.getString(0);
                            String ffhost21=c.getString(1);
                            String ffhost31=c.getString(2);


                            Name.add(ffhost11);
                            Phone_no.add(ffhost21);
                            City.add(ffhost31);
                        }
                        while (c.moveToNext());
                    }
                    Design_view_complaints ob1=new Design_view_complaints(Name,Phone_no,City,View_Complaints_Listview.this);
                    lv_listview.setAdapter(ob1);

                }

            }catch(Exception e)
            {
                Toast.makeText(this, " not data", Toast.LENGTH_SHORT).show();
            }

        }
        else if(tv_name.equals(N1)){
            db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
            try {
                Cursor c= db.rawQuery("select * from Nagapattinam_Police_Station_complaint", null);
                if(c != null) {
                    if (c.moveToFirst()){
                        do{
                            String ffhost12=c.getString(0);
                            String ffhost22=c.getString(1);
                            String ffhost32=c.getString(2);


                            Name.add(ffhost12);
                            Phone_no.add(ffhost22);
                            City.add(ffhost32);
                        }
                        while (c.moveToNext());
                    }
                    Design_view_complaints ob1=new Design_view_complaints(Name,Phone_no,City,View_Complaints_Listview.this);
                    lv_listview.setAdapter(ob1);

                }

            }catch(Exception e)
            {
                Toast.makeText(this, " not data", Toast.LENGTH_SHORT).show();
            }

        }
        else if(tv_name.equals(T1)){
            db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
            try {
                Cursor c= db.rawQuery("select * from Nagapattinam_Police_Station_complaint", null);
                if(c != null) {
                    if (c.moveToFirst()){
                        do{
                            String ffhost123=c.getString(0);
                            String ffhost223=c.getString(1);
                            String ffhost323=c.getString(2);


                            Name.add(ffhost123);
                            Phone_no.add(ffhost223);
                            City.add(ffhost323);
                        }
                        while (c.moveToNext());
                    }
                    Design_view_complaints ob1=new Design_view_complaints(Name,Phone_no,City,View_Complaints_Listview.this);
                    lv_listview.setAdapter(ob1);

                }

            }catch(Exception e)
            {
                Toast.makeText(this, " not data", Toast.LENGTH_SHORT).show();
            }

        }




    }
}