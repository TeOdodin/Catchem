package com.example.daudin.catchem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;

    DatabaseReference myRef;

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
    }
}
