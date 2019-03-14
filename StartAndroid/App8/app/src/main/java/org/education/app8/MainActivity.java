package org.education.app8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = findViewById(R.id.myText);
        myText.setText("Android it's easy");

        Button myBtn = findViewById(R.id.myBtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myBtn.setText("My first Button");
        myBtn.setEnabled(false);

        CheckBox myChb = findViewById(R.id.myChb);
        myChb.setChecked(true);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.LessonBtn:
                        myText.setText("Lesson text"+System.currentTimeMillis());
                        return;
                    default:
                        return;
                }
            }
        };
        Button lessonBtn = findViewById(R.id.LessonBtn);
        lessonBtn.setOnClickListener(onClickListener);

    }


    public void buttonOnClick(View view){
        myText.setText("Click: "+System.currentTimeMillis()%10);
    }
}
