package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Userpage extends AppCompatActivity {
    EditText ed_username,ed_pass;
    TextView t1,t2;
    Button bt_log;
    SQLiteDatabase db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);

        ed_username=findViewById(R.id.usernameid1ud);
        ed_pass=findViewById(R.id.passid1ud);
        bt_log=findViewById(R.id.bt_login1ud);
        t1=findViewById(R.id.regid1ud);
        t2=findViewById(R.id.regid2ud);

        db = openOrCreateDatabase("DATABASE", MODE_PRIVATE, null);


        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String USER=ed_username.getText().toString();
                String PASS=ed_pass.getText().toString();

                /*SharedPreferences sharedPreferences=getSharedPreferences("DATABASE",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                String s1=sharedPreferences.getString("key1","");
                String s2=sharedPreferences.getString("key2","");*/

                /*Intent ob1=new Intent();
                ob1.get*/



                 if ((USER.isEmpty()) || (PASS.isEmpty())) {
                    ed_username.setError("UserName Missing");
                    ed_pass.setError("Password Missing");
                }

                else  {
                        try {
                            db = openOrCreateDatabase("DATABASE", MODE_PRIVATE, null);
                            Cursor c = db.rawQuery("select * from REGUSER where Username='" + USER + "' and Password='" + PASS + "'", null);
                            if (c.moveToFirst())
                            {
                                Toast.makeText(Userpage.this,"Login Succesfully",Toast.LENGTH_SHORT).show();
                                Intent ob = new Intent(Userpage.this, User_login_successful.class);
                                startActivity(ob);
                            }
                            // Cursor c=db.rawQuery("select * from Username where Name='"+S1+"' and Password='"+S2+"'",null);
                        }
                        catch (Exception e) { 
                        }
                }



               /* else{
                    try{
                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        Cursor c=db.rawQuery("select * from REGUSER where Username='"+USER+"' and Password='"+PASS+"'",null);
                        if (c.moveToNext()){
                            Intent ob =new Intent(Userpage.this,User_login_successful.class);
                            startActivity(ob);
                        }
                       // Cursor c=db.rawQuery("select * from Username where Name='"+S1+"' and Password='"+S2+"'",null);



                    }catch (Exception e){

                    }
                }*/
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob =new Intent(Userpage.this,User_regpage.class);
                startActivity(ob);

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob =new Intent(Userpage.this,User_regpage.class);
                startActivity(ob);

            }
        });



    }
}