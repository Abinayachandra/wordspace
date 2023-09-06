package com.example.crime_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Design_custompage extends BaseAdapter {
    String[] station_name;
    String[] station_place;
    String[] plus91;
    String[] phone;
    int[] call_logo;
    Context context;
    LayoutInflater inflater;
    public Design_custompage(String[] station_name,String[] station_place,String[] plus91,String[] phone,int[] call_logo,Context context) {
        this.station_name=station_name;
        this.station_place=station_place;
        this.plus91=plus91;
        this.phone=phone;
        this.call_logo=call_logo;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return station_name.length;
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
    public View getView(int i, View v, ViewGroup viewGroup) {
        v=inflater.inflate(R.layout.design_custompage,null);
        TextView t1=(TextView) v.findViewById(R.id.tv_police1);
        TextView t2=(TextView) v.findViewById(R.id.tv_police2);
        TextView t3=(TextView) v.findViewById(R.id.tv_police3);
        TextView t4=(TextView) v.findViewById(R.id.tv_police4);
        ImageView img=(ImageView) v.findViewById(R.id.img_id1);

        t1.setText(station_name[i]);
        t2.setText(station_place[i]);
        t3.setText(plus91[i]);
        t4.setText(phone[i]);
        img.setImageResource(call_logo[i]);

        return v;
    }
}
