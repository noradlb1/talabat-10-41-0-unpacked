package com.instabug.library.util;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;

public abstract class n {
    @RequiresApi(29)
    public static void a(Service service2, @StringRes int i11, int i12) {
        NotificationCompat.Builder a11 = a((Context) service2, "ibg-screen-recording", 2);
        a11.setOngoing(false).setAutoCancel(true).setSmallIcon(R.drawable.ibg_core_ic_instabug_logo).setContentText(LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(service2.getApplicationContext()), i11, service2.getApplicationContext()));
        service2.startForeground(i12, a11.build());
    }

    @TargetApi(26)
    private static void b(Context context, String str, int i11) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null && notificationManager.getNotificationChannel(str) == null) {
            notificationManager.createNotificationChannel(new NotificationChannel(str, "Screen Recording Service", i11));
        }
    }

    public static NotificationCompat.Builder a(Context context, String str, int i11) {
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(context);
        }
        b(context, str, i11);
        return new NotificationCompat.Builder(context, str);
    }

    public static void a(Context context, int i11) {
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.cancel(i11);
        }
    }
}
