package com.example.mylistapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] prices;
    String[] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = findViewById(R.id.myListView);
        items = res.getStringArray(R.array.items);
        description = res.getStringArray(R.array.descriptions);
        prices = res.getStringArray(R.array.prices);
        myListView.setAdapter(new ItemAdapter(this,items, description, prices));
        //myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, items));
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent descriptionIntent = new Intent(getApplicationContext(), DetailActivity.class);
                descriptionIntent.putExtra("com.example.mylistapp.ITEM_INDEX", position);
                startActivity(descriptionIntent);
            }
        });

    }
}
