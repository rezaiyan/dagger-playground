package ir.alirezaiyan.dagger.auth;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;

import javax.inject.Inject;

import androidx.core.app.NotificationCompat;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 7:11 PM.
 */
public class AuthenticationNotification {

    private static final String NOTIFICATION_ID = "9001";
    private static final int _ID = 9001;
    private static final String NOTIFICATION_NAME = "Authentication";
    private static final int LOGIN_REQUEST_ID = 9100;
    private final Context context;
    private final String title;
    private final String body;
    private final int icon;
    private final Intent intent;

    @Inject
    public AuthenticationNotification(Context context){
        this.context = context;

        title = "Please login to app";
        body = "";
        icon = R.mipmap.ic_launcher;
        intent = new Intent();
        intent.setData(Uri.parse("dagger://auth.alirezaiyan.ir"));
    }

    void show(){
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(NOTIFICATION_ID, NOTIFICATION_NAME, NotificationManager.IMPORTANCE_HIGH);

            channel.setDescription("Notification to login user");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.setVibrationPattern(new long[]{500, 1000, 500});
            channel.enableVibration(true);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NOTIFICATION_ID)
            .setDefaults(Notification.DEFAULT_ALL)
            .setSmallIcon(icon)
            .setContentTitle(title).setContentText(body)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setContentIntent(PendingIntent.getActivity(context, LOGIN_REQUEST_ID, intent, 0));

        if (manager != null) {
            manager.notify(_ID, builder.build());
        }
    }

}
