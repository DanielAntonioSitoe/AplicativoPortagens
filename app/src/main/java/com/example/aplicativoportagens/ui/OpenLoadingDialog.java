package com.example.aplicativoportagens.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.aplicativoportagens.R;

public class OpenLoadingDialog{
    AlertDialog dialog;
    Activity activity;

    public OpenLoadingDialog(Activity activity){
        this.activity=activity;
    }

    public void startDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }
    public void dismissDialog(){
        dialog.dismiss();
    }
}
