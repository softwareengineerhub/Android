package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ItemAdapter itemAdapter;
    Context context;
    ListView listView;
    TextView progressTextView;
    Map<String, Double> fruitsMap = new LinkedHashMap();
    MyRepository myRepository = new MyRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        listView = findViewById(R.id.myListView);
        progressTextView = findViewById(R.id.progressTextView);
        progressTextView.setText("");



        Button btn = findViewById(R.id.getDatabutton);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData getData = new GetData(listView, myRepository, progressTextView, fruitsMap, itemAdapter, context);
                getData.execute("");

            }
        });

    }
}
