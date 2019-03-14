package org.education.intentextras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String name = getIntent().getStringExtra("org.education.intentextras.MainActivity.name");
        TextView textView = findViewById(R.id.textView);
        textView.setText(name);
    }
}
