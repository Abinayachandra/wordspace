package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Custom_user extends AppCompatActivity {
    ListView lv_listview;
    ArrayList<String> user_name=new ArrayList<>();
    ArrayList<String> user_phoneno=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_user);
        lv_listview=findViewById(R.id.listid1);
        Custom_design_pageuser obname =new Custom_design_pageuser(user_name,user_phoneno,Custom_user.this);
        lv_listview.setAdapter(obname);
        lv_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=user_name.get(i);

                if(s.isEmpty()){
                    Toast.makeText(Custom_user.this, "Fill the Field", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intobname1=new Intent(Custom_user.this,Final_tv_user.class);
                    startActivity(intobname1);
                }
            }
        });
    }
}