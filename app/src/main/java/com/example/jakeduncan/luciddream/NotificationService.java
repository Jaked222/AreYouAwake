package com.example.jakeduncan.luciddream;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

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
        Calendar cal = Calendar.getInstance();

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

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(300);

            AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            PendingIntent pintent = PendingIntent.getService(getApplicationContext(), 0, intent, 0);
            alarm.cancel(pintent);
            alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES, pintent);
            //AlarmManager.INTERVAL_HOUR

        // try {
        //    sleep(5000);
         //   startService(intent);
     //   } catch (InterruptedException e) {
      //      e.printStackTrace();
      //  }
    }

}