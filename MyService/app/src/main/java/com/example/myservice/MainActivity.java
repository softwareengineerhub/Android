package com.example.myservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.backend.api.model.details.Details;
import com.example.myservice.details.DetailsDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClickStart(View v) {
        startService(new Intent(this, MyServiceInternet.class));
    }

    // no service
    /*public void onClickStart(View v) {
        new Thread(new Runnable() {
            public void run() {
                DetailsDao detailsDao = new DetailsDao();
                List<Details> details =  detailsDao.findAllDetails("c0");
                System.out.println("-------------------------------------");
                System.out.println(details.size());
                System.out.println(details);
                System.out.println("-------------------------------------");
                //stopSelf();
            }
        }).start();
    }*/

    public void onClickStop(View v) {
        stopService(new Intent(this, MyServiceInternet.class));
    }
}
