package com.devfest14.semih.wearappdemoone;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();

        /** Send notification */
        sendNotification();
    }

    private void sendNotification()
    {
        int notificationId = 001;

        /** Send a hello-world notification */
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.generic_confirmation_00174)
                        .setContentTitle("Merhaba İstanbul!")
                        .setContentText("DevFest14 İstanbul'a Hoş geldiniz!");

        /** Get a notification manager instance and notify the wearable device*/
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
