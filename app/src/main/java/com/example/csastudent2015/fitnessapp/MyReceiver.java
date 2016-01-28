package com.example.csastudent2015.fitnessapp;

/**
 * Created by csastudent2015 on 1/28/16.
 * Alarm Notification
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

 public class MyReceiver extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent)
        {
            Intent service1 = new Intent(context, MyAlarmService.class);
            context.startService(service1);

        }
    }

