package com.example.ashish.sqlitedemo.screen.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ashish.sqlitedemo.screen.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashish on 10/10/17.
 */

public class EmpDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EmployeeDatabase.db";
    private static final String TABLE_NAME = "emplyee";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_EMPNAME = "emp_name";
    private static final String COLUNM_EMPNUM = "emp_num";
    private static final String COLUNM_EMAIL = "emp_email";
    private static final String COLUNM_DEPT = "emp_dep";
    private static final String COLUNM_CONTACT = "emp_contact";



    public EmpDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EMPNAME + " TEXT, "
                + COLUNM_EMPNUM + " TEXT, "
                + COLUNM_EMAIL + " TEXT, "
                + COLUNM_DEPT + " TEXT, "
                + COLUNM_CONTACT + " INTEGER "
                + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void saveRecord(Employee employee){
        String res= null;
        ContentValues values = new ContentValues();

        values.put(COLUMN_EMPNAME , employee.getEmp_name());
        values.put(COLUNM_EMPNUM , employee.getEmp_number());
        values.put(COLUNM_EMAIL , employee.getEmp_email());
        values.put(COLUNM_DEPT , employee.getEmp_department());
        values.put(COLUNM_CONTACT , employee.getEmp_contactNumber());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List printRecord(){
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String quety = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(quety,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex(COLUMN_EMPNAME))!=null){
                    Employee employee = new Employee();
                    employee.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID))));
                    employee.setEmp_name(cursor.getString(cursor.getColumnIndex(COLUMN_EMPNAME)));
                    employee.setEmp_number(cursor.getString(cursor.getColumnIndex(COLUNM_EMPNUM)));
                    employee.setEmp_email(cursor.getString(cursor.getColumnIndex(COLUNM_EMAIL)));
                    employee.setEmp_department(cursor.getString(cursor.getColumnIndex(COLUNM_DEPT)));
                    employee.setEmp_contactNumber(cursor.getString(cursor.getColumnIndex(COLUNM_CONTACT)));
                    employeeArrayList.add(employee);
            }
            cursor.moveToNext();
        }

        return employeeArrayList;
    }
}
