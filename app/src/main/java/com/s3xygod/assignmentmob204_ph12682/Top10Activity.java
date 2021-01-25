package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.SachDAO;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterTopBooks;
import com.s3xygod.assignmentmob204_ph12682.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class Top10Activity extends AppCompatActivity {
    public static List<Sach> dsSach = new ArrayList<>();
    ListView lvBook;
    AdapterTopBooks adapter = null;
    SachDAO sachDAO;
    EditText Thang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10);

        lvBook = findViewById(R.id.lvBookTop);
        Thang = findViewById(R.id.edThang);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void VIEW_SACH_TOP_10(View view) {
        try {
            if (Integer.parseInt(Thang.getText().toString()) > 13 ||
                    Integer.parseInt(Thang.getText().toString()) < 0) {
                Toast.makeText(this, "Không đúng định dạng tháng (1- 12)", Toast.LENGTH_SHORT).show();
            } else {
                sachDAO = new SachDAO(Top10Activity.this);
                dsSach = sachDAO.getSachTop10(Thang.getText().toString());
                adapter = new AdapterTopBooks(this, dsSach);
                lvBook.setAdapter(adapter);
            }
        } catch (Exception ex) {
            Toast.makeText(this, "Lỗi truy suất (Không có dữ liệu)", Toast.LENGTH_SHORT).show();
        }
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