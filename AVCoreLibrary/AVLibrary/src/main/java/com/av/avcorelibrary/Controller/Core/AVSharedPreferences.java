package com.av.avcorelibrary.Controller.Core;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by CodeSyaona on 7/13/16.
 */
public class AVSharedPreferences {

    private static SharedPreferences mSharedPreferences;
    private static Context mContext;
    private static final String APP_PREFS= "APP_SETTINGS";

    private AVSharedPreferences() {}

    public static void init(Context context) {
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

    public static String getSomeStringValue(Context context, String key) {
        return mSharedPreferences.getString(key , "");
    }

    public static void setSomeStringValue(Context context, String key, String newValue) {
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key , newValue);
        editor.apply();
    }

    public static void clearAllPreferences() {
        mSharedPreferences.edit().clear().apply();
    }

}
