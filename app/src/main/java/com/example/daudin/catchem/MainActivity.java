package com.example.daudin.catchem;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat gestureDetector;


    FirebaseDatabase database;

    DatabaseReference myRef;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            database = FirebaseDatabase.getInstance();
        } catch (Exception e) {
            Log.e("BUGdatabase", e.getMessage());
        }
        try {
        myRef = database.getReference("message");
        } catch (Exception e) {
            Log.e("BUGref", e.getMessage());
        }
        try {
            myRef.setValue("Hello, World!");
        } catch (Exception e) {
            Log.e("BUGValue", e.getMessage());
        }

        gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
        // myRef.setValue("Hello, World!");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getY() > e2.getY()) {
            this.swipeUp();
            Log.e("test quentin","swipe up");
        }
        return false;
    }

    public void swipeUp(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        overridePendingTransition(R.anim.swipe_up, R.anim.staticview);
    }
}
