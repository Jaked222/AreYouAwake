package com.example.jakeduncan.luciddream;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    private static int interval = 60;
    private static EditText intervalEditText;
    private static Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        intervalEditText = (EditText) findViewById(R.id.intervalEditText);
        intervalEditText.setText(String.valueOf(interval));

        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(intervalEditText.getText().toString()) < 1) {
                    intervalEditText.setText("1");
                }
                else {
                    interval = Integer.parseInt(intervalEditText.getText().toString());
                    Intent main = new Intent(v.getContext(), MainActivity.class);
                    startActivity(main);
                }
            }
        });
    }

    public static int getInterval() {
        return interval;
    }

}
