package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import java.util.Date;
import java.util.List;

public class d {
    public static String a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
            return null;
        }
    }

    public static Intent b(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception unused) {
            HMSLog.w("PushSelfShowLog", str + " not have launch activity");
            return null;
        }
    }

    private static boolean c() {
        return true;
    }

    public static boolean c(Context context, String str) {
        if (!(context == null || str == null || "".equals(str))) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                    return false;
                }
                HMSLog.d("PushSelfShowLog", str + " is installed");
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean d() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean f() {
        return true;
    }

    public static int b() {
        if (c()) {
            return 67108864;
        }
        return C.BUFFER_FLAG_FIRST_SAMPLE;
    }

    public static Boolean a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (queryIntentActivities.get(i11).activityInfo != null && str.equals(queryIntentActivities.get(i11).activityInfo.applicationInfo.packageName)) {
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", e11.toString(), (Throwable) e11);
        }
        return Boolean.FALSE;
    }

    public static long a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            Date date = new Date();
            int hours = (date.getHours() * 2) + (date.getMinutes() / 30);
            String concat = str.concat(str);
            HMSLog.i("PushSelfShowLog", "startIndex is " + hours + ",ap is:" + concat + ",length is:" + concat.length());
            int length = concat.length();
            for (int i11 = hours; i11 < length; i11++) {
                if (concat.charAt(i11) != '0') {
                    long minutes = ((long) (((i11 - hours) * 30) - (date.getMinutes() % 30))) * 60000;
                    HMSLog.d("PushSelfShowLog", "startIndex is:" + hours + " i is:" + i11 + " delay:" + minutes);
                    if (minutes >= 0) {
                        return minutes;
                    }
                    return 0;
                }
            }
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", "error ", (Throwable) e11);
        }
        return 0;
    }

    public static void a(Context context, Intent intent, long j11) {
        try {
            HMSLog.d("PushSelfShowLog", "enter setAPDelayAlarm(interval:" + j11 + "ms.");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j11, PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() / 1000), intent, b()));
            }
        } catch (Exception e11) {
            HMSLog.w("PushSelfShowLog", "set DelayAlarm error" + e11.toString());
        }
    }

    public static boolean a(Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }

    public static void a(Context context, int i11) {
        if (context == null) {
            HMSLog.e("PushSelfShowLog", "context is null");
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.cancel(i11);
            }
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", "removeNotifiCationById err:" + e11.toString());
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra("selfshow_auto_clear_id", 0);
            HMSLog.d("PushSelfShowLog", "setDelayAlarm(cancel) alarmNotityId " + intExtra);
            if (intExtra != 0) {
                Intent intent2 = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
                intent2.setPackage(context.getPackageName()).setFlags(32);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                PendingIntent broadcast = PendingIntent.getBroadcast(context, intExtra, intent2, a());
                if (broadcast == null || alarmManager == null) {
                    HMSLog.d("PushSelfShowLog", "alarm not exist");
                    return;
                }
                HMSLog.d("PushSelfShowLog", "alarm cancel");
                alarmManager.cancel(broadcast);
            }
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", "cancelAlarm err:" + e11.toString());
        }
    }

    private static int a() {
        return d() ? 603979776 : 536870912;
    }
}
