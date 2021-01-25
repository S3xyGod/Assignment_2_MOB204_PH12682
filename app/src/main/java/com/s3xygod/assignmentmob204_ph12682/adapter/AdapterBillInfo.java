package com.s3xygod.assignmentmob204_ph12682.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.Bill_InfoDAO;
import com.s3xygod.assignmentmob204_ph12682.model.Bill_Info;
import java.util.List;

public class AdapterBillInfo extends BaseAdapter {
    public Activity context;
    public LayoutInflater inflater;
    List<Bill_Info> arrHoaDonChiTiet;
    Bill_InfoDAO hoaDonChiTietDAO;

    public AdapterBillInfo(Activity context, List<Bill_Info> arrayHoaDonChiTiet) {
        super();
        this.context = context;
        this.arrHoaDonChiTiet = arrayHoaDonChiTiet;
        this.inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        hoaDonChiTietDAO = new Bill_InfoDAO(context);
    }


    @Override
    public int getCount() {
        return arrHoaDonChiTiet.size();
    }

    @Override
    public Object getItem(int position) {
        return arrHoaDonChiTiet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.one_bill_info, null);
            holder.txtMaSach = convertView.findViewById(R.id.tvMaSach);
            holder.txtSoLuong = convertView.findViewById(R.id.tvSoLuong);
            holder.txtGiaBia = convertView.findViewById(R.id.tvGiaBia);
            holder.txtThanhTien = convertView.findViewById(R.id.tvThanhTien);
            holder.imgDelete = convertView.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    hoaDonChiTietDAO.deleteBill_InfoByID(String.valueOf(arrHoaDonChiTiet.get(position).getMaHDCT()));
                    arrHoaDonChiTiet.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        Bill_Info _entry = arrHoaDonChiTiet.get(position);
        holder.txtMaSach.setText("Mã sách: " + _entry.getSach().getMaSach());
        holder.txtSoLuong.setText("Số lượng: " + _entry.getSoLuongMua());
        holder.txtGiaBia.setText("Giá bìa: " + _entry.getSach().getGiaBia() + " vnd");
        holder.txtThanhTien.setText("Thành tiền: " + _entry.getSoLuongMua() * _entry.getSach().getGiaBia() + " vnd");
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<Bill_Info> items) {
        this.arrHoaDonChiTiet = items;
        notifyDataSetChanged();
    }

    public static class ViewHolder {
        TextView txtMaSach;
        TextView txtSoLuong;
        TextView txtGiaBia;
        TextView txtThanhTien;
        ImageView imgDelete;
    }
}
