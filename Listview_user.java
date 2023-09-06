package com.example.crime_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Listview_user extends AppCompatActivity {
    ListView listView1;
    String[] station_name={"Mayiladuthurai Police Station","Kumbhakonam Police Station","Nagapattinam Police Station","Thanjavur Police Station"};
    String[] station_place={"Mayiladuthurai","Kumbhakonam","Nagapattinam","Thanjavur"};
    String[] plus91={" +91"," +91"," +91"," +91"};
    String[] phone={"7871837649","7871837649","7871837649","7871837649"};
    int[] call_logo={R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_call_24};

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_user);
        listView1=findViewById(R.id.listid_1);

        Design_custompage obname1=new Design_custompage(station_name,station_place,plus91,phone,call_logo,Listview_user.this);
        listView1.setAdapter(obname1);

       /* db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
        db.execSQL("create table if not exists Mayiladuthurai_Police_Station(Username TEXT,Phonenumber TEXT,Mailid TEXT,Gender TEXT,City TEXT);");
        db.execSQL("create table if not exists Kumbhakonam_Police_Station(Username TEXT,Phonenumber TEXT,Mailid TEXT,Gender TEXT,City TEXT);");
        db.execSQL("create table if not exists Nagapattinam_Police_Station(Username TEXT,Phonenumber TEXT,Mailid TEXT,Gender TEXT,City TEXT);");
        db.execSQL("create table if not exists Thanjavur_Police_Station(Username TEXT,Phonenumber TEXT,Mailid TEXT,Gender TEXT,City TEXT);");
        db.close();*/


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String str_id1=station_name[i];
                String str_id2=station_place[i];
                String str_id3=plus91[i];
                String str_id4=phone[i];
                int str_callid=call_logo[i];


                ///SharedPreference used to  shared the position od [[[[station_name and station_place]]]]

               /* SharedPreferences sharedPreferences=getSharedPreferences("databasename",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("share1",str_id1);
                editor.putString("share2",str_id2);
                editor.commit();*/


                if (str_id1.equals("Mayiladuthurai Police Station")){

                   /* AlertDialog.Builder builder=new AlertDialog.Builder(Listview_user.this);
                    builder.setTitle("Alert Box");
                    builder.setMessage("Choose Field");

                    builder.setPositiveButton("CALL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent callobname1=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+str_id4));
                            startActivity(callobname1);
                        }
                    });*/
                 /*   builder.setNegativeButton("COMPLAINT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            ///SharedPreference used to  shared the position od [[[[station_name and station_place]]]]

                            SharedPreferences sharedPreferences=getSharedPreferences("databasename",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("share1",str_id1);
                            editor.putString("share2",str_id2);
                            editor.commit();


                            Intent complaint=new Intent(Listview_user.this,Personaldetails.class);
                            //complaint.putExtra("key1",str_id1+str_id2);
                            startActivity(complaint);

                        }
                    });*/
                  /*  builder.setNeutralButton("Decline", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Thus the process was decline

                        }
                    });*/
                    SharedPreferences sharedPreferences=getSharedPreferences("databasename",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("share1",str_id1);
                    editor.putString("share2",str_id2);
                    editor.commit();


                    Intent complaint=new Intent(Listview_user.this,Personaldetails.class);
                    //complaint.putExtra("key1",str_id1+str_id2);
                    startActivity(complaint);
                }
                else if(str_id1.equals("Kumbhakonam Police Station"))
                {

                    AlertDialog.Builder builder=new AlertDialog.Builder(Listview_user.this);
                    builder.setTitle("Alert Box");
                    builder.setMessage("Choose Field");

                    builder.setPositiveButton("CALL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent callobname1=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+str_id4));
                            startActivity(callobname1);
                        }
                    });
                    builder.setNegativeButton("COMPLAINT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            ///SharedPreference used to  shared the position od [[[[station_name and station_place]]]]

                            SharedPreferences sharedPreferences=getSharedPreferences("databasename",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("share1",str_id1);
                            editor.putString("share2",str_id2);
                            editor.commit();


                            Intent complaint=new Intent(Listview_user.this,Personaldetails.class);
                            //complaint.putExtra("key1",str_id1+str_id2);
                            startActivity(complaint);

                        }
                    });
                    builder.setNeutralButton("Decline", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Thus the process was decline

                        }
                    });
                }
                else if(str_id1.equals("Nagapattinam Police Station"))
                {

                    AlertDialog.Builder builder=new AlertDialog.Builder(Listview_user.this);
                    builder.setTitle("Alert Box");
                    builder.setMessage("Choose Field");

                    builder.setPositiveButton("CALL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent callobname1=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+str_id4));
                            startActivity(callobname1);
                        }
                    });
                    builder.setNegativeButton("COMPLAINT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            ///SharedPreference used to  shared the position od [[[[station_name and station_place]]]]

                            SharedPreferences sharedPreferences=getSharedPreferences("databasename",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("share1",str_id1);
                            editor.putString("share2",str_id2);
                            editor.commit();


                            Intent complaint=new Intent(Listview_user.this,Personaldetails.class);
                            //complaint.putExtra("key1",str_id1+str_id2);
                            startActivity(complaint);

                        }
                    });
                    builder.setNeutralButton("Decline", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Thus the process was decline

                        }
                    });
                }
                else if(str_id1.equals("Thanjavur Police Station"))
                {

                    AlertDialog.Builder builder=new AlertDialog.Builder(Listview_user.this);
                    builder.setTitle("Alert Box");
                    builder.setMessage("Choose Field");

                    builder.setPositiveButton("CALL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent callobname1=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+str_id4));
                            startActivity(callobname1);
                        }
                    });
                    builder.setNegativeButton("COMPLAINT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            ///SharedPreference used to  shared the position od [[[[station_name and station_place]]]]

                            SharedPreferences sharedPreferences=getSharedPreferences("databasename",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("share1",str_id1);
                            editor.putString("share2",str_id2);
                            editor.commit();


                            Intent complaint=new Intent(Listview_user.this,Personaldetails.class);
                            //complaint.putExtra("key1",str_id1+str_id2);
                            startActivity(complaint);

                        }
                    });
                    builder.setNeutralButton("Decline", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Thus the process was decline

                        }
                    });
                }

            }
        });
    }
}