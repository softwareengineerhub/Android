package org.education.app10notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "Button clicked" , Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                Log.i(TAG, "button.click");
                toast.show();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "Button clicked" , Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout toastView = (LinearLayout) toast.getView();
               // view.findViewById();
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.ic_launcher_foreground);
                toastView.addView(imageView, 0);
                toast.show();
            }
        });

    }
}
