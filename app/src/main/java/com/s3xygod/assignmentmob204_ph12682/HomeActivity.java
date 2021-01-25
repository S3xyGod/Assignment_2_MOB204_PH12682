package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.s3xygod.assignmentmob204_ph12682.model.Sach;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private TextView wellcom;
    ImageView img_money, img_left, img_mem;
    TextView txt_money, txt_left, txt_mem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        wellcom = findViewById(R.id.txt_wellcom);
        img_money = findViewById(R.id.btn_money_img);
        img_left = findViewById(R.id.btn_booksleft_img);
        img_mem = findViewById(R.id.btn_mem_img);
        txt_money = findViewById(R.id.btn_money_txt);
        txt_left = findViewById(R.id.btn_booksleft_txt);
        txt_mem = findViewById(R.id.btn_mem_txt);
        Intent intent = getIntent();
        String idLogin = intent.getStringExtra("sayHi");
        wellcom.setText("Xin chào, "+idLogin+" !");
        if(idLogin.equals("user")){
            img_money.setVisibility(View.GONE);
            txt_money.setVisibility(View.GONE);
            img_left.setVisibility(View.GONE);
            txt_left.setVisibility(View.GONE);
            img_mem.setVisibility(View.GONE);
            txt_mem.setVisibility(View.GONE);
        }else {
            img_money.setVisibility(View.VISIBLE);
            txt_money.setVisibility(View.VISIBLE);
            img_left.setVisibility(View.VISIBLE);
            txt_left.setVisibility(View.VISIBLE);
            img_mem.setVisibility(View.VISIBLE);
            txt_mem.setVisibility(View.VISIBLE);
        }

    }

    public void OpenListBooks(View view) {
        Intent intent = new Intent(this, ListTheLoaiActivity.class);
        startActivity(intent);
    }

    public void top10(View view) {
        Intent intent = new Intent(this, Top10Activity.class);
        startActivity(intent);
    }

    public void billManager(View view) {
        Intent intent = new Intent(this, BillManagerActivity.class);
        startActivity(intent);
    }

    public void moneyManager(View view) {
        Intent intent = new Intent(this, MoneyActivity.class);
        startActivity(intent);
    }

    public void booksLeft(View view) {
        Intent intent = new Intent(this, BooksLeftActivity.class);
        startActivity(intent);
    }

    public void memManager(View view) {
        Intent intent = new Intent(this, MembersActivity.class);
        startActivity(intent);
    }

    public void exitApp(View view) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Xác nhận đăng xuất");
        b.setMessage("Bạn có đồng ý đăng xuất không ?");
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                HomeActivity.super.onDestroy();
                finish();
            }
        });
        b.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog al = b.create();
        al.show();
    }
}