package org.education.app.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.education.app.R;
import org.education.app.model.Category;
import org.education.app.utils.Utils;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private Context ctx;
    private List<Category> categories;
    private LayoutInflater mInflater;
    private Display screen;

    public CategoryAdapter(Context ctx, List<Category> categories) {
        this.ctx = ctx;
        this.categories = categories;
        mInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Category category = categories.get(position);
        View v = mInflater.inflate(R.layout.category_layout, null);
        TextView languageATextView = v.findViewById(R.id.languageATextView);
        TextView languageBTextView = v.findViewById(R.id.languageBTextView);
        TextView languageCTextView = v.findViewById(R.id.languageCTextView);
        ImageView categoryImageView = v.findViewById(R.id.categoryImageView);

       // v.findViewById(R.drawable.bulk);

        languageATextView.setText(category.getLanguageA());
        languageBTextView.setText(category.getLanguageB());
        languageCTextView.setText(category.getLanguageC());
        if (category.getImg() != null) {
            Bitmap imgContent = Utils.convertToImage(category.getImg());
            categoryImageView.setImageBitmap(imgContent);
        }

        return v;
    }


}
