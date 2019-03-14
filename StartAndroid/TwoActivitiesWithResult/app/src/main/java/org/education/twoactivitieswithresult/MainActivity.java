package org.education.twoactivitieswithresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_DEFAULT = 0;
    public static final int REQUEST_CODE_COLOR = 1;
    public static final int REQUEST_CODE_ALIGN = 2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = findViewById(R.id.textView);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE_DEFAULT);
            }
        });

        Button colorBtn = findViewById(R.id.colorBtn);
        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
            }
        });

        Button alignBtn = findViewById(R.id.alignBtn);
        alignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AlignActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGN);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView = findViewById(R.id.textView);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@onActivityResult()");
        System.out.println("requestCode="+requestCode);
        System.out.println("resultCode="+resultCode);
        if(data==null){
            return;
        }
        if(requestCode==REQUEST_CODE_DEFAULT) {
            String result = data.getStringExtra("org.education.twoactivitieswithresult.SecondActivity.result");
            System.out.println("result="+result);
            textView.setText(result);
        }
        if(requestCode==REQUEST_CODE_COLOR) {
            String result = data.getStringExtra("color");
            System.out.println("result="+result);
            textView.setText(result);
        }
        if(requestCode==REQUEST_CODE_ALIGN) {
            String result = data.getStringExtra("align");
            System.out.println("result="+result);
            textView.setText(result);
        }

    }
}
