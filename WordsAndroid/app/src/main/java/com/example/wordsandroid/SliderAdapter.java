package com.example.wordsandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.utils.CategoriesModel;
import com.example.utils.CategoriesReader;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public int[] slide_images;
    public String[] slideChinese;
    public String[] slideChineseMeta;
    public String[] slideEng;
    public String[] slideRu;

    public SliderAdapter(Context context) {
        this.context = context;
        slide_images = new int[83];
        int j=0;
        slide_images[j++] = R.drawable.c0;
        slide_images[j++] = R.drawable.c1;
        slide_images[j++] = R.drawable.c2;
        slide_images[j++] = R.drawable.c3;
        slide_images[j++] = R.drawable.c4;
        slide_images[j++] = R.drawable.c5;
        slide_images[j++] = R.drawable.c6;
        slide_images[j++] = R.drawable.c7;
        slide_images[j++] = R.drawable.c8;
        slide_images[j++] = R.drawable.c9;
        slide_images[j++] = R.drawable.c10;
        slide_images[j++] = R.drawable.c11;
        slide_images[j++] = R.drawable.c12;
        slide_images[j++] = R.drawable.c13;
        slide_images[j++] = R.drawable.c14;
        slide_images[j++] = R.drawable.c15;
        slide_images[j++] = R.drawable.c16;
        slide_images[j++] = R.drawable.c17;
        slide_images[j++] = R.drawable.c18;
        slide_images[j++] = R.drawable.c19;
        slide_images[j++] = R.drawable.c20;
        slide_images[j++] = R.drawable.c21;
        slide_images[j++] = R.drawable.c22;
        slide_images[j++] = R.drawable.c23;
        slide_images[j++] = R.drawable.c24;
        slide_images[j++] = R.drawable.c25;
        slide_images[j++] = R.drawable.c26;
        slide_images[j++] = R.drawable.c27;
        slide_images[j++] = R.drawable.c28;
        slide_images[j++] = R.drawable.c29;
        slide_images[j++] = R.drawable.c30;
        slide_images[j++] = R.drawable.c31;
        slide_images[j++] = R.drawable.c32;
        slide_images[j++] = R.drawable.c33;
        slide_images[j++] = R.drawable.c34;
        slide_images[j++] = R.drawable.c35;
        slide_images[j++] = R.drawable.c36;
        slide_images[j++] = R.drawable.c37;
        slide_images[j++] = R.drawable.c38;
        slide_images[j++] = R.drawable.c39;
        slide_images[j++] = R.drawable.c40;
        slide_images[j++] = R.drawable.c41;
        slide_images[j++] = R.drawable.c42;
        slide_images[j++] = R.drawable.c43;
        slide_images[j++] = R.drawable.c44;
        slide_images[j++] = R.drawable.c45;
        slide_images[j++] = R.drawable.c46;
        slide_images[j++] = R.drawable.c47;
        slide_images[j++] = R.drawable.c48;
        slide_images[j++] = R.drawable.c49;
        slide_images[j++] = R.drawable.c50;
        slide_images[j++] = R.drawable.c51;
        slide_images[j++] = R.drawable.c52;
        slide_images[j++] = R.drawable.c53;
        slide_images[j++] = R.drawable.c54;
        slide_images[j++] = R.drawable.c55;
        slide_images[j++] = R.drawable.c56;
        slide_images[j++] = R.drawable.c57;
        slide_images[j++] = R.drawable.c58;
        slide_images[j++] = R.drawable.c59;
        slide_images[j++] = R.drawable.c60;
        slide_images[j++] = R.drawable.c61;
        slide_images[j++] = R.drawable.c62;
        slide_images[j++] = R.drawable.c63;
        slide_images[j++] = R.drawable.c64;
        slide_images[j++] = R.drawable.c65;
        slide_images[j++] = R.drawable.c66;
        slide_images[j++] = R.drawable.c67;
        slide_images[j++] = R.drawable.c68;
        slide_images[j++] = R.drawable.c69;
        slide_images[j++] = R.drawable.c70;
        slide_images[j++] = R.drawable.c71;
        slide_images[j++] = R.drawable.c72;
        slide_images[j++] = R.drawable.c73;
        slide_images[j++] = R.drawable.c74;
        slide_images[j++] = R.drawable.c75;
        slide_images[j++] = R.drawable.c76;
        slide_images[j++] = R.drawable.c77;
        slide_images[j++] = R.drawable.c78;
        slide_images[j++] = R.drawable.c79;
        slide_images[j++] = R.drawable.c80;
        slide_images[j++] = R.drawable.c81;
        slide_images[j++] = R.drawable.c82;

        CategoriesModel[] array= CategoriesReader.readAllCategories();
        slideChinese = new String[array.length];
        slideChineseMeta = new String[array.length];
        slideEng = new String[array.length];
        slideRu = new String[array.length];

        for(int i=0;i<array.length;i++){
            CategoriesModel cm = array[i];
            slideChinese[i] = cm.getCh();
            slideChineseMeta[i] = cm.getChMeta();
            slideEng[i] = cm.getEng();
            slideRu[i] = cm.getRu();
        }
    }

    @Override
    public int getCount() {
        return slideChinese.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== (LinearLayout) object;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout2, container, false);

        ImageView slideImageView = view.findViewById(R.id.slide_image2);
        TextView slideChHeading = view.findViewById(R.id.chTextView);
        TextView slideChmetaHeading = view.findViewById(R.id.chmetaTextView);
        TextView slideEngHeading = view.findViewById(R.id.enTextView);
        TextView slideRuHeading = view.findViewById(R.id.ruTextView);

        slideImageView.setImageResource(slide_images[position]);
        slideChHeading.setText(slideChinese[position]);
        slideChmetaHeading.setText(slideChineseMeta[position]);
        slideEngHeading.setText(slideEng[position]);
        slideRuHeading.setText(slideRu[position]);
        container.addView(view);
        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object){

    }

}
