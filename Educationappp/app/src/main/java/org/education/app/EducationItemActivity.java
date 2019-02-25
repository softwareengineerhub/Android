package org.education.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.education.app.config.ApplicationConfig;
import org.education.app.model.EducationItem;
import org.education.app.service.EducationService;
import org.education.app.task.EducationItemControllerTask;

import java.util.ArrayList;
import java.util.List;

public class EducationItemActivity extends AppCompatActivity {
    //private List<EducationItem> items = new ArrayList();
    private EducationItemControllerTask educationItemControllerTask;
    private int position;
    private EducationService educationService;
    private String categoryTitle;
    private ImageView educationItemImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_item);

        categoryTitle = getIntent().getStringExtra("org.education.app.ITEM_TITLE");

        educationService = ApplicationConfig.getInstance().getEducationService();
        educationItemImageView = findViewById(R.id.educationItemImageView);
        educationItemControllerTask = new EducationItemControllerTask(categoryTitle, position, educationItemImageView, educationService);
        educationItemControllerTask.execute("");


        Button englishButton = findViewById(R.id.englishButton);
        Button chineseButton = findViewById(R.id.chinesButton);
        Button rusButton = findViewById(R.id.rusButton);
        Button prevButton = findViewById(R.id.prevButton);
        Button nextButton = findViewById(R.id.nextButton);


        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String urlStr = educationService.getEducationItemUrlSoundB(categoryTitle, position);
                    System.out.println(urlStr);
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(urlStr);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    //mediaPlayer.stop();
                }catch(Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });


        chineseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String urlStr = educationService.getEducationItemUrlSoundB(categoryTitle,position);
                    System.out.println(urlStr);
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(urlStr);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
  //                  mediaPlayer.stop();
                }catch(Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        rusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String urlStr = educationService.getEducationItemUrlSoundC(categoryTitle,position);
                    System.out.println(urlStr);
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(urlStr);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
//                    mediaPlayer.stop();
                }catch(Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    educationItemControllerTask = new EducationItemControllerTask(categoryTitle, position-1, educationItemImageView, educationService);
                    AsyncTask res=educationItemControllerTask.execute("");
                    byte[] result = (byte[]) res.get();
                    if(result.length>0){
                        position--;
                    }
                }catch(Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    educationItemControllerTask = new EducationItemControllerTask(categoryTitle, position+1, educationItemImageView, educationService);
                    AsyncTask res=educationItemControllerTask.execute("");
                    byte[] result = (byte[]) res.get();
                    if(result.length>0){
                        position++;
                    }
                }catch(Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
