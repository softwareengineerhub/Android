package org.education.mycalculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActionListener implements View.OnClickListener {
    private TextView textView;


    public CalculatorActionListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        textView.setText(textView.getText() + String.valueOf(btn.getText()));
    }


}
