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
import com.s3xygod.assignmentmob204_ph12682.data.Sach;

import java.util.ArrayList;

public class AdapterListBooks extends ArrayAdapter {
    Context context;
    ArrayList<Sach> lstSach;
    int layoutResource;
    public AdapterListBooks(@NonNull Context context, int resource, ArrayList<Sach> object) {
        super(context, resource, object);
        this.context = context;
        this.lstSach = object;
        this.layoutResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource,null);
        ImageView img_sach = (ImageView)convertView.findViewById(R.id.img_books);
        TextView txt_ten = (TextView)convertView.findViewById(R.id.txt_tenSach);
        txt_ten.setText(lstSach.get(position).getNameBook());
        TextView txt_TL = (TextView)convertView.findViewById(R.id.txt_TheLoai);
        txt_TL.setText(lstSach.get(position).getNameTL());


        return convertView;
    }
}
