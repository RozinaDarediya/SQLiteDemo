package com.example.ashish.sqlitedemo.screen.model;

/**
 * Created by ashish on 10/10/17.
 */

public class Department  {

    private static int id;
    private static String emp_dept;

    public Department() {
    }

    public Department(String emp_name){
        this.emp_dept = emp_name;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Department.id = id;
    }

    public static String getEmp_dept() {
        return emp_dept;
    }

    public static void setEmp_dept(String emp_name) {
        Department.emp_dept = emp_name;
    }
}
