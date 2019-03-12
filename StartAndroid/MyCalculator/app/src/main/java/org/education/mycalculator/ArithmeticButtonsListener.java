package org.education.mycalculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ArithmeticButtonsListener implements View.OnClickListener {

    private TextView textView;
    private MainActivity mainActivity;

    public ArithmeticButtonsListener(TextView textView, MainActivity mainActivity) {
        this.textView = textView;
       this.mainActivity=mainActivity;
    }


    @Override
    public void onClick(View v) {
        mainActivity.currentValue = Float.parseFloat(String.valueOf(textView.getText()));
        Button btn = (Button) v;
        mainActivity.calculationActionType = String.valueOf(btn.getText());
        textView.setText(textView.getText() + mainActivity.calculationActionType);
    }
}
