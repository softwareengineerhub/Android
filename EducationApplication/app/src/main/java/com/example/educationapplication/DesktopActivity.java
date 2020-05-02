package com.example.educationapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class DesktopActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();



        setContentView(R.layout.activity_main4);
        ConstraintLayout constraintLayout = findViewById(R.id.constraint_layout);
        int[] colors = {Color.parseColor("red"),Color.parseColor("aqua")};
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
        gd.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        //gd.setCornerRadius(0f);
        //gd.setAlpha(1);
        constraintLayout.setBackground(gd);


        initStartAnimation(findViewById(R.id.textViewHeader));
        initStartAnimation(findViewById(R.id.imageView1));
        initStartAnimation(findViewById(R.id.imageView2));
        initStartAnimation(findViewById(R.id.imageView3));
        initStartAnimation(findViewById(R.id.imageView4));
        initStartAnimation(findViewById(R.id.imageView5));
        initStartAnimation(findViewById(R.id.imageView6));
        initStartAnimation(findViewById(R.id.imageView7));
        initStartAnimation(findViewById(R.id.imageView8));
        initStartAnimation(findViewById(R.id.imageView9));



        initActionListener((ImageView)findViewById(R.id.imageView1), 1);
        initActionListener((ImageView)findViewById(R.id.imageView2), 2);
        initActionListener((ImageView)findViewById(R.id.imageView3), 3);
        initActionListener((ImageView)findViewById(R.id.imageView4), 4);
        initActionListener((ImageView)findViewById(R.id.imageView5), 5);
        initActionListener((ImageView)findViewById(R.id.imageView6), 6);
        initActionListener((ImageView)findViewById(R.id.imageView7), 7);
        initActionListener((ImageView)findViewById(R.id.imageView8), 8);
        initActionListener((ImageView)findViewById(R.id.imageView9), 9);


        /*imageView1.setOnClickListener(new View.OnClickListener() {
            ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
            @Override
            public void onClick(View v) {
                Toast.makeText(DesktopActivity.this, "You Selected Path1", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DesktopActivity.this, CategoryActivity.class);
                intent = intent.putExtra("btnNumber", 1);
                startActivity(intent);
            }
        });*/
    }

    private void initStartAnimation(final View imageView){
        imageView.setVisibility(View.INVISIBLE);
        Animation mEnlargeAnimation = AnimationUtils.loadAnimation(DesktopActivity.this, R.anim.enlarge);
        imageView.startAnimation(mEnlargeAnimation);
        mEnlargeAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    private void initUnSelectAnimation(final View imageView, int btnNumber){
        RotateAnimation animation = new RotateAnimation(-45, 45, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(4);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(300L);
        imageView.startAnimation(animation);

    }

    private void initSelectAnimation(final View imageView, final int btnNumber){
        final Animation selectAnimation = AnimationUtils.loadAnimation(DesktopActivity.this, R.anim.select);
        final Animation shrinkAnimation = AnimationUtils.loadAnimation(DesktopActivity.this, R.anim.shrink);

        selectAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(shrinkAnimation);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        shrinkAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(DesktopActivity.this, CategoryActivity.class);
                intent = intent.putExtra("btnNumber", btnNumber);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(selectAnimation);
    }

    private void initActionListener(final ImageView imageView, final int btnNumber){
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(DesktopActivity.this, "You have selected Path "+btnNumber, Toast.LENGTH_SHORT).show();
                if(btnNumber!=1){
                    initUnSelectAnimation(findViewById(R.id.imageView1), btnNumber);
                }
                if(btnNumber!=2){
                    initUnSelectAnimation(findViewById(R.id.imageView2), btnNumber);
                }
                if(btnNumber!=3){
                    initUnSelectAnimation(findViewById(R.id.imageView3), btnNumber);
                }
                if(btnNumber!=4){
                    initUnSelectAnimation(findViewById(R.id.imageView4), btnNumber);
                }
                if(btnNumber!=5){
                    initUnSelectAnimation(findViewById(R.id.imageView5), btnNumber);
                }
                if(btnNumber!=6){
                    initUnSelectAnimation(findViewById(R.id.imageView6), btnNumber);
                }
                if(btnNumber!=7){
                    initUnSelectAnimation(findViewById(R.id.imageView7), btnNumber);
                }
                if(btnNumber!=8){
                    initUnSelectAnimation(findViewById(R.id.imageView8), btnNumber);
                }
                if(btnNumber!=9){
                    initUnSelectAnimation(findViewById(R.id.imageView9), btnNumber);
                }


                initSelectAnimation(imageView, btnNumber);


               // Animation mEnlargeAnimation = AnimationUtils.loadAnimation(DesktopActivity.this, R.anim.enlarge);
               // imageView.startAnimation(mEnlargeAnimation);


            }
        });
    }
}
