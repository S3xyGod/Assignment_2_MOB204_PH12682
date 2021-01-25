package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.s3xygod.assignmentmob204_ph12682.ActivityCon.TheLoaiActivity;
import com.s3xygod.assignmentmob204_ph12682.ActivityCon.TheLoaiInfoActivity;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.TheLoaiDAO;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterTheLoai;
import com.s3xygod.assignmentmob204_ph12682.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ListTheLoaiActivity extends AppCompatActivity {
    public static List<TheLoai> dsTheLoai = new ArrayList<>();
    ListView lvTheLoai;
    TheLoaiDAO theLoaiDAO;
    AdapterTheLoai adapterTheLoai = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.HaveTitleBar);
        setTitle("");
        setContentView(R.layout.activity_list_books);
        lvTheLoai = findViewById(R.id.lv_theLoai);
        registerForContextMenu(lvTheLoai);
        theLoaiDAO = new TheLoaiDAO(ListTheLoaiActivity.this);
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapterTheLoai = new AdapterTheLoai(this, dsTheLoai);
        lvTheLoai.setAdapter(adapterTheLoai);
        lvTheLoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListTheLoaiActivity.this, TheLoaiInfoActivity.class);
                Bundle b = new Bundle();
                b.putString("MATHELOAI", dsTheLoai.get(position).getMaTheloai());
                b.putString("TENTHELOAI", dsTheLoai.get(position).getTenTheloai());
                b.putString("MOTA", dsTheLoai.get(position).getMoTa());
                b.putString("VITRI", String.valueOf(dsTheLoai.get(position).getViTri()));
                intent.putExtras(b);
                startActivity(intent);
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
                Intent intent = new Intent(ListTheLoaiActivity.this, TheLoaiActivity.class);
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

    @Override
    protected void onResume() {
        super.onResume();
        dsTheLoai.clear();
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapterTheLoai.changeDataset(dsTheLoai);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Chọn thông tin");
    }


}