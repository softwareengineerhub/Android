package org.education.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.lang.annotation.Annotation;

public class MainActivity extends AppCompatActivity {
    private int step=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button animationBtn = findViewById(R.id.animationBtn);


        animationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Animation myalpha = null;
                switch(step){
                    case 0:
                        myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myalpha);
                    case 1:
                        myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myrotate);
                    case 2:
                        myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myscale);
                    case 3:
                        myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.mytranslate);
                    case 4:
                        myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.mycombo);
                }*/

                //Animation  myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myalpha);
                //Animation  myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.mytranslate);
                //Animation  myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myrotate);
                //Animation  myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myscale);
                Animation  myalpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.mycombo);
                v.startAnimation(myalpha);
            }
        });
    }
}
