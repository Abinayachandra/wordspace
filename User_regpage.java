package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User_regpage extends AppCompatActivity {
    EditText ed_username,ed_Address,ed_phone,ed_mail,ed_Aadhar,ed_pass,ed_conformpass;
    Button bt_submit;
    SQLiteDatabase db;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_regpage);
        ed_username=findViewById(R.id.ed_userreg1);
        ed_Address=findViewById(R.id.ed_userAddress1);
        ed_phone=findViewById(R.id.ed_phoneregid1);
        ed_Aadhar=findViewById(R.id.ed_aadharregid1);
        ed_mail=findViewById(R.id.mailregid1);
        ed_pass=findViewById(R.id.ed_passregid1);
        ed_conformpass=findViewById(R.id.ed_comformpass_idreg1);
        bt_submit=findViewById(R.id.bt_submitregid1);

        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
        db.execSQL("create table if not exists REGUSER(Username TEXT,Phonenumber TEXT,Aadharno TEXT,Mailid TEXT,Password TEXT);");
        db.close();

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name=ed_username.getText().toString();
                String user_address=ed_Address.getText().toString();
                String phone_number=ed_phone.getText().toString();
                String Aadhar_number=ed_Aadhar.getText().toString();
                String Mail_id=ed_mail.getText().toString();
                String Pass_word=ed_pass.getText().toString();
                String conform_pass=ed_conformpass.getText().toString();

                if (user_name.isEmpty()){
                    ed_username.setError("Username missing");
                }
                else if(user_address.isEmpty()){
                    ed_Address.setError("Address Missing");
                }
                else if (phone_number.isEmpty()){
                    ed_phone.setError("Phonenumber missing");
                }
                else if (Aadhar_number.isEmpty()){
                    ed_Aadhar.setError("Aadharnumber missing");
                }
                else if ((Mail_id.isEmpty())){

                    ed_mail.setError("fill the mail id");
                }


                else if (Pass_word.isEmpty()){
                    ed_pass.setError("Password missing");
                }else if (!(conform_pass.equals(Pass_word))){
                    Toast.makeText(User_regpage.this, "Please check your password...", Toast.LENGTH_SHORT).show();
                }
                else{

                    /*SharedPreferences sharedPreferences=getSharedPreferences("DATABASE",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("key1",user_name);
                    editor.putString("key2",phone_number);
                    editor.commit();*/

                    if(Mail_id.trim().matches(emailPattern)){

                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        db.execSQL("insert into REGUSER values ('"+user_name+"','"+phone_number+"','"+Aadhar_number+"','"+Mail_id+"','"+Pass_word+"');");
                        db.close();
                        Toast.makeText(User_regpage.this, "User Added successfully completed...", Toast.LENGTH_SHORT).show();

                        Intent ob=new Intent(User_regpage.this,Userpage.class);
                        startActivity(ob);
                        finish();
                    }
                    else {
                        Toast.makeText(User_regpage.this, "Invalid Id", Toast.LENGTH_SHORT).show();
                    }


                    /*Intent ob=new Intent(User_regpage.this,Userpage.class);
                    ob.putExtra("key1_name",user_name);
                    ob.putExtra("key2_Pass_word",Pass_word);
                    startActivity(ob);*/
                }
            }
        });
    }
}