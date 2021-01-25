package com.s3xygod.assignmentmob204_ph12682.ActivityCon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.TheLoaiDAO;
import com.s3xygod.assignmentmob204_ph12682.model.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {
    Button btnThemTheLoai;
    TheLoaiDAO theloaiDAO;
    EditText edMa, edTen, edVi, edMo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thêm thể loại sách");
        setContentView(R.layout.activity_the_loai);

        btnThemTheLoai = findViewById(R.id.btnThem);
        edMa = findViewById(R.id.edMa);
        edTen = findViewById(R.id.edTen);
        edVi = findViewById(R.id.edVi);
        edMo = findViewById(R.id.edMo);
        TextView text = findViewById(R.id.text);
    }

    public void themtheloai(View view) {
        theloaiDAO = new TheLoaiDAO(TheLoaiActivity.this);
        TheLoai user = new TheLoai(edMa.getText().toString(), edTen.getText().toString(), edMo.getText().toString(), edVi.getText().toString());
        try {
            if (validateForm() > 0) {
                if (theloaiDAO.inserTheLoai(user) > 0) {
                    onBackPressed();
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Lỗi:", ex.toString());
        }
    }

    public void showtheloai(View view) {
    }

    public void quaylai(View view) {
    }

    public int validateForm() {
        int check = 1;
        if (edMa.getText().length() == 0 || edTen.getText().length() == 0
                || edVi.getText().length() == 0 || edMo.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
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