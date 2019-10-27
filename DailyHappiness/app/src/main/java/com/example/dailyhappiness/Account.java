package com.example.dailyhappiness;

import android.util.Log;

import static okhttp3.internal.Internal.instance;

public class Account {

    static String id = "";
    static String pw = "";
    static String gender = "";
    static String age = "";
    private static Account instance =null;


    public static String getId() {
        return id;
    }

    public static String getPw() {
        return pw;
    }

    public static String getGender() {
        return gender;
    }

    public static String getAge() {
        return age;
    }

    public static void setId(String id) {
        Account.id = id;
    }

    public static void setPw(String pw) {
        Account.pw = pw;
    }

    public static void setGender(String gender) {
        Account.gender = gender;
    }

    public static void setAge(String age) {
        Account.age = age;
    }

    private Account(){}

    public static Account getInstance(){
        if(instance ==null){
            instance = new Account();
        }
        return instance;
    }

    public static void Account(String id, String pw, String gender, String age,String name, String time_affordable, String expense_affordable) {
        Log.d("account 생성자", id);
        setAge(age);
        setGender(gender);
        setId(id);
        setPw(pw);
    }



}