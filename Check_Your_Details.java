package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Check_Your_Details extends AppCompatActivity {
    TextView tv_name,tv_place,t1_phone,t2_mail,t3_date,t4_gender,t5_city,t6_name2,t7_phone2,t8_gender2,t9_crime,t10_city2;
    Button bt_done;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_your_details);

        tv_name=findViewById(R.id.tv_check_dts1);
        tv_place=findViewById(R.id.tv_check_dts2);
        t1_phone=findViewById(R.id.check_user_number);
        t2_mail=findViewById(R.id.check_user_Mailid);
        t3_date=findViewById(R.id.check_user_Date);
        t4_gender=findViewById(R.id.check_user_Gender);
        t5_city=findViewById(R.id.check_user_city);
        t6_name2=findViewById(R.id.check_Complain_name);
        t7_phone2=findViewById(R.id.check_Complain_number);
        t8_gender2=findViewById(R.id.check_complain_gender);
        t9_crime=findViewById(R.id.check_complain_crime);
        t10_city2=findViewById(R.id.check_city_complain);

        bt_done=findViewById(R.id.bt_check_done1);

        SharedPreferences sharedPreferences=getSharedPreferences("databasename",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String s1=sharedPreferences.getString("share1","");
        String s2=sharedPreferences.getString("share2","");
        tv_name.setText(s1);
        tv_place.setText(s2);





                if (tv_name.equals("Mayiladuthurai Police Station"))//INTENT VALUES ARE GET FROM PERSONAL DETAILS PAGE
                {
                    Intent ob1=getIntent();//First part so F1,F2,F3,F4
                    String Phone_F1_1=ob1.getStringExtra("myl_Personkey1_number");
                    String Mail_F1_2=ob1.getStringExtra("myl_Personkey2_Mailid");
                    String Date_F1_3=ob1.getStringExtra("myl_Personkey3_date");
                    String Gender_F1_4=ob1.getStringExtra("myl_Personkey4_Gender");
                    String City_F1_5=ob1.getStringExtra("myl_Personkey5_city");//Thus the above details are get from Personal details page
                                           //Second part so S1,S2,S3,S4
                    String S1_Name_1=ob1.getStringExtra("myl_Complaintkey1_name");//The BELOW details are get from COMPLAINT_PERSONS_DETAILS Page
                    String S1_Number_2=ob1.getStringExtra("myl_Complaintkey2_number");
                    String S1_Gender_3=ob1.getStringExtra("myl_Complaintkey4_Gender");
                    String S1_Crimetype_4=ob1.getStringExtra("myl_Complaintkey4_Crime_type");
                    String S1_City_5=ob1.getStringExtra("myl_Complaintkey5_city");
                    if (Phone_F1_1.isEmpty()){
                        t1_phone.setError("Phonenumber does not get from database");
                    }
                    else if (Mail_F1_2.isEmpty()){
                        t2_mail.setError("Mail ID does not get from database");
                    }
                    else if (Date_F1_3.isEmpty()){
                        t3_date.setError("Date does not get from database");
                    }
                    else if (Gender_F1_4.isEmpty()){
                        t4_gender.setError("Gender does not get from database");
                    }
                    else if (City_F1_5.isEmpty()){
                        t5_city.setError("City does not get from database");
                    }

                    // the BELOW else if conditions are used from the the COMPLAINT_PERSONS_DETAILS Page

                    else if(S1_Name_1.isEmpty()){
                        t6_name2.setError("Complaint's name missing");
                    }
                    else if (S1_Number_2.isEmpty()){
                        t7_phone2.setError("Complaint's Phone number missing");
                    }
                    else if (S1_Gender_3.isEmpty()){
                        t8_gender2.setError("Complaint's Phone number missing");
                    }
                    else if (S1_Crimetype_4.isEmpty()){
                        t9_crime.setError("Complaint's Phone number missing");
                    }
                    else if (S1_City_5.isEmpty()){
                        t10_city2.setError("Complaint's Phone number missing");
                    }
                    else{
                        try{
                            db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                            Cursor c1=db.rawQuery("select * from Mayiladuthurai_Police_Station_Person where Phonenumber='"+Phone_F1_1+"' and Mailid='"+Mail_F1_2+"' and Date='"+Date_F1_3+"' and Gender_F4='"+Gender_F1_4+"' and City='"+City_F1_5+"' ",null);
                            Cursor c11=db.rawQuery("select * from Mayiladuthurai_Police_Station_complaint where Username_complainants='"+S1_Name_1+"' and Phonenumber_complainants='"+S1_Number_2+"' and Gender_complainants='"+S1_Gender_3+"' and Crime_type_complainants='"+S1_Crimetype_4+"' and City_complainants='"+S1_City_5+"' ",null);

                            if(c1.moveToNext()){
                                //Intent intent1=new Intent(Check_Your_Details.this,)
                            }
                            else if(c11.moveToNext()){

                            }
                        }catch (Exception e){
                        }
                    }
                }
                else if(tv_name.equals("Kumbhakonam Police Station")){
                    Intent ob2=getIntent();
                    String Phone_F2_1=ob2.getStringExtra("Kum_Personkey1_number");
                    String Mail_F2_2=ob2.getStringExtra("Kum_Personkey2_Mailid");
                    String Date_F2_3=ob2.getStringExtra("Kum_Personkey3_date");
                    String Gender_F2_4=ob2.getStringExtra("Kum_Personkey4_Gender");
                    String City_F2_5=ob2.getStringExtra("Kum_Personkey5_city");

                    String S2_Name_1=ob2.getStringExtra("Kum_Complaintkey1_name");//The BELOW details are get from COMPLAINT_PERSONS_DETAILS Page
                    String S2_Number_2=ob2.getStringExtra("Kum_Complaintkey2_number");
                    String S2_Gender_3=ob2.getStringExtra("Kum_Complaintkey4_Gender");
                    String S2_Crimetype_4=ob2.getStringExtra("Kum_Complaintkey4_Crime_type");
                    String S2_City_5=ob2.getStringExtra("Kum_Complaintkey5_city");

                    if (Phone_F2_1.isEmpty()){
                        t1_phone.setError("Phonenumber does not get from database");
                    }
                    else if(Mail_F2_2.isEmpty()){
                        t2_mail.setError("Mail ID does not get from database");
                    }
                    else if(Date_F2_3.isEmpty()){
                        t3_date.setError("Date does not get from database");
                    }
                    else if(Gender_F2_4.isEmpty()){
                        t4_gender.setError("gender does not get from database");
                    }
                    else if(City_F2_5.isEmpty()){
                        t5_city.setError("City does not get from database");
                    }
                    ///////////////////////////////////////////////////Intent from complaint persons name
                    else if(S2_Name_1.isEmpty()){
                        t6_name2.setError("Complaint's name missing");
                    }
                    else if (S2_Number_2.isEmpty()){
                        t7_phone2.setError("Complaint's Phone number missing");
                    }
                    else if (S2_Gender_3.isEmpty()){
                        t8_gender2.setError("Complaint's Phone number missing");
                    }
                    else if (S2_Crimetype_4.isEmpty()){
                        t9_crime.setError("Complaint's Phone number missing");
                    }
                    else if (S2_City_5.isEmpty()){
                        t10_city2.setError("Complaint's Phone number missing");
                    }
                    else{
                        try{
                            db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                            Cursor c2=db.rawQuery("select * from Kumbhakonam_Police_Station_Person where Phonenumber='"+Phone_F2_1+"' and Mailid='"+Mail_F2_2+"' and Date='"+Date_F2_3+"' and Gender_F4='"+Gender_F2_4+"' and City='"+City_F2_5+"' ",null);
                            Cursor c22=db.rawQuery("select * from Kumbhakonam_Police_Station_complaint where Username_complainants='"+S2_Name_1+"' and Phonenumber_complainants='"+S2_Number_2+"' and Gender_complainants='"+S2_Gender_3+"' and Crime_type_complainants='"+S2_Crimetype_4+"' and City_complainants='"+S2_City_5+"' ",null);
                            if(c2.moveToNext()){
                                //Intent intent1=new Intent(Check_Your_Details.this,)
                            }
                            else if(c22.moveToNext()){

                            }
                        }catch (Exception e){
                        }
                    }
                }
                else if(tv_name.equals("Nagapattinam Police Station")){
                    Intent ob3=getIntent();
                    String Phone_F3_1=ob3.getStringExtra("NGP_Personkey1_number");
                    String Mail_F3_2=ob3.getStringExtra("NGP_Personkey2_Mailid");
                    String Date_F3_3=ob3.getStringExtra("NGP_Personkey3_date");
                    String Gender_F3_4=ob3.getStringExtra("NGP_Personkey4_Gender");
                    String City_F3_5=ob3.getStringExtra("NGP_Personkey5_city");

                    String S3_Name_1=ob3.getStringExtra("NGP_Complaintkey1_name");//The BELOW details are get from COMPLAINT_PERSONS_DETAILS Page
                    String S3_Number_2=ob3.getStringExtra("NGP_Complaintkey2_number");
                    String S3_Gender_3=ob3.getStringExtra("NGP_Complaintkey4_Gender");
                    String S3_Crimetype_4=ob3.getStringExtra("NGP_Complaintkey4_Crime_type");
                    String S3_City_5=ob3.getStringExtra("NGP_Complaintkey5_city");


                    if (Phone_F3_1.isEmpty()){
                        t1_phone.setError("Phonenumber does not get from database");
                    }
                    else if(Mail_F3_2.isEmpty()){
                        t2_mail.setError("Mail ID does not get from database");
                    }
                    else if(Date_F3_3.isEmpty()){
                        t3_date.setError("Date does not get from database");
                    }
                    else if(Gender_F3_4.isEmpty()){
                        t4_gender.setError("gender does not get from database");
                    }
                    else if(City_F3_5.isEmpty()){
                        t5_city.setError("City does not get from database");
                    }


                    else if(S3_Name_1.isEmpty()){
                        t6_name2.setError("Complaint's name missing");
                    }
                    else if (S3_Number_2.isEmpty()){
                        t7_phone2.setError("Complaint's Phone number missing");
                    }
                    else if (S3_Gender_3.isEmpty()){
                        t8_gender2.setError("Complaint's Phone number missing");
                    }
                    else if (S3_Crimetype_4.isEmpty()){
                        t9_crime.setError("Complaint's Phone number missing");
                    }
                    else if (S3_City_5.isEmpty()){
                        t10_city2.setError("Complaint's Phone number missing");
                    }
                    else{
                        try{
                            db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                            Cursor c3=db.rawQuery("select * from Nagapattinam_Police_Station_Person where Phonenumber='"+Phone_F3_1+"' and Mailid='"+Mail_F3_2+"' and Date='"+Date_F3_3+"' and Gender_F4='"+Gender_F3_4+"' and City='"+City_F3_5+"' ",null);
                            Cursor c33=db.rawQuery("select * from Nagapattinam_Police_Station_complaint where Username_complainants='"+S3_Name_1+"' and Phonenumber_complainants='"+S3_Number_2+"' and Gender_complainants='"+S3_Gender_3+"' and Crime_type_complainants='"+S3_Crimetype_4+"' and City_complainants='"+S3_City_5+"' ",null);
                            if(c3.moveToNext()){
                                //Intent intent1=new Intent(Check_Your_Details.this,)
                            }
                            else if(c33.moveToNext()){
                            }
                        }catch (Exception e){
                        }
                    }
                }
                else if(tv_name.equals("Thanjavur Police Station")){
                    Intent ob4=getIntent();
                    String Phone_F4_1=ob4.getStringExtra("TJ_Personkey1_number");
                    String Mail_F4_2=ob4.getStringExtra("TJ_Personkey2_Mailid");
                    String Date_F4_3=ob4.getStringExtra("TJ_Personkey3_date");
                    String Gender_F4_4=ob4.getStringExtra("TJ_Personkey4_Gender");
                    String City_F4_5=ob4.getStringExtra("TJ_Personkey5_city");

                    String S4_Name_1=ob4.getStringExtra("NGP_Complaintkey1_name");//The BELOW details are get from COMPLAINT_PERSONS_DETAILS Page
                    String S4_Number_2=ob4.getStringExtra("NGP_Complaintkey2_number");
                    String S4_Gender_3=ob4.getStringExtra("NGP_Complaintkey4_Gender");
                    String S4_Crimetype_4=ob4.getStringExtra("NGP_Complaintkey4_Crime_type");
                    String S4_City_5=ob4.getStringExtra("NGP_Complaintkey5_city");

                    if (Phone_F4_1.isEmpty()){
                        t1_phone.setError("Phonenumber does not get from database");
                    }
                    else if(Mail_F4_2.isEmpty()){
                        t2_mail.setError("Mail ID does not get from database");
                    }
                    else if(Date_F4_3.isEmpty()){
                        t3_date.setError("Date does not get from database");
                    }
                    else if(Gender_F4_4.isEmpty()){
                        t4_gender.setError("gender does not get from database");
                    }
                    else if(City_F4_5.isEmpty()){
                        t5_city.setError("City does not get from database");
                    }

                    else if(S4_Name_1.isEmpty()){
                        t6_name2.setError("Complaint's name missing");
                    }
                    else if (S4_Number_2.isEmpty()){
                        t7_phone2.setError("Complaint's Phone number missing");
                    }
                    else if (S4_Gender_3.isEmpty()){
                        t8_gender2.setError("Complaint's Phone number missing");
                    }
                    else if (S4_Crimetype_4.isEmpty()){
                        t9_crime.setError("Complaint's Phone number missing");
                    }
                    else if (S4_City_5.isEmpty()){
                        t10_city2.setError("Complaint's Phone number missing");
                    }
                    else{
                        try{
                            db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                            Cursor c4=db.rawQuery("select * from Thanjavur_Police_Station_Person where Phonenumber='"+Phone_F4_1+"' and Mailid='"+Mail_F4_2+"' and Date='"+Date_F4_3+"' and Gender_F4='"+Gender_F4_4+"' and City='"+City_F4_5+"' ",null);
                            Cursor c44=db.rawQuery("select * from Thanjavur_Police_Station_complaint where Username_complainants='"+S4_Name_1+"' and Phonenumber_complainants='"+S4_Number_2+"' and Gender_complainants='"+S4_Gender_3+"' and Crime_type_complainants='"+S4_Crimetype_4+"' and City_complainants='"+S4_City_5+"' ",null);
                            if(c4.moveToNext()){
                                //Intent intent1=new Intent(Check_Your_Details.this,)
                            }
                            else if(c44.moveToNext()){

                            }
                        }catch (Exception e){
                        }
                    }
                }
                else{

                }

               // Toast.makeText(Check_Your_Details.this, "Submitted Successfully !", Toast.LENGTH_LONG).show();
        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String call1=t1_phone.getText().toString();

               /* Intent callobject=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+call1));
                startActivity(callobject);*/
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(call1,null,"Your Complaint was send To Police",null,null);

                Intent sucess=new Intent(Check_Your_Details.this,Success_notification.class);
                startActivity(sucess);
            }
        });
    }
}