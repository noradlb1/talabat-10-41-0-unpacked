package com.huawei.secure.android.common.intent;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.secure.android.common.activity.a;

public final class SafePendingIntent {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33829a = "SafePendingIntent";

    public static PendingIntent getSafeActivities(Context context, int i11, Intent[] intentArr, int i12) {
        try {
            return PendingIntent.getActivities(context, i11, intentArr, i12 | 67108864);
        } catch (Throwable th2) {
            String str = f33829a;
            a.a(str, "PendingIntent getSafeActivities: " + th2.getMessage(), true);
            return null;
        }
    }

    public static PendingIntent getSafeActivity(Context context, int i11, Intent intent, int i12) {
        try {
            return PendingIntent.getActivity(context, i11, intent, i12 | 67108864);
        } catch (Throwable th2) {
            String str = f33829a;
            a.a(str, "PendingIntent getSafeActivity: " + th2.getMessage(), true);
            return null;
        }
    }

    public static PendingIntent getSafeBroadcast(Context context, int i11, Intent intent, int i12) {
        try {
            return PendingIntent.getBroadcast(context, i11, intent, i12 | 67108864);
        } catch (Throwable th2) {
            String str = f33829a;
            a.a(str, "PendingIntent getSafeBroadcast: " + th2.getMessage(), true);
            return null;
        }
    }

    public static PendingIntent getSafeService(Context context, int i11, Intent intent, int i12) {
        try {
            return PendingIntent.getService(context, i11, intent, i12 | 67108864);
        } catch (Throwable th2) {
            String str = f33829a;
            a.a(str, "PendingIntent getSafeService: " + th2.getMessage(), true);
            return null;
        }
    }

    public static PendingIntent getSafeActivity(Context context, int i11, Intent intent, Bundle bundle, int i12) {
        try {
            return PendingIntent.getActivity(context, i11, intent, i12 | 67108864, bundle);
        } catch (Throwable th2) {
            String str = f33829a;
            a.a(str, "PendingIntent getSafeActivity: " + th2.getMessage(), true);
            return null;
        }
    }
}
