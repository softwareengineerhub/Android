package com.example.quicklauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getIntent().hasExtra("com.example.quicklauncher.SOMETHING")){
            TextView textView = findViewById(R.id.secondTextView);
            String somethingValue=getIntent().getStringExtra("com.example.quicklauncher.SOMETHING");
            textView.setText(somethingValue);
        }
    }
}
