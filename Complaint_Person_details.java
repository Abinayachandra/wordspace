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

public class Complaint_Person_details extends AppCompatActivity {

    TextView tv_Name,tv_place;
    EditText ed_name,ed_number,ed_crime_type,ed_city;
    Button bt_next;
    Spinner spinner_gender;
    String[] str={"Female","Male","Others"};
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_person_details);
        tv_Name=findViewById(R.id.complaints_tv1);
        tv_place=findViewById(R.id.complaints_tv2);

        ed_name=findViewById(R.id.ed_complaints_name);
        ed_number=findViewById(R.id.ed_complaints_number);
        spinner_gender=(Spinner)findViewById(R.id.sp_compalints_gender);
        ed_crime_type=findViewById(R.id.ed_complaints_crimtype);
        ed_city=findViewById(R.id.ed_complaints_city);
        bt_next=findViewById(R.id.bt_compalints);

        ArrayAdapter ob_array=new ArrayAdapter(Complaint_Person_details.this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,str);
        spinner_gender.setAdapter(ob_array);


        // These SharedPreferences values are get from ((Listview-page))
        SharedPreferences sharedPreferences=getSharedPreferences("databasename",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String s1=sharedPreferences.getString("share1","");
        String s2=sharedPreferences.getString("share2","");
        tv_Name.setText(s1);
        tv_place.setText(s2);


        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
        db.execSQL("create table if not exists Mayiladuthurai_Police_Station_complaint(Username_complainants TEXT,Phonenumber_complainants TEXT,Gender_complainants TEXT,Crime_type_complainants TEXT,City_complainants TEXT);");
        db.execSQL("create table if not exists Kumbhakonam_Police_Station_complaint(Username_complainants TEXT,Phonenumber_complainants TEXT,Gender_complainants TEXT,Crime_type_complainants TEXT,City_complainants TEXT);");
        db.execSQL("create table if not exists Nagapattinam_Police_Station_complaint(Username_complainants TEXT,Phonenumber_complainants TEXT,Gender_complainants TEXT,Crime_type_complainants TEXT,City_complainants TEXT);");
        db.execSQL("create table if not exists Thanjavur_Police_Station_complaint(Username_complainants TEXT,Phonenumber_complainants TEXT,Gender_complainants TEXT,Crime_type_complainants TEXT,City_complainants TEXT);");
        db.close();


        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv_Name.equals("Mayiladuthurai Police Station")){

                    String s1_name_cp=ed_name.getText().toString();
                    String s2_number_cp=ed_number.getText().toString();
                    String s3_gender_cp=spinner_gender.getSelectedItem().toString();
                    String s4_crimetype_cp=ed_crime_type.getText().toString();
                    String s5_city_cp=ed_city.getText().toString();

                    if(s1_name_cp.isEmpty()){
                        ed_name.setError("Enter Name");
                    }
                    else if (s2_number_cp.isEmpty()){
                        ed_number.setError("Enter Phone Number");
                    }
                    else if (s3_gender_cp.isEmpty()){
                        Toast.makeText(Complaint_Person_details.this, "Select Gender", Toast.LENGTH_SHORT).show();
                    }
                    else if (s4_crimetype_cp.isEmpty()){
                        ed_crime_type.setError("Please Enter Crime type");
                    }
                    else if(s5_city_cp.isEmpty()){
                        ed_city.setError("Please Enter City");
                    }
                    else{
                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        db.execSQL("insert into Mayiladuthurai_Police_Station_complaint values('"+s1_name_cp+"','"+s2_number_cp+"','"+s3_gender_cp+"','"+s4_crimetype_cp+"','"+s5_city_cp+"');");
                        db.close();
                        Intent ob1=new Intent(Complaint_Person_details.this,Check_Your_Details.class);
                        ob1.putExtra("myl_Complaintkey1_name",s1_name_cp);
                        ob1.putExtra("myl_Complaintkey2_number",s2_number_cp);//This values are passed to CHECK YOUR DETAILS PAGE
                        ob1.putExtra("myl_Complaintkey4_Gender",s3_gender_cp);
                        ob1.putExtra("myl_Complaintkey4_Crime_type",s4_crimetype_cp);
                        ob1.putExtra("myl_Complaintkey5_city",s5_city_cp);
                        startActivity(ob1);

                    }
                }
                else  if (tv_Name.equals("Kumbhakonam_Police_Station")){
                    String s1_name1_cp=ed_name.getText().toString();
                    String s2_number1_cp=ed_number.getText().toString();
                    String s3_gender1_cp=spinner_gender.getSelectedItem().toString();
                    String s4_crimetype1_cp=ed_crime_type.getText().toString();
                    String s5_city1_cp=ed_city.getText().toString();
                    if (s1_name1_cp.isEmpty()){
                        ed_name.setError("Enter Name");
                    }
                    else if (s2_number1_cp.isEmpty()){
                        ed_number.setError("Please Enter Number");
                    }
                    else  if (s3_gender1_cp.isEmpty()){
                        Toast.makeText(Complaint_Person_details.this, "Select gender", Toast.LENGTH_SHORT).show();
                    }
                    else  if (s4_crimetype1_cp.isEmpty()){
                        ed_crime_type.setError("Enter Crime Type");
                    }
                    else if (s5_city1_cp.isEmpty()){
                        ed_city.setError("Enter City");
                    }
                    else{
                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        db.execSQL("insert into Kumbhakonam_Police_Station_complaint values('"+s1_name1_cp+"','"+s2_number1_cp+"','"+s3_gender1_cp+"','"+s4_crimetype1_cp+"','"+s5_city1_cp+"');");
                        db.close();
                        Intent ob2=new Intent(Complaint_Person_details.this,Check_Your_Details.class);
                        ob2.putExtra("Kum_Complaintkey1_name",s1_name1_cp);
                        ob2.putExtra("Kum_Complaintkey2_number",s2_number1_cp);//This values are passed to CHECK YOUR DETAILS PAGE
                        ob2.putExtra("Kum_Complaintkey4_Gender",s3_gender1_cp);
                        ob2.putExtra("Kum_Complaintkey4_Crime_type",s4_crimetype1_cp);
                        ob2.putExtra("Kum_Complaintkey5_city",s5_city1_cp);
                        startActivity(ob2);
                    }
                }
                else if (tv_Name.equals("Nagapattinam_Police_Station")){

                    String s1_name2_cp=ed_name.getText().toString();
                    String s2_number2_cp=ed_number.getText().toString();
                    String s3_gender2_cp=spinner_gender.getSelectedItem().toString();
                    String s4_crimetype2_cp=ed_crime_type.getText().toString();
                    String s5_city2_cp=ed_city.getText().toString();

                    if (s1_name2_cp.isEmpty()){
                        ed_name.setError("Enter Name");

                    }
                    else if(s2_number2_cp.isEmpty()){
                        ed_number.setError("Enter Number");
                    }
                    else if(s3_gender2_cp.isEmpty()){
                        Toast.makeText(Complaint_Person_details.this, "Select Gender", Toast.LENGTH_SHORT).show();
                    }
                    else if (s4_crimetype2_cp.isEmpty()){
                        ed_crime_type.setError("Enter Crime Type");
                    }
                    else if(s5_city2_cp.isEmpty()){
                        ed_city.setError("Enter City");
                    }
                    else {
                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        db.execSQL("insert into Nagapattinam_Police_Station_complaint values('"+s1_name2_cp+"','"+s2_number2_cp+"','"+s3_gender2_cp+"','"+s4_crimetype2_cp+"','"+s5_city2_cp+"');");
                        db.close();
                        Intent ob3=new Intent(Complaint_Person_details.this,Check_Your_Details.class);
                        ob3.putExtra("NGP_Complaintkey1_name",s1_name2_cp);
                        ob3.putExtra("NGP_Complaintkey2_number",s2_number2_cp);//This values are passed to CHECK YOUR DETAILS PAGE
                        ob3.putExtra("NGP_Complaintkey4_Gender",s3_gender2_cp);
                        ob3.putExtra("NGP_Complaintkey4_Crime_type",s4_crimetype2_cp);
                        ob3.putExtra("NGP_Complaintkey5_city",s5_city2_cp);
                        startActivity(ob3);
                    }
                }
                else if (tv_Name.equals("Thanjavur_Police_Station")){

                    String s1_name3_cp=ed_name.getText().toString();
                    String s2_number3_cp=ed_number.getText().toString();
                    String s3_gender3_cp=spinner_gender.getSelectedItem().toString();
                    String s4_crimetype3_cp=ed_crime_type.getText().toString();
                    String s5_city3_cp=ed_city.getText().toString();

                    if (s1_name3_cp.isEmpty()){
                        ed_name.setError("Enter Name");

                    }
                    else if(s2_number3_cp.isEmpty()){
                        ed_number.setError("Enter Number");
                    }
                    else if(s3_gender3_cp.isEmpty()){
                        Toast.makeText(Complaint_Person_details.this, "Select Gender", Toast.LENGTH_SHORT).show();
                    }
                    else if (s4_crimetype3_cp.isEmpty()){
                        ed_crime_type.setError("Enter Crime Type");
                    }
                    else if(s5_city3_cp.isEmpty()){
                        ed_city.setError("Enter City");
                    }
                    else {
                        db=openOrCreateDatabase("DATABASE",MODE_PRIVATE,null);
                        db.execSQL("insert into Nagapattinam_Police_Station_complaint values('"+s1_name3_cp+"','"+s2_number3_cp+"','"+s3_gender3_cp+"','"+s4_crimetype3_cp+"','"+s5_city3_cp+"');");
                        db.close();
                        Intent ob4=new Intent(Complaint_Person_details.this,Check_Your_Details.class);
                        ob4.putExtra("TJ_Complaintkey1_name",s1_name3_cp);
                        ob4.putExtra("TJ_Complaintkey2_number",s2_number3_cp);//This values are passed to CHECK YOUR DETAILS PAGE
                        ob4.putExtra("TJ_Complaintkey4_Gender",s3_gender3_cp);
                        ob4.putExtra("TJ_Complaintkey4_Crime_type",s4_crimetype3_cp);
                        ob4.putExtra("TJ_Complaintkey5_city",s5_city3_cp);
                        startActivity(ob4);
                    }
                }
                else{
                    Toast.makeText(Complaint_Person_details.this, "Thus the values are not inserted", Toast.LENGTH_SHORT).show();
                }
                Intent on=new Intent(Complaint_Person_details.this,Check_Your_Details.class);
                startActivity(on);

            }
        });







    }
}