package com.example.mylistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    String[] items;
    String[] prices;
    String[] descriptions;
    LayoutInflater mInflater;

    public ItemAdapter(Context c, String[] items,  String[] descriptions, String[] prices) {
        this.items = items;
        this.prices = prices;
        this.descriptions = descriptions;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = items[position];
        String description = descriptions[position];
        String price = prices[position];

        View v = mInflater.inflate(R.layout.my_listview_details2, null);
        TextView nameTextView = v.findViewById(R.id.nameTextView2);
        TextView descriptionTextView = v.findViewById(R.id.descriptionTextView2);
        TextView priceTextView = v.findViewById(R.id.priceTextView2);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        priceTextView.setText(price);
        return v;
    }
}
