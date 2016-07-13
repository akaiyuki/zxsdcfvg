package com.av.avcorelibrary.Views.Snackbar;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.av.avcorelibrary.Controller.Core.BaseActivity;
import com.av.avcorelibrary.Models.Activity.MainActivity;
import com.av.avcorelibrary.R;
import com.golovin.fluentstackbar.FluentSnackbar;

/**
 * Created by CodeSyaona on 7/13/16.
 */
public class AVSnackBar {

    public static FluentSnackbar mSnackbar;

    public static void displaySnackBar(BaseActivity baseActivity){

        mSnackbar = new FluentSnackbar(baseActivity);

        mSnackbar.create("Text")
                .maxLines(2) // default is 1 line
                .backgroundColorRes(R.color.colorPrimaryDark) // default is #323232
                .textColorRes(R.color.colorTextColor) // default is Color.WHITE
                .duration(Snackbar.LENGTH_LONG) // default is Snackbar.LENGTH_LONG
                .actionText("Action text") // default is "Action"
                .actionTextColorRes(R.color.colorAccent)
                .important()
                .action(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .show();
    }

}
