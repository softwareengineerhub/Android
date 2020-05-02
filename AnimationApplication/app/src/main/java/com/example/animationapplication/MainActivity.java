package com.example.animationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Animation mEnlargeAnimation;
    private Animation mShrinkAnimation;
    private Animation rotateCenterAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);


        //ZOOM animation
        // подключаем файлы анимации
        //mEnlargeAnimation = AnimationUtils.loadAnimation(this, R.anim.enlarge);
        //mShrinkAnimation = AnimationUtils.loadAnimation(this, R.anim.shrink);
       // mEnlargeAnimation.setAnimationListener(animationEnlargeListener);
       // mShrinkAnimation.setAnimationListener(animationShrinkListener);
        // при запуске начинаем с эффекта увеличения
        //mImageView.startAnimation(mEnlargeAnimation);


        //Rotation animation
        //RotateAnimation animation = new RotateAnimation(-30, 60, 100, 180);
        //animation.setRepeatMode(Animation.REVERSE);
        //animation.setRepeatCount(Animation.INFINITE);
        //animation.setInterpolator(new LinearInterpolator());
        //animation.setDuration(1000L);
        //mImageView.startAnimation(animation);

        /*Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_center);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(1000L);
        mImageView.startAnimation(animation);*/


        //Rotation animation
        RotateAnimation animation = new RotateAnimation(-45, 45, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //rotate.setDuration(5000);
        //rotate.setInterpolator(new LinearInterpolator());
        //RotateAnimation animation = new RotateAnimation(-30, 60, 0, 0);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(300L);
        mImageView.startAnimation(animation);


       // rotateCenterAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_center);
       // rotateCenterAnimation.setRepeatMode(Animation.REVERSE);
       // rotateCenterAnimation.setRepeatCount(Animation.INFINITE);
       // mImageView.startAnimation(rotateCenterAnimation);


    }

    @Override
    protected void onPause() {
        super.onPause();
        mImageView.clearAnimation();
    }

    Animation.AnimationListener animationEnlargeListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationEnd(Animation animation) {
            // когда анимация увеличения заканчивается,
            // то запускаем анимацию уменьшения
            mImageView.startAnimation(mShrinkAnimation);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }
    };

    Animation.AnimationListener animationShrinkListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            // когда анимация уменьшения заканчивается,
            // то начинаем анимацию увеличения
         //   mImageView.startAnimation(mEnlargeAnimation);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }
    };
}
