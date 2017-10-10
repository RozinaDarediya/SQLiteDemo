package com.example.ashish.sqlitedemo.screen.global;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.ashish.sqlitedemo.R;

/**
 * Created by ashish on 10/10/17.
 */

public class AppDialog {

    public static ProgressDialog progressDialog;

    public static void showAlertDialog(Context _context, String _title,
                                       String _message, String _positiveText,
                                       DialogInterface.OnClickListener _onPositiveClick) {
        AlertDialog dialog = new AlertDialog.Builder(_context).create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        if (_title != null && _title.length() > 0) {
            dialog.setTitle(_title);
        } else {
            dialog.setTitle(_context.getString(R.string.app_name));
        }
        dialog.setMessage(_message);
        dialog.setButton(Dialog.BUTTON_POSITIVE, _positiveText,
                _onPositiveClick);
        dialog.setCancelable(false);
        dialog.show();
    }

    public static void showProgressDialog(Context context, String msg) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);
        progressDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public static void dismissProgressDialog() {
        if ((progressDialog != null) && progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
