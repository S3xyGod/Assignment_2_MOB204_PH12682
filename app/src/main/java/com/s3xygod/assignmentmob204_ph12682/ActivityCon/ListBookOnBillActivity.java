package com.s3xygod.assignmentmob204_ph12682.ActivityCon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.Bill_InfoDAO;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterBillInfo;
import com.s3xygod.assignmentmob204_ph12682.model.Bill_Info;

import java.util.ArrayList;
import java.util.List;

public class ListBookOnBillActivity extends AppCompatActivity {
    public List<Bill_Info> dsHDCT = new ArrayList<>();
    ListView lvCart;
    AdapterBillInfo adapter = null;
    Bill_InfoDAO hoaDonChiTietDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book_on_bill);
        lvCart = findViewById(R.id.lvHoaDonChiTiet);
        hoaDonChiTietDAO = new Bill_InfoDAO(ListBookOnBillActivity.this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            dsHDCT = hoaDonChiTietDAO.getAllBill_InfoByID(b.getString("MAHOADON"));
        }
        adapter = new AdapterBillInfo(this, dsHDCT);
        lvCart.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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