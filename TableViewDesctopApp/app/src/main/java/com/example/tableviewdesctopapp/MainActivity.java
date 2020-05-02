package com.example.tableviewdesctopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ConstraintLayout constraintLayout = findViewById(R.id.constraint_layout);
        int[] colors = {Color.parseColor("red"),Color.parseColor("aqua")};
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
        gd.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        //gd.setCornerRadius(0f);
        //gd.setAlpha(1);
        constraintLayout.setBackground(gd);

        ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "You clicked on ImageView1", Toast.LENGTH_LONG).show();

            }
        });

    }

    private void initBackgroundColor(){

    }
}
