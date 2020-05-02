package com.example.category;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.backend.api.repository.LocalRepository;
import com.backend.api.server.DetailsDao;
import com.example.educationapplication.CategoryActivity;
import com.example.educationapplication.DetailsActivity;
import com.example.educationapplication.R;
import com.example.utils.CategoriesModel;
import com.example.utils.CategoriesReader;

import java.util.concurrent.CountDownLatch;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public int[] slide_images;

    public String[] slideChinese;
    public String[] slideChineseMeta;
    public String[] slideEng;
    public String[] slideRu;
    private int btnNumber;
    private Activity activityParent;

    public SliderAdapter(Context context, int btnNumber, Activity activityParent) {
        this.context = context;
        this.btnNumber=btnNumber;
        this.activityParent = activityParent;

        int[] tmpPictures = new int[83];
        int j=0;
        tmpPictures[j++] = R.drawable.c0;
        tmpPictures[j++] = R.drawable.c1;
        tmpPictures[j++] = R.drawable.c2;
        tmpPictures[j++] = R.drawable.c3;
        tmpPictures[j++] = R.drawable.c4;
        tmpPictures[j++] = R.drawable.c5;
        tmpPictures[j++] = R.drawable.c6;
        tmpPictures[j++] = R.drawable.c7;
        tmpPictures[j++] = R.drawable.c8;
        tmpPictures[j++] = R.drawable.c9;
        tmpPictures[j++] = R.drawable.c10;
        tmpPictures[j++] = R.drawable.c11;
        tmpPictures[j++] = R.drawable.c12;
        tmpPictures[j++] = R.drawable.c13;
        tmpPictures[j++] = R.drawable.c14;
        tmpPictures[j++] = R.drawable.c15;
        tmpPictures[j++] = R.drawable.c16;
        tmpPictures[j++] = R.drawable.c17;
        tmpPictures[j++] = R.drawable.c18;
        tmpPictures[j++] = R.drawable.c19;
        tmpPictures[j++] = R.drawable.c20;
        tmpPictures[j++] = R.drawable.c21;
        tmpPictures[j++] = R.drawable.c22;
        tmpPictures[j++] = R.drawable.c23;
        tmpPictures[j++] = R.drawable.c24;
        tmpPictures[j++] = R.drawable.c25;
        tmpPictures[j++] = R.drawable.c26;
        tmpPictures[j++] = R.drawable.c27;
        tmpPictures[j++] = R.drawable.c28;
        tmpPictures[j++] = R.drawable.c29;
        tmpPictures[j++] = R.drawable.c30;
        tmpPictures[j++] = R.drawable.c31;
        tmpPictures[j++] = R.drawable.c32;
        tmpPictures[j++] = R.drawable.c33;
        tmpPictures[j++] = R.drawable.c34;
        tmpPictures[j++] = R.drawable.c35;
        tmpPictures[j++] = R.drawable.c36;
        tmpPictures[j++] = R.drawable.c37;
        tmpPictures[j++] = R.drawable.c38;
        tmpPictures[j++] = R.drawable.c39;
        tmpPictures[j++] = R.drawable.c40;
        tmpPictures[j++] = R.drawable.c41;
        tmpPictures[j++] = R.drawable.c42;
        tmpPictures[j++] = R.drawable.c43;
        tmpPictures[j++] = R.drawable.c44;
        tmpPictures[j++] = R.drawable.c45;
        tmpPictures[j++] = R.drawable.c46;
        tmpPictures[j++] = R.drawable.c47;
        tmpPictures[j++] = R.drawable.c48;
        tmpPictures[j++] = R.drawable.c49;
        tmpPictures[j++] = R.drawable.c50;
        tmpPictures[j++] = R.drawable.c51;
        tmpPictures[j++] = R.drawable.c52;
        tmpPictures[j++] = R.drawable.c53;
        tmpPictures[j++] = R.drawable.c54;
        tmpPictures[j++] = R.drawable.c55;
        tmpPictures[j++] = R.drawable.c56;
        tmpPictures[j++] = R.drawable.c57;
        tmpPictures[j++] = R.drawable.c58;
        tmpPictures[j++] = R.drawable.c59;
        tmpPictures[j++] = R.drawable.c60;
        tmpPictures[j++] = R.drawable.c61;
        tmpPictures[j++] = R.drawable.c62;
        tmpPictures[j++] = R.drawable.c63;
        tmpPictures[j++] = R.drawable.c64;
        tmpPictures[j++] = R.drawable.c65;
        tmpPictures[j++] = R.drawable.c66;
        tmpPictures[j++] = R.drawable.c67;
        tmpPictures[j++] = R.drawable.c68;
        tmpPictures[j++] = R.drawable.c69;
        tmpPictures[j++] = R.drawable.c70;
        tmpPictures[j++] = R.drawable.c71;
        tmpPictures[j++] = R.drawable.c72;
        tmpPictures[j++] = R.drawable.c73;
        tmpPictures[j++] = R.drawable.c74;
        tmpPictures[j++] = R.drawable.c75;
        tmpPictures[j++] = R.drawable.c76;
        tmpPictures[j++] = R.drawable.c77;
        tmpPictures[j++] = R.drawable.c78;
        tmpPictures[j++] = R.drawable.c79;
        tmpPictures[j++] = R.drawable.c80;
        tmpPictures[j++] = R.drawable.c81;
        tmpPictures[j++] = R.drawable.c82;

        CategoriesModel[] array= CategoriesReader.readAllCategories();

        int k = (btnNumber - 1)*10;
        int n = btnNumber==9 ? array.length-k : 10;
        /*System.out.println("-------------------------------------");
        System.out.println("btnNumber="+btnNumber);
        System.out.println("array.length="+array.length);
        System.out.println("k="+k);
        System.out.println("n="+n);
        System.out.println("-------------------------------------");
*/

        slide_images = new int[n];
        slideChinese = new String[n];
        slideChineseMeta = new String[n];
        slideEng = new String[n];
        slideRu = new String[n];

        if(btnNumber==9){
            for(int i=0; k<array.length; k++){
                slide_images[i] = tmpPictures[k];
                CategoriesModel cm = array[k];
                slideChinese[i] = cm.getCh();
                slideChineseMeta[i] = cm.getChMeta();
                slideEng[i] = cm.getEng();
                slideRu[i] = cm.getRu();
                i++;
            }
        } else {
            for(int i=0; i<10; i++){
                //System.out.println("start ################"+i+"####################");
                slide_images[i] = tmpPictures[k];
                CategoriesModel cm = array[k];
                slideChinese[i] = cm.getCh();
                slideChineseMeta[i] = cm.getChMeta();
                slideEng[i] = cm.getEng();
                slideRu[i] = cm.getRu();
                //System.out.println("slide_images[i]="+slide_images[i]);
                //System.out.println("slideChinese[i]="+slideChinese[i]);
                //System.out.println("slideChineseMeta[i]="+slideChineseMeta[i]);
                //System.out.println("slideEng[i]="+slideEng[i]);
                //System.out.println("slideRu[i]="+slideRu[i]);
                //System.out.println("end ################"+i+"####################");
                k++;
            }
        }

        /*for(int i=0;i<array.length;i++){
            CategoriesModel cm = array[i];
            slideChinese[i] = cm.getCh();
            slideChineseMeta[i] = cm.getChMeta();
            slideEng[i] = cm.getEng();
            slideRu[i] = cm.getRu();
        }*/
    }

    @Override
    public int getCount() {
        return slideChinese.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== (LinearLayout) object;
    }

    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout2, container, false);

        final ImageView slideImageView = view.findViewById(R.id.slide_image2);


        //Animation animation = new ScaleAnimation();
        //slideImageView.startAnimation(animation);

        slideImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PressStatus.isPressed()){
                    return;
                }
                PressStatus.setPressed(true);

                final String categoryName = "c"+((btnNumber-1)*10+position);
                LocalRepository.setCategoryName(categoryName);

               // final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Thread(){

                    public void run(){
                        LocalRepository.getCurrentDetails().clear();
                        DetailsDao detailsDao = new DetailsDao();
                        //Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show();
                        LocalRepository.getCurrentDetails().addAll(detailsDao.findAllDetails(categoryName));
                        //dialog.startLoadingDialog();
                        //countDownLatch.countDown();
                        PressStatus.setPressed(false);
                        Intent intent = new Intent(context, DetailsActivity.class);
                        context.startActivity(intent);
                    }

                }.start();
                Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show();
                initSelectAnimation(slideImageView);
            }
        });


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


    private void initSelectAnimation(final View imageView){
        final Animation selectAnimation = AnimationUtils.loadAnimation(context, R.anim.select_details_panel);
        final Animation shrinkAnimation = AnimationUtils.loadAnimation(context, R.anim.shrink_details_panel);

        selectAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(shrinkAnimation);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        shrinkAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(selectAnimation);
    }

}
