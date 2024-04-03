package com.instabug.library.sessionV3.providers;

import android.app.ActivityManager;
import android.content.Context;
import com.instabug.library.Instabug;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f51821a = new b();

    private b() {
    }

    private final Context b() {
        return Instabug.getApplicationContext();
    }

    public boolean a() {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Context b11 = b();
        if (!(b11 == null || (activityManager = (ActivityManager) b11.getSystemService("activity")) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
            T t11 = null;
            if (runningAppProcesses.isEmpty()) {
                runningAppProcesses = null;
            }
            if (runningAppProcesses != null) {
                Iterator<T> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                    b bVar = f51821a;
                    Intrinsics.checkNotNullExpressionValue(runningAppProcessInfo, "appProcess");
                    Context b12 = bVar.b();
                    Intrinsics.checkNotNull(b12);
                    if (bVar.a(runningAppProcessInfo, b12)) {
                        t11 = next;
                        break;
                    }
                }
                return ((ActivityManager.RunningAppProcessInfo) t11) == null;
            }
        }
    }

    private final boolean a(ActivityManager.RunningAppProcessInfo runningAppProcessInfo, Context context) {
        return runningAppProcessInfo.importance == 100 && Intrinsics.areEqual((Object) runningAppProcessInfo.processName, (Object) context.getPackageName());
    }
}
