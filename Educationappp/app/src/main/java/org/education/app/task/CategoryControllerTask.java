package org.education.app.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import org.education.app.adapter.CategoryAdapter;
import org.education.app.config.ApplicationConfig;
import org.education.app.model.Category;

import java.util.List;

public class CategoryControllerTask extends AsyncTask {
    private Context ctx;
    private ListView listView;
    private List<Category> categories;

    public CategoryControllerTask(Context ctx, ListView listView, List<Category> categories) {
        this.ctx = ctx;
        this.listView = listView;
        this.categories = categories;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        if (categories == null || categories.isEmpty()) {
            categories = ApplicationConfig.getInstance().getEducationService().findAllCategories();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        if (categories != null && !categories.isEmpty()) {
            CategoryAdapter categoryAdapter = new CategoryAdapter(ctx, categories);
            listView.setAdapter(categoryAdapter);
        }
    }

    /*
    progressTextView.setText(o + "");
        if (fruitsMap.size() > 0) {
            ItemAdapter itemAdapter = new ItemAdapter(context, fruitsMap);
            listView.setAdapter(itemAdapter);
            progressTextView.setText("");
        } else {
            progressTextView.setText("Process complete.");
        }
     */


}
