package com.example.soundplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn= findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(MainActivity.this,R.raw.sound);
                mp.start();
            }
        });

        Button btn3= findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(MainActivity.this,R.raw.ch);
                mp.start();
            }
        });

        Button btn2= findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String urlPath="http://134.209.244.234:8080/sound-backend-api-application/sound?category=c0&details=d0&language=ch";
                String urlPath="http://www.hochmuth.com/mp3/Bloch_Prayer.mp3";
                Uri myUri = Uri.parse(urlPath);
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    //MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, myUri);
                    //mediaPlayer.setDataSource(MainActivity.this, myUri);
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource(urlPath);

                    mediaPlayer.prepare(); //don't use prepareAsync for mp3 playback
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
