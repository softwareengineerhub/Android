package com.example.details;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.backend.api.repository.LocalRepository;
import com.example.educationapplication.R;

public class DetailsSliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public DetailsSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return LocalRepository.getCurrentDetails().size();
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

        createImageFromBytes(slideImageView, LocalRepository.getCurrentDetails().get(position).getImageData());
        detailsChmetaTextView.setText(LocalRepository.getCurrentDetails().get(position).getDescriptionA());
        detailsChTextView.setText(LocalRepository.getCurrentDetails().get(position).getDescriptionB());
        detailsRuTextView.setText(LocalRepository.getCurrentDetails().get(position).getDescriptionC());
        detailsEnTextView.setText(LocalRepository.getCurrentDetails().get(position).getDescriptionD());

        container.addView(view);

        return view;
    }

    private void createImageFromBytes(ImageView imageViewer, byte[] data){
        Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length);
        //DisplayMetrics dm = new DisplayMetrics();
        //getWindowManager().getDefaultDisplay().getMetrics(dm);
        //imageViewer.setMinimumHeight(dm.heightPixels);
        //imageViewer.setMinimumWidth(dm.widthPixels);
        imageViewer.setImageBitmap(bm);
    }

    public void destroyItem(ViewGroup container, int position, Object object){
    }

}
