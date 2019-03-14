package org.education.activitylifecycle;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("\tActivity1.onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.getContext();
                Intent intent = new Intent(v.getContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        System.out.println("\tActivity1.onPostCreate()");
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        System.out.println("\tActivity1.onStart()");
        super.onStart();
    }

    @Override
    protected void onPause() {
        System.out.println("\tActivity1.onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("\tActivity1.onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("\tActivity1.onDestroy()");
        super.onDestroy();
    }
}
