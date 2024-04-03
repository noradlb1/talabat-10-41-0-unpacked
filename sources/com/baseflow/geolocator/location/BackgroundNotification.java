package com.baseflow.geolocator.location;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.exoplayer2.C;

public class BackgroundNotification {
    @NonNull
    private NotificationCompat.Builder builder;
    @NonNull
    private final String channelId;
    @NonNull
    private final Context context;
    @NonNull
    private final Integer notificationId;

    public BackgroundNotification(Context context2, String str, Integer num, ForegroundNotificationOptions foregroundNotificationOptions) {
        this.context = context2;
        this.notificationId = num;
        this.channelId = str;
        this.builder = new NotificationCompat.Builder(context2, str).setPriority(1);
        updateNotification(foregroundNotificationOptions, false);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    private PendingIntent buildBringToFrontIntent() {
        int i11;
        Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(this.context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.setPackage((String) null);
        launchIntentForPackage.setFlags(270532608);
        if (Build.VERSION.SDK_INT > 23) {
            i11 = 201326592;
        } else {
            i11 = C.BUFFER_FLAG_FIRST_SAMPLE;
        }
        return PendingIntent.getActivity(this.context, 0, launchIntentForPackage, i11);
    }

    private int getDrawableId(String str, String str2) {
        return this.context.getResources().getIdentifier(str, str2, this.context.getPackageName());
    }

    private void updateNotification(ForegroundNotificationOptions foregroundNotificationOptions, boolean z11) {
        int drawableId = getDrawableId(foregroundNotificationOptions.getNotificationIcon().getName(), foregroundNotificationOptions.getNotificationIcon().getDefType());
        if (drawableId == 0) {
            getDrawableId("ic_launcher.png", "mipmap");
        }
        this.builder = this.builder.setContentTitle(foregroundNotificationOptions.getNotificationTitle()).setSmallIcon(drawableId).setContentText(foregroundNotificationOptions.getNotificationText()).setContentIntent(buildBringToFrontIntent()).setOngoing(foregroundNotificationOptions.isSetOngoing());
        if (z11) {
            NotificationManagerCompat.from(this.context).notify(this.notificationId.intValue(), this.builder.build());
        }
    }

    public Notification build() {
        return this.builder.build();
    }

    public void updateChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManagerCompat from = NotificationManagerCompat.from(this.context);
            NotificationChannel notificationChannel = new NotificationChannel(this.channelId, str, 0);
            notificationChannel.setLockscreenVisibility(0);
            from.createNotificationChannel(notificationChannel);
        }
    }

    public void updateOptions(ForegroundNotificationOptions foregroundNotificationOptions, boolean z11) {
        updateNotification(foregroundNotificationOptions, z11);
    }
}
