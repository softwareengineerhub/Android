package org.education.app.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class Utils {

    public static Bitmap convertToImage(byte[] img) {
        return BitmapFactory.decodeByteArray(img, 0, img.length);
    }

    /*public static void scaleImg(ImageView img, int pic, int screenWidth){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);
        int imgWidth = options.outWidth;
        if(imgWidth>screenWidth){
            int ration = Math.round((float)imgWidth/(float)screenWidth);
            options.inSampleSize = ration;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);

    }*/

}
