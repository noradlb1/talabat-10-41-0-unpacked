package com.instabug.commons.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class b {
    @NotNull
    public static final ActivityManager a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            return (ActivityManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @Nullable
    public static final ActivityManager.RunningAppProcessInfo b(@NotNull Context context) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "<this>");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = a(context).getRunningAppProcesses();
        T t11 = null;
        if (runningAppProcesses == null) {
            return null;
        }
        Iterator<T> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (((ActivityManager.RunningAppProcessInfo) next).pid == Process.myPid()) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                t11 = next;
                break;
            }
        }
        return (ActivityManager.RunningAppProcessInfo) t11;
    }

    @RequiresApi(30)
    @NotNull
    public static final List c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        List a11 = a(context).getHistoricalProcessExitReasons((String) null, 0, 0);
        Intrinsics.checkNotNullExpressionValue(a11, "activityManager.getHisto…ssExitReasons(null, 0, 0)");
        return a11;
    }

    public static final boolean d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        ActivityManager.RunningAppProcessInfo b11 = b(context);
        if (b11 != null && b11.importance == 100) {
            return true;
        }
        return false;
    }
}
