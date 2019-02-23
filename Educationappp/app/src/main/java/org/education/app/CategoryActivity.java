package org.education.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.education.app.adapter.CategoryAdapter;
import org.education.app.config.ApplicationConfig;
import org.education.app.model.Category;
import org.education.app.task.CategoryControllerTask;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ListView categoryListView = findViewById(R.id.categoryListView);
        CategoryControllerTask categoryControllerTask = new CategoryControllerTask(this, categoryListView, categories);
        categoryControllerTask.execute("");
    }



}
