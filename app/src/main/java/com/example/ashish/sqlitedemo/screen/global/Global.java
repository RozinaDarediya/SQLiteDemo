package com.example.ashish.sqlitedemo.screen.global;

import android.text.TextUtils;

/**
 * Created by ashish on 10/10/17.
 */

public class Global {

    // to validate email id
    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
