package mo.atef.amit.amit_dayseven.views.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import mo.atef.amit.amit_dayseven.R;
import mo.atef.amit.amit_dayseven.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNLE_ID = "CHANNLE_ID";
    /*
        Notifications - FCM ( Firebase Messaging Service ) - Push Notification
         */
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnNotificationLauncher.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                showChatNotification();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showChatNotification() {
        Intent intent=new Intent(MainActivity.this, Notifications.class);

        NotificationChannel notificationChannel=new NotificationChannel(CHANNLE_ID,"name", NotificationManager.IMPORTANCE_DEFAULT);

        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),1,intent,0);
        Notification notification=new Notification.Builder(getApplicationContext(), CHANNLE_ID)
                .setContentTitle("AMIT")
                .setContentText("Android Course")
                .setContentIntent(pendingIntent)
                .addAction(android.R.drawable.sym_action_chat, "Chat", pendingIntent)
                .setChannelId(CHANNLE_ID)
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .build();
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(1,notification);
    }
}