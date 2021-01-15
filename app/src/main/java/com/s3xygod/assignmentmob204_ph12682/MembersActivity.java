package com.s3xygod.assignmentmob204_ph12682;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
    }

    public void openListMem(View view) {
        Intent intent = new Intent(MembersActivity.this, ListMemActivity.class);
        startActivity(intent);
    }

    public void cannelAdd(View view) {
    }

    public void addMem(View view) {
    }
}