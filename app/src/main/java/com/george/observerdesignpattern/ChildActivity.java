package com.george.observerdesignpattern;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class ChildActivity extends AppCompatActivity {

    private Button triggerEventButton;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        messageEditText = (EditText)findViewById(R.id.editText);
        triggerEventButton = (Button)findViewById(R.id.button);

        triggerEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText = messageEditText.getText().toString();

                CustomMessageEvent event = new CustomMessageEvent();
                event.setCustomMessage(userText);
                EventBus.getDefault().post(event);

                finish();
            }
        });

    }

}