package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.Bill_InfoDAO;

public class MoneyActivity extends AppCompatActivity {
    TextView tvNgay, tvThang, tvNam;
    Bill_InfoDAO hoaDonChiTietDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

//        tvNgay = findViewById(R.id.tvThongKeNgay);
//        tvThang = findViewById(R.id.tvThongKeThang);
//        tvNam = findViewById(R.id.tvThongKeNam);
//        hoaDonChiTietDAO = new Bill_InfoDAO(this);
//        tvNgay.setText("Hôm nay      : " + hoaDonChiTietDAO.getDoanhThuTheoNgay());
//        tvThang.setText("Tháng này   : " + hoaDonChiTietDAO.getDoanhThuTheoThang());
//        tvNam.setText("Năm này       : " + hoaDonChiTietDAO.getDoanhThuTheoNam());
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//
//            default:
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}