package com.example.mylistapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        if(getIntent().hasExtra("com.example.mylistapp.ITEM_INDEX")){
            //TextView textView = findViewById(R.id.secondTextView);
            int position = getIntent().getIntExtra("com.example.mylistapp.ITEM_INDEX", -1);
            if(position!=-1) {
                ImageView imageView = findViewById(R.id.imageView);
                int pic = getImage(position);
                scaleImg(imageView, pic);
            }
        }
    }

    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);
        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();
        if(imgWidth>screenWidth){
            int ration = Math.round((float)imgWidth/(float)screenWidth);
            options.inSampleSize = ration;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }

    private int getImage(int position) {
        switch (position) {
            case 0:
                return R.drawable.apple;
            case 1:
                return R.drawable.bulk;
            case 2:
                return R.drawable.kivi;
            default:
                return -1;
        }
    }
}
