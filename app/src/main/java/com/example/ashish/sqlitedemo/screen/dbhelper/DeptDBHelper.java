package com.example.ashish.sqlitedemo.screen.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ashish.sqlitedemo.screen.model.Department;

import java.util.ArrayList;

/**
 * Created by ashish on 10/10/17.
 */

public class DeptDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EmpDepartmentDatabase.db";
    private static final String TABLE_NAME = "department";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DEPT = "dep_name";

    public DeptDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_DEPT + " TEXT "
                + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(Department department){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DEPT , department.getEmp_dept());
        db.insert(TABLE_NAME, null ,values);
        db.close();
    }

    public ArrayList<Department> getData(){
        ArrayList<Department> departmentArrayList = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();


/*
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("productname")) != null) {
                dbString += c.getString(c.getColumnIndex("productname"));
                dbString += "\n";
            }
            c.moveToNext();
        }*/

        while (!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("dep_name")) != null){
                Department department = new Department();
                department.setEmp_dept(cursor.getString(cursor.getColumnIndex("dep_name")));
                departmentArrayList.add(department);
            }
            cursor.moveToNext();
        }
        db.close();
        return departmentArrayList;
    }
}
