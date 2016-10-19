package com.example.jakeduncan.luciddream;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = (TextView) findViewById(R.id.textView4);
        TextView info = (TextView) findViewById(R.id.textView5);
        title.setText("How to use this app:");
        info.setText("This is a very simple app designed to help you lucid dream. All you need to do to use it is " +
                "start the app and then let it run in the background. You can continue to use your phone as " +
                "normal, or just keep it in your pocket. At random intervals, a reminder will pop up telling " +
                "you to follow on of the following instructions: \n\n\n \"Hop\" means to literally hop. Gravity in " +
                "dreams usually works differently. \n\n \"Check a clock\" When you see this, look at a clock." +
                " Look away, then look at it again. In a dream, clocks never stay at the same time. " +
                " \n\n \"Look at you hand\" Your mind can\'t properly create the back of your hand in a dream. " +
                "It will look very distorted if its a dream. You\'ll know. \n\n \"Flick a light switch\" Light " +
                "switches dont work in dreams. \n\n \n The purpose of doing these things is to set a habit of checking " +
                "whether or not you\'re sleeping. Eventually you\'ll do this in a dream, and it will spark you to " +
                "become concious. At this point, you\'re lucid.");

        Intent intent = new Intent(this, NotificationService.class);
        startService(intent);
    }
}
