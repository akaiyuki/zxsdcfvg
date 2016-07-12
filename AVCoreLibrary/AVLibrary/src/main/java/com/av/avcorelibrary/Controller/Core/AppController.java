package com.av.avcorelibrary.Controller.Core;

import android.app.Application;

/**
 * Created by CodeSyaona on 7/12/16.
 */
public class AppController extends Application {

    private static AppController mInstance;
    public static synchronized AppController getInstance() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
//        SharedPreferences.init(mInstance);

    }


}
