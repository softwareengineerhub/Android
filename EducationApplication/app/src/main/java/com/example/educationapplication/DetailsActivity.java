package com.example.educationapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.backend.api.repository.LocalRepository;
import com.backend.api.sound.SmartSoundApi;
import com.backend.api.sound.SoundApi;
import com.backend.api.sound.SoundDao;
import com.backend.api.sound.SoundPlayer;
import com.example.details.DetailsSliderAdapter;
import com.example.details.SoundPressStatus;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DetailsActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private DetailsSliderAdapter sliderAdapter;
    private int detailsCurrentPage;
    private ExecutorService executorService;
    SoundDao soundDao = new SoundDao();
    MediaPlayer mediaPlayer = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        executorService = Executors.newSingleThreadExecutor();
        setContentView(R.layout.activity_details);
        mSlideViewPager = findViewById(R.id.details_slideViewPager);
        sliderAdapter = new DetailsSliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        mSlideViewPager.setCurrentItem(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
        getSupportActionBar().hide();


        findViewById(R.id.details_imageView1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(SoundPressStatus.isPressed()){
                    return;
                }
                SoundPressStatus.setPressed(true);
                initSelectAnimation(findViewById(R.id.details_imageView1));

                executorService.submit(new Callable<String>() {


                    @Override
                    public String call() throws Exception {
                     byte[] data = soundDao.getSoundData(LocalRepository.getCategoryName(),"d"+detailsCurrentPage,"ch");
                        SoundPlayer.playMp3(data, new MediaPlayer());
                        SoundPressStatus.setPressed(false);
                        return "";
                    }
                });

            }
        });

        findViewById(R.id.details_imageView2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(SoundPressStatus.isPressed()){
                    return;
                }
                SoundPressStatus.setPressed(true);
                initSelectAnimation(findViewById(R.id.details_imageView2));

                executorService.submit(new Callable<String>() {


                    @Override
                    public String call() throws Exception {
                        byte[] data = soundDao.getSoundData(LocalRepository.getCategoryName(),"d"+detailsCurrentPage,"en");
                        SoundPlayer.playMp3(data, new MediaPlayer());
                        SoundPressStatus.setPressed(false);
                        return "";
                    }
                });

            }
        });

        findViewById(R.id.details_imageView3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(SoundPressStatus.isPressed()){
                    return;
                }
                SoundPressStatus.setPressed(true);
                initSelectAnimation(findViewById(R.id.details_imageView3));

                executorService.submit(new Callable<String>() {


                    @Override
                    public String call() throws Exception {
                        byte[] data = soundDao.getSoundData(LocalRepository.getCategoryName(),"d"+detailsCurrentPage,"ru");
                        SoundPlayer.playMp3(data, new MediaPlayer());
                        SoundPressStatus.setPressed(false);
                        return "";
                    }
                });

            }
        });
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            detailsCurrentPage = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    private void initSelectAnimation(final View imageView){
        final Animation selectAnimation = AnimationUtils.loadAnimation(DetailsActivity.this, R.anim.select_bottom_panel);
        final Animation shrinkAnimation = AnimationUtils.loadAnimation(DetailsActivity.this, R.anim.shrink_bottom_panel);

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

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(selectAnimation);
    }

    private void makeSoundAction(){
        if(SoundPressStatus.isPressed()){
            return;
        }
        SoundPressStatus.setPressed(true);
        initSelectAnimation(findViewById(R.id.details_imageView1));

        executorService.submit(new Callable<String>() {


            @Override
            public String call() throws Exception {
                byte[] data = soundDao.getSoundData(LocalRepository.getCategoryName(),"d"+detailsCurrentPage,"ch");
                SoundPlayer.playMp3(data, mediaPlayer);
                SoundPressStatus.setPressed(false);
                return "";
            }
        });
    }
}
