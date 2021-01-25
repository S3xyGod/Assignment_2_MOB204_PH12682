package com.s3xygod.assignmentmob204_ph12682.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.s3xygod.assignmentmob204_ph12682.DataBaseHelper.DataBaseHelper;
import com.s3xygod.assignmentmob204_ph12682.model.Bill;
import com.s3xygod.assignmentmob204_ph12682.model.Bill_Info;
import com.s3xygod.assignmentmob204_ph12682.model.Sach;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Bill_InfoDAO {
    public static final String TABLE_NAME = "HoaDonChiTiet";
    public static final String SQL_BILL_INFO = "CREATE TABLE HoaDonChiTiet(maHDCT INTEGER PRIMARY KEY AUTOINCREMENT, " + "maHoaDon text NOT NULL, maSach text NOT NULL, soLuong INTEGER);";
    public static final String TAG = "Bill_Info";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SQLiteDatabase db;
    private DataBaseHelper dbHelper;

    public Bill_InfoDAO(Context context) {
        dbHelper = new DataBaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public int inserBill_Info(Bill_Info bill_info) {
        ContentValues values = new ContentValues();
        values.put("mahoadon", bill_info.getHoaDon().getIdBill());
        values.put("maSach", bill_info.getSach().getMaSach());
        values.put("soLuong", bill_info.getSoLuongMua());
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
    public List<Bill_Info> getAllBill_Info() {
        List<Bill_Info> lstBill_Info = new ArrayList<>();
        String sSQL = "SELECT maHDCT, HoaDon.maHoaDon,HoaDon.ngayMua, " + "Sach.maSach, Sach.maTheLoai, Sach.tenSach, Sach.tacGia, Sach.NXB, Sach.giaBia, " + "Sach.soLuong,HoaDonChiTiet.soLuong FROM HoaDonChiTiet INNER JOIN HoaDon " + "on HoaDonChiTiet.maHoaDon = HoaDon.maHoaDon INNER JOIN Sach on Sach.maSach = HoaDonChiTiet.maSach";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        try {
            while (c.isAfterLast() == false) {
                Bill_Info ee = new Bill_Info();
                ee.setMaHDCT(c.getInt(0));
                ee.setHoaDon(new Bill(c.getString(1), sdf.parse(c.getString(2))));
                ee.setSach(new Sach(c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getInt(8), c.getInt(9)));
                ee.setSoLuongMua(c.getInt(10));
                lstBill_Info.add(ee);
                Log.d("//=====", ee.toString());
                c.moveToNext();
            }
            c.close();
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
        return lstBill_Info;
    }

    //getAll
    public List<Bill_Info> getAllBill_InfoByID(String maHoaDon) {
        List<Bill_Info> dsHoaDonChiTiet = new ArrayList<>();
        String sSQL = "SELECT maHDCT, HoaDon.maHoaDon,HoaDon.ngayMua, " + "Sach.maSach, Sach.maTheLoai, Sach.tenSach, Sach.tacGia, Sach.NXB, Sach.giaBia, " + "Sach.soLuong,HoaDonChiTiet.soLuong FROM HoaDonChiTiet INNER JOIN HoaDon " + "on HoaDonChiTiet.maHoaDon = HoaDon.maHoaDon INNER JOIN Sach on Sach.maSach = HoaDonChiTiet.maSach where HoaDonChiTiet.maHoaDon='" + maHoaDon + "'";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        try {
            while (c.isAfterLast() == false) {
                Bill_Info ee = new Bill_Info();
                ee.setMaHDCT(c.getInt(0));
                ee.setHoaDon(new Bill(c.getString(1), sdf.parse(c.getString(2))));
                ee.setSach(new Sach(c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getInt(8), c.getInt(9)));
                ee.setSoLuongMua(c.getInt(10));
                dsHoaDonChiTiet.add(ee);
                Log.d("//=====", ee.toString());
                c.moveToNext();
            }
            c.close();
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
        return dsHoaDonChiTiet;
    }

    //update
    public int updateBill_Info(Bill_Info bill_info) {
        ContentValues values = new ContentValues();
        values.put("maHDCT", bill_info.getMaHDCT());
        values.put("mahoadon", bill_info.getHoaDon().getIdBill());
        values.put("maSach", bill_info.getSach().getMaSach());
        values.put("soLuong", bill_info.getSoLuongMua());
        int result = db.update(TABLE_NAME, values, "maHDCT=?", new
                String[]{String.valueOf(bill_info.getMaHDCT())});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteBill_InfoByID(String maHDCT) {
        int result = db.delete(TABLE_NAME, "maHDCT=?", new String[]{maHDCT});
        if (result == 0)
            return -1;
        return 1;
    }

    //check
    public boolean checkBill(String idBill) {
        //SELECT
        String[] columns = {"maHoaDon"};
        //WHERE clause
        String selection = "maHoaDon=?";
        //WHERE clause arguments
        String[] selectionArgs = {idBill};
        Cursor c = null;
        try {
            c = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null,
                    null);
            c.moveToFirst();
            int i = c.getCount();
            c.close();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public double getDoanhThuTheoNgay() {
        double doanhThu = 0;
        String sSQL = "SELECT SUM(tongtien) from (SELECT SUM(Sach.giaBia * HoaDonChiTiet.soLuong) as 'tongtien' " +
                "FROM HoaDon INNER JOIN HoaDonChiTiet on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon " + "INNER JOIN Sach on HoaDonChiTiet.maSach = Sach.maSach where HoaDon.ngayMua = date('now') GROUP BY HoaDonChiTiet.maSach)tmp";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            doanhThu = c.getDouble(0);
            c.moveToNext();
        }
        c.close();
        return doanhThu;
    }

    public double getDoanhThuTheoThang() {
        double doanhThu = 0;
        String sSQL = "SELECT SUM(tongtien) from (SELECT SUM(Sach.giaBia * HoaDonChiTiet.soLuong) as 'tongtien' " + "FROM HoaDon INNER JOIN HoaDonChiTiet on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon " + "INNER JOIN Sach on HoaDonChiTiet.maSach = Sach.maSach where strftime('%m',HoaDon.ngayMua) = strftime('%m','now') GROUP BY HoaDonChiTiet.maSach)tmp";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            doanhThu = c.getDouble(0);
            c.moveToNext();
        }
        c.close();
        return doanhThu;
    }

    public double getDoanhThuTheoNam() {
        double doanhThu = 0;
        String sSQL = "SELECT SUM(tongtien) from (SELECT SUM(Sach.giaBia * HoaDonChiTiet.soLuong) as 'tongtien' " + "FROM HoaDon INNER JOIN HoaDonChiTiet on HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon " + "INNER JOIN Sach on HoaDonChiTiet.maSach = Sach.maSach where strftime('%Y',HoaDon.ngayMua) = strftime('%Y','now') GROUP BY HoaDonChiTiet.maSach)tmp";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            doanhThu = c.getDouble(0);
            c.moveToNext();
        }
        c.close();
        return doanhThu;
    }
}
