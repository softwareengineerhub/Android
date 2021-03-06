package org.education.callotheractivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dateBtn =  findViewById(R.id.dateBtn);
        Button  timeBtn =  findViewById(R.id.timeBtn);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("org.education.callotheractivity.action.date");
                startActivity(intent);
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("org.education.callotheractivity.action.time");
               // Intent intent = new Intent(v.getContext(), TimeActivity.class);

                startActivity(intent);
            }
        });
    }
}
