package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterListBooks;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterTopBooks;
import com.s3xygod.assignmentmob204_ph12682.data.Sach;

import java.util.ArrayList;

public class BooksLeftActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Sach> ArrLstSach;
    AdapterTopBooks adapterTopBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_left);
        listView = findViewById(R.id.lv_books_left);
        ArrLstSach = new ArrayList<>();
        ArrLstSach.add(new Sach(01, "Chi Pheo", "Van hoc", 50000));
        ArrLstSach.add(new Sach(02, "Vu tru", "Khoa hoc", 90000));
        ArrLstSach.add(new Sach(03, "Luc quan tinh", "Vat ly", 80000));
        ArrLstSach.add(new Sach(04, "Top notch 1", "Tieng Anh", 65000));
        adapterTopBooks = new AdapterTopBooks(BooksLeftActivity.this, R.layout.one_the_loai, ArrLstSach);
        listView.setAdapter(adapterTopBooks);
    }
}