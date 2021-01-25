package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.MemberDAO;
import com.s3xygod.assignmentmob204_ph12682.adapter.AdapterMem;
import com.s3xygod.assignmentmob204_ph12682.model.Members;

import java.util.ArrayList;
import java.util.List;

public class ListMemActivity extends AppCompatActivity {
    public static List<Members> dsMem = new ArrayList<>();
    ListView listView;
    AdapterMem adapter = null;
    MemberDAO memberDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mem);
        listView = findViewById(R.id.lv_members);

        memberDAO = new MemberDAO(ListMemActivity.this);
        dsMem = memberDAO.getAllMem();
        adapter = new AdapterMem(this, dsMem);
        listView.setAdapter(adapter);

    }
}