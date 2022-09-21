package mo.atef.amit.amit_dayseven.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mo.atef.amit.amit_dayseven.R;
import mo.atef.amit.amit_dayseven.databinding.ActivityBigNotificationBinding;
import mo.atef.amit.amit_dayseven.util.Util;

public class BigNotificationActivity extends AppCompatActivity {

    private static final String CHANNLE_ID = "CHANNLE_ID";
    ActivityBigNotificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_big_notification);
        binding.btnLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification();
            }
        });
    }

    private void showNotification() {
        Intent intent = new Intent(BigNotificationActivity.this, Notifications.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(BigNotificationActivity.this, CHANNLE_ID)
                .setContentTitle("AMIT")
                .setContentText("Hi, Our session has started!")
                .setSmallIcon(android.R.drawable.ic_dialog_email)
//                .setStyle(new NotificationCompat.BigTextStyle().bigText("Attendees: Mohamed Atef, Ahmed Samy, Mohamed Adel, Yara Sherif, Aya Eyad, Maha, Main, Mahmoud Abdelmaksoud, Mousheraa, Radwa, Adham"))
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(Util.convertToBitmap(getResources().getDrawable(R.drawable.mango)))
                        .bigLargeIcon(null))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        createNotificationChannel();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(BigNotificationActivity.this);
        notificationManagerCompat.notify(3, builder.build());
    }

    private void createNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            CharSequence name = "Custom Gmail";
            String description = "Important Email!";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNLE_ID, name, importance);

            notificationChannel.setDescription(description);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}