package com.s3xygod.assignmentmob204_ph12682.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.MemberDAO;
import com.s3xygod.assignmentmob204_ph12682.model.Members;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class AdapterMem extends BaseAdapter {
    public Activity context;
    public LayoutInflater inflater;
    List<Members> arrNguoiDung;
    MemberDAO nguoiDungDAO;

    public AdapterMem(Activity context, List<Members> arrayNguoiDung) {
        super();
        this.context = context;
        this.arrNguoiDung = arrayNguoiDung;
        this.inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDAO = new MemberDAO(context);
    }

    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }

    @Override
    public Object getItem(int position) {
        return arrNguoiDung.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.one_member, null);
            holder.img = convertView.findViewById(R.id.ivIcon);
            holder.txtName = convertView.findViewById(R.id.tvName);
            holder.txtPhone = convertView.findViewById(R.id.tvPhone);
            holder.imgDelete = convertView.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nguoiDungDAO.deleteMemByID(arrNguoiDung.get(position).getHoTen());
                    arrNguoiDung.remove(position);
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        Members _entry = (Members) arrNguoiDung.get(position);
        if (position % 3 == 0) {
            holder.img.setImageResource(R.drawable.emone);
        } else if (position % 3 == 1) {
            holder.img.setImageResource(R.drawable.emtwo);
        } else {
            holder.img.setImageResource(R.drawable.emthree);
        }
        holder.txtName.setText(_entry.getHoTen());
        holder.txtPhone.setText(_entry.getPhone());
        return convertView;
    }

    public void changeDataset(List<Members> items) {
        this.arrNguoiDung = items;
        notifyDataSetChanged();
    }

    public static class ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtPhone;
        ImageView imgDelete;
    }
}
