package com.s3xygod.assignmentmob204_ph12682.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.data.Members;
import com.s3xygod.assignmentmob204_ph12682.data.Sach;

import java.util.ArrayList;

public class AdapterMem extends ArrayAdapter {
    Context context;
    ArrayList<Members> lstMem;
    int layoutResource;
    public AdapterMem(@NonNull Context context, int resource, ArrayList<Members> object) {
        super(context, resource, object);
        this.context = context;
        this.lstMem = object;
        this.layoutResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource,null);
        TextView txt_stt = (TextView)convertView.findViewById(R.id.txt_idMem);
        int stt = lstMem.get(position).getId();
        txt_stt.setText(String.valueOf(stt));
        TextView txt_ten = (TextView)convertView.findViewById(R.id.txt_nameMem);
        txt_ten.setText(lstMem.get(position).getName());


        return convertView;
    }
}
