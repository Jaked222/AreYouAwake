package com.example.jakeduncan.luciddream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    private static int interval = 60;
    private static EditText intervalEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        intervalEditText = (EditText) findViewById(R.id.intervalEditText);
        intervalEditText.setText(String.valueOf(interval));

        intervalEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0)
                    intervalEditText.setText("0");

                interval = Integer.parseInt(intervalEditText.getText().toString());
            }
        });
    }

    public int getInterval() {
        return interval;
    }

}
