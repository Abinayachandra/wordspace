package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Secondpage extends AppCompatActivity {
    ImageView img_user,img_police;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        img_user=findViewById(R.id.img_userid1sec);
        img_police=findViewById(R.id.img_police1secid);

        img_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obname1=new Intent(Secondpage.this,Userpage.class);
                startActivity(obname1);
            }
        });
        img_police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obname2=new Intent(Secondpage.this,Policepage.class);
                startActivity(obname2);
            }
        });

    }
}