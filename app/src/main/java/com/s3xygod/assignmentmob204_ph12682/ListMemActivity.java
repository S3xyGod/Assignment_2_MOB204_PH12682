package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterMem;
import com.s3xygod.assignmentmob204_ph12682.data.Members;

import java.util.ArrayList;

public class ListMemActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Members> ArrLstMem;
    AdapterMem adapterMem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mem);
        listView = findViewById(R.id.lv_members);
        ArrLstMem = new ArrayList<>();
        ArrLstMem.add(new Members(01, "Pham Cong Bang", "123456", "0978998816", "Hai Duong"));
        ArrLstMem.add(new Members(02, "Le Van Nam", "123456", "113", "Ha Noi"));
        ArrLstMem.add(new Members(03, "Nguyen Thi Hoa", "123456", "80000", "HP"));
        ArrLstMem.add(new Members(04, "Trinh Dieu Huyen", "123456", "65000", "Hue"));
        adapterMem = new AdapterMem(ListMemActivity.this, R.layout.one_member, ArrLstMem);
        listView.setAdapter(adapterMem);
    }
}