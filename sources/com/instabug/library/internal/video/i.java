package com.instabug.library.internal.video;

import android.app.ActivityManager;
import android.content.Context;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class i {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final i f51236a = new i();

    private i() {
    }

    @JvmStatic
    public static final boolean a(@NotNull Context context, @NotNull Class cls) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cls, "serviceClass");
        List<ActivityManager.RunningServiceInfo> b11 = b(context);
        if (b11 == null || b11.isEmpty()) {
            return false;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : b11) {
            if (!Intrinsics.areEqual((Object) runningServiceInfo.service.getClassName(), (Object) cls.getName()) || !runningServiceInfo.foreground) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    private static final List b(Context context) {
        ActivityManager activityManager;
        Object systemService = context.getSystemService("activity");
        if (systemService instanceof ActivityManager) {
            activityManager = (ActivityManager) systemService;
        } else {
            activityManager = null;
        }
        if (activityManager == null) {
            return null;
        }
        return activityManager.getRunningServices(Integer.MAX_VALUE);
    }

    @JvmStatic
    public static final boolean a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<ActivityManager.RunningServiceInfo> b11 = b(context);
        if (b11 != null && !b11.isEmpty()) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : b11) {
                if (runningServiceInfo.foreground) {
                    return true;
                }
            }
        }
        return false;
    }
}
