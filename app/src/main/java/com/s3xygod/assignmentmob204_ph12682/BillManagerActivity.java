package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.assignmentmob204_ph12682.ActivityCon.AddBillActivity;
import com.s3xygod.assignmentmob204_ph12682.ActivityCon.BillInfoActivity;
import com.s3xygod.assignmentmob204_ph12682.ActivityCon.ListBookOnBillActivity;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.BillDAO;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterBill;
import com.s3xygod.assignmentmob204_ph12682.model.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillManagerActivity extends AppCompatActivity {
    ListView lvHoaDon;
    public List<Bill> dsHoaDon = new ArrayList<>();
    AdapterBill adapter = null;
    BillDAO hoaDonDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.HaveTitleBar);
        setTitle("");
        setContentView(R.layout.activity_bill_manager);
        lvHoaDon = findViewById(R.id.lvHoaDon);


        hoaDonDAO = new BillDAO(BillManagerActivity.this);
        try {
            dsHoaDon = hoaDonDAO.getAllBill();
        } catch (Exception e) {
            Log.d("Error: ", e.toString());
        }
        adapter = new AdapterBill(this, dsHoaDon);
        lvHoaDon.setAdapter(adapter);
        lvHoaDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bill hoaDon = (Bill) parent.getItemAtPosition(position);
                Intent intent = new Intent(BillManagerActivity.this, BillInfoActivity.class);
                Bundle b = new Bundle();
                b.putString("MAHOADON", hoaDon.getIdBill());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        // TextFilter
        lvHoaDon.setTextFilterEnabled(true);
        EditText edSeach = findViewById(R.id.edSearch);
        edSeach.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {
                System.out.println("Text [" + s + "] - Start [" + start + "] - Before [" + before + "] - Count [" + count + "]");
                if (count < before) {
                    adapter.resetData();
                }
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_theloai, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addd:
                Intent intent = new
                        Intent(BillManagerActivity.this, AddBillActivity.class);
                startActivity(intent);
                return (true);
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}