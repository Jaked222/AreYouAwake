package com.example.jakeduncan.luciddream;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button instructionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent notificationIntent = new Intent(this, NotificationService.class);
        startService(notificationIntent);


        instructionsButton = (Button) findViewById(R.id.instructions);
        instructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToInstructions();
            }
        });
    }
    public void switchToInstructions(){
        Intent instructionsIntent = new Intent(this, InstructionsActivity.class);
        startActivity(instructionsIntent);
    }
}
