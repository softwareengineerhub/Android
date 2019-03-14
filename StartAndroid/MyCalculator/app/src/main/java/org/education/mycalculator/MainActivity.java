package org.education.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CalculatorActionListener calculatorActionListener;
    private ArithmeticButtonsListener arithmeticButtonsListener;
    protected float currentValue;
    protected String calculationActionType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView resultTextView = findViewById(R.id.resultTextView);
        arithmeticButtonsListener = new ArithmeticButtonsListener(resultTextView, this);
        calculatorActionListener = new CalculatorActionListener(resultTextView);

        Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(calculatorActionListener);
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(calculatorActionListener);
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(calculatorActionListener);
        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(calculatorActionListener);
        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(calculatorActionListener);
        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(calculatorActionListener);
        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(calculatorActionListener);
        Button btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(calculatorActionListener);
        Button btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(calculatorActionListener);
        Button btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(calculatorActionListener);

        Button cancelBtn = findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationActionType = null;
                currentValue = 0;
                resultTextView.setText("");
            }
        });

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(arithmeticButtonsListener);

        Button subtrackBtn = findViewById(R.id.subtrackBtn);
        subtrackBtn.setOnClickListener(arithmeticButtonsListener);

        Button multiplyBtn = findViewById(R.id.multiplyBtn);
        multiplyBtn.setOnClickListener(arithmeticButtonsListener);

        Button devideBtn = findViewById(R.id.devideBtn);
        devideBtn.setOnClickListener(arithmeticButtonsListener);

        Button resBtn = findViewById(R.id.resBtn);
        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textValue = String.valueOf(resultTextView.getText());
                int index = textValue.indexOf(calculationActionType);
                String tmpValue = textValue.substring(index + 1);
                float val = Float.parseFloat(tmpValue);
                float tmpRes = 0;
                if ("+".equals(calculationActionType)) {
                    tmpRes = currentValue + val;
                } else if ("-".equals(calculationActionType)) {
                    tmpRes = currentValue - val;
                } else if ("*".equals(calculationActionType)) {
                    tmpRes = currentValue * val;
                } else if ("/".equals(calculationActionType)) {
                    tmpRes = currentValue / val;
                }
                currentValue = tmpRes;
                resultTextView.setText(tmpRes + "");
                calculationActionType = null;
            }
        });

    }
}
