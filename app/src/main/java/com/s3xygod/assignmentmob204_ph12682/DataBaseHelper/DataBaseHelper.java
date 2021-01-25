package com.s3xygod.assignmentmob204_ph12682.DataBaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.BillDAO;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.Bill_InfoDAO;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.MemberDAO;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.SachDAO;
import com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper.TheLoaiDAO;
import com.s3xygod.assignmentmob204_ph12682.model.Bill;
import com.s3xygod.assignmentmob204_ph12682.model.Bill_Info;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MemberDAO.SQL_MEMBERS);
        db.execSQL(TheLoaiDAO.SQL_THE_LOAI);
        db.execSQL(SachDAO.SQL_SACH);
        db.execSQL(BillDAO.SQL_BILL);
        db.execSQL(Bill_InfoDAO.SQL_BILL_INFO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + MemberDAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + TheLoaiDAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + SachDAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + BillDAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + Bill_InfoDAO.TABLE_NAME);
        onCreate(db);
    }
}
