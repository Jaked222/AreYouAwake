package com.example.jakeduncan.luciddream;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by jakeduncan on 10/18/16.
 */

public class NotificationService extends IntentService {

    private static String TAG = "Inchoo.net tutorial";

    private ArrayList<String> reminderList;

    public NotificationService() {
        super("Service");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: getting in");

        reminderList = new ArrayList();
        reminderList.add("Flick a Light Switch");
        reminderList.add("Hop");
        reminderList.add("Check a clock");
        reminderList.add("Look at the back of your hand");




        Random random = new Random();

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.thirdeye)
                        .setContentTitle("Am I Awake?")
                        .setContentText(reminderList.get(random.nextInt(3)));

        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        int mNotificationId = 001;
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

        Log.d(TAG, "onHandleIntent: getting out");
        try {
            sleep(5000);
            startService(intent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(Runnable(), NotificationService.class);
//                startService(intent);
//            }
//        }, 2000);
    }

}