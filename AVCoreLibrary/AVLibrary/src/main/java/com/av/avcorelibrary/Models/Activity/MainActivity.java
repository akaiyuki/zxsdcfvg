package com.av.avcorelibrary.Models.Activity;

import android.os.Bundle;

import com.av.avcorelibrary.Controller.Core.AVEngine;
import com.av.avcorelibrary.Controller.Core.BaseActivity;
import com.av.avcorelibrary.Models.Fragment.EventsFragment;
import com.av.avcorelibrary.R;

public class MainActivity extends BaseActivity {

    public static MainActivity INSTANCE = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFrameLayout(R.id.framelayout_main);

        INSTANCE = this;
        AVEngine.switchFragment(this, new EventsFragment(), getFrameLayout());
    }

}
