package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.s3xygod.assignmentmob204_ph12682.ActivityCon.AddBookActivity;
import com.s3xygod.assignmentmob204_ph12682.ActivityCon.BookInfoActivity;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.SachDAO;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterSach;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterTopBooks;
import com.s3xygod.assignmentmob204_ph12682.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class BooksLeftActivity extends AppCompatActivity {
    public static List<Sach> dsSach = new ArrayList<>();
    ListView lvBook;
    AdapterSach adapter = null;
    SachDAO sachDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.HaveTitleBar);
        setTitle("");
        setContentView(R.layout.activity_books_left);
        lvBook = findViewById(R.id.lv_books_left);

        sachDAO = new SachDAO(BooksLeftActivity.this);
        dsSach = sachDAO.getAllSach();
        adapter = new AdapterSach(this, dsSach);
        lvBook.setAdapter(adapter);
        lvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sach sach = (Sach) parent.getItemAtPosition(position);
                Intent intent = new Intent(BooksLeftActivity.this, BookInfoActivity.class);
                Bundle b = new Bundle();
                b.putString("MASACH", sach.getMaSach());
                b.putString("MATHELOAI", sach.getMaTheLoai());
                b.putString("TENSACH", sach.getTenSach());
                b.putString("TACGIA", sach.getTacGia());
                b.putString("NXB", sach.getNXB());
                b.putString("GIABIA", String.valueOf(sach.getGiaBia()));
                b.putString("SOLUONG", String.valueOf(sach.getSoLuong()));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        // TextFilter
        lvBook.setTextFilterEnabled(true);
        EditText edSeach = findViewById(R.id.edSearchBook);
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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sach, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.them:
                Intent intent = new Intent(BooksLeftActivity.this, AddBookActivity.class);
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