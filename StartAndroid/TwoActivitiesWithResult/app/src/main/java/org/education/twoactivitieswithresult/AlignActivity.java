package org.education.twoactivitieswithresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlignActivity extends AppCompatActivity implements View.OnClickListener {


    private Button leftBtn;
    private Button centerBtn;
    private Button rightBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);
        leftBtn = findViewById(R.id.leftBtn);
        centerBtn = findViewById(R.id.centerBtn);
        rightBtn = findViewById(R.id.rightBtn);

        leftBtn.setOnClickListener(this);
        centerBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.leftBtn:
                intent.putExtra("align", "left");
                break;
            case R.id.centerBtn:
                intent.putExtra("align", "center");
                break;
            case R.id.rightBtn:
                intent.putExtra("align", "right");
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
