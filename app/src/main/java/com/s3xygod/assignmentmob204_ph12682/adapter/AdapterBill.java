package com.s3xygod.assignmentmob204_ph12682.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.data.Bill;
import com.s3xygod.assignmentmob204_ph12682.data.Sach;

import java.util.ArrayList;

public class AdapterBill extends ArrayAdapter {
    Context context;
    ArrayList<Bill> lstBill;
    int layoutResource;
    public AdapterBill(@NonNull Context context, int resource, ArrayList<Bill> object) {
        super(context, resource, object);
        this.context = context;
        this.lstBill = object;
        this.layoutResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource,null);
        TextView txt_STT = (TextView)convertView.findViewById(R.id.stt_bill);
        int stt = lstBill.get(position).getId();
        txt_STT.setText((String.valueOf(stt)));
        TextView txt_tenNg = (TextView)convertView.findViewById(R.id.txt_tenNgMuon);
        txt_tenNg.setText(lstBill.get(position).getNameMem());
        TextView txt_tenS = (TextView)convertView.findViewById(R.id.txt_sachMuon);
        txt_tenS.setText(lstBill.get(position).getNameSach());

        return convertView;
    }

}
