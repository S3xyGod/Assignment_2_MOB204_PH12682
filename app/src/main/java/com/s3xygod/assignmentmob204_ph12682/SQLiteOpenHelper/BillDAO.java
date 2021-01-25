package com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.s3xygod.assignmentmob204_ph12682.DataBaseHelper.DataBaseHelper;
import com.s3xygod.assignmentmob204_ph12682.model.Bill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class BillDAO {
    public static final String TABLE_NAME = "Bill";
    public static final String SQL_BILL = "CREATE TABLE Bill (idBill TEXT PRIMARY KEY, ngayMuon DATE);";
    public static final String TAG = "Bil_Info";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SQLiteDatabase db;
    private DataBaseHelper dbHelper;

    public BillDAO(Context context) {
        dbHelper = new DataBaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertBill(Bill bill){
        ContentValues values = new ContentValues();
        values.put("idBill", bill.getIdBill());
        values.put("ngayMuon", simpleDateFormat.format(bill.getNgayMuon()));
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<Bill> getAllBill() throws ParseException{
        List<Bill> lstBill = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            Bill billtemp = new Bill();
            billtemp.setIdBill(cursor.getString(0));
            billtemp.setNgayMuon(simpleDateFormat.parse(cursor.getString(1)));
            lstBill.add(billtemp);
            Log.d("//=====", billtemp.toString());
            cursor.moveToNext();
        }
        cursor.close();
        return lstBill;
    }

    public int updateBill(Bill bill){
        ContentValues values = new ContentValues();
        values.put("idBill", bill.getIdBill());
        values.put("ngayMuon", bill.getNgayMuon().toString());
        int result = db.update(TABLE_NAME, values, "idBill=?", new
                String[]{bill.getIdBill()});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int deleteBill(String idBill){
        int result = db.delete(TABLE_NAME, "idBill=?", new String[]{idBill});
        if (result == 0){
            return -1;
        }
        return 1;
    }

}
