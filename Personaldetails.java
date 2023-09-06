package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Personaldetails extends AppCompatActivity {
    TextView tv_policename,tv_policeplace;
    EditText ed_name,ed_mbl,ed_mail,ed_date,ed_city;
    Spinner sp_gender;
    Button bt_next;

    String[] str={"Female","Male","Others"};
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldetails);

        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
        db.execSQL("create table if not exists Mayiladuthurai_Police_Station_Person(Phonenumber TEXT,Mailid TEXT,Date TEXT,Gender TEXT,City TEXT);");
        db.execSQL("create table if not exists Kumbhakonam_Police_Station_Person(Phonenumber TEXT,Mailid TEXT,Date TEXT,Gender TEXT,City TEXT);");
        db.execSQL("create table if not exists Nagapattinam_Police_Station_Person(Phonenumber TEXT,Mailid TEXT,Date TEXT,Gender TEXT,City TEXT);");
        db.execSQL("create table if not exists Thanjavur_Police_Station_Person(Phonenumber TEXT,Mailid TEXT,Date TEXT,Gender TEXT,City TEXT);");
        db.close();



        tv_policename=findViewById(R.id.tv_personal_details1);
        tv_policeplace=findViewById(R.id.tv_personal_details2);

        ed_name=findViewById(R.id.Ed_personal_dts_name1);
        ed_mbl=findViewById(R.id.Ed_personal_details_mlbnumber2);
        ed_date=findViewById(R.id.personal_date);
        ed_mail=findViewById(R.id.personaldts_emailid1);
       // sp_gender=findViewById(R.id.personal_gender);
        sp_gender = (Spinner) findViewById(R.id.personal_gender);

        ed_city=findViewById(R.id.ed_city_personal);

        bt_next=findViewById(R.id.personal_btid1);



        ArrayAdapter ob_array=new ArrayAdapter(Personaldetails.this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,str);
        sp_gender.setAdapter(ob_array);

        /////using if condition
        // These SharedPreferences values are get from ((Listview-page))
        SharedPreferences sharedPreferences=getSharedPreferences("databasename",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String s1=sharedPreferences.getString("share1","");
        String s2=sharedPreferences.getString("share2","");
        tv_policename.setText(s1);
        tv_policeplace.setText(s2);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(tv_policename.equals("Mayiladuthurai Police Station")){

                    String s1_name=ed_name.getText().toString();
                    String s2_number=ed_mbl.getText().toString();
                    String s3_mail=ed_mail.getText().toString();
                    String s4_date=ed_date.getText().toString();
                    // String s4_gender=spinner[i];
                    //String text = findViewById(R.id.spinner).getSelectedItem().toString();
                    /*String text = findViewById(R.id.personal_gender).getSelectedItem(i).toString();*/
                    String s5_gender = sp_gender.getSelectedItem().toString();
                    String s6_city=ed_city.getText().toString();

                    if (s1_name.isEmpty()){
                        ed_name.setError("Fill Name");
                    }
                    else if(s2_number.isEmpty()){
                        ed_mbl.setError("Enter Phone Number");

                    }
                    else if(s3_mail.isEmpty()){
                        ed_mail.setError("Enter Mail");

                    }
                    else if(s4_date.isEmpty()){
                        ed_date.setError("Enter Date");
                    }
                    else if(s5_gender.isEmpty()){
                        Toast.makeText(Personaldetails.this, "Select Gender", Toast.LENGTH_SHORT).show();

                    }
                    else if(s6_city.isEmpty()){
                        ed_city.setError("Fill City");

                    }
                    else{
                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        db.execSQL("insert into Mayiladuthurai_Police_Station_Person values('"+s2_number+"','"+s3_mail+"','"+s4_date+"','"+s5_gender+"','"+s6_city+"');");
                        db.close();
                        Intent i1=new Intent(Personaldetails.this,Check_Your_Details.class);
                        i1.putExtra("myl_Personkey1_number",s2_number);
                        i1.putExtra("myl_Personkey2_Mailid",s3_mail);//This values are passed to CHECK YOUR DETAILS PAGE
                        i1.putExtra("myl_Personkey3_date",s4_date);
                        i1.putExtra("myl_Personkey4_Gender",s5_gender);
                        i1.putExtra("myl_Personkey5_city",s6_city);
                        startActivity(i1);
                    }
                }
                else if(tv_policename.equals("Kumbhakonam Police Station")){

                    String s1_name1=ed_name.getText().toString();
                    String s2_number1=ed_mbl.getText().toString();
                    String s3_mail1=ed_mail.getText().toString();
                    String s4_date1=ed_date.getText().toString();
                    String s5_gender1 = sp_gender.getSelectedItem().toString();
                    String s6_city1=ed_city.getText().toString();

                    if (s1_name1.isEmpty()){
                        ed_name.setError("Fill Name");
                    }
                    else if(s2_number1.isEmpty()){
                        ed_mbl.setError("Enter Phone Number");

                    }
                    else if(s3_mail1.isEmpty()){
                        ed_mail.setError("Enter Mail");

                    }
                    else if(s4_date1.isEmpty()){
                        ed_date.setError("Enter Date");
                    }
                    else if(s5_gender1.isEmpty()){
                        Toast.makeText(Personaldetails.this, "Select Gender", Toast.LENGTH_SHORT).show();

                    }
                    else if(s6_city1.isEmpty()){
                        ed_city.setError("Fill City");

                    }
                    else{
                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        db.execSQL("insert into Kumbhakonam_Police_Station_Person values('"+s2_number1+"','"+s3_mail1+"','"+s4_date1+"','"+s5_gender1+"','"+s6_city1+"');");
                        db.close();
                        Intent i2=new Intent(Personaldetails.this,Check_Your_Details.class);
                        i2.putExtra("Kum_Personkey1_number",s2_number1);
                        i2.putExtra("Kum_Personkey2_Mailid",s3_mail1);//This values are passed to CHECK YOUR DETAILS PAGE
                        i2.putExtra("Kum_Personkey3_date",s4_date1);
                        i2.putExtra("Kum_Personkey4_Gender",s5_gender1);
                        i2.putExtra("Kum_Personkey5_city",s6_city1);
                        startActivity(i2);

                    }
                }
                else if(tv_policename.equals("Nagapattinam Police Station")){

                    String s1_name2=ed_name.getText().toString();
                    String s2_number2=ed_mbl.getText().toString();
                    String s3_mail2=ed_mail.getText().toString();
                    String s4_date2=ed_date.getText().toString();
                    String s5_gender2 = sp_gender.getSelectedItem().toString();
                    String s6_city2=ed_city.getText().toString();

                    if (s1_name2.isEmpty()){
                        ed_name.setError("Fill Name");
                    }
                    else if(s2_number2.isEmpty()){
                        ed_mbl.setError("Enter Phone Number");

                    }
                    else if(s3_mail2.isEmpty()){
                        ed_mail.setError("Enter Mail");

                    }
                    else if(s4_date2.isEmpty()){
                        ed_date.setError("Enter Date");
                    }
                    else if(s5_gender2.isEmpty()){
                        Toast.makeText(Personaldetails.this, "Select Gender", Toast.LENGTH_SHORT).show();

                    }
                    else if(s6_city2.isEmpty()){
                        ed_city.setError("Fill City");

                    }
                    else{
                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        db.execSQL("insert into Kumbhakonam_Police_Station_Person values('"+s2_number2+"','"+s3_mail2+"','"+s4_date2+"','"+s5_gender2+"','"+s6_city2+"');");
                        db.close();
                        Intent i3=new Intent(Personaldetails.this,Check_Your_Details.class);
                        i3.putExtra("NGP_Personkey1_number",s2_number2);
                        i3.putExtra("NGP_Personkey2_Mailid",s3_mail2);//This values are passed to CHECK YOUR DETAILS PAGE
                        i3.putExtra("NGP_Personkey3_date",s4_date2);
                        i3.putExtra("NGP_Personkey4_Gender",s5_gender2);
                        i3.putExtra("NGP_Personkey5_city",s6_city2);
                        startActivity(i3);

                    }
                }
                else if(tv_policename.equals("Thanjavur Police Station")){

                    String s1_name3=ed_name.getText().toString();
                    String s2_number3=ed_mbl.getText().toString();
                    String s3_mail3=ed_mail.getText().toString();
                    String s4_date3=ed_date.getText().toString();
                    String s5_gender3 = sp_gender.getSelectedItem().toString();
                    String s6_city3=ed_city.getText().toString();

                    if (s1_name3.isEmpty()){
                        ed_name.setError("Fill Name");
                    }
                    else if(s2_number3.isEmpty()){
                        ed_mbl.setError("Enter Phone Number");

                    }
                    else if(s3_mail3.isEmpty()){
                        ed_mail.setError("Enter Mail");

                    }
                    else if(s4_date3.isEmpty()){
                        ed_date.setError("Enter Date");
                    }
                    else if(s5_gender3.isEmpty()){
                        Toast.makeText(Personaldetails.this, "Select Gender", Toast.LENGTH_SHORT).show();

                    }
                    else if(s6_city3.isEmpty()){
                        ed_city.setError("Fill City");

                    }
                    else{
                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        db.execSQL("insert into Kumbhakonam_Police_Station_Person values('"+s2_number3+"','"+s3_mail3+"','"+s4_date3+"','"+s5_gender3+"','"+s6_city3+"');");
                        db.close();
                        Intent i4=new Intent(Personaldetails.this,Check_Your_Details.class);
                        i4.putExtra("TJ_Personkey1_number",s2_number3);
                        i4.putExtra("TJ_Personkey2_Mailid",s3_mail3);//This values are passed to CHECK YOUR DETAILS PAGE
                        i4.putExtra("TJ_Personkey3_date",s4_date3);
                        i4.putExtra("TJ_Personkey4_Gender",s5_gender3);
                        i4.putExtra("TJ_Personkey5_city",s6_city3);
                        startActivity(i4);

                    }
                }
                else{
                    Toast.makeText(Personaldetails.this, "Thus the values are not inserted", Toast.LENGTH_SHORT).show();
                }
                Intent intentperson=new Intent(Personaldetails.this,Complaint_Person_details.class);
                startActivity(intentperson);

            }
        });













    }
}