package com.s3xygod.assignmentmob204_ph12682.ActivityCon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.Bill_InfoDAO;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.SachDAO;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterBillInfo;
import com.s3xygod.assignmentmob204_ph12682.model.Bill;
import com.s3xygod.assignmentmob204_ph12682.model.Bill_Info;
import com.s3xygod.assignmentmob204_ph12682.model.Sach;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillInfoActivity extends AppCompatActivity {
    public List<Bill_Info> dsHDCT = new ArrayList<>();
    EditText edMaSach, edMaHoaDon, edSoLuong;
    TextView tvThanhTien;
    Bill_InfoDAO hoaDonChiTietDAO;
    SachDAO sachDAO;
    ListView lvCart;
    AdapterBillInfo adapter = null;
    double thanhTien = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_info);
        edMaSach = findViewById(R.id.edMaSach);
        edMaHoaDon = findViewById(R.id.edMaHoaDon);
        edSoLuong = findViewById(R.id.edSoLuongMua);
        lvCart = findViewById(R.id.lvCart);
        tvThanhTien = findViewById(R.id.tvThanhTien);
        adapter = new AdapterBillInfo(this, dsHDCT);
        lvCart.setAdapter(adapter);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            edMaHoaDon.setText(b.getString("MAHOADON"));
        }

    }
        public void ADDHoaDonCHITIET (View view){
            hoaDonChiTietDAO = new Bill_InfoDAO(BillInfoActivity.this);
            sachDAO = new SachDAO(BillInfoActivity.this);
            try {
                if (validation() < 0) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Sach sach = sachDAO.getSachByID(edMaSach.getText().toString());
                    if (sach != null) {
                        int pos = checkMaSach(dsHDCT, edMaSach.getText().toString());
                        Bill hoaDon = new Bill(edMaHoaDon.getText().toString(), new
                                Date());
                        Bill_Info hoaDonChiTiet = new
                                Bill_Info(1, hoaDon, sach, Integer.parseInt(edSoLuong.getText().toString()));
                        if (pos >= 0) {
                            int soluong = dsHDCT.get(pos).getSoLuongMua();
                            hoaDonChiTiet.setSoLuongMua(soluong +
                                    Integer.parseInt(edSoLuong.getText().toString()));
                            dsHDCT.set(pos, hoaDonChiTiet);
                        } else {
                            dsHDCT.add(hoaDonChiTiet);
                        }
                        adapter.changeDataset(dsHDCT);
                    } else {
                        Toast.makeText(getApplicationContext(), "Mã sách không tồn tại", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception ex) {
                Log.e("Error", ex.toString());
            }
        }

        public void thanhToanHoaDon (View view){
            hoaDonChiTietDAO = new Bill_InfoDAO(BillInfoActivity.this);
            //tinh tien
            thanhTien = 0;
            try {
                for (Bill_Info hd : dsHDCT) {
                    hoaDonChiTietDAO.inserBill_Info(hd);
                    thanhTien = thanhTien + hd.getSoLuongMua() *
                            hd.getSach().getGiaBia();
                }
                tvThanhTien.setText("Tổng tiền: " + thanhTien);
            } catch (Exception ex) {
                Log.e("Error", ex.toString());
            }
        }

        public int checkMaSach (List < Bill_Info > lsHD, String maSach){
            int pos = -1;
            for (int i = 0; i < lsHD.size(); i++) {
                Bill_Info hd = lsHD.get(i);
                if (hd.getSach().getMaSach().equalsIgnoreCase(maSach)) {
                    pos = i;
                    break;
                }
            }
            return pos;
        }

        public int validation () {
            if (edMaSach.getText().toString().isEmpty() || edSoLuong.getText().toString().isEmpty() ||
                    edMaHoaDon.getText().toString().isEmpty()) {
                return -1;
            }
            return 1;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case android.R.id.home:
                    onBackPressed();
                    return true;

                default:
                    break;
            }
            return super.onOptionsItemSelected(item);
        }

}