package com.example.ashish.sqlitedemo.screen.screen;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ashish.sqlitedemo.R;
import com.example.ashish.sqlitedemo.screen.dbhelper.DeptDBHelper;
import com.example.ashish.sqlitedemo.screen.dbhelper.EmpDBHelper;
import com.example.ashish.sqlitedemo.screen.global.AppDialog;
import com.example.ashish.sqlitedemo.screen.global.Global;
import com.example.ashish.sqlitedemo.screen.model.Department;
import com.example.ashish.sqlitedemo.screen.model.Employee;

import java.util.ArrayList;

public class AddDataActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Employee employee;
    DeptDBHelper deptDBHelper;
    EmpDBHelper empDBHelper;

    EditText etEmpName, etEmpEmail, etEmpNum, etEmpCnt;
    Spinner spinner;
    Button btnAdd;
    String department;

    ArrayList<Department> getDeptArrayList;
    ArrayList<String> strings ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        empDBHelper = new EmpDBHelper(this,null,null,1);
        deptDBHelper = new DeptDBHelper(this, null, null, 1);
        employee = new Employee();
        intt();
    }

    private void intt() {
        etEmpName = (EditText)findViewById(R.id.etEmpName);
        etEmpEmail = (EditText)findViewById(R.id.etEmpEmail);
        etEmpNum = (EditText)findViewById(R.id.etEmpNum);
        etEmpCnt = (EditText)findViewById(R.id.etEmpCnt);
        spinner = (Spinner)findViewById(R.id.spinner);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        spinner.setOnItemSelectedListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Department department = new Department("Marketing");
        deptDBHelper.addData(department);
        Department department1 = new Department("Production");
        deptDBHelper.addData(department1);
        Department department2 = new Department("Sales");
        deptDBHelper.addData(department2);
        Department department3 = new Department("Management");
        deptDBHelper.addData(department3);

        getDeptArrayList = new ArrayList<>();
        strings = new ArrayList<>();
        getDeptArrayList = deptDBHelper.getData();
        for (int i = 0; i < getDeptArrayList.size(); i++) {
            Department department4 = new Department();
            strings.add(department4.getEmp_dept());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strings);
        spinner.setAdapter(adapter);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        department = strings.get(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        validate();
    }

    //validation for edittext
    private void validate() {
      // todo check permission if needed
        String empName = etEmpName.getText().toString().trim();
        String empEmail = etEmpEmail.getText().toString().trim();
        String empNum = etEmpNum.getText().toString().trim();
        String empCnt = etEmpCnt.getText().toString().trim();

        if((!TextUtils.isEmpty(empName)) && (!TextUtils.isEmpty(empEmail)) && (!TextUtils.isEmpty(empNum)) && (!TextUtils.isEmpty(empCnt))){
            if(Global.isValidEmail(empEmail)){
                // add into db
                addToDb(empName);
            }
            else {
                AppDialog.showAlertDialog(this, "", getString(R.string.email_validation), getString(R.string.txt_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            }

        }
        else{
            AppDialog.showAlertDialog(this, "", getString(R.string.error_msg), getString(R.string.txt_ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    private void addToDb(String name) {
        Log.e("name",name);
    }
}
