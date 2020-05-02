package com.example.educationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);




        videoView = findViewById(R.id.videoView);
        String s = "android.resource://"+getPackageName()+"/"+R.raw.myvideo;
        videoView.setVideoPath(s);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


        videoView.start();

        Button loginStartBtn = findViewById(R.id.loginStartBtn);
        loginStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DesktopActivity.class);
                startActivity(intent);
            }
        });

        Button loginShareBtn = findViewById(R.id.loginShareBtn);
        loginShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Application for learning";
                String shareSubject = "This is great application for learning";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });

        getSupportActionBar().hide();

        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayShowTitleEnabled(false);

    }





    public void onResume() {
        super.onResume();
        videoView.start();
    }
}
