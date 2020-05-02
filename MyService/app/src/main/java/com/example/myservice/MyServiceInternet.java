package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.backend.api.model.details.Details;
import com.example.myservice.details.DetailsDao;
import com.example.myservice.details.ServerClient;
import com.example.myservice.details.ServerClientImpl;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyServiceInternet extends Service {

    final String LOG_TAG = "myLogs";

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand");
        someTask();
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "onBind");
        return null;
    }

    void someTask() {
        new Thread(new Runnable() {
            public void run() {
                DetailsDao detailsDao = new DetailsDao();
                List<Details> details =  detailsDao.findAllDetails("c0");
                System.out.println("-------------------------------------");
                System.out.println(details.size());
                System.out.println(details);
                System.out.println("-------------------------------------");
                stopSelf();
            }
        }).start();




    }
}
