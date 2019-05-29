package com.george.observerdesignpattern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

        private EditText resultsEditText;
        private Button launchButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

          //  EventBus.getDefault().register(this);

            resultsEditText = findViewById(R.id.resultsEditText);
            launchButton = findViewById(R.id.launchButton);

            launchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                    startActivity(intent);
                }
            });
    }
}
