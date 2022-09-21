package mo.atef.amit.amit_dayseven.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import mo.atef.amit.amit_dayseven.model.Message;
import android.view.View;

import mo.atef.amit.amit_dayseven.R;
import mo.atef.amit.amit_dayseven.databinding.ActivityEmailBinding;

public class EmailActivity extends AppCompatActivity {

    private static final String CHANNLE_ID = "CHANNLE_ID";
    ActivityEmailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_email);

        binding.btnLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification();
            }
        });
    }

    String email="Hi,\nWe are a Software Solution Company Located im Manchester, UK. We are offering you a Software Developer position with USD 5000 per month.";
    String shortLine="Hi, how are you ?";
    String shortLine2="I am fine, Thanks.";
    String shortLine3="What's about you ?";

    private void showNotification() {
        Message[] messages = new Message[3];

        messages[0] = new Message(shortLine, 12050305, "atef");
        messages[1] = new Message(shortLine2, 12846305, "Samy");
        messages[2] = new Message(shortLine3, 12860305, "Aya");

        NotificationCompat.MessagingStyle.Message message1 =
                new NotificationCompat.MessagingStyle.Message(messages[0].getSender(), messages[0].getTime(), messages[0].getText());

        NotificationCompat.MessagingStyle.Message message2 =
                new NotificationCompat.MessagingStyle.Message(messages[1].getSender(),
                        messages[1].getTime(),
                        messages[1].getText());

        NotificationCompat.MessagingStyle.Message message3 =
                new NotificationCompat.MessagingStyle.Message(messages[2].getSender(),
                        messages[2].getTime(),
                        messages[2].getText());

        Intent intent = new Intent(EmailActivity.this, Notifications.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(EmailActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(EmailActivity.this, CHANNLE_ID)
                .setContentTitle("TecTah")
                .setContentText("Atef")
                .setSmallIcon(R.drawable.mango)
                .setStyle(new NotificationCompat.MessagingStyle("atef")
                        .addMessage(message1)
                        .addMessage(message2)
                        .addMessage(message3))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        createNotificationChannel();

        NotificationManagerCompat compat = NotificationManagerCompat.from(this);
        compat.notify(6, builder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Custom Gmail";
            String description = "Important Email!";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNLE_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}