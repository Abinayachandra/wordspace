package com.example.crime_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_design_pageuser extends BaseAdapter {
    ArrayList<String> user_name;
    ArrayList<String> user_phoneno;
    Context context;
    LayoutInflater inflater;

    public Custom_design_pageuser(ArrayList<String> user_name,ArrayList<String> user_phoneno,Context context) {
        this.user_name=user_name;
        this.user_phoneno=user_phoneno;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return user_name.size();
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
        v=inflater.inflate(R.layout.custom_designpage,null);
        TextView tv1=(TextView) v.findViewById(R.id.tv_idcustomdesign1);
        TextView tv2=(TextView) v.findViewById(R.id.tv_idcustomdesign2);
        tv1.setText(user_name.get(i));
        tv2.setText(user_phoneno.get(i));
        return v;
    }
}
