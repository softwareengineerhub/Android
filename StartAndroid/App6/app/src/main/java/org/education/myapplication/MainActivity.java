package org.education.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main_relative);
        //setContentView(R.layout.activity_main_table);
        //setContentView(R.layout.screen_parameters);
        //setContentView(R.layout.activity_main_frame);
        setContentView(R.layout.activity_main_layout_margin);
    }
}
