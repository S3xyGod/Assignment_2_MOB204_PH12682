package com.s3xygod.assignmentmob204_ph12682.ActivityCon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.assignmentmob204_ph12682.R;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.TheLoaiDAO;

public class TheLoaiInfoActivity extends AppCompatActivity {
    EditText edMatheloai, edTentheloai, edMota, edVitri;
    TheLoaiDAO theloaiDAO;
    String ma, ten, vi, mo, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai_info);

        edMatheloai = findViewById(R.id.edMatheloai);
        edTentheloai = findViewById(R.id.edTentheloai);
        edMota = findViewById(R.id.edMota);
        edVitri = findViewById(R.id.edVitri);
        theloaiDAO = new TheLoaiDAO(this);
        TextView text = findViewById(R.id.text);
//        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/svn-hello_sweets.otf");
//        text.setTypeface(type);
        Intent in = getIntent();
        Bundle c = in.getExtras();
        user = c.getString("MATHELOAI");
        ten = c.getString("TENTHELOAI");
        mo = c.getString("MOTA");
        vi = c.getString("VITRI");
        edMatheloai.setText(user);
        edTentheloai.setText(ten);
        edMota.setText(mo);
        edVitri.setText(vi);
    }
    public void updateU(View view) {

        if (theloaiDAO.updateInfoTheLoai(user, edMatheloai.getText().toString(), edTentheloai.getText().toString(), edMota.getText().toString(), edVitri.getText().toString()) > 0) {
            Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
        }
    }

    public void Huy(View view) {
        finish();
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