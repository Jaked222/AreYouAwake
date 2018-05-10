package com.example.jakeduncan.luciddream;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    public static String NOTIFICATIONS_ON = "notificationsOn";

    private static Button instructionsButton;
    private static ToggleButton toggleNotificationsButton;
    private static boolean notificationsOn = true;

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

        toggleNotificationsButton = (ToggleButton) findViewById(R.id.toggleNotifications);
        toggleNotificationsButton.setChecked(notificationsOn);
        toggleNotificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationsOn = !notificationsOn;
                toggleNotificationsButton.setChecked(notificationsOn);
                toggleNotifications(notificationsOn);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void switchToInstructions(){
        Intent instructionsIntent = new Intent(this, InstructionsActivity.class);
        startActivity(instructionsIntent);
    }

    public void toggleNotifications(boolean notificationsOn){
        Intent notificationIntent = new Intent(this, NotificationService.class).putExtra(NOTIFICATIONS_ON, notificationsOn);
        startService(notificationIntent);
    }
}
