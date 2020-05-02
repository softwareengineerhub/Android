package com.example.soundapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class DetailsSliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public DetailsSliderAdapter(Context context) {
        this.context = context;
    }

    public int[] details_slide_images = {
            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon,
    };

    public String[] details_chmeta = {
            "CH_META1",
            "CH_META2",
            "CH_META3"
    };

    public String[] details_ch = {
            "Ch1","Ch2","Ch3"
    };

    public String[] details_ru = {
            "Ru1","Ru2","Ru3"
    };

    public String[] details_eng = {
            "Eng1","Eng2","Eng3"
    };

    @Override
    public int getCount() {
        return details_ch.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== (LinearLayout) object;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.details_slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.details_slide_image);
        TextView detailsChmetaTextView = view.findViewById(R.id.details_chmetaTextView);
        TextView detailsChTextView = view.findViewById(R.id.details_chTextView);
        TextView detailsRuTextView = view.findViewById(R.id.details_ruTextView);
        TextView detailsEnTextView = view.findViewById(R.id.details_enTextView);

        slideImageView.setImageResource(details_slide_images[position]);
        detailsChmetaTextView.setText(details_chmeta[position]);
        detailsChTextView.setText(details_ch[position]);
        detailsRuTextView.setText(details_ru[position]);
        detailsEnTextView.setText(details_eng[position]);


        container.addView(view);

        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object){
    }

}
