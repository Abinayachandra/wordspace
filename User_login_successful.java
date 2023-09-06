package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class User_login_successful extends AppCompatActivity {
    ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_successful);
        img1=findViewById(R.id.img_idnewxt1);
        img2=findViewById(R.id.img_idnewxt2);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob=new Intent(User_login_successful.this,Listview_user.class);
                startActivity(ob);
            }
        });
    }
}