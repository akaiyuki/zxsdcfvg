package com.av.avcorelibrary.Views.Gesture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

import com.av.avcorelibrary.Models.Activity.MainActivity;
import com.av.avcorelibrary.R;
import com.github.pwittchen.swipe.library.Swipe;
import com.github.pwittchen.swipe.library.SwipeListener;

/**
 * Created by CodeSyaona on 7/13/16.
 */
public class SwipeActivity extends AppCompatActivity {

    private Swipe swipe;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipe = new Swipe();
        swipe.addListener(new SwipeListener() {
            @Override public void onSwipingLeft(final MotionEvent event) {
                Log.d("swipe", "swiping left");
            }

            @Override public void onSwipedLeft(final MotionEvent event) {
                Log.d("swipe", "swiped left");
            }

            @Override public void onSwipingRight(final MotionEvent event) {
                Log.d("swipe", "swiping right");
            }

            @Override public void onSwipedRight(final MotionEvent event) {
                Log.d("swipe", "swiped right");
            }

            @Override public void onSwipingUp(final MotionEvent event) {
                Log.d("swipe", "swiping up");
            }

            @Override public void onSwipedUp(final MotionEvent event) {
                Log.d("swipe", "swiped up");
            }

            @Override public void onSwipingDown(final MotionEvent event) {
                Log.d("swipe", "swiping down");
            }

            @Override public void onSwipedDown(final MotionEvent event) {
                Log.d("swipe", "swiped down");
            }
        });
    }

    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        swipe.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }


}