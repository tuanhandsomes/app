package com.example.appqunlsinhvin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appqunlsinhvin.model.Monhoc;

import javax.security.auth.Subject;

public class database extends SQLiteOpenHelper {

    //Tên database
    private static String DATABASE_NAME = "Quanlysinhvien";
    //Bảng môn học
    private static String BANG_MONHOC = "Monhoc";
    private static String ID_MONHOC = "idmonhoc";
    private static String TEN_MONHOC = "tenMonhoc";
    private static String SO_TIN_CHI = "soTinChi";
    private static String TIME_HOC = "timeHoc";
    private static String DIA_DIEM = "diaDiem";
    private static String VERSION = String.valueOf(1);

    //Bảng sinh viên
    private static String BANG_SINHVIEN = "sinhVien";
    private static String ID_SINHVIEN = "idsinhVien";
    private static String TEN_SINHVIEN = "tensinhVien";
    private static String GIOI_TINH = "gioiTinh";
    private static String MA_SINHVIEN = "masinhVien";
    private static String NGAYSINH = "ngaySinh";

    //Tạo bảng môn học
    private String SQLQuery = "CREATE TABLE " + BANG_MONHOC + " ( " + ID_MONHOC + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TEN_MONHOC + " TEXT, "
            + SO_TIN_CHI + "INTEGER, "
            + TIME_HOC + " TEXT ,"
            + DIA_DIEM + " TEXT) ";

    //Tạo bảng sinh viên
    private String SQLQuery1 = "CREATE TABLE "+ BANG_SINHVIEN + " ( " + ID_SINHVIEN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TEN_SINHVIEN + " TEXT, "
            + GIOI_TINH + " TEXT, "
            + MA_SINHVIEN + " TEXT, "
            + NGAYSINH + " TEXT, "
            + ID_MONHOC + " INTEGER , FOREIGN KEY ( "+ ID_MONHOC + " ) REFERENCES "
            + BANG_MONHOC + "("+ID_MONHOC+"))";


    public database(@Nullable Context context) {
        super(context, DATABASE_NAME,null, Integer.parseInt(VERSION));
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        sqLiteDatabase.execSQL(SQLQuery1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Phương thức insert môn học
    public void AddMonhoc (Monhoc monhoc){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TEN_MONHOC,monhoc.getTenMonhoc());
        values.put(SO_TIN_CHI,monhoc.getSoTinChi());
        values.put(TIME_HOC,monhoc.getTimeHoc());
        values.put(DIA_DIEM,monhoc.getDiaDiem());

        db.insert(BANG_MONHOC, null,values);
        db.close();
    }

    // Cập nhật môn học
    public boolean UpdateMonhoc (Monhoc monhoc,int id){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEN_MONHOC,monhoc.getTenMonhoc());
        values.put(SO_TIN_CHI,monhoc.getSoTinChi());
        values.put(TIME_HOC,monhoc.getTimeHoc());
        values.put(DIA_DIEM,monhoc.getDiaDiem());

        db.update(BANG_MONHOC, values, ID_MONHOC + " = " + id,null);
        return true;
    }

    //Lấy dữ liệu môn học
    public Cursor getDataMonhoc(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ BANG_MONHOC, null);
        return cursor;
    }

    public int DeleteMonhoc(int i){
        //Chú ý :getWritableDatabase(); là cả đọc và ghi
        //getReadableDatabase(); chỉ đọc, không được phép chỉnh sửa, không cần thiết thì dùng Read cho tối ưu
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(BANG_MONHOC, ID_MONHOC + " = " + i, null);
        return res;
    }
}
