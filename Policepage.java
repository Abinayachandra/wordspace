package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Policepage extends AppCompatActivity {
    TextView tv_submit;
    EditText ed_login,ed_password;
    ImageButton img_btn;

    String policeLoginid="Tamil Nadu";
    String policePassword_MYL="123_MYL";
    String policePassword_KUM="123_KUM";
    String policePassword_NGP="123_NGP";
    String policePassword_TNJ="123_TNJ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policepage);
        ed_login=findViewById(R.id.ed_policelogin);
        ed_password=findViewById(R.id.ed_policepass);
        img_btn=findViewById(R.id.img_logo_btn);
        tv_submit=findViewById(R.id.tv_submitid1_btn);

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*String LoginM1 = ed_login.getText().toString();
                String PasswordM1 = ed_password.getText().toString();*/

               /* String LoginK1 = ed_login.getText().toString();
                String PasswordK1 = ed_password.getText().toString();
                */
                /*String LoginN1 = ed_login.getText().toString();
                String PasswordN1 = ed_password.getText().toString();*/

                String LoginT1 = ed_login.getText().toString();
                String PasswordT1 = ed_password.getText().toString();

                if((PasswordT1.equals(policePassword_MYL)) || (LoginT1.equals(policeLoginid))) {

                    String LoginM1 = ed_login.getText().toString();
                    String PasswordM1 = ed_password.getText().toString();
                    Intent obname1=new Intent(Policepage.this,Police_Search_icon_page.class);
                    obname1.putExtra("Police_name","Mayiladuthurai Police Station");
                    obname1.putExtra("Police_Place","Mayiladuthurai");
                    startActivity(obname1);
                }
                else if((PasswordT1.equals(policePassword_KUM)) || (LoginT1.equals(policeLoginid)))
                {
                    String LoginK1 = ed_login.getText().toString();
                    String PasswordK1 = ed_password.getText().toString();

                    Intent obname2=new Intent(Policepage.this,Police_Search_icon_page.class);
                    obname2.putExtra("Police_name","Kumbhakonam Police Station");
                    obname2.putExtra("Police_Place","Kumbhakonam");
                    startActivity(obname2);
                }
                else if((PasswordT1.equals(policePassword_NGP)) || (LoginT1.equals(policeLoginid))){

                    String LoginN1 = ed_login.getText().toString();
                    String PasswordN1 = ed_password.getText().toString();
                    Intent obname3=new Intent(Policepage.this,Police_Search_icon_page.class);
                    obname3.putExtra("Police_name","Nagapattinam Police Station");
                    obname3.putExtra("Police_Place","Nagapattinam");
                    startActivity(obname3);

                }
                else if((PasswordT1.equals(policePassword_TNJ)) || (LoginT1.equals(policeLoginid))){
                    Intent obname4=new Intent(Policepage.this,Police_Search_icon_page.class);
                    obname4.putExtra("Police_name","Thanjavur Police Station");
                    obname4.putExtra("Police_Place","Thanjavur");
                    startActivity(obname4);
                }
                else{
                    Toast.makeText(Policepage.this, "Values does not Added", Toast.LENGTH_SHORT).show();
                }


                }


            });




           /*         String LoginM1 = ed_login.getText().toString();
                    String PasswordM1 = ed_password.getText().toString();
                *//*if ((Login.equals(policeLoginid)) && (Password.equals(policePassword))){
                       Intent obname=new Intent(Policepage.this,Custom_user.class);
                startActivity(obname);
                }*//*


                }
                    *//*if((LoginM1.isEmpty())*//**//*||(PasswordM1.isEmpty())*//**//*){
                        ed_login.setError("Enter LoginID");
                        ed_password.setError("Enter Password");
                    }*//*
                   else if(((LoginM1.equals(policeLoginid)))||((PasswordM1.equals(policePassword_MYL)))){
                        Intent obname1=new Intent(Policepage.this,Police_Search_icon_page.class);
                        obname1.putExtra("Myl_Police_name","Mayiladuthurai Police Station");
                        obname1.putExtra("Myl_Police_Place","Mayiladuthurai");
                        startActivity(obname1);
                    }
                    else if((!(LoginM1.equals(policeLoginid)))|| (!(PasswordM1.equals(policePassword_MYL))))
                    {
                        ed_login.setError("Incorrect ID");
                        ed_password.setError("Incorrect PassWord");
                    }
                    else {
                        //Toast.makeText(Policepage.this,"Please fill the field",Toast.LENGTH_SHORT).show();
                    }

                else if(ed_password.equals("123_KUM")){
                    String LoginK1=ed_login.getText().toString();
                    String PasswordK1=ed_password.getText().toString();

                    *//*if((LoginK1.isEmpty())||(PasswordK1.isEmpty())){
                        ed_login.setError("Enter LoginID");
                        ed_password.setError("Enter Password");
                    }*//*
                    if(((LoginK1.equals(policeLoginid)))||((PasswordK1.equals(policePassword_KUM)))){
                        Intent obname2=new Intent(Policepage.this,Police_Search_icon_page.class);
                        obname2.putExtra("KUM_Police_name","Kumbhakonam Police Station");
                        obname2.putExtra("KUM_Police_Place","Kumbhakonam");
                        startActivity(obname2);
                    }
                    else if((!(LoginK1.equals(policeLoginid)))|| (!(PasswordK1.equals(policePassword_KUM))))
                    {
                        ed_login.setError("Incorrect ID");
                        ed_password.setError("Incorrect PassWord");
                    }
                    else {
                        //Toast.makeText(Policepage.this,"Please fill the field",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(ed_password.equals("123_NGP")){
                    String LoginN1=ed_login.getText().toString();
                    String PasswordN1=ed_password.getText().toString();
                   *//* if((LoginN1.isEmpty())||(PasswordN1.isEmpty())){
                        ed_login.setError("Enter LoginID");
                        ed_password.setError("Enter Password");
                    }*//*
                     if(((LoginN1.equals(policeLoginid)))||((PasswordN1.equals(policePassword_NGP)))){
                        Intent obname3=new Intent(Policepage.this,Police_Search_icon_page.class);
                        obname3.putExtra("NGP_Police_name","Nagapattinam Police Station");
                        obname3.putExtra("NGP_Police_Place","Nagapattinam");
                        startActivity(obname3);
                    }
                    else if((!(LoginN1.equals(policeLoginid)))|| (!(PasswordN1.equals(policePassword_NGP))))
                    {
                        ed_login.setError("Incorrect ID");
                        ed_password.setError("Incorrect PassWord");
                    }
                    else {
                        //Toast.makeText(Policepage.this,"Please fill the field",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(ed_password.equals("123_TNJ")){
                    String LoginT1=ed_login.getText().toString();
                    String PasswordT1=ed_password.getText().toString();
                   *//* if((LoginT1.isEmpty())||(PasswordT1.isEmpty())){
                        ed_login.setError("Enter LoginID");
                        ed_password.setError("Enter Password");
                    }*//*
                     if(((LoginT1.equals(policeLoginid)))||((PasswordT1.equals(policePassword_TNJ)))){
                        Intent obname4=new Intent(Policepage.this,Police_Search_icon_page.class);
                        obname4.putExtra("TNJ_Police_name","Thanjavur Police Station");
                        obname4.putExtra("TNJ_Police_Place","Thanjavur");
                        startActivity(obname4);
                    }
                    else if((!(LoginT1.equals(policeLoginid)))|| (!(PasswordT1.equals(policePassword_TNJ))))
                    {
                        ed_login.setError("Incorrect ID");
                        ed_password.setError("Incorrect PassWord");
                    }
                    else {
                        //Toast.makeText(Policepage.this,"Please fill the field",Toast.LENGTH_SHORT).show();
                    }
                }
                *//*else{// ELSE for total if condition
                    Toast.makeText(Policepage.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                }*//*
            }
        });*/
    }
}

































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































