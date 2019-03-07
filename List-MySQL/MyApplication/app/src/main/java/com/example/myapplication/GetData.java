package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Map;

public class GetData extends AsyncTask {

    private ListView listView;
    private MyRepository myRepository;
    private TextView progressTextView;
    private Map<String, Double> fruitsMap;
    private ItemAdapter itemAdapter;
    private Context context;

    public GetData(ListView listView, MyRepository myRepository, TextView progressTextView, Map<String, Double> fruitsMap, ItemAdapter itemAdapter, Context context) {
        this.listView = listView;
        this.myRepository = myRepository;
        this.progressTextView = progressTextView;
        this.fruitsMap=fruitsMap;
        this.itemAdapter = itemAdapter;
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        progressTextView.setText("Connecting to database...");
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        fruitsMap.putAll(myRepository.getAll());
        //progressTextView.setText("Process complete.");
        return null;
    }


    @Override
    protected void onPostExecute(Object o) {
        progressTextView.setText(o+"");
        if(fruitsMap.size()>0){
            ItemAdapter itemAdapter = new ItemAdapter(context, fruitsMap);
            listView.setAdapter(itemAdapter);
            progressTextView.setText("");
        }else{
            progressTextView.setText("Process complete.");
        }
    }
}
