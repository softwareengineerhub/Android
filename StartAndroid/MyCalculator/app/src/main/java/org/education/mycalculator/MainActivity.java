package org.education.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CalculatorActionListener calculatorActionListener;
    private float currentValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView resultTextView = findViewById(R.id.resultTextView);
        calculatorActionListener = new CalculatorActionListener(resultTextView, currentValue);

        Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn1 = findViewById(R.id.btn1);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn2 = findViewById(R.id.btn2);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn3 = findViewById(R.id.btn3);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn4 = findViewById(R.id.btn4);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn5 = findViewById(R.id.btn5);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn6 = findViewById(R.id.btn6);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn7 = findViewById(R.id.btn7);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn8 = findViewById(R.id.btn8);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn9 = findViewById(R.id.btn9);
        btn0.setOnClickListener(calculatorActionListener);
    }
}
