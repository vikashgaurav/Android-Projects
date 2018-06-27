package com.grv.vikash.smartrip.Activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.grv.vikash.smartrip.R;

public class AlarmActi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);


        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent i = new Intent();
        i.setAction("asd");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+10000, pendingIntent);
    }
}
