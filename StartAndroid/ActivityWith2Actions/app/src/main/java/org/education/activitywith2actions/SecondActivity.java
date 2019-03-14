package org.education.activitywith2actions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView resultTextView = findViewById(R.id.resultTextView);

        Intent intent = getIntent();
        String action = intent.getAction();
        if (action.endsWith("time")) {
            resultTextView.setText("TIME");
        } else {
            resultTextView.setText("DATE");
        }
    }
}
