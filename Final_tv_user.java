package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Final_tv_user extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_tv_user);

        tv1=findViewById(R.id.tvid1);
        tv2=findViewById(R.id.tvid2);
        tv3=findViewById(R.id.tvid3);
        tv4=findViewById(R.id.tvid4);
        tv5=findViewById(R.id.tvid5);
        tv6=findViewById(R.id.tvid6);




    }
}