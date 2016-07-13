package com.av.avcorelibrary.Models.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.av.avcorelibrary.Controller.Core.AVEngine;
import com.av.avcorelibrary.Controller.Core.BaseActivity;
import com.av.avcorelibrary.Models.Fragment.EventsFragment;
import com.av.avcorelibrary.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public static MainActivity INSTANCE = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        /* set framelayout for fragment */
        setFrameLayout(R.id.framelayout_main);

        INSTANCE = this;
        AVEngine.switchFragment(this, new EventsFragment(), getFrameLayout());


    }


    void startAnim(){
        findViewById(R.id.avloadingIndicatorView).setVisibility(View.VISIBLE);
    }

    void stopAnim(){
        findViewById(R.id.avloadingIndicatorView).setVisibility(View.GONE);
    }



}
