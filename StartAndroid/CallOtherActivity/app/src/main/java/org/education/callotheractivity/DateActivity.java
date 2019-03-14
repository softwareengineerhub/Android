package org.education.callotheractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        //SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        //String time = dateFormat.format(new Date());
        TextView dateTextView = findViewById(R.id.dateTextView);
        dateTextView.setText(new Date().toString());
    }
}
