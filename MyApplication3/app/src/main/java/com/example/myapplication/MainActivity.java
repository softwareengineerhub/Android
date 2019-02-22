package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("@@@@@Here");
                EditText firstNumber = findViewById(R.id.firstNumEditText);
                EditText secondNumber = findViewById(R.id.secondNumEditText);
                int a = Integer.parseInt(firstNumber.getText().toString());
                int b = Integer.parseInt(secondNumber.getText().toString());
                TextView textView = findViewById(R.id.result);
                textView.setText(a+b+"");
            }
        });
    }
}
