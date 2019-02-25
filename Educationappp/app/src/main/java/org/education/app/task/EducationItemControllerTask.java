package org.education.app.task;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;

import org.education.app.config.ApplicationConfig;
import org.education.app.model.EducationItem;
import org.education.app.service.EducationService;
import org.education.app.utils.Utils;

import java.util.List;

public class EducationItemControllerTask extends AsyncTask {
    private ImageView educationItemImageView;
    private String categoryTitle;
    private int position;
    private byte[] img;
    private EducationService educationService;
    //private List<EducationItem> items;

    public EducationItemControllerTask(String categoryTitle, int position, ImageView educationItemImageView, EducationService educationService) {
        this.categoryTitle = categoryTitle;
        this.position = position;
        this.educationItemImageView = educationItemImageView;
        this.categoryTitle = categoryTitle;
        this.educationService = educationService;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        img = educationService.getEducationItemImg(categoryTitle, position);
        System.out.println("@@@img.length="+img.length);
        return img;
    }

    @Override
    protected void onPostExecute(Object o) {
        if (img != null && img.length != 0) {
            Bitmap bitmap = Utils.convertToImage(img);
            educationItemImageView.setImageBitmap(bitmap);
        }

    }

}
