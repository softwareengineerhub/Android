package com.example.educationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.category.SliderAdapter;
import com.example.educationapplication.R;

public class CategoryActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private int btnNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Click on picture");
        //getSupportActionBar().setWindowTitle("t2");
        //getSupportActionBar().hide();
        Intent intent = getIntent();
        btnNumber = intent.getIntExtra("btnNumber", 1);

        //System.out.println("btnNumber="+btnNumber);


        setContentView(R.layout.activity_category);
        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        addDotsIndicator(0, btnNumber);

        sliderAdapter = new SliderAdapter(this, btnNumber, this);
        mSlideViewPager.setAdapter(sliderAdapter);
        mSlideViewPager.addOnPageChangeListener(viewListener);
        mSlideViewPager.setCurrentItem(0);
    }

    public void addDotsIndicator(int position, int btnNumber){
        mDots = new TextView[btnNumber!=9 ? 10 : 3];
        mDotLayout.removeAllViews();
        for(int i=0;i<mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }
        if(mDots.length>2){
            mDots[position].setTextColor(getResources().getColor(R.color.black));
        }
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
           // mCurrentPage = position;
            addDotsIndicator(position, btnNumber);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
