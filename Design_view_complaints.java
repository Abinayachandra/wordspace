package com.example.crime_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Design_view_complaints extends BaseAdapter {
    ArrayList<String> Name;
    ArrayList<String> Phone_no;
    ArrayList<String> City;
    Context context;
    LayoutInflater inflater;
    public Design_view_complaints(ArrayList<String> Name,ArrayList<String> Phone_no,ArrayList<String> City,Context context) {
        this.Name=Name;
        this.Phone_no=Phone_no;
        this.City=City;
        this.context=context;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {

        return Name.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view=inflater.inflate(R.layout.design_view_complaints,null);
        TextView t1=view.findViewById(R.id.tv_design_name1);
        TextView t2=view.findViewById(R.id.tv_design_Gender1);
        TextView t3=view.findViewById(R.id.tv_design_City1);
        t1.setText(Name.get(i));
        t2.setText(Phone_no.get(i));
        t3.setText(City.get(i));

        return view;
    }
}
