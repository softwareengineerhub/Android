package com.example.soundapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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
}
