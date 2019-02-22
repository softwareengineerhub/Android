package com.example.asusadmin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text1= findViewById(R.id.firstNumEditText);
                EditText text2= findViewById(R.id.secondNumEditText);
                int a = Integer.parseInt(text1.getText().toString());
                int b = Integer.parseInt(text2.getText().toString());
                int res = a+b;
                System.out.println("RESULT="+res);
                TextView resultTextView = findViewById(R.id.resultTextView);
                resultTextView.setText(res+"");

            }
        });
    }
}
