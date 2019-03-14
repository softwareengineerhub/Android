package org.education.twoactivitieswithresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final EditText nameText = findViewById(R.id.nameText);
        Button backBtn  = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("org.education.twoactivitieswithresult.SecondActivity.result", nameText.getText()+"");
                setResult(RESULT_OK, intent);
                System.out.println("button is clicked");
                finish();
            }
        });

    }
}
