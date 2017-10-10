package com.example.ashish.sqlitedemo.screen.model;

/**
 * Created by ashish on 10/10/17.
 */

public class Employee {

    private static int id;
    private static String emp_name;
    private static String emp_number;
    private static String emp_email;
    private static String emp_department;
    private static String emp_contactNumber;

    public Employee() {
    }

    public Employee(String emp_name,String emp_number, String emp_email,String emp_department, String emp_contactNumber){
        this.emp_name = emp_name;
        this.emp_number = emp_number;
        this.emp_email = emp_email;
        this.emp_department = emp_department;
        this.emp_contactNumber = emp_contactNumber;
    }

    public Employee(String emp_name,String emp_number, String emp_email,String emp_department){
        this.emp_name = emp_name;
        this.emp_number = emp_number;
        this.emp_email = emp_email;
        this.emp_department = emp_department;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Employee.id = id;
    }

    public static String getEmp_name() {
        return emp_name;
    }

    public static void setEmp_name(String emp_name) {
        Employee.emp_name = emp_name;
    }

    public static String getEmp_number() {
        return emp_number;
    }

    public static void setEmp_number(String emp_number) {
        Employee.emp_number = emp_number;
    }

    public static String getEmp_email() {
        return emp_email;
    }

    public static void setEmp_email(String emp_email) {
        Employee.emp_email = emp_email;
    }

    public static String getEmp_department() {
        return emp_department;
    }

    public static void setEmp_department(String emp_department) {
        Employee.emp_department = emp_department;
    }

    public static String getEmp_contactNumber() {
        return emp_contactNumber;
    }

    public static void setEmp_contactNumber(String emp_contactNumber) {
        Employee.emp_contactNumber = emp_contactNumber;
    }
}
