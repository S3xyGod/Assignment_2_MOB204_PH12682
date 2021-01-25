package com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.s3xygod.assignmentmob204_ph12682.DataBaseHelper.DataBaseHelper;
import com.s3xygod.assignmentmob204_ph12682.model.Members;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public static final String TABLE_NAME = "NguoiDung";
    public static final String SQL_MEMBERS = "CREATE TABLE NguoiDung (username text primary key, password text, phone text, hoten text);";
    public static final String TAG = "Members";
    private SQLiteDatabase db;
    private DataBaseHelper dbHelper;

    public MemberDAO(Context context) {
        dbHelper = new DataBaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public int inserMem(Members members) {
        ContentValues values = new ContentValues();
        values.put("username", members.getUserName());
        values.put("password", members.getPassword());
        values.put("phone", members.getPhone());
        values.put("hoten", members.getHoTen());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    //getAll
    public List<Members> getAllMem() {
        List<Members> lstMembers = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Members ee = new Members();
            ee.setUserName(c.getString(0));
            ee.setPassword(c.getString(1));
            ee.setPhone(c.getString(2));
            ee.setHoTen(c.getString(3));
            lstMembers.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return lstMembers;
    }

    //update
    public int updateMem(Members nd) {
        ContentValues values = new ContentValues();
        values.put("username", nd.getUserName());
        values.put("password", nd.getPassword());
        values.put("phone", nd.getPhone());
        values.put("hoten", nd.getHoTen());
        int result = db.update(TABLE_NAME, values, "username=?", new
                String[]{nd.getUserName()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int changePassMem(Members nd) {
        ContentValues values = new ContentValues();
        values.put("username", nd.getUserName());
        values.put("password", nd.getPassword());
        int result = db.update(TABLE_NAME, values, "username=?", new String[]{nd.getUserName()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int changePass(Members nd) {
        ContentValues values = new ContentValues();
        values.put("password", nd.getPassword());
        int result = db.update(TABLE_NAME, values, "password=?", new String[]{nd.getPassword()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int updateInfoMem(String username, String phone, String name) {
        ContentValues values = new ContentValues();
        values.put("phone", phone);
        values.put("hoten", name);
        int result = db.update(TABLE_NAME, values, "username=?", new
                String[]{username});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteMemByID(String username) {
        int result = db.delete(TABLE_NAME, "username=?", new String[]{username});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //check login
    public int checkLogin(String username, String password) {
        int result = db.delete(TABLE_NAME, "username=? AND password=?", new
                String[]{username, password});
        if (result == 0)
            return -1;
        return 1;
    }

    public Boolean Luu(String user, String pass) {
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from NguoiDung where username=? AND password=?", new String[]{user, pass});
        return cursor.getCount() > 0;
    }
}

