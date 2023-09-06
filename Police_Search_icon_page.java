package com.example.crime_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Police_Search_icon_page extends AppCompatActivity {

    TextView tv_name,tv_place,tv_VIEW_COMPLAINTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_search_icon_page);

        tv_name=findViewById(R.id.tv_Search_icon_page1);
        tv_place=findViewById(R.id.tv_Search_icon_page2);
        tv_VIEW_COMPLAINTS=findViewById(R.id.id_viewcomplaints1);

        Intent ob1=getIntent();//Intent from Policelogin Page
        String M1=ob1.getStringExtra("Police_name");
        String M2=ob1.getStringExtra("Police_Place");
        tv_name.setText(M1);
        tv_place.setText(M2);
        Toast.makeText(this, M1+M2, Toast.LENGTH_SHORT).show();

      /*  Intent ob2=getIntent();//Intent from Policelogin Page
        String K1=ob2.getStringExtra("Myl_Police_name");
        String K2=ob2.getStringExtra("Myl_Police_Place");
        tv_name.setText(K1);
        tv_place.setText(K2);

        Intent ob3=getIntent();//Intent from Policelogin Page
        String N1=ob3.getStringExtra("Myl_Police_name");
        String N2=ob3.getStringExtra("Myl_Police_Place");
        tv_name.setText(N1);
        tv_place.setText(N2);

        Intent ob4=getIntent();//Intent from Policelogin Page
        String T1=ob4.getStringExtra("Myl_Police_name");
        String T2=ob4.getStringExtra("Myl_Police_Place");
        tv_name.setText(T1);
        tv_place.setText(T2);*/


        tv_VIEW_COMPLAINTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String place=tv_name.getText().toString();
                if(M1.equals("Mayiladuthurai Police Station")){
                    Intent int1=new Intent(Police_Search_icon_page.this,View_Complaints_Listview.class);
                    int1.putExtra("myl_1","Mayiladuthurai Police Station");
                    int1.putExtra("myl_2","Mayiladuthurai");
                    startActivity(int1);
                }
                else if(M1.equals("Kumbhakonam Police Station")){
                    Intent int2=new Intent(Police_Search_icon_page.this,View_Complaints_Listview.class);
                    int2.putExtra("kum1","Kumbhakonam Police Station");
                    int2.putExtra("kum2","Kumbhakonam");
                    startActivity(int2);
                }
                else if(M1.equals("Nagapattinam Police Station")){
                    Intent int3=new Intent(Police_Search_icon_page.this,View_Complaints_Listview.class);
                    int3.putExtra("ngp1","Nagapattinam Police Station");
                    int3.putExtra("ngp2","Nagapattinam");
                    startActivity(int3);
                }
                else if(M1.equals("Thanjavur Police Station")){
                    Intent int4=new Intent(Police_Search_icon_page.this,View_Complaints_Listview.class);
                    int4.putExtra("tj1","Thanjavur Police Station");
                    int4.putExtra("tj2","Thanjavur");

                    startActivity(int4);
                }
                else {

                    Toast.makeText(Police_Search_icon_page.this, "Invalid details", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}