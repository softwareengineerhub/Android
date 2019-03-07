package org.education.mycalculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActionListener implements View.OnClickListener {
    private TextView textView;
    private float currentValue;

    public CalculatorActionListener(TextView textView, float currentValue) {
        this.textView = textView;
        this.currentValue = currentValue;
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        int delta = Integer.parseInt(String.valueOf(btn.getText()));
        doAction(currentValue, delta);
    }


    private void doAction(float value, float delta) {
        addValue(value, delta);
        updateText(value);
    }

    private void updateText(float value) {
        this.textView.setText(String.valueOf(value));
    }


    private void addValue(float value, float delta) {
        value = value * 10 + delta;
    }


}
