package com.av.avcorelibrary.Controller.Core;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by CodeSyaona on 7/11/16.
 */
public class AVEngine {

    public static void switchFragment(BaseActivity baseActivity, Fragment fragment, int frame) {

        FragmentManager fm = baseActivity.getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(frame, fragment);
        transaction.addToBackStack(fragment.getClass().toString());
        transaction.commit();
    }

    public static Realm realmConfiguration(BaseActivity baseActivity){
        // Create a RealmConfiguration that saves the Realm file in the app's "files" directory.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(baseActivity).build();
        Realm.setDefaultConfiguration(realmConfig);

        // Get a Realm instance for this thread
        return Realm.getDefaultInstance();
    }

    public static void clearDatabase(Realm realm, String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{

        Class classTemp = Class.forName(className);
//        Object obj =classTemp.newInstance();

        realm.beginTransaction();
        //noinspection unchecked
        realm.delete(classTemp);
        realm.commitTransaction();

    }

}
