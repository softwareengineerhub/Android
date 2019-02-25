package org.education.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.education.app.adapter.CategoryAdapter;
import org.education.app.config.ApplicationConfig;
import org.education.app.model.Category;
import org.education.app.task.CategoryControllerTask;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private List<Category> categories = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ListView categoryListView = findViewById(R.id.categoryListView);
        CategoryControllerTask categoryControllerTask = new CategoryControllerTask(this, categoryListView, categories);
        categoryControllerTask.execute("");
        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent educationItemIntent = new Intent(getApplicationContext(), EducationItemActivity.class);
                //educationItemIntent.putExtra("org.education.app.ITEM_INDEX", position);
                educationItemIntent.putExtra("org.education.app.ITEM_TITLE", categories.get(position).getTitle());
                startActivity(educationItemIntent);
            }
        });

    }



}
