package org.education.twoactivitieswithresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRed;
    private Button btnGreen;
    private Button btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        btnGreen = findViewById(R.id.btnGreen);

        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnRed:
                intent.putExtra("color", Color.RED+"");
                break;
            case R.id.btnGreen:
                intent.putExtra("color", Color.GREEN+"");
                break;
            case R.id.btnBlue:
                intent.putExtra("color", Color.BLUE+"");
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
