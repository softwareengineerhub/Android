package org.education.activitylifecycle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("\t\tActivity2.onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        System.out.println("\t\tActivity2.onPostCreate()");
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        System.out.println("\t\tActivity2.onStart()");
        super.onStart();
    }

    @Override
    protected void onPause() {
        System.out.println("\t\tActivity2.onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("\t\tActivity2.onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("\t\tActivity2.onDestroy()");
        super.onDestroy();
    }
}
