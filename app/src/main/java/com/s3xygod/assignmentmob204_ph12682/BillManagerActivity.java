package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterBill;
import com.s3xygod.assignmentmob204_ph12682.data.Bill;

import java.util.ArrayList;

public class BillManagerActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Bill> lstBill;
    AdapterBill adapterBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_manager);
        listView = findViewById(R.id.lv_bill);
        lstBill = new ArrayList<>();
        lstBill.add(new Bill(01, "Pham Cong Bang", "Top notch 1", "10/10/2020"));
        lstBill.add(new Bill(02, "Le Van Nam", "Chi Pheo", "11/05/2020"));
        lstBill.add(new Bill(03, "Nguyen Thi Hoa", "Vu tru", "24/01/2021"));
        lstBill.add(new Bill(04, "Trinh Dieu Huyen", "Luc quan tinh", "10/01/2021"));
        adapterBill = new AdapterBill(BillManagerActivity.this, R.layout.one_bill, lstBill);
        listView.setAdapter(adapterBill);
    }
}