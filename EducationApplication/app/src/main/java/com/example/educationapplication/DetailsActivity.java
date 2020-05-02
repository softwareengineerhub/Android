package com.example.educationapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.backend.api.model.details.Details;
import com.backend.api.repository.LocalRepository;
import com.backend.api.sound.SoundApi;
import com.example.details.DetailsSliderAdapter;
import com.example.details.SoundPressStatus;

import java.io.IOException;

public class DetailsActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private DetailsSliderAdapter sliderAdapter;
    private int detailsCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                String urlPath = SoundApi.getUrl(LocalRepository.getCategoryName(),"d"+detailsCurrentPage,"ch");
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(urlPath);
                    mediaPlayer.prepare(); //don't use prepareAsync for mp3 playback
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SoundPressStatus.setPressed(false);

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
                String urlPath = SoundApi.getUrl(LocalRepository.getCategoryName(),"d"+detailsCurrentPage,"en");
             //   System.out.println("urlPath="+urlPath);
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(urlPath);
                    mediaPlayer.prepare(); //don't use prepareAsync for mp3 playback
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SoundPressStatus.setPressed(false);

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
                String urlPath = SoundApi.getUrl(LocalRepository.getCategoryName(),"d"+detailsCurrentPage,"ru");
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(urlPath);
                    mediaPlayer.prepare(); //don't use prepareAsync for mp3 playback
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SoundPressStatus.setPressed(false);

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
}
